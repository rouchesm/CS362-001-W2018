package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;


import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {

	 @Test
	  public void test01()  throws Throwable  {
		 CalDay myDay = new CalDay();
	     Calendar rightnow = Calendar.getInstance();
	     int thisMonth = rightnow.get(Calendar.MONTH)+1;
		 int thisYear = rightnow.get(Calendar.YEAR);
		 int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
		 GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
		 CalDay myDay2 = new CalDay(today);
		 myDay.iterator();
	
		 GregorianCalendar myDay3 = new GregorianCalendar(2018,02,10);
		 Appt appt1 = new Appt(18,21,27,1,2018,"My Day","Appointment tonight");
		 myDay2.addAppt(appt1);
	     assertFalse(myDay.isValid());
		 assertTrue(myDay2.isValid());
		 
		 Appt appt2 = new Appt(15,20,27,1,2018,"My Day","Appointment earlier");
		 myDay2.addAppt(appt2);
		 assertEquals(2,myDay2.getSizeAppts());
		 
		 Appt appt3 = new Appt(12,20,27,1,2018,"appt","This is earlier yet");
		 myDay2.addAppt(appt3);
		 Appt appt4 = new Appt(12,20,-1,2,2018,"Invalid appt","This is not a real day");
		 myDay2.addAppt(appt3);
		 
		 String my_day_2_string = myDay2.toString();
		 String my_day_string = myDay.toString();

	 }
	 @Test
	  public void test02()  throws Throwable  {
		 Calendar rightnow = Calendar.getInstance();
	     int thisMonth = rightnow.get(Calendar.MONTH)+1;
		 int thisYear = rightnow.get(Calendar.YEAR);
		 int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
		 GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
		 CalDay myDay = new CalDay(today);
		 myDay.iterator();
		 
		 //assertEquals(1,myDay.getMonth());
		 //assertEquals(28,myDay.getMonth()); //These will change depending on when the code is run
		 assertEquals(2018,myDay.getYear());
		 assertEquals(0,myDay.getSizeAppts());
		 myDay.getAppts();
		 
	 }
//add more unit tests as you needed	
}
