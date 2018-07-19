package it.univaq.disim.mobile.myunivaq.domain;

import org.apache.catalina.User;

import javax.persistence.*;

@Entity
@Table (name = "schedepersonali")
public class SchedaPersonale {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name ="ID_SCHEDAPERSONALE", nullable = false)
    private Long id;

    @Column (name = "GOAL", nullable = false)
    private String goal;

    @ManyToMany
    @JoinColumn (name = "ID_ESERCIZIO", nullable = false)
    private Esercizio esercizio;

    @ManyToOne
    @JoinColumn (name = "ID_USER", nullable = false)
    private Utente utente;


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
}
