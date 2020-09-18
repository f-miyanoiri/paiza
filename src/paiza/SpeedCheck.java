package paiza;
import java.util.Scanner;
public class SpeedCheck {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int section = sc.nextInt();
			int speedLimit = sc.nextInt();
			int[] roundSpeed = new int[section];
			int[] roundSection = new int[section];
			int outCheck = 0;
			for(int i=0;i<section;i++){
				roundSection[i]= sc.nextInt();
				roundSpeed[i]= sc.nextInt();
			}
			for(int i=1;i<section;i++) {
				try {
					int sectionCheck = roundSection[i] - roundSection[i-1];
					int speedCheck = roundSpeed[i]- roundSpeed[i-1];
					if(speedLimit <= speedCheck / sectionCheck) {
						System.out.println("YES");
						outCheck++;
						break;
					}
				} catch (ArrayIndexOutOfBoundsException e){
				}
			}

			if(outCheck == 0) {
				System.out.println("NO");
			}
		}
	}
}