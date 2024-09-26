package StaffManagement;

public class InvalidDayException extends Exception{
	//returns the passed string as a InvalidDayException
	public InvalidDayException(String errorMessage) {
		super(errorMessage);
	}
}
