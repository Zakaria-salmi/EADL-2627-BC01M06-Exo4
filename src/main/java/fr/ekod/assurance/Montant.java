package fr.ekod.assurance;

public record Montant(double euros) {
    public static Montant montant(double euros) {
        return new Montant(euros);
    }

    Montant ajouter(double a) {
        return new Montant(a + euros);
    }
}
