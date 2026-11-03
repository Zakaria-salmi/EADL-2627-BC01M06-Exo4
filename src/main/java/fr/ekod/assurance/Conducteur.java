package fr.ekod.assurance;

/**
 * Le conducteur à assurer.
 *
 * @param age                        âge en années
 * @param anneesPermis               années écoulées depuis l'obtention du permis
 * @param sinistresResponsables3Ans  nombre de sinistres responsables sur les trois dernières années
 * @param coefficientBonusMalus      coefficient de bonus-malus, de 0,50 (meilleur bonus) à 3,50 (malus maximal)
 */
public record Conducteur(int age, int anneesPermis, int sinistresResponsables3Ans, double coefficientBonusMalus) {
    private static final int LIMITE_SINISTRE = 3;
    private static final int PERMIS_ANNEE_LIMITE = 3;
    private static final double MAJORATION_AGE_JEUNE = 0.40;
    private static final double MAJORATION_AGE_SENIOR = 0.20;
    private static final double MAJORATION_PERMIS = 0.25;
    private static final double MAJORATION_SINISTRE = 0.15;

    public void ageValide() {
        if(age < 18) throw new IllegalArgumentException("conducteur mineur");
        if(anneesPermis > age - 18) throw new IllegalArgumentException("permis incohérent");

    }

    public double calculMajorationAge() {
        if (age < 25) return MAJORATION_AGE_JEUNE;
        if (age > 70) return MAJORATION_AGE_SENIOR;

        return 0;
    }

    public double calculMajorationPermis() {
        if (anneesPermis < PERMIS_ANNEE_LIMITE) return MAJORATION_PERMIS;

        return 0;
    }

    public double calculMajorationSinistres() {
        return nbSinistresMajoration() * MAJORATION_SINISTRE;
    }

    private int nbSinistresMajoration() {
        return Math.min(sinistresResponsables3Ans, LIMITE_SINISTRE);
    }
}
