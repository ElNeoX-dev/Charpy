/**
 * Classe permettant l'affichage de la simulation
 * @author WARIN, CAMPRUBI, BRUSQUE, CHAMPOUILLON
 */ 

import java.awt.*;
public class Materiau {

    // ATTRIBUTS 
    String Nom;
    double Resilience;
    Color Couleur;


    /**
     * Constructeur de la classe matériau
     * @param les caractéristiques du matériau
     */  
    public Materiau (String unNom, double uneResilience, Color uneCouleur) {

        Nom = unNom;
        Resilience = uneResilience;
        Couleur = uneCouleur;

    }
    
}
