package testovo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Testovo {

	public static void main(String[] args) throws ParseException {
		
		
		Random random = new Random();
//		int minDay = (int) LocalDate.of(2015, 1, 1).toEpochDay();
//		int maxDay = (int) LocalDate.of(2016, 1, 20).toEpochDay();
//		long randomDay = minDay + random.nextInt(maxDay - minDay);
//
//		LocalDate randomBirthDate = LocalDate.ofEpochDay(randomDay);
//
//		System.out.println(randomBirthDate);
		
		   
//		Calendar calendar = Calendar.getInstance();
//		Date now = calendar.getTime();
//		System.out.println(now);
//		calendar.add(Calendar.YEAR,1);
//		Date oneYearFromNow = calendar.getTime();
//		System.out.println(oneYearFromNow);
		
//		Date dNow = new Date();
//	    SimpleDateFormat ft = new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
//	    System.out.println("Current Date: " + ft.format(dNow));
	    
		int year = (int)(Math.random()*(2016 - 2015) + 2015);
		int month = (int)(Math.random()*(12 - 1) + 1);
		int day = 0;
		switch (month){
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			day = (int)(Math.random()*(31 - 1) + 1);
			break;
		case 2: 
			day = (int)(Math.random()*(28 - 1) + 1);
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			day = (int)(Math.random()*(30 - 1) + 1);
			break;
		}
		
		String string = year + "-" + month + "-" + day + " 08:34:55.705";
		Date dateOfIssue = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(string);
		System.out.println(dateOfIssue);
		
		int days = (int)(Math.random() * (31 - 7) + 7);
		if(days <= 15){
			days = 7;
		}else if(days > 15 && days <= 31){
			days = 31;
		}else if(days > 31){
			days = 365;
		}
		
		String string2;
		Date expirationDate = null;
		
		int year1 = dateOfIssue.getYear() + 1900;
		int month1 = dateOfIssue.getMonth();
		int day1 = dateOfIssue.getDay();
		
		if(days == 7){
			day1 += 7;
			string2 = year1 + "-" + month1 + "-" + day1 + " 08:34:55.705";
			expirationDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(string2);
		}else if(days == 31){
			day1 += 31;
			string2 = year1 + "-" + month1 + "-" + day1 + " 08:34:55.705";
			expirationDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(string2);
		}else if(days == 365){
			day += 365;
			string2 = year1 + "-" + month1 + "-" + day1 + " 08:34:55.705";
			expirationDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(string2);
		}
		
		System.out.println(expirationDate);
	}

}
