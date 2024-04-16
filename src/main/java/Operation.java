/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */

import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import java.io.Serializable;
import mg.manolotsoa.tpbanquerazafindrakotomanolotsoadaniel54.entity.CompteBancaire;
import mg.manolotsoa.tpbanquerazafindrakotomanolotsoadaniel54.jsf.Util;
import mg.manolotsoa.tpbanquerazafindrakotomanolotsoadaniel54.service.GestionnaireCompte;

/**
 *
 * @author manou
 */
@Named(value = "operation")
@ViewScoped
public class Operation implements Serializable {

    private Long id;
    private CompteBancaire compteBancaire;
    private String type; // retrait ou depot
    private int montant;

    /**
     * Creates a new instance of Operation
     */
    public Operation() {
    }

    @Inject
    private GestionnaireCompte gestionnaireCompte;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CompteBancaire getCompteBancaire() {
        return compteBancaire;
    }

    public void setCompteBancaire(CompteBancaire compteBancaire) {
        this.compteBancaire = compteBancaire;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public void loadCompte() {
        compteBancaire = gestionnaireCompte.findById(id);
    }

    public String enregistrer() {
        System.out.print("TYPE IS " + type);
        if (type.equals("depot")) {
            gestionnaireCompte.deposer(compteBancaire, montant);
        } else {
            gestionnaireCompte.retirer(compteBancaire, montant);
        }
        Util.addFlashInfoMessage("Operation enregistré sur le compte de " + compteBancaire.getNom());
        return "listeComptes?faces-redirect=true";
    }
}
