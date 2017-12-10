package Menu;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import Stack.Stack;

public class Interface {
	/**
	 * Objet de type Scanner
	 */
	private Scanner sc;
	
	/**
	 * Objet de type Stack (pile)
	 */
	private Stack stack;
	
	/** Flux de sortie*/
	private PrintWriter file;
	
	/**
	 * Constructeur de la classe Interface
	 * @param stack	Objet de type Pile sur lequel les modifications seront faites
	 */
	public Interface(Stack stack) {
		sc = new Scanner(System.in);
		this.stack = stack;
		
		try {
			file = new PrintWriter(new BufferedWriter(new FileWriter("log.txt", true)));
		} catch (Exception e) {
			e.printStackTrace(file);
		}
		run();
	}
	
	/** 
	 * Analyse et execute la commande saisie par l'utilisateur
	 * @param Proc	Commande tapee par l'utilisateur
	 */
	private void RequestProc(String Proc) {
		if(Proc.toLowerCase().startsWith("push")) {
			try{
			stack.Push(Integer.parseInt(Proc.substring(5)));
			file.println(Proc);
			}
			catch(Exception e) {
				System.out.println("Invalid command syntax. Enter push [integer]");
			}
		}
		else if(Proc.toLowerCase().equals("pop")) {
			stack.Pop();
			file.println(Proc);
		}
		else if(Proc.toLowerCase().equals("clear")) {
			stack.Clear();
			file.println(Proc);
		}
		else if(Proc.toLowerCase().equals("quit")) {
			file.println(Proc);
			file.close();
			System.exit(1);
		}
		else {
			System.out.println("Command not found\nEnter one of these commands:\npush [integer]\npop\nclear\nquit");
		}
	}
	
	/** 
	 * Routine d'utilisation
	 */
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
