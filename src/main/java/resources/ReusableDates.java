package resources;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ReusableDates {
	
	public static String getCurrentDateFormat1() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date currentDate = new Date();
		return dateFormat.format(currentDate);
	}
	
	public static String getCurrentDateFormat2() {
		DateFormat dateFormat = new SimpleDateFormat("M/d/yyyy"); //8/6/2020
		Date currentDate = new Date();
		return dateFormat.format(currentDate);
	}
	
	public static String getCurrentDateFormat3() {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy"); //08/06/2020
		Date currentDate = new Date();
		return dateFormat.format(currentDate);
	}
	
	public static String getCurrentDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date currentDate = new Date();
		return dateFormat.format(currentDate);
	}
	
	public static String getCurrentDatePlusOneDay() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date currentDate = new Date();
		Calendar c = Calendar.getInstance();
        c.setTime(currentDate);
        c.add(Calendar.DATE, 1);
        Date currentDatePlusOneDay = c.getTime();
		return dateFormat.format(currentDatePlusOneDay);
	}
	
	public static String getCurrentDatePlusOneDay8AM() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd 08:00");
		Date currentDate = new Date();
		Calendar c = Calendar.getInstance();
        c.setTime(currentDate);
        c.add(Calendar.DATE, 1);
        Date currentDatePlusOneDay = c.getTime();
		return dateFormat.format(currentDatePlusOneDay);
	}
	
	public static String getCurrentDatePlusOneWeek() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date currentDate = new Date();
		Calendar c = Calendar.getInstance();
        c.setTime(currentDate);
        c.add(Calendar.DATE, 7);
        Date currentDatePlusOneWeek = c.getTime();
		return dateFormat.format(currentDatePlusOneWeek);
	}
	
	public static String getCurrentDatePlusOneMonth() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date currentDate = new Date();
		Calendar c = Calendar.getInstance();
        c.setTime(currentDate);
        c.add(Calendar.MONTH, 1);
        Date currentDatePlusOneMonth = c.getTime();
		return dateFormat.format(currentDatePlusOneMonth);
	}
	
	public static String getCurrentDatePlusOneYear() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date currentDate = new Date();
		Calendar c = Calendar.getInstance();
        c.setTime(currentDate);
        c.add(Calendar.YEAR, 1);
        Date currentDatePlusOneYear = c.getTime();
		return dateFormat.format(currentDatePlusOneYear);
	}
	
	public static String getCurrentDatePlusFiveYears() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date currentDate = new Date();
		Calendar c = Calendar.getInstance();
        c.setTime(currentDate);
        c.add(Calendar.YEAR, 5);
        Date currentDatePlusFiveYears = c.getTime();
		return dateFormat.format(currentDatePlusFiveYears);
	}
	
	public static String getCurrentDatePlusTenYears() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date currentDate = new Date();
		Calendar c = Calendar.getInstance();
        c.setTime(currentDate);
        c.add(Calendar.YEAR, 10);
        Date currentDatePlusTenYears = c.getTime();
		return dateFormat.format(currentDatePlusTenYears);
	}
	
	public static String getCurrentDateMinusOneYear() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date currentDate = new Date();
		Calendar c = Calendar.getInstance();
        c.setTime(currentDate);
        c.add(Calendar.YEAR, -1);
        Date currentDateMinusOneYear = c.getTime();
		return dateFormat.format(currentDateMinusOneYear);
	}
	
	public static String getCurrentDatePlusXDays(int dayCount) {
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date currentDate = new Date();
		Calendar c = Calendar.getInstance();
	    c.setTime(currentDate);
	    c.add(Calendar.DATE, dayCount);
	    Date currentDatePlusOneDay = c.getTime();
		return dateFormat.format(currentDatePlusOneDay);	
	}
	
	public static String getCurrentDateMinusXYears(int yearCount) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date currentDate = new Date();
		Calendar c = Calendar.getInstance();
        c.setTime(currentDate);
        c.add(Calendar.YEAR, -yearCount);
        Date currentDateMinusOneYear = c.getTime();
		return dateFormat.format(currentDateMinusOneYear);
	}
	
	public static String getTomorrowsDayAndDate(){
	
	SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, MMMMM d, yyyy");
		Calendar today = Calendar.getInstance();
		 today.add(Calendar.DAY_OF_YEAR, 1);
		 String tomorrowsDayNDate = dateFormat.format(today.getTime());
		 return tomorrowsDayNDate;
	}
	
	public static String getDayAfterTomorrowsDayAndDate(){
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, MMMMM d, yyyy");
			Calendar today = Calendar.getInstance();
			 today.add(Calendar.DAY_OF_YEAR, 2);
			 String tomorrowsDayNDate = dateFormat.format(today.getTime());
			 return tomorrowsDayNDate;
		}
	
	public static String getCurrentDateFormat4(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/d/yyyy");
		Calendar today = Calendar.getInstance();
		String currentdate = dateFormat.format(today.getTime());
		return currentdate ;
		}
	
	public static String getCurrentDateFormatPlusOne(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/d/yyyy");
		Calendar today = Calendar.getInstance();
		today.add(Calendar.DAY_OF_YEAR, 1);
		String currentdate = dateFormat.format(today.getTime());
		return currentdate ;
		}
	
	public static String getCurrentDateFormatPlusTwo(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/d/yyyy");
		Calendar today = Calendar.getInstance();
		today.add(Calendar.DAY_OF_YEAR, 2);
		String currentdate = dateFormat.format(today.getTime());
		return currentdate ;
		}
}
	
	