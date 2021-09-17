package marc_Project_1;

public class ListException extends RuntimeException{
	
	/*
	 * constructs message about item not found
	 * @param a string with the message
	 */

	public ListException(String message) {
		super(message);
	}
}
