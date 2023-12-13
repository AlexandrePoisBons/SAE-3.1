package ihm.previsionnel.ressources.ressourcesCentre.repartition.heure;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

import java.awt.Color;

import javax.swing.JPanel;

import ihm.previsionnel.ressources.ressourcesCentre.repartition.PanelRepartition;

public class PanelRepartitionHeure extends JPanel{
	private PanelRepartition panelMere;
	private PanelRepartitionHGauche panelRepartitionHGauche;
	private PanelRepartitionHDroite panelRepartitionHDroite;

	public PanelRepartitionHeure(PanelRepartition panelMere){
		this.panelMere = panelMere;
		this.setLayout(new GridLayout(1,2));
		this.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));

		this.panelRepartitionHGauche = new PanelRepartitionHGauche(this);
		this.panelRepartitionHDroite = new PanelRepartitionHDroite();

		this.add(this.panelRepartitionHGauche);
		this.add(this.panelRepartitionHDroite);
	}
	
}