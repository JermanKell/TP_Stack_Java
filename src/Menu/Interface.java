package Menu;

import java.util.Scanner;

public class Interface {
	private Scanner sc;
	
	public Interface() {
		sc = new Scanner(System.in);
	}
	
	private void RequestProc(String Proc) {
		
	}
	
	public void run() {
		String processing = null;
		while (true) {
			System.out.println("What do you like to do ?\n");
			processing = sc.nextLine();
			
			RequestProc(processing);
		}
	}
}
