package marc_Project_1;

public interface Bag {
	
	//creates a bag of size 100
	public void CreateBag();
	
	//inserts an item into the bag
	public void insert(Item item);
	
	//removes last item from bag
	public void removeLast();
	
	//removes random item
	public void removeRandom();
	
	//gets the index location of an item
	public int get(String item);
	
	//gets reference to item at a certain index
	public String get(int index);
	
	//returns number of items in the bag
	public int size();
	
	//returns if empty
	public boolean isEmpty();
	
	//will make and empty bag
	public void makeEmpty();
	

}
