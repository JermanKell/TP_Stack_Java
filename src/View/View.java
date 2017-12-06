package View;

import java.util.ArrayList;
import java.util.List;

public class View {
	private List<Integer> lToDisplay;
	private int id = 0;
	
	public View() {
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
	public void Update(List<Integer> stContent) {
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

	public void ListToDisp() {
		
	}



}
