package it.univaq.disim.mobile.myunivaq.domain;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Objects;

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

	@JsonIgnore
	@Column(name = "PASSWORD", nullable = false, length = 255)
	private String password;
	
	@Column(name = "EMAIL", nullable = false, length = 255)
	private String email;

	@Column(name = "ETA", nullable = true, length = 6)
	private int età;

	@Column(name = "PESO", nullable = true, length = 20)
	private Float peso;

	@Column(name = "ALTEZZA", nullable = true)
	private Float altezza;

	@OneToMany
	@JoinColumn ( name = "ID_SCHEDAPERSONALE", nullable = false)
	private SchedaPersonale schedapersonale;

	@OneToMany
	@JoinColumn ( name = "ID_SCHEDA", nullable = false)
	private Scheda scheda;



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


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Utente utente = (Utente) o;
		return età == utente.età &&
				Objects.equals(id, utente.id) &&
				Objects.equals(nome, utente.nome) &&
				Objects.equals(cognome, utente.cognome) &&
				Objects.equals(password, utente.password) &&
				Objects.equals(email, utente.email) &&
				Objects.equals(peso, utente.peso) &&
				Objects.equals(altezza, utente.altezza);
	}

}
