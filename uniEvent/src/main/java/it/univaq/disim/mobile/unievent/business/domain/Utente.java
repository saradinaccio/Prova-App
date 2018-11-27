package it.univaq.disim.mobile.unievent.business.domain;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

@Entity
@Table(name = "utenti")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TIPOLOGIA_UTENTE", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("utente")
public class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_UTENTE", nullable = false)
    private Long id;

    @Column(name = "NOME", nullable = false, length = 255)
    private String nome;

    @Column(name = "COGNOME", nullable = false, length = 255)
    private String cognome;

    @Column(name = "USERNAME", nullable = false, length = 16, updatable = false, unique = true)
    private String username;

    @JsonIgnore
    @Column(name = "PASSWORD", nullable = false, length = 255)
    private String password;

    @Column(name = "EMAIL", nullable = false, length = 255)
    private String email;

    @Column(name = "ETA", length = 6)
    private int età;

    @Column(name = "PESO",  length = 20)
    private Float peso;

    @Column(name = "ALTEZZA")
    private Float altezza;

    @OneToMany (mappedBy = "utente", targetEntity = Scheda.class)
    private List<Scheda> scheda;

    @OneToMany (mappedBy = "utente", targetEntity = SchedaPersonale.class)
    private List<SchedaPersonale> schedapersonale;

    @OneToMany (mappedBy = "utente", targetEntity = Routine.class)
    private List<Routine> routine;



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

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEtà() {
        return età;
    }

    public void setEtà(int età) {
        this.età = età;
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public Float getAltezza() {
        return altezza;
    }

    public void setAltezza(Float altezza) {
        this.altezza = altezza;
    }

}
