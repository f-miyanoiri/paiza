package paiza;

import java.util.Scanner;

public class PageNation {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int number = sc.nextInt();
			int displayed = sc.nextInt();
			int page = sc.nextInt();
			int check=0;
			int pageNation = page * displayed - displayed + 1;

			for(int i= pageNation;i<pageNation+displayed;i++) {
				if(i>number) {
					break;
				}
				check++;
				if(i == pageNation) {
					System.out.print(i);
				}else {
					System.out.print(" "+i);
				}
			}
			if(check==0) {
				System.out.println("none");
			}
		}
	}
}