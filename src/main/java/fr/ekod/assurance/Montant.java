package fr.ekod.assurance;

public record Montant(
        double euros
)
{
    public static Montant euros(double euros) {
        return new Montant(euros);
    }
}
