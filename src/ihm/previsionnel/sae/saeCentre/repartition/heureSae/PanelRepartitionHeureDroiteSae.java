package ihm.previsionnel.sae.saeCentre.repartition.heureSae;

import javax.swing.JPanel;
import javax.swing.JTextField;

import ihm.previsionnel.sae.saeCentre.repartition.PanelRepartitionSae;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JLabel;

public class PanelRepartitionHeureDroiteSae extends JPanel{
	private JPanel panelC;
	private ArrayList<JTextField> ensTxtFld;
	public PanelRepartitionHeureDroiteSae(){
		this.panelC = new JPanel();
		this.ensTxtFld = new ArrayList<JTextField>();
		for(int i = 0; i < 15; i++){
            JTextField textField = new JTextField(3);
            this.ensTxtFld.add(textField); 
        }
		
		this.panelC.setLayout(new GridBagLayout());
		GridBagConstraints gbcC = new GridBagConstraints();


		// Ajout des composants avec GridBagLayout
        gbcC.gridx = 0;
        gbcC.gridy = 0;
        gbcC.insets = new Insets(9, 0, 2, 0);
		gbcC.gridx = 4;
		this.panelC.add(new JLabel("Σ"), gbcC);
		gbcC.insets = new Insets(0, 0, 2, 0);
		gbcC.gridy = 2;
		gbcC.gridx = 4;
		this.panelC.add(this.ensTxtFld.get(9), gbcC);
		gbcC.gridy = 3;
		gbcC.gridx = 4;
		this.panelC.add(this.ensTxtFld.get(8), gbcC);
		this.add(this.panelC);
	}
}
