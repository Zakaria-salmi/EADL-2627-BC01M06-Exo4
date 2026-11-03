package fr.ekod.assurance;

/**
 * Le véhicule à assurer.
 *
 * @param puissanceCh  puissance en chevaux
 * @param electrique   vrai si le véhicule est électrique
 * @param garageFerme  vrai si le véhicule dort dans un garage fermé
 */
public record Vehicule(int puissanceCh, boolean electrique, boolean garageFerme) {
    private static final int LIMITE_CHEVAUX = 150;
    private static final double MAJORATION_VEHICULE = 0.30;
    private static final double REDUCTION_VEHICULE_ELECTRIQUE = 0.10;
    private static final double REDUCTION_GARAGE_FERME = 0.05;

    public double calculMajorationVehicule() {
        if (puissanceCh > LIMITE_CHEVAUX) {
            return MAJORATION_VEHICULE;
        }
        return 0;
    }

    public double reductionVehiculeElectrique() {
        if(electrique) return REDUCTION_VEHICULE_ELECTRIQUE;

        return 0;
    }

    public double reductionVehiculeGarageFerme() {
        if(garageFerme) return REDUCTION_GARAGE_FERME;

        return 0;
    }
}
