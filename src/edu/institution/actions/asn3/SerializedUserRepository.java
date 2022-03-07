package edu.institution.actions.asn3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import edu.institution.UserRepository;
import edu.institution.asn2.LinkedInException;
import edu.institution.asn2.LinkedInUser;

public class SerializedUserRepository implements UserRepository {
	private String filePath;
	private String fileName;
	private List<LinkedInUser> users;
	@Override
	public void init(String filePath, String fileName) {
		// TODO Auto-generated method stub
		this.filePath = filePath;
		this.fileName = fileName;
		this.users = retrieveAll();
		// this.users = deserialized list from file system
		//loop through using the add method to populate the list if it exists
		//otherwise add a new list and make it empty
	}
	//add user 
	@Override
	public void add(LinkedInUser user) throws LinkedInException {
		
		try {
			boolean userAlreadyExists = false;
			for(LinkedInUser userToCheck : users) {
				if(user.getUsername().equalsIgnoreCase(userToCheck.getUsername())){
					userAlreadyExists = true;
					break;
				}
			}
			if(userAlreadyExists) {
				Exception LinkedInException = new LinkedInException("The user already exists.");
				throw LinkedInException ;
			}
			else {
				this.users.add(user);
				saveAll();
			}
			
		}
		
		catch(LinkedInException ex) {
			ex.toString();
		} 
		
		catch (Exception e) {
			e.toString();
		}
		

	}

	@Override
	//All users saved
	public void saveAll() {
		
		File file = new File(this.filePath + this.fileName);
		//check if the file exists 
		if(file.exists()) {
			
			file.delete();
		}
		//if needed make the new file path
		else {
			new File(this.filePath).mkdirs();
		}
		//try to write a file with the list of users
		try (FileOutputStream fout = new FileOutputStream(file); 
				ObjectOutputStream oos = new ObjectOutputStream(fout)){
			oos.writeObject(users);
		}
		
		catch (Exception ex){
			throw new RuntimeException(ex);
			
		}
	}

	@Override
	//delete passed in user
	public void delete(LinkedInUser user) {
		
		this.users.remove(user);
		saveAll();

	}
	//retrieve a specific user
	@Override
	public LinkedInUser retrieve(String username) {
		
		LinkedInUser userToRetrieve = new LinkedInUser();
		for(LinkedInUser user : this.users) {
			if(user.getUsername().equalsIgnoreCase(username)) {
				userToRetrieve = user;
			}
		}
		return userToRetrieve;
	}
	//Retrieve all users
	@Override
	public List<LinkedInUser> retrieveAll() {
		File file = new File(this.filePath + this.fileName);
		List<LinkedInUser> users = new ArrayList<LinkedInUser>();
		if(file.exists()) {
			try(FileInputStream fis = new FileInputStream(file);
					ObjectInputStream ois = new ObjectInputStream(fis)){
					users = (List<LinkedInUser>)ois.readObject();
			}
			
			catch (Exception ex){
				throw new RuntimeException(ex);
			}
		}
		return users;
	}


}
