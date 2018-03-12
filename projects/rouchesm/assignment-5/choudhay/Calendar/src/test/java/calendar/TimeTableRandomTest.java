 package calendar;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.Random;

import org.junit.Test;


import static org.junit.Assert.*;

/**
 * Random Test Generator  for TimeTable class.
 */

public class TimeTableRandomTest {
    /**
     * Generate Random Tests that tests TimeTable Class.
     */
	 public static int NUM_TESTS = 1000;
	 public static int TestTimeout = 50 *300 * 1;
	 
	 @Test
	  public void radnomtest()  throws Throwable  {
		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		 System.out.println("Start testing...");
		 
		try{ 
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed =System.currentTimeMillis(); //10
				Random random = new Random(randomseed);
			 	int startMonth = ValuesGenerator.getRandomIntBetween(random, 1, 11);
				int startYear = ValuesGenerator.RandInt(random);
				int startDay = ValuesGenerator.RandInt(random);
				
				int endMonth = ValuesGenerator.getRandomIntBetween(random, 1, 11);
				int endYear = ValuesGenerator.RandInt(random);
				int endDay = ValuesGenerator.RandInt(random);
				
				GregorianCalendar firstDay = new GregorianCalendar(startYear,startMonth,startDay);
				GregorianCalendar lastDay = new GregorianCalendar(endYear,endMonth,endDay);
				TimeTable myTimeTable = new TimeTable();
				
				int apptsToAdd = ValuesGenerator.getRandomIntBetween(random,0,20);
				LinkedList <Appt> apptRange = new LinkedList<Appt>();
				for(int j = 0; j < apptsToAdd; j++) {
					int apptMonth = ValuesGenerator.getRandomIntBetween(random, 1, 11);
					int apptYear = ValuesGenerator.RandInt(random);
					int apptDay = ValuesGenerator.RandInt(random);
					int apptMinute = ValuesGenerator.RandInt(random);
					int apptHour = ValuesGenerator.RandInt(random);
					String title="Birthday Party";
					String description="This is my birthday party.";
					//Construct a new Appointment object with the initial data	 
					Appt appt = new Appt(apptHour,apptMinute ,apptDay ,apptMonth ,apptYear ,title, description);
					apptRange.add(appt);
				}
				//LinkedList<Appt> nullRange = null;
				if(firstDay.before(lastDay)) {
					myTimeTable.getApptRange(apptRange, firstDay, lastDay);
				}/*else {
					myTimeTable.getApptRange(apptRange,firstDay,lastDay);
				}*/
				int apptNumToDelete = ValuesGenerator.getRandomIntBetween(random, 0, apptsToAdd-1);
				for(int j = 0; j < apptNumToDelete; j++) {
					int appt_delet_idx = ValuesGenerator.getRandomIntBetween(random,0,apptsToAdd);
					apptsToAdd--;
					System.out.println(appt_delet_idx + "\n" + apptRange.toString());
					Appt apptToDelet = apptRange.get(appt_delet_idx);
					//myTimeTable.deleteAppt(nullRange, apptToDelet);
					myTimeTable.deleteAppt(apptRange, apptToDelet);
				}
				Appt nullAppt = null;
				apptRange.add(nullAppt);
				myTimeTable.deleteAppt(apptRange, nullAppt);
				
				elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
			        if((iteration%10000)==0 && iteration!=0 )
			              System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
			 
			}
		}catch(NullPointerException e){
			
		}
	 	
	 }
}	
