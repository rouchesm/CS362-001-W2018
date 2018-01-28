package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
public class ApptTest {
    /**
     * Test that the gets methods work as expected.
     */
	 @Test
	  public void test01()  throws Throwable  {
		 int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
	// assertions
		 assertTrue(appt.getValid());
		 assertEquals(21, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(15, appt.getStartDay());
		 assertEquals(01, appt.getStartMonth());
		 assertEquals(2018, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
		 assertEquals("This is my birthday party.", appt.getDescription());         		
	 }

	 @Test
	  public void test02()  throws Throwable  {
		 int startHour=5;
		 int startMinute=15;
		 int startDay=1;
		 int startMonth=02;
		 int startYear=2018;
		 String title="Interview Day 1 JHU Departure";
		 String description="This is flight to Johns Hopkins from Eugene";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour, startMinute ,startDay , startMonth , startYear , title, description);
		 int [] recur_days = null;
		 appt.setRecurrence(recur_days, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_FOREVER);
		 int [] recur_days_get = appt.getRecurDays();
		 int recur_increment = appt.getRecurIncrement();
		 assertTrue(appt.isRecurring());
		 int recur_by = appt.getRecurBy();
		 appt.setRecurrence(recur_days, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_NEVER);
		 boolean recurs = appt.isRecurring();
		 
		 int startHour2=9;
		 int startMinute2=51;
		 int startDay2=1;
		 int startMonth2=02;
		 int startYear2=2018;
		 String title2 = "Interview Day 1 JHU Flight Connection 1";
		 String desc2 = "This is my flight to Johns Hopkins, first connection";
		 Appt appt2 = new Appt(startHour2, startMinute2 , startDay2 ,startMonth2 ,  startYear2 , title2,  desc2);
		 Appt appt3 = new Appt(-1,12,3,11,2019,"invalid appointment 1","hour is oob");
		 String invalid_appt_string = appt3.toString();
		 Appt appt4 = new Appt(2,62,3,11,2019,"invalid appointment 1","hour is oob");
		 Appt appt5 = new Appt(4,12,35,11,2019,"invalid appointment 1","hour is oob");
		 //Appt appt7 = new Appt(4,12,22,-1,2019,"invalid appointment 1","hour is oob");
		 
	// assertions;         		
	 }
	 @Test
	 public void test03()  throws Throwable {
		 int startHour=14;
		 int startMinute=15;
		 int startDay=27;
		 int startMonth=01;
		 int startYear=2018;
		 String title="Interview Day 1 JHU Departure";
		 String description="This is flight to Johns Hopkins from Eugene";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour, startMinute ,startDay , startMonth , startYear , title, description);
		 int startHour2=9;
		 int startMinute2=51;
		 int startDay2=28;
		 int startMonth2=01;
		 int startYear2=2018;
		 String title2 = "Interview Day 1 JHU Flight Connection 1";
		 String desc2 = "This is my flight to Johns Hopkins, first connection";
		 Appt appt2 = new Appt(startHour2, startMinute2 , startDay2 ,startMonth2 ,  startYear2 , title2,  desc2);
	
		// Testing Setters
		 //get a list of appointments for one day, which is today
		appt2.setDescription("I'm changing the Description");
		assertEquals("I'm changing the Description",appt2.getDescription());
		appt2.setStartDay(3);
		appt2.setStartHour(14);
		appt2.setStartMinute(15);
		appt2.setStartMonth(10);
		appt2.setStartYear(2020);
		appt2.setTitle("Testing setters");
		assertEquals("Testing setters",appt2.getTitle());
		appt2.setTitle(null);
		appt2.setDescription(null);
		int [] recur_days = {4,6};
		appt2.setRecurrence(recur_days, Appt.RECUR_BY_WEEKLY, 1, Appt.RECUR_NUMBER_FOREVER);
		
		//assertions of setters
		assertEquals(3,appt2.getStartDay());
		assertEquals(14,appt2.getStartHour());
		assertEquals(15,appt2.getStartMinute());
		assertEquals(10,appt2.getStartMonth());
		assertEquals(2020,appt2.getStartYear());
		assertEquals("",appt2.getTitle());
		assertEquals("",appt2.getDescription());
		
		String appt2_string = appt2.toString();
		String appt_string = appt.toString();
		System.out.println("**"+ appt2_string+"**");
		System.out.println("**"+appt_string+"**");
		assertEquals(41,appt.compareTo(appt2));
		
	 }
	 @Test
	 public void test04()  throws Throwable {
		 //Leap year appointment
		GregorianCalendar leap_year = new GregorianCalendar(2020,02,28);
		GregorianCalendar leap_year_next = (GregorianCalendar)leap_year.clone();
		leap_year_next.add(Calendar.DAY_OF_MONTH, 1);
		CalendarUtil cal_util = new CalendarUtil();
		assertTrue(cal_util.IsLeapYear(2020));
		assertFalse(cal_util.IsLeapYear(2018));
		assertTrue(cal_util.IsLeapYear(2000));
			
	 }

}
//add more unit tests as you needed
	

