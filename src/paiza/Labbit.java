package paiza;
import java.util.Scanner;

public class Labbit {
	public static int[] bushes;

	Labbit(int[] bushes){
		Labbit.bushes = bushes;
	}

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int bush = sc.nextInt();
			int[] bushes = new int[bush];
			int labbit = sc.nextInt();
			int junp = sc.nextInt();
			for(int i=0;i<labbit;i++) {
				bushes[sc.nextInt()-1] = i+1;
			}
			@SuppressWarnings("unused")
			Labbit main = new Labbit(bushes);
			for(int i=0;i<junp;i++) {
				for(int y=0;y<labbit;y++) {
					searchLabbit(y+1);
				}
			}

			for(int i=0;i<labbit;i++) {
				for(int y=0;y<bushes.length;y++) {
					if(i+1 == bushes[y]) {
						System.out.println(y+1);
					}
				}

			}

		}
	}

	public static void searchLabbit(int number) {
		int whereLabbit = 0;
		for(int i=0;i<bushes.length;i++) {
			if(number == bushes[i]) {
				whereLabbit = i;
				labbitJunp(whereLabbit,number);
				break;
			}
		}

	}

	public static void labbitJunp(int whereLabbit,int number) {
		int nowSerch = whereLabbit+1;
		if(nowSerch >= bushes.length) {
			nowSerch = 0;
		}
		for(int i=nowSerch;i<bushes.length;i++) {
			if(bushes[i] == 0) {
				bushes[i] = number;
				bushes[whereLabbit] = 0;
				break;
			}
			if(i == bushes.length-1) {
				i=-1;
			}
		}

	}
}
