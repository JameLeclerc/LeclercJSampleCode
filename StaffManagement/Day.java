package StaffManagement;

public class Day {
	//A day consists of 4 time objects, punchIn, punchOut, breakStart, and breakEnd
	
	//NOTE: getters and setters's first attribute is a string to specific which time attribute is being changed
	//the options are: pi for punchIn, po for punchOut, bs for breakStart, and be for breakEnd
	private Time punchIn;
	private Time punchOut;
	private Time breakStart;
	private Time breakEnd;
	
	//constructor takes times without breaks and breaks are set to null as default
	public Day(String punchIn, String punchOut) throws InvalidTimeException, InvalidDayException{
		this.punchIn = new Time(punchIn);
		this.punchOut = new Time(punchOut);
		this.breakStart = null;
		this.breakEnd = null;
		//after attributes are assigned check if the times are "valid" with the is valid method, if not throw InvaldiDayException
		try {
			isValid();
		}
		catch(InvalidDayException err) {
			throw err;
		}
	}
	//constructor with break and sets them to the passed values
	public Day(String punchIn, String breakStart, String breakEnd, String punchOut) throws InvalidTimeException, InvalidDayException{
		this.punchIn = new Time(punchIn);
		this.punchOut = new Time(punchOut);
		this.breakStart = new Time(breakStart);
		this.breakEnd = new Time(breakEnd);
		//after attributes are assigned check if the times are "valid" with the is valid method, if not throw InvaldiDayException
		try {
			isValid();
		}
		catch(InvalidDayException err) {
			throw err;
		}
	}
	
	//getter for each time attribute returning it as a string
	public String getTime(String attribute){
			switch(attribute) {
			case "pi":
				return punchIn.toString();
			case "po":
				return punchOut.toString();
			case "bs":
				return breakStart.toString();
			case "be":
				return breakEnd.toString();
			default:
				return null;
			}
		}

	//setter for time each time attirbute assigning it to a new object
	public void setTime(String attribute, String time) throws InvalidTimeException{
		switch(attribute) {
		case "pi":
			this.punchIn = new Time(time);
			break;
		case "po":
			this.punchOut = new Time(time);
			break;
		case "bs":
			this.breakStart = new Time(time);
			break;
		case "be":
			this.breakEnd = new Time(time);
			break;
		}
	}
	
	//checks if the day if "valid" and uses the toHours method of the time class to add the numerical value of each time to find the hours specified between
	//the four time attributes
	public double getHours() throws InvalidDayException{
		try {
			isValid();
		}
		catch(InvalidDayException err) {
			throw err;
		}
		//breakStart is null if there is no break, isValid catches if there is a breakStart but no breakEnd
		if(breakStart == null) return punchOut.toHours() - punchIn.toHours();
		return punchOut.toHours() - punchIn.toHours() - (breakEnd.toHours() - breakStart.toHours());
	}
	
	//concats the toString of each time attributes and returns it formatted
	public String toString() {
		String returnString = "Punch In: " + punchIn.toString() + ", ";
		//if there is a break start and end they are added to the return string
		if(breakStart != null) returnString += "Break Start: " + breakStart.toString() + ", ";
		if(breakEnd != null) returnString += "Break End: " + breakEnd.toString() + ", ";
		returnString += "Punch Out: " + punchOut.toString() + ", ";
		return returnString;
	}
	
	
	//checks if the day object's time attributes are valid with each other and throws a Invalid Day Exception if the day object fails specific checks
	//each time should be "less" then the previous inOrder for a day to be valid
	private void isValid() throws InvalidDayException{
		if(punchIn.toHours() >= punchOut.toHours()) throw new InvalidDayException("Punch In must be before Punch Out");
		//a break end must be given if there is a break start
		if(this.breakStart != null && this.breakEnd == null) throw new InvalidDayException("Break End must be given");
		//A break start must be given if there is a break end
		else if(breakStart == null && breakEnd != null) throw new InvalidDayException("Break Start must be given");
		//check if the day if valid knowing there is a break start and end
		else if(breakStart != null && breakEnd != null){
			if(punchIn.toHours() >= breakStart.toHours()) throw new InvalidDayException("Punch In must be before Break Start");
			if(breakStart.toHours() >= breakEnd.toHours()) {
				System.out.println(breakStart +" " + breakEnd);
				throw new InvalidDayException("Break Start must be before Break End");
			}
			if(breakEnd.toHours() >= punchOut.toHours()) throw new InvalidDayException("Break End must be before Punch Out");
		}
	}
}
