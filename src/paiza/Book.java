package paiza;

import java.util.Scanner;


public class Book {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int category = sc.nextInt();
			String[] categories = new String[category];
			int[] length = new int[category];

			for(int i=0;i<category;i++) {
				categories[i] = sc.next();
				length[i] = categories[i].length();
			}

			int data = sc.nextInt();
			String[][] list = new String[data][category];



			for(int i=0;i<data;i++) {
				for(int y=0;y<category;y++) {
					list[i][y] = sc.next();
				}
			}

			for(int i=0;i<category;i++) {
				for(int y=0;y<data;y++) {
					if(length[i] < list[y][i].length()) {
						length[i] = list[y][i].length();
					}
				}
			}

			for(int i=0;i<category;i++) {
				System.out.print("| "+categories[i]);
				int space = categories[i].length();
				for(int y=0;y<length[i] - space;y++) {
					System.out.print(" ");
				}
				if(i == category-1) {
					System.out.println(" |");
				}else {
					System.out.print(" ");
				}

			}

			for(int i=0;i<category;i++) {
				System.out.print("|-");
				for(int y=0;y<length[i];y++) {
					System.out.print("-");
				}
				if(i == category-1) {
					System.out.println("-|");
				}else {
					System.out.print("-");
				}
			}

			for(int y=0;y<data;y++) {
				for(int i=0;i<category;i++) {
					System.out.print("| "+list[y][i]);
					int space = list[y][i].length();
					for(int t=0;t<length[i] - space;t++) {
						System.out.print(" ");
					}
					if(i == category-1) {
						System.out.println(" |");
					}else {
						System.out.print(" ");
					}
				}
			}
		}
	}
}