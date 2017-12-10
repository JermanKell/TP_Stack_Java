package Main;

import Stack.*;
import View.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

import Menu.*;

public class Main 
{

	public static void main(String[] args) 
	{
		Stack pile = new Stack();
		new View(1, pile);
		new View(2, pile);
		new Interface(pile);
	}	
}	
	
