package edu.institution.actions.asn10;

//use this class to keep track of the action and information to undo

public class LinkedInAction {
	@Override
	public String toString() {
		return "LinkedInAction [menuOption=" + menuOption + ", menuTitle=" + menuTitle + ", dataObject=" + dataObject
				+ "]";
	}

	private int menuOption;
	private String menuTitle;
	
	private Object dataObject;
	
	public LinkedInAction () {
		super();
	}
	

	public LinkedInAction(int menuOption, String menuTitle, Object dataObject) {
		super();
		this.menuOption = menuOption;
		this.menuTitle = menuTitle;
		this.dataObject = dataObject;
	}

	public int getMenuOption() {
		return menuOption;
	}

	public void setMenuOption(int menuOption) {
		this.menuOption = menuOption;
	}

	public String getMenuTitle() {
		return menuTitle;
	}

	public void setMenuTitle(String menuTitle) {
		this.menuTitle = menuTitle;
	}

	public Object getDataObject() {
		return dataObject;
	}

	public void setDataObject(Object dataObject) {
		this.dataObject = dataObject;
	}
	
}
