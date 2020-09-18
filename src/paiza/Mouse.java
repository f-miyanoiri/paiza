package paiza;
import java.util.Scanner;

public class Mouse {
	public static String direction;
	public static int mouseHeight;
	public static int mouseWidth;
	public static String[][] townMap;
	public static Boolean poorOrRich;

	Mouse(String direction,int mouseHeight,int mouseWidth,String[][] townMap,Boolean poorOrRich){
		Mouse.direction = direction;
		Mouse.mouseHeight = mouseHeight;
		Mouse.mouseWidth = mouseWidth;
		Mouse.townMap = townMap;
		Mouse.poorOrRich = poorOrRich;
	}

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int height = sc.nextInt();
			int width = sc.nextInt();
			String[][] townMap = new String[height][width];
			int mouseHeight = sc.nextInt() - 1;
			int mouseWidth = sc.nextInt() - 1;
			String direction = "north";
			boolean poorOrRich = true;

			for(int i=0;i<height;i++) {
				String[] testMap = sc.next().split("");
				for(int y=0;y<width;y++) {
					townMap[i][y] = testMap[y];
				}
			}

			if(townMap[mouseHeight][mouseWidth].equals("*")) {
				poorOrRich = false;
			}else {
				poorOrRich = true;
			}
			@SuppressWarnings("unused")
			Mouse main = new Mouse(direction, mouseHeight, mouseWidth, townMap, poorOrRich);
			try {
				changePoorAndRich();
			}catch (ArrayIndexOutOfBoundsException e) {
			}

			for(int i=0;i<height;i++) {
				for(int y=0;y<width;y++) {
					System.out.print(townMap[i][y]);
				}
				System.out.println("");
			}

		}
	}

	public static void ChangeDirection() {

		if(poorOrRich) {
			if(direction.equals("north")) {
				direction = "east";
			}else if(direction.equals("south")) {
				direction = "west";
			}else if(direction.equals("east")) {
				direction = "south";
			}else {
				direction = "north";
			}
		}else {
			if(direction.equals("north")) {
				direction = "west";
			}else if(direction.equals("south")) {
				direction = "east";
			}else if(direction.equals("east")) {
				direction = "north";
			}else {
				direction = "south";
			}
		}

		junp();

	}

	public static void junp(){
		if(direction.equals("north")) {
			mouseHeight--;
		}else if(direction.equals("south")) {
			mouseHeight++;
		}else if(direction.equals("east")) {
			mouseWidth++;
		}else {
			mouseWidth--;
		}

		changePoorAndRich();
	}

	public static void changePoorAndRich(){

		if(townMap[mouseHeight][mouseWidth].equals("*")) {
			poorOrRich = false;
			townMap[mouseHeight][mouseWidth] = ".";
		}else {
			poorOrRich = true;
			townMap[mouseHeight][mouseWidth] = "*";
		}

		ChangeDirection();
	}
}
