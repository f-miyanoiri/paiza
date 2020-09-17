package paiza;
import java.util.Scanner;

public class Flower {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int height = sc.nextInt();
			int width = sc.nextInt();
			String [][] garden = new String[height][width];
			int flower = 0;

			for(int i=0;i<height;i++) {
				String flowerCount = sc.next();
				String[] charChange = flowerCount.split("");
				for(int y=0;y<charChange.length;y++) {
					garden[i][y] = charChange[y];
					if(garden[i][y].equals("#")) {
						flower++;
					}
				}
			}

			flower *= 4;

			for(int i=0;i<height;i++) {
				for(int y=0;y<width;y++) {
					if(garden[i][y].equals("#")) {
						int judgement = flowerCheck(garden, i, y);
						flower -= judgement;
					}
				}
			}

			System.out.println(flower);

		}
	}

	public static int flowerCheck(String[][] garden,int i,int y) {
		int adjacent = 0;

		try {
			if(garden[i+1][y].equals("#")) {
				adjacent++;
			}
		} catch (Exception e) {
		}

		try {
			if(garden[i-1][y].equals("#")) {
				adjacent++;
			}
		} catch (Exception e) {
		}

		try {
			if(garden[i][y+1].equals("#")) {
				adjacent++;
			}
		} catch (Exception e) {
		}

		try {
			if(garden[i][y-1].equals("#")) {
				adjacent++;
			}
		} catch (Exception e) {

		}

		return adjacent;
	}
}
