package paiza;

import java.util.Scanner;


public class bread {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int breadType = sc.nextInt();
			int query = sc.nextInt();
			int[] breadPrice = new int[breadType];
			int[] numberOfBread = new int[breadType];

			for(int i=0;i<breadType;i++) {
				breadPrice[i] = sc.nextInt();
				numberOfBread[i] = sc.nextInt();
			}

			int[] purchase = new int[breadType];

			for(int i=0;i<query;i++) {
				boolean availableForPurchase = true;
				boolean buyOrBake = true;
				String buyBake = sc.next();
				buyOrBake = buyOrBake(buyBake);

				if(buyOrBake) {
					for(int y=0;y<breadType;y++) {
						purchase[y] = sc.nextInt();
						if(numberOfBread[y] < purchase[y]) {
							availableForPurchase = false;
						}
					}

					if(availableForPurchase) {
						int howMach = 0;
						for(int k=0;k<breadType;k++) {
							numberOfBread[k] -= purchase[k];
							howMach += breadPrice[k] * purchase[k];
						}
						System.out.println(howMach);
					}else {
						System.out.println("-1");
					}

				}else {
					for(int t=0;t<breadType;t++) {
						int addBread = sc.nextInt();
						numberOfBread[t] += addBread;
					}

				}
			}
		}
	}

	public static boolean buyOrBake(String buyBake) {
		if(buyBake.equals("buy")) {
			return true;
		}else {
			return false;
		}
	}
}