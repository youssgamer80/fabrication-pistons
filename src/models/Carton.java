package models;
public class Carton {

    private Piece Tete;
    private Piece Axe;
    private Piece Jupe;

    public Carton(Piece Tete, Piece Axe, Piece Jupe) {

        this.Tete = Tete;

        this.Axe = Axe;

        this.Jupe = Jupe;
    }

    public Piece getTete() {

        return this.Tete;
    }

    public Piece getAxe() {

        return this.Axe;
    }

    public Piece getJupe() {

        return this.Jupe;
    }
}
