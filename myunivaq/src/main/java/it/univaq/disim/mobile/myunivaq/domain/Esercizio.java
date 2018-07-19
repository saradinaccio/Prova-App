package it.univaq.disim.mobile.myunivaq.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Esercizi")

public class Esercizio {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "ID_ESRCIZIO", nullable = false)
    private Long id;

    @Column (name = "NOME", nullable = false)
    private String nome;

    @Column(name = "DESCRIZIONE", nullable = false, length = 255)
    private String descrizione;

    @Column (name = "SERIE", nullable = false)
    private int serie;

    @Column (name = "RIPETIZIONI", nullable = false)
    private int ripetizioni;

    @Column (name = "FOTO", nullable = false)
    private String foto;

    @Column (name = "VIDEO", nullable = false)
    private String video;

    @Column (name = "RECUPERO", nullable = false)
    private int recupero;


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

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public int getRecupero() {
        return recupero;
    }

    public void setRecupero(int recupero) {
        this.recupero = recupero;
    }

    // EQUALS


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Esercizio esercizio = (Esercizio) o;
        return serie == esercizio.serie &&
                ripetizioni == esercizio.ripetizioni &&
                recupero == esercizio.recupero &&
                Objects.equals(id, esercizio.id) &&
                Objects.equals(nome, esercizio.nome) &&
                Objects.equals(descrizione, esercizio.descrizione) &&
                Objects.equals(foto, esercizio.foto) &&
                Objects.equals(video, esercizio.video);
    }

}
