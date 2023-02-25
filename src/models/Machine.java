package models;
public class Machine {

    private Boolean disponibilite;

    private Double tempsTraitement;

    private Double chancePanne;

    private double tempsReparation;

    public Machine(Boolean disponibilite, Double tempsTraitement, Double chancePanne, Double tempsReparation) {

        this.tempsTraitement = tempsTraitement;

        this.chancePanne = chancePanne;

        this.disponibilite = true;

        this.tempsReparation = 0.0;
    }

    public void setDisponibilite(Boolean disponibilite) {

        this.disponibilite = disponibilite;
    }

    public void setTempsReparation(Double tempsReparation) {

        this.tempsReparation = tempsReparation;
    }

    // getters

    public Boolean getDisponibilite() {

        return this.disponibilite;
    }

    public Double getTempsTraitement() {

        return this.tempsTraitement;
    }

    public Double getChancePanne() {

        return this.chancePanne;
    }

    public Double getTempsReparatrion() {

        return this.tempsReparation;
    }
}
