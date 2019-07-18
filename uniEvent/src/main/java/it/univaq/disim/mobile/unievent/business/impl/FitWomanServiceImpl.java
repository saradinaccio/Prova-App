package it.univaq.disim.mobile.unievent.business.impl;

import it.univaq.disim.mobile.unievent.business.domain.*;

import java.util.List;
import it.univaq.disim.mobile.unievent.business.domain.Esercizio;
import it.univaq.disim.mobile.unievent.business.domain.Scheda;
import it.univaq.disim.mobile.unievent.business.domain.Utente;
import it.univaq.disim.mobile.unievent.business.domain.Routine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class  FitWomanServiceImpl implements FitWomanService {

    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private UtenteRepository utenteRepository;

    @Autowired
    private EsercizioRepository esercizioRepository;

    @Autowired
    private SchedaPersonaleRepository schedaPersonaleRepository;

    @Autowired
    private RoutineRepository routineRepository;

    @Override
    public Session login(String username, String password) {
        Utente user = utenteRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            Session session = new Session();
            session.setUser(user);
            session.setToken(Utility.generateToken());
            Session newSession = sessionRepository.save(session);
            return newSession;
        } else {
            return null;
        }
    }

    @Override
    public void logout(String token) {
        Session session = sessionRepository.findByToken(token);
        if (session != null) {
            sessionRepository.delete(session);
        }
    }

    @Override
    public Session createUtente(Utente utente) {
        Utente u = utenteRepository.findByUsername(utente.getUsername());
        if (u != null) {
            return null;
        }
        Utente newUtente = utenteRepository.save(utente);
        Session session = new Session();
        session.setUser(newUtente);
        session.setToken(Utility.generateToken());
        Session newSession = sessionRepository.save(session);
        return newSession;
    }

    @Override
    public Utente findUtenteByUsername(String username) {
        return null;
    }

    @Override
    public List<Esercizio> findAllEsercizi(String token) {
        Session session = sessionRepository.findByToken(token);

        if(session != null) {
            return esercizioRepository.findAll();
        }
        else return null;
    }

    @Override
    public Esercizio getEsercizioById(String token, Long id) {
        Session session = sessionRepository.findByToken(token);

        if(session != null) {
            return esercizioRepository.findEsercizioById(id);
        }
        else return null;
    }

    @Override
    public List<SchedaPersonale> getAllSchedePersonali(String token){
        Session session = sessionRepository.findByToken(token);

        if(session != null) {
            List<SchedaPersonale> schede = schedaPersonaleRepository.getAllSchedePersonali(session.getUser());

            if (schede != null) {
                for (SchedaPersonale scheda : schede) {
                    List<Esercizio> esercizi = esercizioRepository.findEserciziBySchedaPersonale(scheda.getId());

                    for (Esercizio esercizio : esercizi) {
                        scheda.getEsercizi().add(esercizio);
                    }
                }
                return schede;
            }
        }
        return null;
    }

    @Override
    public SchedaPersonale getSchedaPersonaleById(String token, Long id) {
        Session session = sessionRepository.findByToken(token);

        if(session != null) {
            SchedaPersonale scheda = schedaPersonaleRepository.findOne(id);

            if(scheda != null) {
                List<Esercizio> esercizi = esercizioRepository.findEserciziBySchedaPersonale(scheda.getId());

                for (Esercizio esercizio : esercizi) {
                    scheda.getEsercizi().add(esercizio);
                }
                return scheda;
            }
        }
        return null;
    }

    @Override
    public List<Scheda> findAllSchede() {
        return null;
    }

    @Override
    public List<Esercizio> getEserciziByLivelloAndZona(String token, Long livello, String zona) {
        Session session = sessionRepository.findByToken(token);

        if(session != null) {
            return esercizioRepository.findEserciziByLivelloAndZona(livello, zona);
        } else {
            return null;
        }
    }

    @Override
    public List<Esercizio> getEserciziByZona(String token, String zona) {
        Session session = sessionRepository.findByToken(token);

        if(session != null) {
            List<Esercizio> sc = esercizioRepository.findEserciziByZona(zona);
            return sc;
        }
        else {
            return null;
        }
    }

    @Override
    public boolean createSchedaPersonale(String token, SchedaPersonale scheda) {
        Session session = sessionRepository.findByToken(token);

        if(session != null) {
            for(Esercizio esercizio : scheda.getEsercizi()) {
                esercizioRepository.save(esercizio);
            }
            scheda.setUtente(session.getUser());
            this.schedaPersonaleRepository.save(scheda);
            return true;
        }
        return false;
    }

    @Override
    public SchedaPersonale updateSchedaPersonale(String token, SchedaPersonale newScheda) {
        Session session = sessionRepository.findByToken(token);

        if(session != null) {
            SchedaPersonale scheda = schedaPersonaleRepository.findOne(newScheda.getId());
            if(scheda != null) {
                scheda.setGoal(newScheda.getGoal());
                scheda.setEsercizi(newScheda.getEsercizi());
                return scheda;
            } else {
                System.out.println("SchedaPersonale non trovato");
                return null;
            }
        }
        else {
            System.out.println("Non sei loggato");
            return null;
        }
    }

    @Override
    public boolean deleteSchedaPersonale(String token, Long id) {
        Session session = sessionRepository.findByToken(token);
        if (session != null) {
            System.out.println(id);
            SchedaPersonale scheda = schedaPersonaleRepository.findOne(id);
            if(scheda != null) {
                for(Esercizio esercizio : scheda.getEsercizi()) {
                    esercizioRepository.delete(esercizio);
                }
            }
            //scheda.getEsercizi().removeAll(scheda.getEsercizi());
            schedaPersonaleRepository.delete(scheda);

            return true;
        } else {
            return false;
        }
    }

    @Override
    public Utente findUtenteById (String token, Long Id) {
        Session session = sessionRepository.findByToken(token);
        if (session != null) {
            Utente utente = utenteRepository.findOne(Id);
            if (utente != null) {
                return utente;
            }
            else {
                System.out.println("Utente non trovato");
                return null;
            }
        }
        else {
            System.out.println("Non sei loggato");
            return null;
        }
    }

    @Override
    public Utente updateUtente(String token, Utente newUtente) {
        Session session = sessionRepository.findByToken(token);
        if (session != null) {
            Utente utente = utenteRepository.findOne(newUtente.getId());
            if (utente != null) {
                utente.setEmail(newUtente.getEmail());
                utente.setEtà(newUtente.getEtà());
                utente.setNome(newUtente.getNome());
                utente.setUsername(newUtente.getUsername());
                utente.setCognome(newUtente.getCognome());
                utente.setAltezza(newUtente.getAltezza());
                utente.setPeso(newUtente.getPeso());
                return utente;
            }
            else {
                System.out.println("Utente non trovato");
                return null;
            }
        }
        else {
            System.out.println("Non sei loggato");
            return null;
        }
    }

    @Override
    public List<Routine> getRoutineByTipo(String token, int tipo) {
        Session session = sessionRepository.findByToken(token);
        if(session != null) {
            List<Routine> routines = routineRepository.getRoutineByTipo(tipo);
            return routines;
        }
        else {
            return null;
        }
    }


}

