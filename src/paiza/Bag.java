package paiza;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Bag {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int bag = sc.nextInt();
			int howMany = sc.nextInt();
			int[] items = new int[howMany];
			int anser = 0;
			int coinCase = 0;
			List<Integer> counts = new ArrayList<>();

			for(int i=0;i<howMany;i++) {
				items[i]= sc.nextInt();
			}

			for (int i = 0; i < 1 << howMany; i++) {
				for (int j = 0; j < howMany; j++) {

					if ((1 & i >> j) == 1) {
						coinCase += items[j];
						counts.add(items[j]);
					}
				}

				if (coinCase >= bag) {
					boolean bagCheck = true;

					for(int k=0;k<counts.size();k++) {
						if(coinCase - counts.get(k) >= bag) {
							bagCheck = false;
						}
					}

					if(bagCheck) {
						anser++;
						coinCase = 0;
					}
				}

				counts = new ArrayList<>();
				coinCase = 0;
			}

			System.out.println(anser);
		}
	}
}