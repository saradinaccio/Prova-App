package it.univaq.disim.mobile.unievent.business.domain;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table (name = "schedepersonali")
public class SchedaPersonale {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name ="ID_SCHEDAPERSONALE", nullable = false)
    private Long id;

    @Column (name = "GOAL", nullable = false)
    private String goal;

    /* @ManyToMany
     @JoinColumn (name = "ID_ESERCIZIO", nullable = false)
     private Esercizio esercizio;

     @ManyToOne
     @JoinColumn (name = "ID_USER", nullable = false)
     private Utente utente;
 */
    @ManyToOne
    @JoinColumn (name = "ID_UTENTE")
    private Utente utente;
    /*
    public Set<Esercizio> getEsercizioSet() {
        return esercizioSet;
    }

    public void setEsercizioSet(Set<Esercizio> esercizioSet) {
        this.esercizioSet = esercizioSet;
    }
    */
    @ManyToMany(fetch = FetchType.EAGER,
            cascade = {
                    CascadeType.REFRESH,
                    CascadeType.MERGE
            })
    @JoinTable(name = "esercizio_schedapersonale",
            joinColumns = { @JoinColumn(name = "id_schedapersonale") },
            inverseJoinColumns = { @JoinColumn(name = "id_esercizio") })
    private Set<Esercizio> esercizi = new HashSet<>();

/* @OneToMany (mappedBy = "Esercizio")
    private Set<SchedaPersonale> schedaPersonaleset;*/


    // GETTER AND SETTER


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Set<Esercizio> getEsercizi() {
        return esercizi;
    }

    public void setEsercizi(Set<Esercizio> esercizi) {
        this.esercizi = esercizi;
    }
}
