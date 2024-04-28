/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.manolotsoa.tpbanquerazafindrakotomanolotsoadaniel54.jsf;

import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import java.io.Serializable;
import java.util.List;
import mg.manolotsoa.tpbanquerazafindrakotomanolotsoadaniel54.entity.CompteBancaire;
import mg.manolotsoa.tpbanquerazafindrakotomanolotsoadaniel54.entity.OperationBancaire;
import mg.manolotsoa.tpbanquerazafindrakotomanolotsoadaniel54.service.GestionnaireCompte;

/**
 *
 * @author manou
 */
@Named(value = "operations")
@RequestScoped
public class Operations implements Serializable {

    private List<OperationBancaire> allOperations;

    /**
     * Creates a new instance of Operations
     */
    public Operations() {
    }

    private Long compteId;
    @Inject
    private GestionnaireCompte gestionnaireCompte;

    private CompteBancaire compteBancaire;

    public Long getCompteId() {
        return compteId;
    }

    public void setCompteId(Long id) {
        this.compteId = id;
    }

    public void recupererCompte() {
        this.compteBancaire = gestionnaireCompte.findById(compteId);
    }

    public CompteBancaire getCompteBancaire() {
        return compteBancaire;
    }

    public List<OperationBancaire> getAllOperations() {
        allOperations = compteBancaire.getOperations();
        return allOperations;
    }

}
