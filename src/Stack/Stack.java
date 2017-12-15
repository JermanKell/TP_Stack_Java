package Stack;

import java.util.*;
import Observer_pattern.Subject;
import Observer_pattern.Observer;

public class Stack implements Subject{
	/**
	 * Liste d'entiers contenant les entiers de la pile
	 */
	private List<Integer> stackCont;
	
	/**
	 * Liste d'observateurs ayant un regard sur la pile
	 */
	private List<Observer> lObs;
	
	/** 
	 * Constructeur de l'objet Stack qui initialise
	 * 		les liste d'observateurs et la liste d'entiers
	 */
	public Stack() {
		stackCont = new ArrayList<Integer>();
		lObs = new ArrayList<Observer>();
	}	
	
	/**
	 * Permet l'ajout d'un entier dans la pile
	 * @param val	Valeur à ajouter sur le dessus de la pile
	 */
	public void Push(int val) {
		stackCont.add(val);
		Notify();
	}
	
	/**
	 * Retire le dernier element present sur le dessus de la pile et 
	 * 		notifie les observateurs
	 */
	public void Pop() {
		if(stackCont.size() > 0){
			stackCont.remove(stackCont.size() -1);
			Notify();
		}
	}
	
	/**
	 * Vide la pile et notifie tous les observateurs
	 */
	public void Clear() {
		stackCont.clear();
		Notify();
	}
	
	////////////////////// Methodes intégrant le Pattern Observer //////////////
	
	/**
	 *  Ajoute un observateur
	 */
	public void Attach(Observer obs) {
		lObs.add(obs);
	}
	
	/** 
	 * Retire un observateur
	 */
	public void Detach(Observer obs) {
		Iterator<Observer> it = lObs.iterator();
		while(it.hasNext()) {
			Observer ob = it.next();
			if(ob.equals(obs))
				it.remove();
		}
	}
	
	/** 
	 * Informe tous les observateurs que l'observable (pile) à changer
	 */
	public void Notify() {
		for (Observer obs : lObs) 
			obs.update(stackCont);		
	}	
}
