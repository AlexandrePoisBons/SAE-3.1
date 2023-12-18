package ihm.parametrage;

import javax.swing.*;

import java.util.*;

import metier.Statut;

import ihm.accueil.FrameAccueil;
import ihm.accueil.PanelAcceuil;

import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionEvent		;
import java.awt.event.ActionListener	;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

public class PanelParam extends JPanel implements ActionListener{

	private ArrayList<String> listStatut;
	private ArrayList<Statut> ensStatut;
	private PanelFormulaire   panelFormulaire;

	private FrameAccueil      frame;
	private JPanel            panelStatut;
	private JPanel            panelSud;

	private JButton           btnAjout;
	private JButton           btnModifier;
	private JButton           btnSupp;
	private JButton           btnRetour;
	private JButton           btnEnregistrer;

	private JTable            tableauStatut;
	private DefaultTableModel dtmStatut;

	
	public PanelParam(FrameAccueil frame){
		this.frame      = frame;
		this.listStatut = new ArrayList<String>();
		this.ensStatut  = new ArrayList<Statut>();
		this.setLayout(new BorderLayout());

		//Placement de la frame
		int hauteur = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight()  - (int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()*0.05);
		int largeur = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		int xSize = (int)(largeur*0.25);
		int ySize = (int)(hauteur*0.7);
		this.frame.setSize(xSize, ySize);
		this.frame.setLocation((int)(largeur*0.5-xSize*0.5),(int)(hauteur*0.5-ySize*0.5));

		// Creation des éléments de la page 
		this.panelFormulaire     = new PanelFormulaire();
		this.dtmStatut           = new DefaultTableModel();
		this.panelStatut         = new JPanel();
		this.panelSud            = new JPanel();

		this.btnAjout    = new JButton("Ajouter");
		this.btnModifier = new JButton("Modifier");
		this.btnSupp     = new JButton("Supprimer");
		this.btnRetour       = new JButton("Retour");
		this.btnEnregistrer  = new JButton("Enregistrer");


		// Creation du tableau
		this.dtmStatut.addColumn("Statut");
		this.tableauStatut  = new JTable(this.dtmStatut);
		//rendre les lignes du tableau non éditables
		this.tableauStatut.setDefaultEditor(Object.class, null);
		
		
		// Creation des scrollpane
		JScrollPane scrollStatut = new JScrollPane(this.tableauStatut);
		scrollStatut.setPreferredSize(new Dimension(300, 300));
		

		// Creation sous panels
		JPanel panelTableauG = new JPanel();
		JPanel panelBtnG     = new JPanel();

		this.panelStatut.setLayout(new BorderLayout());
		
		panelTableauG.add(scrollStatut);

		panelBtnG.add(this.btnAjout);
		panelBtnG.add(this.btnModifier);
		panelBtnG.add(this.btnSupp);


		// Ajout dans panel gauche
		this.panelStatut.add(panelTableauG, BorderLayout.NORTH);
		this.panelStatut.add(panelBtnG);



		//Ajout dans panel retour
		this.panelSud.add(this.btnRetour, FlowLayout.LEFT);
		this.panelSud.add(this.btnEnregistrer, FlowLayout.LEFT);

		// Ajout des panels
		this.add(this.panelStatut   , BorderLayout.WEST);
		this.add(this.panelFormulaire, BorderLayout.CENTER);
		this.add(this.panelSud , BorderLayout.SOUTH);

		// Activation des boutons 
		this.btnAjout  .addActionListener(this);
		this.btnModifier.addActionListener(this);
		this.btnSupp   .addActionListener(this);
		this.btnRetour     .addActionListener(this);
		this.btnEnregistrer.addActionListener(this);

		this.init();

		this.setVisible(true);
	}


	public void init() {
		List<Statut> statuts = this.frame.getControleur().getCtrl().metier().getStatuts();

		for (Statut statut : statuts)
			this.ajouterStatut(statut);

	}

	// Ajout des statut
	public void ajouterStatut(Statut statut) {
		String[] objs = {statut.getNomStatut()};
		this.dtmStatut.addRow(objs);
		this.ensStatut.add(statut);
		System.out.println("taille: " + listStatut.size());
	}

	// Modifier des statuts
	public void modifierStatut() {
		int ligneSelectionne = this.tableauStatut.getSelectedRow();
		if (ligneSelectionne != -1) {
			this.panelFormulaire.setLigne(this.ensStatut.get(ligneSelectionne).getNomStatut(), 
										  this.ensStatut.get(ligneSelectionne).getNbHeureService(),
										  this.ensStatut.get(ligneSelectionne).getNbHeuresMax(),
										  this.ensStatut.get(ligneSelectionne).getCoeffTP());
			this.ensStatut.remove(ligneSelectionne);
			this.dtmStatut.removeRow(ligneSelectionne);
			this.panelFormulaire.revalidate();
			this.panelFormulaire.repaint();
		}
	}
	// Supprimer Statut
	public void supprimerStatut() {
		int ligneSelectionne = this.tableauStatut.getSelectedRow();
		
		if (ligneSelectionne != -1) {
			String valeurASupp = (String) this.dtmStatut.getValueAt(ligneSelectionne, 0);
			this.dtmStatut.removeRow(ligneSelectionne);
	
			if (!this.listStatut.isEmpty() && this.listStatut.contains(valeurASupp)) {
				this.listStatut.remove(valeurASupp);
			}
		}
	
		System.out.println("taille : " + listStatut.size());
		System.out.println(this.listStatut);
	}
	

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.btnAjout){
			int hauteur = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight()  - (int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()*0.05);
			int largeur = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
			int xSize = (int)(largeur*0.6);
			int ySize = (int)(hauteur*0.7);
			this.frame.setSize(xSize, ySize);
			this.frame.setLocation((int)(largeur*0.5-xSize*0.5),(int)(hauteur*0.5-ySize*0.5));
			this.remove(this.panelFormulaire);
			this.panelFormulaire = new PanelFormulaire(this);
			this.add(this.panelFormulaire, BorderLayout.CENTER);
			this.revalidate();
			this.repaint();
			this.setVisible(true);
		}

		if(e.getSource() == this.btnSupp){
			this.supprimerStatut();
		}

		if(e.getSource() == this.btnModifier){
			this.modifierStatut();
		}

		// Ajout des valeurs dans listStatut et listCoef quand on clique sur Enregistrer
		if(e.getSource() == this.btnEnregistrer){
			
			for (int i = 0; i < this.dtmStatut.getRowCount(); i++) {
				if(this.dtmStatut.getValueAt(i, 0) != ""){
					if(!this.listStatut.contains((String) this.dtmStatut.getValueAt(i, 0))){
						this.listStatut.add((String) this.dtmStatut.getValueAt(i, 0));
					}
				}
				System.out.println("enreg: " + listStatut);	
			}
				
			
		}

		if(e.getSource() == this.btnRetour){
			this.frame.changerPanel(new PanelAcceuil(frame));
			//this.frame.setSize(350, 200);
		}
	}

	public ArrayList<String> getListStatut(){
		return this.listStatut;
	}
}
