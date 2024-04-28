/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.component.UIInput;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.ValidatorException;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.persistence.OptimisticLockException;
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
        try {
            if (type.equals("depot")) {
                gestionnaireCompte.deposer(compteBancaire, montant);
            } else {
                gestionnaireCompte.retirer(compteBancaire, montant);
            }
            Util.addFlashInfoMessage("Operation enregistré sur le compte de " + compteBancaire.getNom());
            return "listeComptes?faces-redirect=true";
        } catch (OptimisticLockException ex) {
            Util.messageErreur("Le compte de " + compteBancaire.getNom()
                    + " a été modifié ou supprimé par un autre utilisateur !");
            return null;
        }
    }
    
     public void soldeValidation(FacesContext fc, UIComponent composant, Object valeur) {
        UIInput composantTypeMouvement = (UIInput) composant.findComponent("type");
        // Il faut savoir si c'est un retrait ou un dépôt.
        // type n'est pas encore mis tant que la validation n'est pas finie.
        String valeurType = (String) composantTypeMouvement.getLocalValue();
        if (valeurType == null) {
            // Pour le cas où l'utilisateur a soumis le formulaire sans indiquer le type,
            // Le test valeurType.equals("retrait") ci-dessous génèrera une erreur car
            // il est exécuté avant que JSF ne vérifie que l'utilisateur a bien choisi
            // entre ajout et retrait (le choix est requis dans la page operation.xhtml)
            return;
        }
        if (valeurType.equals("retrait")) {
            int retrait = (int) valeur;
            if (compteBancaire.getSolde() < retrait) {
                FacesMessage message
                        = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                "Le retrait doit être inférieur au solde du compte",
                                "Le retrait doit être inférieur au solde du compte");
                throw new ValidatorException(message);
            }
        }
    }
}
