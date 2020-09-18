package paiza;
import java.util.Scanner;

public class Window {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int height = sc.nextInt();
			int width = sc.nextInt();
			for(int i=0;i<height;i++) {
				for(int y=0;y<width;y++) {
					int blackOrWhite = sc.nextInt();
					if(blackOrWhite >= 128) {
						System.out.print("1");
					}else {
						System.out.print("0");
					}
					if(y == width-1) {
						System.out.println("");
					}else {
						System.out.print(" ");
					}
				}
			}
		}
	}
}
