package it.univaq.disim.mobile.unievent.business.domain;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table (name = "Routine")
public class Routine {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "ID_ROUTINE", nullable = false)
    private Long id;

    @Column (name = "TIPO")
    private int tipo;

    @Column (name = "NOME")
    private String nome;

    @Column (name = "DURATA")
    private int durata;

    @Column (name = "DESCRIZIONE")
    private String descrizione;


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

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
}
