package fr.ekod.assurance;

public class CalculPrime {
    private static final Montant BASE = Montant.euros(500);

    // NE PAS TOUCHER sans prevenir la direction technique (cf. ticket 4512)
    public double calculerPrime(Conducteur conducteur, Vehicule vehicule) {
        if (conducteur.age() < 18) {
            throw new IllegalArgumentException("conducteur mineur");
        }

        double majorations = conducteur.calculMajorationTotale()
                + vehicule.calculMajorationReductionVehicule();

        double total = BASE.euros() * (1 + majorations) * conducteur.coefficientBonusMalus();
        return Math.round(total * 100) / 100.0;
    }
}
