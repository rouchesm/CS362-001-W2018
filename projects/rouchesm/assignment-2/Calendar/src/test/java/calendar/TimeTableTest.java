package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {
	//Various test for getApptRange
	 @Test
	  public void test01()  throws Throwable  {
		 TimeTable my_tt= new TimeTable();
		 LinkedList<Appt> listAppts = new LinkedList<Appt>();
		 LinkedList <CalDay> cal_days = new LinkedList<CalDay>();
		 
		 GregorianCalendar first_day = new GregorianCalendar(2018,02,8);
		 GregorianCalendar last_day = new GregorianCalendar(2018,02,15);
		 Appt appt1 = new Appt(12,45,04,02,2018,"Test","test_day_1");
		 Appt appt2 = new Appt(17,02,06,02,2018,"Test_2","test_day_2");
		 Appt appt3 = new Appt(21,30,06,02,2018,"Test_3","test_day_3");
		 listAppts.add(appt1);
		 listAppts.add(appt2);
		 listAppts.add(appt3);
		 
		 int [] rec_arr = {2,3,4}; 
		 appt1.setRecurrence(rec_arr, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_FOREVER );
		 appt2.setRecurrence(rec_arr,Appt.RECUR_BY_MONTHLY, 2, Appt.RECUR_NUMBER_FOREVER);
		 appt3.setRecurrence(rec_arr,Appt.RECUR_BY_YEARLY, 2, Appt.RECUR_NUMBER_FOREVER);

		 cal_days = my_tt.getApptRange(listAppts, first_day, last_day);
		 my_tt.deleteAppt(listAppts, appt1);
		 Appt appt4 = new Appt(62,30,12,02,2018,"Test_4","test_day_4");
		 listAppts.add(appt4);
		 cal_days = my_tt.getApptRange(listAppts, first_day, last_day);
		 
	 }
	 @Test
	  public void test02()  throws Throwable  {
		 TimeTable my_tt= new TimeTable();
		 LinkedList<Appt> listAppts = new LinkedList<Appt>();
		 LinkedList <CalDay> cal_days = new LinkedList<CalDay>();
		 
		 GregorianCalendar first_day = new GregorianCalendar(2018,02,8);
		 GregorianCalendar last_day = new GregorianCalendar(2018,02,15);
		 Appt appt1 = new Appt(12,45,04,02,2018,"Test","test_day_1");
		 Appt appt2 = new Appt(17,02,06,02,2018,"Test_2","test_day_2");
		 Appt appt3 = new Appt(21,30,06,02,2018,"Test_3","test_day_3");
		 listAppts.add(appt1);
		 listAppts.add(appt2);
		 listAppts.add(appt3);
		 my_tt.deleteAppt(listAppts, appt1);
		 my_tt.deleteAppt(listAppts, appt2);
		 my_tt.deleteAppt(listAppts, appt3);
		 my_tt.deleteAppt(listAppts, null);

		 cal_days = my_tt.getApptRange(listAppts, last_day, first_day); //first day is before last day
		 
	 }
	 @Test
	 public void test03() throws Throwable {
		 TimeTable my_tt= new TimeTable();
		 LinkedList<Appt> listAppts = new LinkedList<Appt>();
		 LinkedList <CalDay> cal_days = new LinkedList<CalDay>();
		 
		 GregorianCalendar first_day = new GregorianCalendar(2018,02,8);
		 GregorianCalendar last_day = new GregorianCalendar(2018,02,15);
		 Appt appt1 = new Appt(12,45,04,02,2018,"Test","test_day_1");
		 Appt appt2 = new Appt(17,02,06,02,2018,"Test_2","test_day_2");
		 Appt appt3 = new Appt(21,30,06,02,2018,"Test_3","test_day_3");
		 listAppts.add(appt1);
		 listAppts.add(appt2);
		 listAppts.add(appt3);
		 
		 int [] p_arr = {2,1,3};
		 int [] p_arr_wrong = {3};
		 LinkedList<Appt> perm_appts = new LinkedList<Appt>();
		 LinkedList<Appt> perm_appts_f = new LinkedList<Appt>();
		 perm_appts = my_tt.permute(listAppts, p_arr);
		 my_tt.permute(listAppts, p_arr_wrong);
	 }
	 @Test
	 public void test04() throws Throwable {
		 TimeTable my_tt= new TimeTable();
		 LinkedList<Appt> listAppts = new LinkedList<Appt>();
		 LinkedList <CalDay> cal_days = new LinkedList<CalDay>();
		 
		 GregorianCalendar first_day = new GregorianCalendar(2018,02,8);
		 GregorianCalendar last_day = new GregorianCalendar(2018,02,15);
		 Appt appt1 = new Appt(12,45,04,02,2018,"Test","test_day_1");
		 Appt appt2 = new Appt(17,02,06,02,2018,"Test_2","test_day_2");
		 Appt appt3 = new Appt(21,30,06,02,2018,"Test_3","test_day_3");
		 listAppts.add(appt1);
		 listAppts.add(appt2);
		 listAppts.add(appt3);
		 
		 int [] p_arr = {2,1,3};
		 int [] p_arr_wrong = {3};
		 LinkedList<Appt> perm_appts = new LinkedList<Appt>();
		 LinkedList<Appt> perm_appts_f = new LinkedList<Appt>();
		 perm_appts = my_tt.permute(listAppts, p_arr);
		 my_tt.permute(listAppts, p_arr_wrong);
	 }
//add more unit tests as you needed
}
