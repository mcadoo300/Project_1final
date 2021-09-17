package marc_Project_1;

import java.util.NoSuchElementException;
import java.util.Random;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class GroceryBag implements Bag{
	
	

	
	protected Item[] bag;//contains an array of Items
	protected int currPos;// current position of index
	protected int numItems;//number of items in the bag
	protected int size;//number of items that fit in bag
	
	
	/*
	 * default constructor
	 * creates an empty bag
	 */
	public GroceryBag() {
		this.bag=null;
		currPos=0;
		numItems=0;
		size=0;
	}
	
	//~~~~~~~~~~~
	
	/*
	 * modified constructor
	 * creates a bag of size int
	 * @Paramater bagSize is the size of the array
	 */
	public GroceryBag(int bagSize) {
		this.bag= new Item[bagSize];
		currPos=0;
		numItems=0;
		size=this.bag.length;
	}
	
	
	//~~~~~~~~~~~
	
	/*
	 * Creates a bag of size 100
	 * 
	 */
	public void CreateBag(){
		this.bag= new Item[100];
		size=this.bag.length;
	}
	

	
	/*
	 * override ToString method
	 * will output a string/list of the name of items, and number of items and size of bag
	 */
	@Override
	public String toString() {
		
		String message=null;//space for message to be stored || initialized to null
		
			//for loop to add name of items one per line
			for(int i=0;i<this.numItems;i++)
			{
				//initial value of i overrites the null
				if(i==0)
					message=this.bag[i].getName() + '\n';
				else//all other values of i are appended to the existing string
				message=message + this.bag[i].getName() + '\n';
				
			}
			return message;//return "completed" message
	}
	
	//~~~~~~~~~~~
	
	
	/*
	 * will return if teh bag is empty or not
	 */
	public boolean isEmpty() {
		return(this.numItems==0);//if num items is zero then return true, otherwise false
	}
	
	//~~~~~~~~~~~
	
	/*
	 * will return if teh bag is full
	 */
	
	public boolean isFull() {
		return(this.numItems==size);//if num items is the size of the bag then return true, otherwise false
	}
	/*
	 * insert item
	 * @Paramater is the Item to be inserted into the bag
	 */
	public void insert(Item newItem) {
		if(this.isFull())
		{
			throw new ListException(newItem.getName() + " cannot be inserted because the bag is full");
		}
		else {
			this.bag[this.numItems]=newItem;//insert item at the index of num items
			numItems++;//incriment num items
		}

	}
	
	//~~~~~~~~~~~
	
	/*
	 * Remove last Item in bag
	 * 
	 */
	public void removeLast() {
		
	
		if(numItems==0) {//if there are no items do nothing
			
		}
		else
		{
			this.remove(numItems-1);
		}
		
	}
	
	//~~~~~~~~~~~
	
	
	/*
	 * remove item
	 * @Paramater index is the index of the item to be removed
	 */
	public void remove(int index) {
		if(index<0 || index > (numItems-1))//if index is less than zero or more than (numItems-1) it is out of bounds
			throw new ListIndexOutOfBoundsException("The index must be between 0 and " + (numItems-1));
		else
		{
			
			int i=index;
			
			while(i<(numItems-1)) {//if the last item is the item to remove then skip loop
				
				this.bag[i]=this.bag[i+1];//assign index[i] the value of index[i+1]
				//until the last item is replaced with null
				i++;
			}
			this.bag[i]=new Item();//last item is set to null
			
			numItems--;
		}
	}
	
	//~~~~~~~~~~
	
	
	/*
	 * remove random Item
	 */
	public void removeRandom() {
		
		if(this.isEmpty())//if empty do nothing
			;
		else
		{
			Random rand = new Random();
			//generate random number
			// values of ((numItems-1) to 0)
			int indexToRmv = rand.nextInt((numItems));
			
			this.remove(indexToRmv);
		}

	}
		
	//~~~~~~~~~~~~~~~~
		
	/*
	 * Will return the number of items in the bag
	 */
	public int size(){
		return this.numItems;
	}
	
	//~~~~~~~~~~~
	
	/*
	 * will make the bag empty
	 */
	public void makeEmpty(){
		
		this.bag=new Item[this.size];//create a new bag of 100 items
		currPos=0;
		numItems=0;
	}
	
	//~~~~~~~~~~~
	
	/*
	 * get item at specified index
	 * @Paramater index is the index value of the item to return
	 */
	public String get(int index){
		if(index<0 || index > (numItems-1))//if index is less than zero or more than (numItems-1) it is out of bounds
			throw new ListIndexOutOfBoundsException("The index must be between 0 and " + (numItems-1));
		else
		return this.bag[index].getName();
	}
	
	//~~~~~~~~~~~
	
	/*
	 * get the first index of specified item
	 * @paramateter name is the item name to search for
	 */
		public int get(String name){
			
			for(int i=0;i<numItems;i++)
			{
				if(this.bag[i].getName().equals(name))
					return i;
			}
			throw new ListException(name + " not found in list"); 
		}
		
	//~~~~~~~~~~~
		
		/*
		 * will read from a text fil and fill a bag
		 */
		public void fillBag(String fileName) {
			
			
			File text= new File(fileName);//create a new file object with the using the file name as parameter
			
			try {
				
				Scanner sc = new Scanner(text);//create new scanner object that references this file
				String newName = sc.nextLine();//read initial line of file
				
				Item newItem = new Item(newName);//create new item with the name
				
				while(newName != null)//while the newItem isnt null (blank line) add them to the bag
				{
					
					
					
					this.insert(newItem);//insert new item
					
					try {
					newName = sc.nextLine();//read next line of file
					}catch(NoSuchElementException e) {
						newName=null;
					}
					
					
						newItem = new Item(newName);//create new item with the name
					
					
					//only continue through the loop while newItem isnt assigned null by a blank line/end of file
					
				}
				
				sc.close();//end memory association
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			/*
			 * set size of bag
			 * @paramater size is the new size
			 */

			
			
		}
		
		
	}