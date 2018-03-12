package calendar;


import org.junit.Test;


import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;



/**
 * Random Test Generator  for CalDay class.
 */

public class CalDayRandomTest {
	
    /**
     * Generate Random Tests that tests CalDay Class.*/
	private static final long TestTimeout = 150 * 300 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=1000;

	@Test
	public void radnomtest()  throws Throwable  {

		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		 System.out.println("Start testing...");
		 
		try{ 
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed =System.currentTimeMillis(); //10
	//			System.out.println(" Seed:"+randomseed );
				Random random = new Random(randomseed);
				Calendar this_cal = Calendar.getInstance();
			 	int thisMonth = this_cal.get(Calendar.MONTH)+1;
				int thisYear = this_cal.get(Calendar.YEAR);
				int thisDay = this_cal.get(Calendar.DAY_OF_MONTH);
				GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
				CalDay myDay = new CalDay(today);
				for (int i = 0; i < NUM_TESTS; i++) {
					int apptsToAdd = ValuesGenerator.getRandomIntBetween(random, 0, 20);
					for(int j = 0; j < apptsToAdd; j++) {
						int startHour=ValuesGenerator.RandInt(random);
						int startMinute=ValuesGenerator.RandInt(random);
						String title="Birthday Party";
						String description="This is my birthday party.";
						//Construct a new Appointment object with the initial data	 
						Appt appt = new Appt(startHour,startMinute ,thisDay ,thisMonth ,thisYear ,title, description);
						myDay.addAppt(appt);
					}
				
				 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
			        if((iteration%10000)==0 && iteration!=0 )
			              System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
					}
			}
		}catch(NullPointerException e){
			
		}
	 
		 System.out.println("Done testing...");
	 }
	
}
