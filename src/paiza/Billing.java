package paiza;
import java.util.Scanner;

public class Billing {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int HowMany = sc.nextInt();
			int[] billing = new int[10000];

			for(int i=0;i<HowMany;i++) {
				int whoBilling = sc.nextInt();
				billing[whoBilling-1]++;
			}
			int max = 0;
			for(int i=0;i<HowMany;i++) {
				if(billing[i] > max) {
					max = billing[i];
				}
			}
			int check = 0;
			for(int i=0;i<HowMany;i++) {
				if(max == billing[i]) {
					if(check == 0) {
						System.out.print(i+1);
						check++;
					}else {
						System.out.print(" "+(i+1));
					}
				}
			}
		}
	}
}
