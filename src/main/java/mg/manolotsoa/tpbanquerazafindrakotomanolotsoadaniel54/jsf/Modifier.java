/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.manolotsoa.tpbanquerazafindrakotomanolotsoadaniel54.jsf;

import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import java.io.Serializable;
import mg.manolotsoa.tpbanquerazafindrakotomanolotsoadaniel54.entity.CompteBancaire;
import mg.manolotsoa.tpbanquerazafindrakotomanolotsoadaniel54.service.GestionnaireCompte;

/**
 *
 * @author manou
 */
@Named(value = "modifier")
@ViewScoped
public class Modifier implements Serializable {

    @Inject
    GestionnaireCompte gestionnaireCompte;

    private Long id;
    private CompteBancaire compteBancaire;
    private String nom;

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

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void loadCompte() {
        compteBancaire = gestionnaireCompte.findById(id);
        nom = compteBancaire.getNom();
    }

    public String update() {
        CompteBancaire compteBancaire = gestionnaireCompte.update(this.compteBancaire);
        Util.addFlashInfoMessage("Le changement du nom " + nom + " en " + compteBancaire.getNom() + " a été effectué avec succès.");
        return "listeComptes?faces-redirect=true";
    }

    /**
     * Creates a new instance of Modifier
     */
    public Modifier() {
    }

}
