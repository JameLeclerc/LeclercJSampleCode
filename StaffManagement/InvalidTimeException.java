package StaffManagement;

public class InvalidTimeException extends Exception{
	//returns the passed string as a InvalidTimeException
	public InvalidTimeException(String errorMessage) {
		super(errorMessage);
	}
}
