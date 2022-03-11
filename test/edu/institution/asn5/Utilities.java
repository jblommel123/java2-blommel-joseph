package edu.institution.asn5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.engine.discovery.predicates.IsTestFactoryMethod;

public class Utilities   {
	
	public <E> E linearSearch (List<E> list, E key) {
		
		if(list.size() < 1) {
			System.out.println("This list is empty. Give me something to work with.");
			return null;
		}
		
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).equals(key)) {
				return list.get(i);
			}
		}
		
		return null;
	}
	
	public <T> void listItems(List<T> listThings) {
		for (T t : listThings) {
			System.out.println(t.toString());
		}

	}
	
	public <T> void removeDuplicates (List<T> items) {
		List<T> uniqueItemsList = new ArrayList<T>();
		if(items.size() > 0) {
			for (int i = 0; i < items.size(); i++) {
				if(uniqueItemsList.contains(items.get(i))) {
					System.out.println("UniqueList already has this.");
				}
				
				else {
					uniqueItemsList.add(items.get(i));
				}
			}
			
			items.clear();
			items.addAll(uniqueItemsList);
		}
		
	}
}
