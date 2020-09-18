package paiza;

import java.util.Scanner;


public class pixel {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int pixel = sc.nextInt();
			int little = sc.nextInt();
			int height = little;
			int width = little;
			int heightCheck = 0;
			int widthCheck = 0;
			int[][] pixels = new int[pixel][pixel];

			for(int i=0;i<pixel;i++) {
				for(int y=0;y<pixel;y++) {
					pixels[i][y]= sc.nextInt();
				}
			}

			int[][] anser = new int[pixel/little][pixel/little];

			for(int i=0;i<pixel;i++) {
				if(i >= height) {
					height += little;
					heightCheck++;
				}
				for(int y=0;y<pixel;y++) {
					if(y >= width) {
						width += little;
						widthCheck++;
					}
					anser[heightCheck][widthCheck] += pixels[i][y];
				}
				width = little;
				widthCheck = 0;
			}

			for(int i=0;i<pixel/little;i++) {
				for(int y=0;y<pixel/little;y++) {
					System.out.print(anser[i][y]/ (little*little) );
					if(y == pixel/little-1) {
						System.out.println("");
					}else {
						System.out.print(" ");
					}
				}
			}
		}
	}
}