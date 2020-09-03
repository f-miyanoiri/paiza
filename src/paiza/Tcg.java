package paiza;

import java.util.Scanner;

public class Tcg {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int howMany = sc.nextInt();
			int type = sc.nextInt();
			int[] cards = new int[type];

			for(int i=0;i<howMany;i++) {
				int complete = 0;
				int card = sc.nextInt();
				cards[card-1]++;

				for(int y=0;y<type;y++) {
					if(cards[y] >= 1  ) {
						complete++;
					}
				}

				if(complete == type) {
					System.out.println(i+1);
					break;
				}

				if(i==howMany-1) {
					System.out.println("unlucky");
				}
			}
		}
	}
}