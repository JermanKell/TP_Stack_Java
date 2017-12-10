package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.*;
import javax.swing.*;
import Stack.Stack;
import Observer_pattern.Observer;

public class View extends JFrame{
	
	/** Pile*/
	private Stack stack;
	
	/** Type de fen�tre*/
	private int id;
	
	/** Champ pour la fen�tre n�1*/
	private JLabel label;
	
	/** Champ pour la fen�tre n�2*/
	private JList<String> jlist;
	
	/** Constructeur de la fen�tre*/
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
	
	/** Ferme la fen�tre*/
	public void Quit() {
		dispose();
	}
	
	/** Accesseur du type de la fen�tre*/
	public int getId() {
		return id;
	}
	
	/** Configure la fen�tre � sa creation*/
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
	 * Fonction assurant la mise a jour du sous tableau de valeurs propre a chaque vue en fonction de leur id
	 * id = 1 => Affichage du premier nombre du dessus
	 * id = 2 => Affichage des NbBasPile=5 derniers nombres du dessous
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
