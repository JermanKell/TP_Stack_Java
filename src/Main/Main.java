package Main;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import Stack.*;
import View.*;

public class Main {

	public static void main(String[] args) {
		Stack pile = new Stack();
		new View(1, pile);
		new View(2, pile);
		pile.Clear();
		try {
			TimeUnit.SECONDS.sleep(2);
			pile.Push(5);
			TimeUnit.SECONDS.sleep(2);
			pile.Push(3);
			TimeUnit.SECONDS.sleep(2);
			pile.Push(12);
			TimeUnit.SECONDS.sleep(2);
			pile.Push(9);
			TimeUnit.SECONDS.sleep(2);
			pile.Push(63);
			TimeUnit.SECONDS.sleep(2);
			pile.Push(11);
			TimeUnit.SECONDS.sleep(2);
			pile.Push(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//Scanner sc = new Scanner(System.in);
		
		
		/*while (true) {
			System.out.println("Which action must I do ?\n");
			String cmd = sc.nextLine();
			if (cmd.equalsIgnoreCase("PUSH")) {
				
			}
		}*/
	}

}
