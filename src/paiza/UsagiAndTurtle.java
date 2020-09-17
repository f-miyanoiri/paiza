package paiza;
import java.util.Scanner;

public class UsagiAndTurtle {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int distance = sc.nextInt();
			int usagiSpeed = sc.nextInt();
			int usagiHandy = sc.nextInt();
			int usagiBreak = sc.nextInt();
			int turtleSpeed = sc.nextInt();
			int usagiTime = 0;
			int turtleTime = 0;
			int usagiCheck = 0;

			for(int i=0;i<distance;i++) {
				usagiTime += usagiSpeed;
				usagiCheck++;
				turtleTime += turtleSpeed;
				if(usagiCheck == usagiHandy && !(i == distance-1)) {
					usagiCheck = 0;
					usagiTime += usagiBreak;
				}
			}

			if(usagiTime == turtleTime) {
				System.out.println("DRAW");
			}else if(usagiTime < turtleTime) {
				System.out.println("USAGI");
			}else {
				System.out.println("KAME");
			}

		}
	}
}
