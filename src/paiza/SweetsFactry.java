package paiza;

import java.util.*;
public class SweetsFactry {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int machine = sc.nextInt();
			int[] machines = new int[machine];
			int sweets = sc.nextInt();
			int min = 0;
			int result = 0;
			for(int i=0;i<machine;i++) {
				machines[i]= sc.nextInt();
				int number = sweets % machines[i];
				if(i==0) {
					min = number;
					result = i;
				}else if(min == number) {
					if(machines[i] > machines[result] ) {
						result = i;
					}
				}else if(min > number) {
					min = number;
					result = i;
				}
			}
			System.out.println(result+1);
		}
	}
}