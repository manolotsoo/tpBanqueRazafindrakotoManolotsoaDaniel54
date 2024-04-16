/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.manolotsoa.tpbanquerazafindrakotomanolotsoadaniel54.jsf;

import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import java.io.Serializable;
import mg.manolotsoa.tpbanquerazafindrakotomanolotsoadaniel54.service.GestionnaireCompte;

/**
 *
 * @author manou
 */
@Named(value = "transfert")
@ViewScoped
public class Transfert implements Serializable {

    private Long compteSource;
    private Long compteDestinataire;
    private int montant;

    public Long getCompteSource() {
        return compteSource;
    }

    public void setCompteSource(Long compteSource) {
        this.compteSource = compteSource;
    }

    public Long getCompteDestinataire() {
        return compteDestinataire;
    }

    public void setCompteDestinataire(Long compteDestinataire) {
        this.compteDestinataire = compteDestinataire;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    /**
     * Creates a new instance of Transfert
     */
    @Inject
    private GestionnaireCompte gestionnaireCompte;

    public Transfert() {
    }

    public String faireTransfert() {
        gestionnaireCompte.transfertArgent(compteSource, compteDestinataire, montant);
        return "listeComptes";
    }

}
