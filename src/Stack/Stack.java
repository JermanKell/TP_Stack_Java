package Stack;

import java.util.ArrayList;
import java.util.List;

import Observer_pattern.*;
import View.View;

public class Stack implements Subject{
	
	private List<Integer> stackCont;
	private List<View> lView;
	private List<Observer> lObs;
	private int nbObs = 0; 
	
	public Stack() {
		stackCont = new ArrayList<Integer>();
		lView = new ArrayList<View>();
		lObs = new ArrayList<Observer>();
	}	
	
	public void Attach(Observer obs) {
		lObs.add(obs);
		nbObs++;
	}
	
	public void Detach(Observer obs) {
		for (Observer ob : lObs) {
			if (ob.equals(obs)) {
				lObs.remove(ob);
			}
		}
		
	}
	
	public void Notify() {
		for (Observer obs : lObs) 
			obs.update(stackCont);		
	}	
	
	public void run() {
		
	}
}
