package ihm.previsionnel.stage.stageCentre.progNatStage;

//import classes java
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.HashMap;
import java.awt.Color;


public class ProgNatStage extends JPanel{
	private JPanel     panelPrincipal;
	private JPanel     panelValidation;
	private JTextField txtHSae;
	private JTextField txtHTut;
	private JTextField txtSomme;
	private JCheckBox  checkValid;

	public ProgNatStage() {
		this.setLayout(new BorderLayout());

		//Initialisation des composants
		this.panelPrincipal  = new JPanel();
		this.panelValidation = new JPanel();
		this.txtHSae         = new JTextField(2);
		this.txtHTut         = new JTextField(2);
		this.txtSomme        = new JTextField(4);
		this.checkValid      = new JCheckBox();

		this.panelPrincipal.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		
		//Rendre certain champ de sasie non modifiable
		this.txtSomme.setEditable(false);

		//Rendre non coché
		this.checkValid.setSelected(false);
		this.checkValid.setEnabled(false);

		//Layouts
		//this.setLayout(new BorderLayout());
		this.panelPrincipal.setLayout(new BorderLayout());
		this.panelPrincipal.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		// Ajout des composants avec GridBagLayout
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(11, 0, 2, 0);
		this.panelPrincipal.add(new JLabel("h Sae"), gbc);
		gbc.gridx = 2;
		this.panelPrincipal.add(new JLabel("h Tut"), gbc);
		gbc.insets = new Insets(11, 10, 2, 0);
		gbc.gridx = 4;
		this.panelPrincipal.add(new JLabel("Σ"), gbc);
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.insets = new Insets(0, 0, 2, 0);
		this.panelPrincipal.add(this.txtHSae, gbc);
		gbc.gridx = 2;
		this.panelPrincipal.add(this.txtHTut, gbc);
		gbc.insets = new Insets(0, 10, 2, 0);
		gbc.gridx = 4;
		this.panelPrincipal.add(this.txtSomme, gbc);

		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.insets = new Insets(0, 0, 2, 0);
		this.panelPrincipal.add(this.txtHSae, gbc);
		gbc.gridx = 2;
		this.panelPrincipal.add(this.txtHTut, gbc);
		gbc.insets = new Insets(0, 10, 2, 0);
		gbc.gridx = 4;
		this.panelPrincipal.add(this.txtSomme, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		this.panelPrincipal.add(new JLabel("Total (eqtd) promo"), gbc);

		//Ajout des composants
		this.panelValidation.add(new JLabel("Validation"));
		this.panelValidation.add(this.checkValid);

		this.add( this.panelPrincipal,  BorderLayout.NORTH  );
		this.add( this.panelValidation, BorderLayout.CENTER );

		this.setVisible(true);
	}


	public HashMap<String, Integer> getHeuresTot() {

		HashMap<String,Integer> map = new HashMap<>();

		try { map.put("REH", Integer.parseInt(this.txtHSae.getText())); }
		catch(NumberFormatException e) { map.put("REH", 0); }

		try { map.put("TUT", Integer.parseInt(this.txtHTut.getText())); }
		catch (NumberFormatException e) { map.put("TUT",0); }

		return map;
	}
}
