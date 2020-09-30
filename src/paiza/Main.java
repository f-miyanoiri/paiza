package paiza;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
			int nowYear = sc.nextInt();
			int nowMonth = sc.nextInt();
			int nowDay = sc.nextInt();
			int nextMonth = sc.nextInt();
			int nextDay = sc.nextInt();
			int nextYear = nowYear;
			int anotherDay = 0;
			int difference = 0;

			for(int i=nextYear;!(i%4==1);i++) {
				difference++;
			}
			if(nowMonth <= nextMonth) {
				difference++;
			}
			if (difference >= 1) {
				anotherDay += 181 * (difference - 1);
			}

			if(nowMonth % 2 ==0) {
				anotherDay += 15 - nowDay;
			}else {
				anotherDay += 13 - nowDay;
			}
			anotherDay += nextDay;

			if(nowMonth == 13) {
				nowMonth = 1;
			}else {
				nowMonth++;
			}

			do {
				if(nowMonth == 13) {
					anotherDay += 13;
					nowMonth = 1;
				}else if((nowMonth + 1) % 2 ==1) {
					anotherDay += 13;
					nowMonth ++;
				}else {
					anotherDay += 15;
					nowMonth ++;
				}
			}while (!(nowMonth == nextMonth));

			System.out.println(anotherDay);
		}
    }
}