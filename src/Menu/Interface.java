package Menu;

import java.util.Scanner;
import Stack.Stack;

public class Interface {
	/** scanner qui lit*/
	private Scanner sc;
	
	/** pile*/
	private Stack stack;
	
	/** Constructeur*/
	public Interface(Stack stack) {
		sc = new Scanner(System.in);
		this.stack = stack;
		run();
	}
	
	/** Analyse et execute la commande saisie par l'utilisateur*/
	private void RequestProc(String Proc) {
		if(Proc.toLowerCase().startsWith("push")) {
			try{
			stack.Push(Integer.parseInt(Proc.substring(5)));
			}
			catch(Exception e) {
				System.out.println("Invalid command syntax. Enter push [integer]");
			}
		}
		else if(Proc.toLowerCase().equals("pop")) {
			stack.Pop();
		}
		else if(Proc.toLowerCase().equals("clear")) {
			stack.Clear();
		}
		else if(Proc.toLowerCase().equals("quit")) {
			System.exit(1);
		}
		else {
			System.out.println("Command not found\nEnter one of these commands:\npush [integer]\npop\nclear\nquit");
		}
	}
	
	/** Terminal*/
	public void run() {
		String processing = null;
		stack.Clear();
		while (true) {
			System.out.println("What do you like to do ?\n");
			processing = sc.nextLine();
			RequestProc(processing);
		}
	}
}
