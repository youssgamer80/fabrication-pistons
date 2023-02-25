package models;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {

        // instanciation des machines de l'usine
        Machine mTete = new Machine(true, 2.0, 0.25, 0.0);
        Machine mAxe = new Machine(true, 3.5, 0.25, 0.0);
        Machine mJupe = new Machine(true, 2.5, 0.25, 0.0);
        Machine mPrincipale = new Machine(true, 1.0, 0.75, 0.0);

        // temps de repartion minimal d'une machine
        double tempsReparationMin = 5.0;

        // temps de repartion maximal d'une machine
        double tempsReparationMax = 10.0;

        // temps de traitement total pour connaitre le temps de production de 100
        // pistons
        double tempsTraitementTotal = 0;

        // liste des
        List<Piston> piston = new ArrayList<>();

        int nbPistonsProduits = 0;

        // on initialise le nombre de panne total qui pourrait survenir au cours du
        // process au niveau des 4 machines
        int nbPanne = 0;

        while (nbPistonsProduits < 100) {

            double tempsProdReparationTete = 0;// initialisation du temps de production et de repation cumule de la
                                               // machine mTete
            double tempsProdReparationJupe = 0;// initialisation du temps de production et de repartation cumule de la
                                               // machine mJupe
            double tempsProdReparationAxe = 0;// initialisation du temps de production et de reparation de la machine
                                              // mAxe
            double tempsProdReparationPrincipale = 0;// initialisation du temps de production et de reparation de la
                                                     // machine mPrincipale

            // initialisation d'un carton contenant 3 pieces de type tete,jupe et axe
            // necessaire a l'asemblage d'un piston
            List<Piece> carton = new ArrayList<>();

            // Definition de la valeur aleatoire qui decidera s'il y aura panne ou pas pour
            // la machine MT
            Double randomChanceTete = Math.random();

            System.out.println("randomChanceTete :" + randomChanceTete);

            // Definition de la valeur aleatoire qui decidera s'il y aura panne ou pas pour
            // la machine MA
            Double randomChanceAxe = Math.random();

            // Definition de la valeur aleatoire qui decidera s'il y aura panne ou pas pour
            // la machine MJ
            Double randomChanceJupe = Math.random();

            // Definition de la valeur aleatoire qui decidera s'il y aura panne ou pas pour
            // la machine MP
            Double randomChancePrincipale = Math.random();

            // generation et envoie d'un nouveau carton de piece
            carton.add(new Piece("tete", 0));

            carton.add(new Piece("axe", 0));

            carton.add(new Piece("jupe", 0));

            // puis ce qu'on ne sait pas ce qu'il y a dans les cartons on melange les pieces
            // dans le carton
            Collections.shuffle(carton);

            // Trier le carton pour dispatcher les pieces en les envoyant vers les machines
            // adequates
            for (Piece piece : carton) {

                if (piece.getTypePiece().equals("tete")) {

                    String tete = piece.getTypePiece();

                } else if (piece.getTypePiece().equals("axe")) {

                    String axe = piece.getTypePiece();

                } else if (piece.getTypePiece().equals("jupe")) {

                    String jupe = piece.getTypePiece();

                } else {

                    System.out.println("Piece non reconnu par le systeme, ejection de la piece...");
                }

                System.out.println("Fin de triage des pieces");
            }

            // simulation de l'arrive d'une tete et de la panne d'une machine de traitemenet
            // des tetes mTete
            if (randomChanceTete < 0.25) {

                mTete.setDisponibilite(false);

                System.out.println("Machine de traitement des tetes en panne");

                mTete.setTempsReparation(
                        Math.random() * (tempsReparationMax - tempsReparationMin) + tempsReparationMin);

                System.out.println("temps reparation : " + mTete.getTempsReparatrion());

                System.out.println("Machine en cours de reparation pour ........" + mTete.getTempsReparatrion());

                tempsProdReparationTete = mTete.getTempsTraitement() + mTete.getTempsReparatrion();

                System.out.println("------------------------temps de traitement total machine tete "
                        + tempsProdReparationTete + "min------------------------------");

                nbPanne = nbPanne + 1;

                System.out.println("Traitement de la tete après reparation de la machine");

                System.out.println("la tete a ete rendu de meilleur qualite");

            } else {

                System.out.println("la tete a ete rendu de meilleur qualite");
            }

            // simulation de la panne d'une machine de traitement des axes
            if (randomChanceAxe < 0.25) {

                mAxe.setDisponibilite(false);

                System.out.println("Machine de traitement des axes en panne");

                mAxe.setTempsReparation(Math.random() * (tempsReparationMax - tempsReparationMin) + tempsReparationMin);

                System.out.println("Machine en cours de reparation pour ............" + mAxe.getTempsReparatrion());

                tempsProdReparationAxe = mAxe.getTempsTraitement() + mAxe.getTempsReparatrion();

                System.out
                        .println("----------------------------------------------temps de traitement total machine axe "
                                + tempsProdReparationAxe + "min----------------------------------");

                nbPanne = nbPanne + 1;

                System.out.println("Traitement de la tete après reparation de la machine");

                System.out.println("la tete a ete rendu de meilleur qualite");

            } else {

                System.out.println("l'axe a ete rendu de meilleur qualite");
            }

            // simulation d'une panne de la machine de traitement de jupes
            if (randomChanceJupe < 0.25) {

                mJupe.setDisponibilite(false);

                System.out.println("La machine de traitement des jupes est en panne");

                mJupe.setTempsReparation(
                        Math.random() * (tempsReparationMax - tempsReparationMin) + tempsReparationMin);

                System.out
                        .println("Machine en cours de reparation pour ................." + mJupe.getTempsReparatrion());

                tempsProdReparationJupe = mJupe.getTempsTraitement() + mJupe.getTempsReparatrion();

                System.out.println("--------------------------temps de Traitement total machine jupe "
                        + tempsProdReparationJupe + "min---------------------------");

                nbPanne = nbPanne + 1;

                System.out.println("Traitement de la tete après reparation de la machine");

                System.out.println("la tete a ete rendu de meilleur qualite");
            } else {

                System.out.println("la jupe a ete rendu de meilleur qualite");
            }

            // definition d'une liste pour repartorier la liste des temps cumule de
            // reparation et de prode de chaque machine
            List<Double> listeTemps = new ArrayList<>();
            listeTemps.add(tempsProdReparationTete);
            listeTemps.add(tempsProdReparationAxe);
            listeTemps.add(tempsProdReparationJupe);

            // le temps de traitement total apres le rendu de meilleur qualite des machines
            // est le le temps le plus eleve des trois machines
            double maxListeTemps = Collections.max(listeTemps);

            System.out.println("=========================temps maximum de traitement de rendu de meilleur qualite : "
                    + maxListeTemps + "============================");

            // simulation d'une panne de la machine principal
            if (randomChancePrincipale < 0.75) {

                mJupe.setDisponibilite(false);

                System.out.println("La machine Principal des jupes est en panne");

                mPrincipale.setTempsReparation(
                        Math.random() * (tempsReparationMax - tempsReparationMin) + tempsReparationMin);

                System.out.println(
                        "Machine en cours de reparation pour ................." + mPrincipale.getTempsReparatrion());

                tempsProdReparationPrincipale = mPrincipale.getTempsTraitement() + mPrincipale.getTempsReparatrion();

                System.out.println("---------------------temps de reparation total machine principal "
                        + tempsProdReparationPrincipale + "min-----------------------");

                nbPanne = nbPanne + 1;

                System.out.println(
                        "===================Assemblage des deifferentes pieces pour former le piston==============");

                System.out.println("Piston assemble avec succes");
            } else {

                System.out.println(
                        "===================Assemblage des deifferentes pieces pour former le piston==============");

                System.out.println("Piston assemble avec succes");
            }

            nbPistonsProduits = nbPistonsProduits + 1;// on incremente le nombre de piston assemble

            tempsTraitementTotal = tempsTraitementTotal + maxListeTemps + tempsProdReparationPrincipale;// on incremente
                                                                                                        // le temps de
                                                                                                        // traitement
                                                                                                        // total

            List<Piston> pistonsAssemble = new ArrayList<>();

            pistonsAssemble.add(new Piston("tete", "axe", "jupe"));

            System.out.println("piston assemble et ajoute avec succes dans la liste");

        }

        System.out.println("le nombre de piston fabriquer est " + nbPistonsProduits);

        System.out.println("le temps necessaire est de " + tempsTraitementTotal + "min");

        System.out.println("le nombre total de panne est " + nbPanne);
    }

}