package marc_Project_1;

public class Helper {
	
	public static void start() {
		
		//list of test items
		Item test = new Item("apple");
		Item test2 = new Item("milk");
		Item test3 = new Item("bread");
		Item test4 = new Item("eggs");
		Item test5 = new Item("bannananan");
		
		//test Item class
	//	System.out.println(test.getName());
		
		//test GroceryBag Class
		
		GroceryBag testBag = new GroceryBag();//defualt constructor test
		
		System.out.println("Default constructor: " + "\n" + testBag + "\n");
		testBag=new GroceryBag(5);
		
		GroceryBag testBag1 = new GroceryBag(100);//modified constructor test
		
		System.out.println("Augmented constructor[100]: " + "\n" +testBag1 + "\n");
		
		//*test create bag method.
		//GroceryBag testBag2 = new GroceryBag();
		//testBag2.CreateBag();
		
		
		//test if isEmpty works for an empty bag
		
		System.out.println("test if isEmpty"+ "\n");
		if(testBag1.isEmpty())
			System.out.println(testBag1+ "\n");
		
		
		//test insert
		testBag1.insert(test);
		testBag1.insert(test2);
		testBag1.insert(test3);
		testBag1.insert(test4);
		testBag1.insert(test5);
		
		System.out.println("Insert 5 items" + "\n");
		System.out.println(testBag1 + "\n");
		
		
		//remove test
		System.out.println("Remove last" + "\n");
		testBag1.removeLast();
		System.out.println(testBag1 + "\n");
		
		

		
		
		
		
		testBag.insert(test);
		testBag.insert(test2);
		testBag.insert(test3);
		testBag.insert(test4);
		
		System.out.println( "Test is full method" + "\n" + testBag + "\n");
		
		//test isFull works for a non empty bag
		if(!testBag.isFull())
			System.out.println("Bag is not full" + "\n");
		
		testBag.insert(test5);
		
		if(testBag.isFull())
			System.out.println(testBag + "\n" + "Bag is full");
		

		//test if get of item works
		System.out.println("Get eggs: " + testBag1.get("eggs"));
		System.out.println("Get Item at 3: " + testBag1.get(3));
		
		
		//remove random test
		System.out.println("Remove Random" + "\n");
		testBag1.removeRandom();
		System.out.println(testBag1 + "\n");
		
		//test make empty
		System.out.println("Make Empty" + "\n");
		testBag1.makeEmpty();
		System.out.println(testBag1 + "\n");
		
		System.out.println("Test insert from file" + "\n");
		

		
		testBag1.fillBag("C:\\Users\\Mcado\\eclipse-workspace\\marc_Project_1\\src\\marc_Project_1\\TestData.txt");
		
		System.out.println(testBag1);

		
		//exception test
		//testBag1.get("agsdfadf");
		//testBag1.get(500);
		//testBag1.get(-1);
		//testBag.insert(test5);//is full test
		
	}

}
