package paiza;

import java.util.Scanner;


public class Tyle {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int k = sc.nextInt();
			int n = sc.nextInt();
			String[][] test = new String[n][n];

			for(int i=0;i<n;i++) {
				String[] hoge = sc.next().split("");
				for(int y=0;y<n;y++) {
					test[i][y] = hoge[y];
				}
			}

			print(test,n,k);
		}
	}

	public static void print(String[][] test,int n,int key) {
		if(key >= 1) {
			int newn = n*n;
			String[][] nowTest = new String[newn][newn];
			int height = 0;
			int width = 0;
			for(int i=0;i<n;i++) {
				for(int y=0;y<n;y++) {
					if(test[i][y].equals("#")) {
						for(int k=0;k<n;k++) {
							for(int t=0;t<n;t++) {
								nowTest[k+height][t+width] = test[k][t];
							}
						}
					}else {
						for(int k=0;k<n;k++) {
							for(int t=0;t<n;t++) {
								nowTest[k+height][t+width] = ".";
							}
						}
					}
					width += n;
				}
				width = 0;
				height += n;
			}

			key--;

			print(nowTest, newn, key);
		}else {
			for(int i=0;i<n;i++) {
				for(int y=0;y<n;y++) {
					System.out.print(test[i][y]);
				}
				System.out.println("");
			}
		}
	}
}