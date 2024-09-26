package StaffManagement;

public abstract class Staff {
	//an abstract class providing baseline implementation
	//abstract since no object of class staff can exist
	private String name;
	private Schedule schedule;
	//constructor only sets name attribute as schedule is set through setters
	public Staff(String name) {
		this.name = name;
		schedule = new Schedule();
	}
	
	//name attribute setter
	public void setName(String name) {this.name = name;}
	//two schedule setter methods with different signatures, one includes break times and the other does not.
	//uses schedule class getters and setters to modify schedule attribute of staff object
	public void setMyScheduleDay(String day, String punchIn, String punchOut) throws InvalidDayException, InvalidTimeException{
		this.schedule.setDay(day, punchIn, punchOut);
	}
	public void setMyScheduleDay(String day, String punchIn, String breakStart, String breakEnd, String punchOut) throws InvalidDayException, InvalidTimeException{
		this.schedule.setDay(day, punchIn, breakStart, breakEnd, punchOut);
	}
	
	//sets a specific time of a day attribute of a day attribute of the staff objects's schedule attribute using schedule attribute setter
	public void setMyScheduleTime(String day, String specificTime, String time) throws InvalidTimeException{
		this.schedule.setDayTime(day, specificTime, time);
	}
	
	//getters returning private attributes
	public String getName() {return name;}
	public Schedule getMySchedule() {return schedule;}	
}
