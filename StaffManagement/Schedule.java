package StaffManagement;

public class Schedule {
	//has seven private day attributes for each day of the week
	//this class if for connecting them and to a single schedule as well as passing the time information to the day setters as Strings
	
	//NOTE: getters and setters first attribute is a String day, either sun, mon, tue, wed, thu, fri, or sat this specifies what day attribute is going to be used
	
	private Day sunday = null;
	private Day monday = null;
	private Day tuesday = null;
	private Day wednesday = null;
	private Day thursday = null;
	private Day friday = null;
	private Day saturday = null;
	
	//Constructor does nothing since a schedule can be empty and all days are assigned to null as default
	public Schedule(){}
	//sets the punch in and punch out for the given day
	
	//sets day only punchIn and punchOut for the given day passed as Strings, throws exceptions for invalid day and time object information
	public void setDay(String day, String punchIn, String punchOut) throws InvalidTimeException, InvalidDayException{
		switch(day){
		case "sun":
			this.sunday = new Day(punchIn, punchOut);
			break;
		case "mon":
			this.monday = new Day(punchIn, punchOut);
			break;
		case "tue":
			this.tuesday = new Day(punchIn, punchOut);
			break;
		case "wed":
			this.wednesday = new Day(punchIn, punchOut);
			break;
		case "thu":
			this.thursday = new Day(punchIn, punchOut);
			break;
		case "fri":
			this.friday = new Day(punchIn, punchOut);
			break;
		case "sat":
			this.saturday = new Day(punchIn, punchOut);
			break;
		}
	}
	
	//sets day punchIn, punchOut, breakStart, and breakEnd for the given day passed as Strings, throws exceptions for invalid day and time object information
	public void setDay(String day, String punchIn, String breakStart, String breakEnd, String punchOut) throws InvalidTimeException, InvalidDayException{
		switch(day){
		case "sun":
			this.sunday = new Day(punchIn, breakStart, breakEnd, punchOut);
			break;
		case "mon":
			this.monday = new Day(punchIn, breakStart, breakEnd, punchOut);
			break;
		case "tue":
			this.tuesday = new Day(punchIn, breakStart, breakEnd, punchOut);
			break;
		case "wed":
			this.wednesday = new Day(punchIn, breakStart, breakEnd, punchOut);
			break;
		case "thu":
			this.thursday = new Day(punchIn, breakStart, breakEnd, punchOut);
			break;
		case "fri":
			this.friday = new Day(punchIn, breakStart, breakEnd, punchOut);
			break;
		case "sat":
			this.saturday = new Day(punchIn, breakStart, breakEnd, punchOut);
			break;
		}
	}
	
	//changes a specific time for a given day 
	public void setDayTime(String day, String specificTime, String time) throws InvalidTimeException{
		switch(day){
		case "sun":
			this.sunday.setTime(specificTime, time);
			break;
		case "mon":
			this.monday.setTime(specificTime, time);
			break;
		case "tue":
			this.tuesday.setTime(specificTime, time);
			break;
		case "wed":
			this.wednesday.setTime(specificTime, time);
			break;
		case "thu":
			this.thursday.setTime(specificTime, time);
			break;
		case "fri":
			this.friday.setTime(specificTime, time);
			break;
		case "sat":
			this.saturday.setTime(specificTime, time);
			break;
		}
	}
	
	//returns the given day rather then having seven getters
	public Day getDay(String day) {
		switch(day){
		case "sun":
			return sunday;
		case "mon":
			return monday;
		case "tue":
			return tuesday;
		case "wed":
			return wednesday;
		case "thu":
			return thursday;
		case "fri":
			return friday;
		case "sat":
			return saturday;
		default:
			return null;
		}
	}
	
	//If the day attribute is not null the getHours double from the day class is added to the total and returned
	public double getTotalHours()throws InvalidDayException{
		double total = 0;
		if (sunday != null) total += sunday.getHours();
		if (monday != null) total += monday.getHours();
		if (tuesday != null) total += tuesday.getHours();
		if (wednesday != null) total += wednesday.getHours();
		if (thursday != null) total += thursday.getHours();
		if (friday != null) total += friday.getHours();
		if (saturday != null) total += saturday.getHours();
		return total;
	}
	
	//if the day attribute is not null the day attributes toString is added to the return string and returns a formatted string
	public String toString() {
		String returnString = "";
		if(sunday != null) returnString += "Sunday: " + sunday.toString() + "\n";
		else returnString += "Sunday: N/A\n";
		if(monday != null) returnString += "Monday: " + monday.toString() + "\n";
		else returnString += "Monday: N/A\n";
		if(tuesday != null) returnString += "Tuesday: " + tuesday.toString() + "\n";
		else returnString += "Tuesday: N/A\n";
		if(wednesday != null) returnString += "Wednesday: " + wednesday.toString() + "\n";
		else returnString += "Wednesday: N/A\n";
		if(thursday != null) returnString += "Thursday: " + thursday.toString() + "\n";
		else returnString += "Thursday: N/A\n";
		if(friday != null) returnString += "Friday: " + friday.toString() + "\n";
		else returnString += "Friday: N/A\n";
		if(saturday != null) returnString += "Saturday: " + saturday.toString() + "\n";
		else returnString += "Saturday: N/A";
		return returnString;
	}
}
