package marc_Project_1;

public class Item {
	
	protected String name;
	
	//will return name of object
	public String getName() {
		return name;
		
	}
	
	//sets name to newName
	//@parameter newName is the new name of item
	public void setName (String newName) {
		name=newName;
	}
	
	//defualt constructor
	//name is blank
	public Item() {
		this.name=null;
	}
	
	//modified constructor
	//@Paramater is the name of the item
	public Item(String name) {
		this.name=name;
	}

}
