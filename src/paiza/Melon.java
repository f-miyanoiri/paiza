package paiza;

import java.util.*;
public class Melon {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int howMany = sc.nextInt();
			int count = 0;
			String[] menu = new String[howMany];
			for(int i=0;i<howMany;i++) {
				menu[i] = sc.next();
			}
			for(int i=0;i<howMany;i++) {
				if(menu[i].equals("melon")) {
					count++;
					i += 9;
				}
			}
			System.out.println(count);
		}
	}
}