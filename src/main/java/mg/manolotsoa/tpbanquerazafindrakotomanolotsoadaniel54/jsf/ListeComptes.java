/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.manolotsoa.tpbanquerazafindrakotomanolotsoadaniel54.jsf;

//import jakarta.annotation.PostConstruct;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import java.io.Serializable;
import java.util.List;
import mg.manolotsoa.tpbanquerazafindrakotomanolotsoadaniel54.entity.CompteBancaire;
import mg.manolotsoa.tpbanquerazafindrakotomanolotsoadaniel54.service.GestionnaireCompte;

/**
 *
 * @author manou
 */
@Named(value = "listeComptes")
@ViewScoped
public class ListeComptes implements Serializable {

    private List<CompteBancaire> allComptes;

    @Inject
    private GestionnaireCompte gestionnaireCompte;

    /**
     * Creates a new instance of ListeComptes
     */
    public ListeComptes() {
    }

    /**
     * @PostConstruct est une annotation utilisée pour définir une méthode qui
     * doit être exécutée après que l'injection de dépendance ait eu lieu et que
     * toutes les initialisations requises aient été effectuées.
     */
//    @PostConstruct
//    public void init() {
//        this.allComptes = gestionnaireCompte.getAllComptes();
//    }

    public List<CompteBancaire> getAllComptes() {
        allComptes = gestionnaireCompte.getAllComptes();
        return allComptes;
    }

}
