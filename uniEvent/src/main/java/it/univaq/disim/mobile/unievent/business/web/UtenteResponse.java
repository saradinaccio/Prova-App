package it.univaq.disim.mobile.unievent.business.web;

import it.univaq.disim.mobile.unievent.business.domain.Utente;

public class UtenteResponse {

    private String username;
    private String nome;
    private String cognome;
    private String email;
    private float peso;
    private float altezza;
    private int età;

    public UtenteResponse() {
    }

    public UtenteResponse(Utente utente) {
        this.nome = utente.getNome();
        this.cognome = utente.getCognome();
        this.username = utente.getUsername();
        this.email = utente.getEmail();
//		if (utente instanceof Docente) {
//			this.ruolo = "docente";
//		} else {
//			this.ruolo = "studente";
//		}
        this.altezza = utente.getAltezza();
        this.età = utente.getEtà();
        this.peso = utente.getPeso();
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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public void setPeso(){ this.peso = peso; }
    public float getPeso() { return peso; }

    public float getAltezza() {
        return altezza;
    }

    public void setAltezza(float altezza) {
        this.altezza = altezza;
    }

    public int getEtà() {
        return età;
    }

    public void setEtà(int età) {
        this.età = età;
    }
}
