package paiza;
import java.util.Scanner;


public class Periods {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {

			int periods = sc.nextInt();
			int unit = sc.nextInt();
			int[] data = new int[periods];
			int[] divisorData = new int[periods];
			int maxData = 0;

			for(int i=0;i<periods;i++) {
				data[i]= sc.nextInt();
				divisorData[i] = data[i] / unit;
				if(maxData < divisorData[i]) {
					maxData = divisorData[i];
				}
			}

			String[] anser = new String[maxData];

			for(int i=0;i<periods;i++) {
				String number = String.valueOf(i + 1);
				anser[i] =  number + ":";
				print(anser, divisorData, maxData, i);
			}
		}

	}

	public static void print(String[] anser,int[]divisorData,int maxData,int howMany) {
		for(int i=0;i<divisorData[howMany];i++) {
			anser[howMany] += "*";
		}
		for(int i=0;i<maxData - divisorData[howMany];i++) {
			anser[howMany] += ".";
		}
		System.out.println(anser[howMany]);
	}
}
