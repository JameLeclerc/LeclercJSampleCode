package StaffManagement;

public class Time {
	//time object contains hours, minutes, and a boolean to determine if the time is in the am or pm
	
	//NOTE: the time class takes a single 7 character long string as a valid constructor, an InvalidTimeException will be thrown if other arguments are passed
	//EXAMPLE: 02:45PM would be a valid input, but 5:00AM would not since it is not 7 characters long, AM and PM are nto case dependant
	private int hours;
	private int minutes;
	private boolean am = true;
	
	// constructor takes a single string formatted correctly
	public Time(String time) throws InvalidTimeException{
		//Checks if the time was formatted correctly using the "isValid" method
		try{
			isValid(time);
		}
		catch(InvalidTimeException err){
			throw err;
		}
		//if its formatted correctly assign hour and minute splitting at :
		String[]timeArr = time.split(":");
		this.hours = Integer.valueOf(timeArr[0]);
		this.minutes = Integer.valueOf(timeArr[1].substring(0, timeArr[1].length()-2));
		if(time.substring(5).toUpperCase().equals("PM")) am = false;
	}	
	
	//The attributes mean nothing as is since they are passed as AM and PM, this method converts it to a double value that is used for math in the day class
	public double toHours() {
		//Since 12AM is the beginning of the day, hours is 0 and minutes converted to hours is the only value returned
		if(am && hours == 12) return ((double)minutes / 60);
		//if the time is still in the AM, then take the hours and add the minutes converted to hours
		else if(am) return hours + ((double)minutes / 60);
		//Convert to military time and add minutes converted to hours
		else if(hours == 12) return hours + ((double)minutes / 60);
		return hours + 12 + ((double)minutes / 60);
	}
	
	//Return a formated string that resembles the passed string minus the extra starting 0 for formatting
	public String toString() {
		String noon = "AM"; 
		String printableMinutes = String.valueOf(minutes);
		if(am != true) noon = "PM";
		if(printableMinutes.equals("0")) printableMinutes = "00";
		return hours + ":" + printableMinutes + noon;
	}
	
	//is valid determines if the passed string is formatted correctly to create a time object
	//has to pass multiple checks otherwise a specific InvalidTimeException is thrown
	private void isValid(String time) throws InvalidTimeException{
		//Time must be denoted with a :
		if(!time.contains(":")) throw new InvalidTimeException("Missing :");
		//The time must be 7 characters long, 00:00AM or 00:00PM
		if(time.length() != 7) throw new InvalidTimeException("Invalid time length");
		//The hours must be between 1 and 12
		if(Integer.valueOf(time.substring(0, time.length()-5)) > 12 || Integer.valueOf(time.substring(0, time.length()-5)) < 1)
			throw new InvalidTimeException("Hours must be between 1 and 12");
		//minutes must be between 0 and 59
		if(Integer.valueOf(time.substring(3, time.length()-2)) > 59 || Integer.valueOf(time.substring(3, time.length()-2)) < 0)
			throw new InvalidTimeException("Minutes must be between 0 and 59");
		//Time must be AM or PM
		if(!(time.substring(5).toUpperCase().equals("AM") || time.substring(5).toUpperCase().equals("PM")))
			throw new InvalidTimeException("Time must contain AM or PM");
	}
}
