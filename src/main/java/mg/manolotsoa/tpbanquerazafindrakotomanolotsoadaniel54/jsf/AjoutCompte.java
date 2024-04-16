/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.manolotsoa.tpbanquerazafindrakotomanolotsoadaniel54.jsf;

import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import mg.manolotsoa.tpbanquerazafindrakotomanolotsoadaniel54.entity.CompteBancaire;
import mg.manolotsoa.tpbanquerazafindrakotomanolotsoadaniel54.service.GestionnaireCompte;

/**
 *
 * @author manou
 */
@Named(value = "ajoutCompte")
@RequestScoped
public class AjoutCompte {

    /**
     * Creates a new instance of AjoutCompte
     */
    public AjoutCompte() {
    }

    @Inject
    GestionnaireCompte gestionnaireCompte;

    private String nom;

    private int solde;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getSolde() {
        return solde;
    }

    public void setSolde(int solde) {
        this.solde = solde;
    }

    public String faire() {
        CompteBancaire compte = new CompteBancaire(nom, solde);
        gestionnaireCompte.creerCompte(compte);
        Util.addFlashInfoMessage("L'ajout a été une réussite");
        return "listeComptes?faces-redirect=true";
    }
}
