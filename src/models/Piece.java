package models;
public class Piece {

    private String typePiece;

    private Integer qualite;

    // mise en place d'un constructeur pour ma classe Piece
    public Piece(String typePiece, Integer qualite) {

        this.typePiece = typePiece;

        this.qualite = qualite;

       
    }

    // ecriture de getter pour pouvoir recuperer les valeurs des proprietes d'une
    // Piece

    public String getTypePiece() {

        return this.typePiece;

    }

    public Integer getQualite() {

        return this.qualite;
    }

}
