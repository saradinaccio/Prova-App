package it.univaq.disim.mobile.unievent.business.domain;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "esercizi")

public class Esercizio {

    @Id
    //@GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "ID_ESERCIZIO", nullable = false)
    private Long id;

    @Column (name = "NOME")
    private String nome;

    @Column(name = "DESCRIZIONE", length = 500)
    private String descrizione;

    @Column (name = "SERIE")
    private int serie;

    @Column (name = "RIPETIZIONI")
    private int ripetizioni;

    @Column (name = "FOTO")
    private String foto;

    @Column (name = "LIVELLO")
    private Long livello;

    @Column (name = "ZONA")
    private String zona;

    /*
    @ManyToMany
    @JoinTable (name = "ESERCIZIO_SCHEDAPERSONALE",
            joinColumns = {@JoinColumn(name = "ID_ESERCIZIO")},
            inverseJoinColumns = {@JoinColumn (name = "ID_SCHEDAPERSONALE")})
    private Set<SchedaPersonale> schedepersonali = new HashSet<>();
    */

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "esercizi")
    private Set<SchedaPersonale> schedepersonali = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "esercizi")
    private Set<Scheda> schede = new HashSet<>();

/*    @ManyToOne
    @JoinColumn (name = "EsercizioId", nullable = false)
    private Esercizio esercizio;*/

    /*
    @ManyToMany
    @JoinTable (name = "ESERCIZIO_SCHEDA",
            joinColumns =  {@JoinColumn (name = "ID_ESERCIZIO")},
            inverseJoinColumns = {@JoinColumn (name = "ID_SCHEDA")})
    private Set<Scheda> schede = new HashSet<>();
    */
    // GETTER AND SETTER


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public int getSerie() {
        return serie;
    }

    public void setSerie(int serie) {
        this.serie = serie;
    }

    public int getRipetizioni() {
        return ripetizioni;
    }

    public void setRipetizioni(int ripetizioni) {
        this.ripetizioni = ripetizioni;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Long getLivello() {
        return livello;
    }

    public void setLivello(Long livello) {
        this.livello = livello;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public Set<SchedaPersonale> getSchedepersonali() {
        return schedepersonali;
    }
    /*
    public Set<Scheda> getSchede() {
        return schede;
    }

    public void setSchede(Set<Scheda> schede) {
        this.schede = schede;
    }
    */
    public void setSchedepersonali(Set<SchedaPersonale> schedepersonali) {
        this.schedepersonali = schedepersonali;
    }

    public void addSchedaPersonale (SchedaPersonale schedaPersonale){
        this.schedepersonali.add(schedaPersonale);
    }


    /*
    public void addScheda (Scheda scheda){
        this.schede.add(scheda);
    }
    */
    // EQUALS


    @Override
    public String toString() {
        return "Esercizio{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descrizione='" + descrizione + '\'' +
                ", serie=" + serie +
                ", ripetizioni=" + ripetizioni +
                ", foto='" + foto + '\'' +
                ", livello=" + livello +
                ", zona='" + zona + '\'' +
                ", schedepersonali=" + schedepersonali +
                //", schede=" + schede +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Esercizio esercizio = (Esercizio) o;
        return serie == esercizio.serie &&
                ripetizioni == esercizio.ripetizioni &&
                Objects.equals(id, esercizio.id) &&
                Objects.equals(nome, esercizio.nome) &&
                Objects.equals(descrizione, esercizio.descrizione) &&
                Objects.equals(foto, esercizio.foto) &&
                Objects.equals(livello, esercizio.livello) &&
                Objects.equals(zona, esercizio.zona) &&
                Objects.equals(schedepersonali, esercizio.schedepersonali);
                //Objects.equals(schede, esercizio.schede);
    }

    @Override
    public int hashCode() {
        //return Objects.hash(id, nome, descrizione, serie, ripetizioni, foto, livello, zona, schedepersonali, schede);
        return Objects.hash(id, nome, descrizione, serie, ripetizioni, foto, livello, zona, schedepersonali);
    }
}

