package StaffManagement;

public class ManagerialStaff extends Staff{

	//The ManagerialStaff Methods take staff objects as parameters and returns and sets their schedule attributes
	
	//ManagerialStaff have not additional attributes
	public ManagerialStaff(String name) {
		super(name);
	}
	
	//These methods use the schedule setter methods of the abstract staff class and apply them to a passed staff object
	public void setStaffScheduleDay(Staff staff, String day, String punchIn, String punchOut) throws InvalidDayException, InvalidTimeException{
		staff.setMyScheduleDay(day, punchIn, punchOut);
	}
	public void setStaffScheduleDay(Staff staff,String day, String punchIn, String breakStart, String breakEnd, String punchOut) throws InvalidDayException, InvalidTimeException{
		staff.setMyScheduleDay(day, punchIn, breakStart, breakEnd, punchOut);
	}
	public void setStaffScheduleTime(Staff staff,String day, String mode, String time) throws InvalidTimeException{
		staff.setMyScheduleTime(day, mode, time);
	}
	
	//These methods take staff objects and return attributes and details of its schedule attribute
	public Schedule getStaffSchedule(Staff staff) {return staff.getMySchedule();}
	public Day getStaffDay(Staff staff, String day) {return staff.getMySchedule().getDay(day);}
	public String getStaffTime(Staff staff, String day, String mode) {return staff.getMySchedule().getDay(day).getTime(mode);}
}
