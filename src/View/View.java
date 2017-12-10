package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.*;
import javax.swing.*;
import Stack.Stack;
import Observer_pattern.Observer;

public class View extends JFrame{
	
	/**
	 * Pile li�e � la vue
	 **/
	private Stack stack;
	
	/**
	 * Identifiant de la vue attach�e � la pile
	 */
	private int id;
	
	/**
	 * Champ pour la fenetre 1
	 */
	private JLabel label;
	
	/**
	 * Champ pour la fenetre 2
	 */
	private JList<String> jlist;
	
	/**
	 * Constructeur d'objet de type Vue
	 * @param typeView	Identifiant de la Vue et qui donne son r�le
	 * @param stack	Objet de type Stack permettant de recuperer un sous-ensemble
	 * 		d'entiers pour l'affichage du dessus ou du dessous de la pile
	 */
	public View(int typeView, Stack stack) {
		this.stack = stack;
		id = typeView;
		
		setTitle(Integer.toString(id));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setAlwaysOnTop(true);
	    ConfigureView();
	    setVisible(true);
	    
	    // Ajoute la fen�tre en tant qu'observateur de la pile
	    this.stack.Attach(new Observer(){
	      public void update(List<Integer> stContent) {
	    	  updateField(stContent);
	      }
	    });
	}
	
	/**
	 * Permet la fermeture d'une vue
	 */
	public void Quit() {
		dispose();
	}
	
	/**
	 * Renvoie l'identifiant d'une Vue correspondant � son r�le
	 * @return id	
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Configure la Vue lors de son appel dans le constructeur de cet objet
	 */
	private void ConfigureView() {
		switch(id) {
		//fen�tre qui affiche le sommet de la pile
		case 1:
			label = new JLabel();
			label.setHorizontalAlignment(JLabel.CENTER);
			getContentPane().add(label, BorderLayout.CENTER);
			setSize(250, 60);
			setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/ 4, Toolkit.getDefaultToolkit().getScreenSize().height / 4);
			break;
		//fen�tre qui affiche les 5 valeurs depuis le bas de la pile
		case 2:
			jlist = new JList<String>();
			DefaultListCellRenderer centerRenderer = new DefaultListCellRenderer();
			centerRenderer.setHorizontalAlignment(JLabel.CENTER);
			jlist.setCellRenderer(centerRenderer);
			getContentPane().add(jlist, BorderLayout.CENTER);
			setSize(250, 200);
			setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/ 2, Toolkit.getDefaultToolkit().getScreenSize().height / 4);
			break;
		//mauvais param�tre: ferme la fen�tre
		default:
			Quit();
		}
	}
	
	/**
	 * Permet de mettre � jour la sous-liste d'entiers de la Vue correspondant 
	 * 		au dessus ou au dessous de la pile
	 * @param stContent		Liste d'entiers de la pile
	 */
	private void updateField(List<Integer> stContent) {
		int sizeStack = stContent.size();
		switch(id) {
			case 1:
				if(sizeStack > 0)
					label.setText(Integer.toString(stContent.get(stContent.size() -1)));
				else
					label.setText("pile vide");
				break;
			case 2:
				int NbBasPile = 5;
				
				DefaultListModel<String> dlm = new DefaultListModel<String>();
				jlist.setModel(dlm);
				
				if(sizeStack >= NbBasPile)
					for(int i = NbBasPile-1; i >= 0; i--)
						dlm.addElement(Integer.toString(stContent.get(i)));	
				else if(sizeStack > 0)
					for (int i = sizeStack-1; i>= 0; i--)
						dlm.addElement(Integer.toString(stContent.get(i)));
				else
					dlm.addElement("pile vide");
				break;
		}
	}
}
