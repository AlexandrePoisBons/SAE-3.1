package ihm.parametrage;
//Imp
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Insets;

import javax.swing.*;

import metier.Statut;

public class PanelFormulaire extends JPanel implements ActionListener{
	private PanelParam panelMere;
	private JTextField txtNomStatut; 
	private JTextField txtBnHeuresService; 
	private JTextField txtNbHeuresMax; 
	private JTextField txtCoeff; 
	private JButton    btnValider;
	private JButton    btnAnnuler;

	public PanelFormulaire(PanelParam panelMere){
		this.panelMere = panelMere;
		this.setLayout(new GridBagLayout());

		GridBagConstraints gbc 	= new GridBagConstraints();		
		gbc.anchor = GridBagConstraints.WEST;
		
		this.txtNomStatut       = new JTextField(15);
		this.txtBnHeuresService = new JTextField(15);
		this.txtNbHeuresMax     = new JTextField(15);
		this.txtCoeff          	= new JTextField(15);
		this.btnValider         = new JButton("Valider");
		this.btnAnnuler         = new JButton("Annuler");

		gbc.gridy = 0;
		gbc.gridx = 0;
		this.add(new JLabel("Nom du statut   "				), gbc);
		gbc.gridy = 1;
		this.add(new JLabel("Nombre d'heures de service   "), gbc);
		gbc.gridy = 2;
		this.add(new JLabel("Nombre d'heures maximum   "	), gbc);
		gbc.gridy = 3;
		this.add(new JLabel("Coefficient   "				), gbc);		
		gbc.gridx = 1;
		gbc.gridy = 0;
		this.add(this.txtNomStatut		, gbc);
		gbc.gridy = 1;
		this.add(this.txtBnHeuresService, gbc);
		gbc.gridy = 2;
		this.add(this.txtNbHeuresMax	, gbc);
		gbc.gridy = 3;
		this.add(this.txtCoeff			, gbc);

		gbc.gridy = 5;
		gbc.gridx = 0;
		gbc.anchor = GridBagConstraints.EAST;
		this.add(this.btnValider, gbc);
		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.WEST;
		this.add(this.btnAnnuler, gbc);

		this.btnValider.addActionListener(this);
		this.btnAnnuler.addActionListener(this);

		this.setVisible(true);
	}	

	public void actionPerformed(ActionEvent e){
		if(e.getSource() == this.btnValider){
			if(this.txtNomStatut.getText() != null && this.txtNbHeuresMax.getText() != null &&
			this.txtBnHeuresService.getText() != null && this.txtCoeff.getText() != null){
				this.panelMere.ajouterStatut(new Statut(this.txtNomStatut.getText(), 
											        Integer.parseInt(this.txtBnHeuresService.getText()), 
													Integer.parseInt(this.txtNbHeuresMax.getText()), 
													Float.parseFloat(this.txtCoeff.getText())));
			}
			else {
			}
		}
		if(e.getSource() == this.btnAnnuler){
			this.txtNomStatut.setText("");
			this.txtBnHeuresService.setText("");
			this.txtNbHeuresMax.setText("");
			this.txtCoeff.setText("");
		}
	}
}
