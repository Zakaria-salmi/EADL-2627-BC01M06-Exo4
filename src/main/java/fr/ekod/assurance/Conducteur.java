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

    public static double calculMajorationAge(int age, int anneesPermis) {
        double majorationAge = 0.0;
        if (age >= 18 && anneesPermis >= 0 && anneesPermis <= (age - 18)) {
            if (age < 25) {
                majorationAge = 0.40;
            } else if (age > 70) {
                majorationAge = 0.20;
            }
        } else {
            throw new IllegalArgumentException("Âge ou années de permis invalides");
        }
        return majorationAge;
    }

    public static double calculMajorationSinistre(int sinistresResponsables3Ans) {
        if (sinistresResponsables3Ans < 0) {
            throw new IllegalArgumentException("Le nombre de sinistres ne peut pas être négatif");
        }
        if (sinistresResponsables3Ans > 3) {
            sinistresResponsables3Ans = 3;
        }
        return sinistresResponsables3Ans * 0.15;
    }
    public static double calculMajorationPermis(int anneesPermis) {
        return anneesPermis < 3 ? 0.25 : 0.0;
    }

    // Méthode d'instance pour calculer la majoration totale du conducteur courant
    public double calculMajorationTotale() {
        return calculMajorationAge(this.age, this.anneesPermis)
                + calculMajorationSinistre(this.sinistresResponsables3Ans)
                + calculMajorationPermis(this.anneesPermis);
    }
}
