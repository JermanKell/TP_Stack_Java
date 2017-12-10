package Stack;

import java.util.*;
import Observer_pattern.Subject;
import Observer_pattern.Observer;

public class Stack implements Subject{
	/** La pile*/
	private List<Integer> stackCont;
	
	/** Liste de tous les observateurs de la pile*/
	private List<Observer> lObs;
	
	/** Constructeur
	 * Initialise la pile et la liste des observateurs
	 */
	public Stack() {
		stackCont = new ArrayList<Integer>();
		lObs = new ArrayList<Observer>();
	}	
	
	/** Ajoute un entier dans la pile et notifie les observateurs*/
	public void Push(int val) {
		stackCont.add(val);
		Notify();
	}
	
	/** Retire le dernier élément de la pile et notifie les observateurs*/
	public void Pop() {
		if(stackCont.size() > 0){
			stackCont.remove(stackCont.size() -1);
			Notify();
		}
	}
	
	/** Vide la pile et notifie les observateurs*/
	public void Clear() {
		stackCont.clear();
		Notify();
	}
	
	////////////////////// Methodes intégrant le Pattern Observer //////////////
	
	/** Ajoute un observateur*/
	public void Attach(Observer obs) {
		lObs.add(obs);
	}
	
	/** Retire un observateur*/
	public void Detach(Observer obs) {
		for (Observer ob : lObs)
			if (ob.equals(obs))
				lObs.remove(ob);
	}
	
	/** Informe tous les observateurs que l'observable (pile) à changé*/
	public void Notify() {
		for (Observer obs : lObs) 
			obs.update(stackCont);		
	}	
}
