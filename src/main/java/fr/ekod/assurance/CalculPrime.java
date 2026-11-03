package fr.ekod.assurance;

import static fr.ekod.assurance.Majoration.majoration;

public class CalculPrime {

    // NE PAS TOUCHER sans prevenir la direction technique (cf. ticket 4512)
    public double calculerPrime(Conducteur c, Vehicule v) {
        double prix = 500;
        Majoration majoration = majoration(0);
        double reduction = 0;

        c.ageValide();
        majoration = majoration.ajouter(c.calculMajorationAge());
        majoration = majoration.ajouter(c.calculMajorationPermis());
        majoration = majoration.ajouter(c.calculMajorationSinistres());
        majoration = majoration.ajouter(v.calculMajorationVehicule());

        // application des majorations
        prix = prix * (1 + majoration.pourcent());

        // reductions
        reduction = reduction + v.reductionVehiculeElectrique();
        reduction = reduction + v.reductionVehiculeGarageFerme();

        prix = prix * (1 - reduction);

        // bonus-malus
        prix = prix * c.coefficientBonusMalus();

        // arrondi au centime
        prix = Math.round(prix * 100) / 100.0;
        return prix;
    }
}
