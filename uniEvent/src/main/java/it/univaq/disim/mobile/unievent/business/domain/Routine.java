package it.univaq.disim.mobile.unievent.business.domain;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table (name = "Routine")
public class Routine {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "ID_ROUTINE")
    private Long id;

    @Column (name = "TIPO", nullable = false)
    private int tipo;

    @Column (name = "NOME", nullable = false)
    private String nome;

    @Column (name = "DURATA", nullable = false)
    private int durata;

    @Column (name = "DESCRIZIONE", nullable = false)
    private int descrzione;

   /* @ManyToMany
    @JoinColumn(name = "ID_ESRCIZIO", nullable = false)
    private Esercizio esercizio;

    @ManyToMany
    @JoinTable(name="ROUTINE",
            joinColumns={@JoinColumn(name="ID_ROUTINE")},
            inverseJoinColumns={@JoinColumn(name="ID_ESERCIZIO")})
    private Set<Esercizio> listaesercizi= new HashSet<>();*/

    @ManyToOne
    @JoinColumn (name = "ID_UTENTE")
    private Utente utente;


    //GETTER AND SETTER


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    public int getDescrzione() {
        return descrzione;
    }

    public void setDescrzione(int descrzione) {
        this.descrzione = descrzione;
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
        Routine routine = (Routine) o;
        return tipo == routine.tipo &&
                durata == routine.durata &&
                descrzione == routine.descrzione &&
                Objects.equals(id, routine.id) &&
                Objects.equals(nome, routine.nome);
    }

}
