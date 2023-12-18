package ihm.intervenants;


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;

import metier.Intervenant;

public class FrameFormulaire extends JFrame implements ActionListener{
	private PanelInter     panelMere;
	private JPanel                  panelFormulaire;
	private JComboBox<Intervenant>  ddlstIntervenant;
	private JTextField              txtNom; 
	private JTextField              txtPrenom;
	private JTextField              txtHServ;
	private JTextField              txtHMax;
	private JTextField              txtCoefTP;
	private JButton                 btnValider;
	private JButton                 btnAnnuler;

	public FrameFormulaire(PanelInter panelMere){
		this.panelMere       = panelMere;
		//Définition de la taille et la position de la fenêtre
		int hauteur = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight()  - (int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()*0.05);
		int largeur = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		int xSize = (int)(largeur*0.5);
		int ySize = (int)(hauteur*0.5);
		this.setSize(xSize, ySize);
		this.setLocation((int)(largeur*0.5-xSize*0.5),(int)(hauteur*0.5-ySize*0.5));

		this.panelFormulaire = new JPanel();

		this.panelFormulaire.setLayout(new GridBagLayout());

		GridBagConstraints gbc 	= new GridBagConstraints();		
		gbc.anchor = GridBagConstraints.WEST;
		
		this.remplirListe(this.panelMere.getIntervenants());
		this.txtNom         = new JTextField(15);
		this.txtPrenom      = new JTextField(15);
		this.txtHServ       = new JTextField(15);
		this.txtHMax        = new JTextField(15);
		this.txtCoefTP      = new JTextField(15);
		this.btnValider     = new JButton("Valider");
		this.btnAnnuler     = new JButton("Annuler");

		gbc.gridy = 0;
		gbc.gridx = 0;
		this.panelFormulaire.add(new JLabel("Catégorie"), gbc);
		gbc.gridy = 1;
		this.panelFormulaire.add(new JLabel("Nom"), gbc);
		gbc.gridy = 2;
		this.panelFormulaire.add(new JLabel("Prénom"	), gbc);
		gbc.gridy = 3;
		this.panelFormulaire.add(new JLabel("Heures services"), gbc);	
		gbc.gridy = 4;
		this.panelFormulaire.add(new JLabel("Heures max"), gbc);
		gbc.gridy = 5;
		this.panelFormulaire.add(new JLabel("Coef TP"), gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;
		this.panelFormulaire.add(this.ddlstIntervenant, gbc);
		gbc.gridy = 1;
		this.panelFormulaire.add(this.txtNom, gbc);
		gbc.gridy = 2;
		this.panelFormulaire.add(this.txtPrenom	, gbc);
		gbc.gridy = 3;
		this.panelFormulaire.add(this.txtHServ			, gbc);
		gbc.gridy = 4;
		this.panelFormulaire.add(this.txtHMax, gbc);
		gbc.gridy = 5;
		this.panelFormulaire.add(this.txtCoefTP, gbc);
		

		gbc.gridy = 6;
		gbc.gridx = 0;
		gbc.anchor = GridBagConstraints.EAST;
		this.panelFormulaire.add(this.btnValider, gbc);
		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.WEST;
		this.panelFormulaire.add(this.btnAnnuler, gbc);

		this.btnValider.addActionListener(this);
		this.btnAnnuler.addActionListener(this);

		this.add(this.panelFormulaire);

		this.setVisible(true);
	}	

	public void actionPerformed(ActionEvent e){
		if(e.getSource() == this.btnValider){
			this.ajouterLigne();
		}
		if(e.getSource() == this.btnAnnuler){
			this.dispose();
		}
	}

	public void remplirListe(List<Intervenant> intervenants){
		Intervenant[] tabInter = new Intervenant[intervenants.size()];
		for(int i=0;i<intervenants.size();i++){
			tabInter[i] = intervenants.get(i);
		}
		this.ddlstIntervenant = new JComboBox<>(tabInter);
	}

	public void ajouterLigne(){
		try {
			this.panelMere.ajouterLigne(this.ddlstIntervenant.getSelectedItem().toString(), 			
										this.txtNom.getText(), 
										this.txtPrenom.getText(), 
										this.txtHServ.getText(), 
										this.txtHMax.getText(),
										this.txtCoefTP.getText());
			
		} catch (Exception err) {
			System.err.println("Erreur : " + err.getMessage() + "\n");
		}
	}
}