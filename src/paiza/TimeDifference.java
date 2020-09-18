package paiza;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TimeDifference {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int country = sc.nextInt();
			@SuppressWarnings("unused")
			Map<String, Integer> countryMap = new HashMap<>();
			int[] timeDifference = new int[country];
			for(int i=0;i<country;i++) {
				@SuppressWarnings("unused")
				String countryName = sc.next();
				timeDifference[i]= sc.nextInt();
			}
			@SuppressWarnings("unused")
			String localCountryName = sc.next();
			String localTime = sc.next();
			Calendar  localCountryTime = stringChangeDate(localTime);

			for(int time : timeDifference) {
				calcTimeDifference(localCountryTime,time);
			}
		}
	}

    public static Calendar stringChangeDate(String localTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            Date date = null;
			try {
				date = sdf.parse(localTime);
			} catch (ParseException e) {
				e.printStackTrace();
			}
            Calendar localCountryTime = Calendar.getInstance();
            localCountryTime.setTime(date);
            return localCountryTime;
    }

    @SuppressWarnings("static-access")
	public static void calcTimeDifference(Calendar localCountryTime,int timeDifference) {
    	localCountryTime.add(localCountryTime.HOUR, timeDifference);
    	Date  calcTimeDifference = localCountryTime.getTime();
    	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        System.out.println(sdf.format(calcTimeDifference));

	}


    }
