package paiza;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class GamePoint {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int param = sc.nextInt();
			int user = sc.nextInt();
			int winner = sc.nextInt();
			Double[] items = new Double[param];
			Double[] points = new Double[user];
			for(int i=0;i<param;i++) {
				items[i] = sc.nextDouble();
			}
			for(int i=0;i<user;i++) {
				for(int y=0;y<param;y++) {
					Double haveItem = sc.nextDouble();
					try {
						points[i] +=  items[y] * haveItem;
					}catch (NullPointerException e) {
						points[i] =  items[y] * haveItem;
					}
				}
			}

			Arrays.sort(points, Collections.reverseOrder());

			for(int i=0;i<winner;i++) {
				System.out.println(Math.round(points[i]));
			}
		}
	}
}