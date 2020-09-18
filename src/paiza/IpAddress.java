package paiza;
import java.util.Scanner;


public class IpAddress {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int howMany = sc.nextInt();
			String[] ipAddresses = new String[howMany];
			for(int i=0;i<howMany;i++) {
				ipAddresses[i] = sc.next();
				String[] dot = ipAddresses[i].split("");
				boolean dotCheck = dotCheck(dot);
				boolean addressCheck = addressCheck(ipAddresses[i]);
				if(dotCheck && addressCheck) {
					System.out.println("True");
				}else {
					System.out.println("False");
				}
			}
		}
	}

	public static boolean dotCheck(String[] dot) {
		int dotCheck = 0;
		for(int i=0;i<dot.length;i++) {
			String test = dot[i];
			String tests = ".";
			if(test.equals(tests)) {
				dotCheck++;
			}
		}
		if(dotCheck == 3) {
			return true;
		}else {
			return false;
		}
	}

	public static boolean addressCheck(String ipAddresses) {
		int addressCheck = 0;
		String[] print = ipAddresses.split("\\.",0);
		for(int y=0;y<print.length;y++) {
			try {
				int check = Integer.parseInt(print[y]);
				if(check <= 255 && check >= 0) {
					addressCheck++;
				}

			} catch (NumberFormatException e) {
			}

		}
		if(addressCheck == 4) {
			return true;
		}else {
			return false;
		}
	}
}
