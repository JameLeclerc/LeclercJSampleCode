package StaffManagement;

public class CodeSampleDriver {

	public static void main(String[] args) throws InvalidTimeException, InvalidDayException{
		//----NOTE----
		//getters and setters take a string as the first attribute to specify a day
		//"sun", "mon", "tue", "wed", "thu", "fri", and "sat" specify days
		//getters and setters that work with a specific time of a day take another string as a attribute
		//"pi" is punchIn, "bs" is breakStart, "be" is breakEnd, "po" is punchOut
		
		//Create a manager staff object with the name attribute "James"
		ManagerialStaff james = new ManagerialStaff("James");
		//Used the "setMyScheduleDay" setter of the staff class to set a specific day attribute of the schedule attribute
		//Passed 3 strings to set a day without a break
		james.setMyScheduleDay("tue", "01:30PM", "02:45PM");
		james.setMyScheduleDay("wed", "12:00PM", "01:00PM");
		//Passed 5 strings to set a day with a break
		james.setMyScheduleDay("thu", "08:00AM", "10:30AM", "11:00AM", "02:00PM");
		james.setMyScheduleDay("fri", "11:00AM", "12:45PM");
		//use the getter attribute of the staff class to return the schedule attribute
		System.out.println(james.getMySchedule());
		//use the getter totalHours method of the schedule class to get the sum of hours
		System.out.println("Total Hours Worked: " + james.getMySchedule().getTotalHours());
		//use the getter getDay method of the schedule class and the getHours method of the day class to get the sum of hours of that specific day
		System.out.println("Total Hours Worked Thursday " + james.getMySchedule().getDay("thu").getHours());
		james.setMyScheduleTime("wed", "po", "02:00PM");
		//use the getter to use the toString of the schedule attribute of the james object
		System.out.println(james.getMySchedule());
		
		System.out.println("--------------------- Modifying Staff Through Manager Objects ---------------------");
		KitchenStaff nick = new KitchenStaff("Nick");
		//setting a day through the james manager object
		james.setStaffScheduleDay(nick, "mon", "12:00AM", "11:59PM");
		System.out.println("Nick's Schedule Without Break: " + james.getStaffDay(nick, "mon").getHours());
		//adding a break start and end time objects to the monday day object of the nick kitchenStaff objects schedule attribute
		james.setStaffScheduleTime(nick, "mon", "bs", "12:00PM");
		james.setStaffScheduleTime(nick, "mon", "be", "01:00PM");
		//calling the day attributes getHours method through the getter of the manager object's getStaffDay method
		System.out.println("Nick's Schedule With Break: " + james.getStaffDay(nick, "mon").getHours());
		//I was too lazy to make getHours round
	}

}
