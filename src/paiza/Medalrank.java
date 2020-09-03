package paiza;

import java.util.*;
public class Medalrank {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			//参加国
			int countries = sc.nextInt();
			//メダル格納用配列
			int[][] medals = new int[countries][3];
			//メダル情報取得
			for(int i=0;i<countries;i++) {
				medals[i][0] = sc.nextInt();
				medals[i][1] = sc.nextInt();
				medals[i][2] = sc.nextInt();
			}

			//メダルランキングソート
			for(int i=0;i<countries;i++) {
				//金メダルの最大値を取得
				int max = checkMax(medals,countries);
				//金メダルが最大値のデータをArrayListに取得
				ArrayList<Integer> checkGold = checkPeer(medals, countries, max);
				//最大値と同数所持しているデータが複数ある場合は銀メダルの数を比較
				if(checkGold.size() > 1) {
					//メダル種別判断用(0:金,1:銀,2:銅)
					int color = 1;
					//金メダルが最大値と同数のデータのみで銀メダルの数を比較
					max = checkMax(medals, color, checkGold);
					//銀メダルが最大値のデータをArrayListに取得
					ArrayList<Integer> checkSilver = checkPeer(medals, color, max, checkGold);
					//最大値と同数所持しているデータが複数ある場合は銅メダルの数を比較
					if(checkSilver.size() > 1) {
						color = 2;
						//銀メダルが最大値と同数のデータのみで銅メダルの数を比較
						max = checkMax(medals, color, checkSilver);
						//銅メダルが最大値のデータをArrayListに取得
						ArrayList<Integer> checkBronze = checkPeer(medals, color, max, checkSilver);
						//結果を出力し配列から該当データのデータを削除
						medals = anserPrint(medals, checkBronze);
					}else {
						//銀メダルの最大値と同じデータが一つの場合はここで結果出力
						medals = anserPrint(medals, checkSilver);
					}
				}else {
					//金メダルの最大値と同じデータが一つの場合はここで結果出力
					medals = anserPrint(medals, checkGold);
				}
			}
		}
	}

	/**
	 * 金メダルの最大個数を取得するメソッド
	 * @param medals　各国メダルデータ
	 * @param countries　参加国数
	 * @return　max　金メダルの最大値
	 */
	public static int checkMax(int[][] medals,int countries) {
		int max = 0;
		for(int i=0; i<countries;i++) {
			if(max <= medals[i][0]) {
				max = medals[i][0];
			}
		}
		return max;
	}

	/**
	 * 銀、銅メダルの最大個数を取得するメソッド
	 * @param medals　各国メダルデータ
	 * @param color　メダル種別
	 * @param checkPeer　金、銀メダルの最大個数と同数所持しているデータの配列番号
	 * @return　max　一つランク下のメダルの最大個数
	 */
	public static int checkMax(int[][] medals,int color,ArrayList<Integer> checkPeer) {
		int max = 0;
		for(int i=0; i<checkPeer.size();i++) {
			if(max <= medals[checkPeer.get(i)][color]) {
				max = medals[checkPeer.get(i)][color];
			}
		}
		return max;
	}

	/**
	 * 最大個数と同数所持しているデータの配列番号をArrayListでリターンするメソッド(金メダル用)
	 * @param medals　各国メダルデータ
	 * @param countries　参加国数
	 * @param max　最大個数
	 * @return checkPeer 最大個数と同数所持しているデータの配列番号
	 */
	public static ArrayList<Integer> checkPeer(int[][] medals,int countries,int max) {
		ArrayList<Integer> checkPeer = new ArrayList<>();
		for(int i=0;i<countries;i++) {
			if(max == medals[i][0]) {
				checkPeer.add(i);
			}
		}
		return checkPeer;
	}

	/**
	 * 	最大個数と同数所持しているデータの配列番号をArrayListでリターンするメソッド(銀、銅メダル用)
	 * @param medals　各国メダルデータ
	 * @param　color メダル種別
	 * @param max　最大個数
	 * @param checkPeer 最大個数と同数所持しているデータの配列番号
	 * @return　checkPeer　 最大個数と同数所持しているデータの配列番号
	 */
	public static ArrayList<Integer> checkPeer(int[][] medals,int color,int max,ArrayList<Integer> checkPeer) {
		ArrayList<Integer> peerRank = new ArrayList<>();
		for(int i=0;i<checkPeer.size();i++) {
			if(medals[checkPeer.get(i)][color] == max){
				peerRank.add(checkPeer.get(i));
			}
		}
		return peerRank;
	}

	/**
	 * 結果出力用メソッド
	 * 結果を出力後に配列から対象データを削除
	 * @param medals　各国メダルデータ
	 * @param rankNumber　対象の配列番号
	 * @return
	 */
	public static int[][] anserPrint(int[][]medals,ArrayList<Integer> rankNumber){
		System.out.println(medals[rankNumber.get(0)][0] + " " + medals[rankNumber.get(0)][1] + " " + medals[rankNumber.get(0)][2]);
		medals[rankNumber.get(0)][0] = 0;
		medals[rankNumber.get(0)][1] = 0;
		medals[rankNumber.get(0)][2] = 0;
		return medals;
	}

}
