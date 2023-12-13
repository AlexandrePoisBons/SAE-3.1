package ihm.previsionnel.ressources;

import ihm.previsionnel.PanelPrevi;
import javax.swing.*;
import java.awt.*;

import ihm.previsionnel.*;
import ihm.acceuil.*;
import ihm.previsionnel.ressources.ressourcesCentre.PRCentre;
import ihm.previsionnel.ressources.ressourcesCentre.progNat.ProgNat;
import ihm.previsionnel.ressources.ressourcesNord.PRNord;
import ihm.previsionnel.ressources.ressourcesSud.PanelSud;

public class PanelRessources extends JPanel {
    private FrameAccueil frameAcceuil;
    private PanelPrevi  panelMere;
    private PRNord      pRNord;
    private PRCentre    pRCentre;
    private PanelSud    pSud;
    


    public PanelRessources(FrameAccueil frameAcceuil, PanelPrevi frame) {
        this.frameAcceuil = frameAcceuil;
        this.panelMere = frame;

        this.frameAcceuil.setSize(1000, 600);
        this.frameAcceuil.setLocation(20, 20);
        this.setLayout(new BorderLayout());

        this.pRNord = new PRNord(this);
        this.pRCentre = new PRCentre(this);
        this.pSud = new PanelSud(this.frameAcceuil, this.panelMere);

        // Utiliser BoxLayout pour organiser les composants horizontalement
        this.add(this.pRNord, BorderLayout.NORTH);
        this.add(this.pRCentre, BorderLayout.CENTER);
        this.add(this.pSud, BorderLayout.SOUTH);
    }
}