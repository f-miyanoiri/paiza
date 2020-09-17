package paiza;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Journy {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int howManySweets = sc.nextInt();
			int money = sc.nextInt();
			int[] sweets = new int[howManySweets];
			List<Integer> costsSave = new ArrayList<>();
			List<Integer> countSave = new ArrayList<>();
			for(int i=0;i<howManySweets;i++) {
				sweets[i]= sc.nextInt();
			}
			int coinCase = 0;
			int count=0;

			for (int i = 0; i < 1 << howManySweets; i++) {
				// bit全探索の全通りのloop

				for (int j = 0; j < howManySweets; j++) {
					// 1loop毎にどの参考書を買うかの判定(j冊目を買うかどうか)

					if ((1 & i >> j) == 1) {

						coinCase += sweets[j];
						count++;
					}
				}

				if (coinCase <= money  && count > 0 ) {
					// 合計値段を一時格納
					costsSave.add(coinCase);
					countSave.add(count);
					count = 0;
					coinCase = 0;
				}else {
					count = 0;
					coinCase = 0;
				}
			}

			serchMax(countSave, costsSave,money);
		}
	}

	public static void serchMax(List<Integer>countSave,List<Integer>costsSave,int money) {
		Integer max = Collections.max(countSave);
		serchAnser(countSave,costsSave,max,money);
	}

	public static void serchAnser(List<Integer>countSave,List<Integer>costsSave,int max,int money) {
		List<Integer> anser = new ArrayList<>();
		for(int i=0;i<costsSave.size();i++) {
			if(countSave.get(i) == max) {
				anser.add(costsSave.get(i));
			}
		}
		Integer price = Collections.max(anser);
		System.out.println(money - price);
	}
}
