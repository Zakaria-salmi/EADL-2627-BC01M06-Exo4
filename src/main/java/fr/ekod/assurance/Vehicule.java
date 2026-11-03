package fr.ekod.assurance;

/**
 * Le véhicule à assurer.
 *
 * @param puissanceCh  puissance en chevaux
 * @param electrique   vrai si le véhicule est électrique
 * @param garageFerme  vrai si le véhicule dort dans un garage fermé
 */
public record Vehicule(int puissanceCh, boolean electrique, boolean garageFerme) {

    public double calculMajorationVehicule(int puissanceCh) {
        double majorationPuissance = 0;
        if (puissanceCh > 150) {
            majorationPuissance = 0.30;
        }
        return majorationPuissance;
    }

    public double reductionVehiculeElectrique(boolean electrique) {
        double reductionElectrique = 0;
        if (electrique) {
            reductionElectrique = 0.10;
        }
        return reductionElectrique;
    }

    public double reductionVehiculeGarageFerme(boolean garageFerme) {
        double reductionGarageFerme = 0;
        if (garageFerme) {
            reductionGarageFerme = 0.05;
        }
        return reductionGarageFerme;
    }

    public double calculReductionVehicule() {
        return reductionVehiculeElectrique(electrique) + reductionVehiculeGarageFerme(garageFerme);
    }

    public double calculMajorationReductionVehicule() {
        return calculMajorationVehicule(puissanceCh) - calculReductionVehicule();
    }
}
