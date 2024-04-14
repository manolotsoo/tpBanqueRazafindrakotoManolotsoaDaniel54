/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mg.manolotsoa.tpbanquerazafindrakotomanolotsoadaniel54.config;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Initialized;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import jakarta.persistence.PersistenceContext;
import jakarta.servlet.ServletContext;
import jakarta.transaction.Transactional;
import mg.manolotsoa.tpbanquerazafindrakotomanolotsoadaniel54.entity.CompteBancaire;
import mg.manolotsoa.tpbanquerazafindrakotomanolotsoadaniel54.service.GestionnaireCompte;

/**
 *
 * @author manou
 */
public class Init {

    @Inject
    private GestionnaireCompte gestionnaireCompte;

    @Transactional
    public void init(@Observes @Initialized(ApplicationScoped.class) ServletContext context) {
        if (gestionnaireCompte.nbComptes() == 0) {
            gestionnaireCompte.creerCompte(new CompteBancaire("John Lennon", 150000)); // Ajoutez ici les paramètres pour créer un compte
            gestionnaireCompte.creerCompte(new CompteBancaire("Paul McCartney", 950000)); // Ajoutez ici les paramètres pour créer un compte
            gestionnaireCompte.creerCompte(new CompteBancaire("Ringo Starr", 20000)); // Ajoutez ici les paramètres pour créer un compte
            gestionnaireCompte.creerCompte(new CompteBancaire("Georges Harrisson", 100000)); // Ajoutez ici les paramètres pour créer un compte
        }
    }
}
