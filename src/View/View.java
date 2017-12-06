package View;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class View extends JFrame{
	
	private List<Integer> lToDisplay;
	private int id = 0;
	private JLabel label = new JLabel();
	
	public View() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
	    this.setSize(200, 80);
	    
		lToDisplay = new ArrayList<Integer>();
		id++;
	}
	
	/*
	 * Fonction assurant la mise a jour du sous tableau de valeurs propre a chaque vue en fonction de leur id
	 * id = 1 => Affichage des 10 premiers nombres du dessus
	 * id = 2 => Affichage des 5 derniers nombres du dessous
	 * Si le sous tableau n'est pas égal a ce qui est recupere, alors on assigne le nouveau sous tableau
	 *
	 */
	public void update(List<Integer> stContent) {
		int startIndex = 0;
		int endIndex = 0;
		if (id == 1) {
			startIndex = stContent.size()-10;
			if (startIndex < stContent.size()) {
				startIndex = 0;
				endIndex = stContent.size();
			}
		}		
		
		if (id == 2) {
			if (stContent.size() < 5)	endIndex = stContent.size();
			else endIndex = 5;
		}
		
		if (!lToDisplay.equals(stContent.subList(startIndex, endIndex))) {
			lToDisplay = stContent.subList(startIndex, endIndex);
		}
	}

	/*
	 * Methode liee a l'affichage graphique du contenu des sous tableaux propres a chaque vue
	 * (des champs textes suffisent)
	 */
	public void ListToDisp() {
		
	}
	
	public int getId() {
		return id;
	}



}
