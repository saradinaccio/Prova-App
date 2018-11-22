package it.univaq.disim.mobile.unievent.business.domain;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "schede")
public class Scheda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_SCHEDA", nullable = false)
    private long id;

    @Column (name = "LIVELLO", nullable = false)
    private String livello;

    @Column (name = "ZONA", nullable = false)
    private String zona;

    @Column (name = "CALORIE", nullable = false)
    private int calorie;

    @ManyToMany (mappedBy = "schede")
    private Set<Esercizio> esercizioSchedeSet = new HashSet<>();

    @ManyToOne
    @JoinColumn (name = "ID_UTENTE")
    private Utente utente;



    // GETTER AND SETTER

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLivello() {
        return livello;
    }

    public void setLivello(String livello) {
        this.livello = livello;
    }

    public String getZona() {
        return zona;
    }


    public void setZona(String zona) {
        this.zona = zona;
    }

    public int getCalorie() {
        return calorie;
    }

    public void setCalorie(int calorie) {
        this.calorie = calorie;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Scheda scheda = (Scheda) o;
        return id == scheda.id &&
                calorie == scheda.calorie &&
                Objects.equals(livello, scheda.livello) &&
                Objects.equals(zona, scheda.zona);
    }
}
