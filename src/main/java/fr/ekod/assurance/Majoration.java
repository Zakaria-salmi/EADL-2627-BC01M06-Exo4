package fr.ekod.assurance;

public record Majoration(double pourcent) {
    public static Majoration majoration(double pourcent) {
        return new Majoration(pourcent);
    }

    Majoration ajouter(double a) {
        return new Majoration(a + pourcent);
    }
}
