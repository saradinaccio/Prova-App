package it.univaq.disim.mobile.unievent.business;

import it.univaq.disim.mobile.unievent.business.domain.Esercizio;
import it.univaq.disim.mobile.unievent.business.domain.Scheda;
import it.univaq.disim.mobile.unievent.business.domain.SchedaPersonale;
import it.univaq.disim.mobile.unievent.business.domain.Utente;
import it.univaq.disim.mobile.unievent.business.impl.EsercizioRepository;
import it.univaq.disim.mobile.unievent.business.impl.SchedaPersonaleRepository;
import it.univaq.disim.mobile.unievent.business.impl.SchedaRepository;
import it.univaq.disim.mobile.unievent.business.impl.UtenteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    /**
     * Per inserire dati nel db appena parte il server
     * @return
     */
//    @Bean
//    public CommandLineRunner loadData(){
//        return null;
//    }


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Bean
    public CommandLineRunner loadData(EsercizioRepository esercizioRepository, SchedaPersonaleRepository schedaPersonaleRepository, UtenteRepository utenteRepository, SchedaRepository schedaRepository) {
        return (args) -> {

            /*
            CREAZIONE UTENTI
             */

            /*
            Esercizio Bicicletta = new Esercizio();
            Bicicletta.setNome("Bicicletta");
            //Bicicletta.setDescrizione("In posizione supina, metti le mani sotto il sedere, solleva le gambe da terra, cominciando a pedalare nel vuoto.\n" +
            //        "Stendi bene le gambe e fai pedalate ampie.");
            Bicicletta.setFoto("foto");
            Bicicletta.setZona("Addome");
            Bicicletta.setRipetizioni(10);
            Bicicletta.setSerie(3);
            Bicicletta.setLivello(1L);
            esercizioRepository.save(Bicicletta);

            Esercizio Climber = new Esercizio();
            Climber.setNome("Climber");
            //Climber.setDescrizione("Assumi la posizione di Push up; con le braccia dritte e il corpo fermo crea una linea retta dalla testa fino ai piedi. Spingi le punte dei piedi in avanti e indietro portando le ginocchia verso il petto; alterna gamba destra e sinistra.");
            Climber.setFoto("foto");
            Climber.setZona("Addome");
            Climber.setRipetizioni(20);
            Climber.setSerie(3);
            Climber.setLivello(1L);
            esercizioRepository.save(Climber);

            Esercizio Planklaterale = new Esercizio();
            Planklaterale.setNome("Plank laterale");
            //Planklaterale.setDescrizione("Mettiti su un fianco e assumi la posizione di Plank laterale tenendo l'altra mano a terra. Alza e abbassa i fianchi in modo che il corpo ritorni in linea retta, dalla tesa ai piedi." );
            Planklaterale.setFoto("foto");
            Planklaterale.setZona("Addome");
            Planklaterale.setRipetizioni(20);
            Planklaterale.setSerie(3);
            Planklaterale.setLivello(2L);
            esercizioRepository.save(Planklaterale);

            Esercizio Sollevamentogambe = new Esercizio();
            Sollevamentogambe.setNome("Sollevamento gambe");
            //Sollevamentogambe.setDescrizione("Si parte da supini, con le braccia lungo il busto ed il palmo della mano poggiato al pavimento. Solleva le gambe unite e tese, mantenendo l’area sacrale ben salda a terra. Si abbassano lentamente le gambe, fino ad arrivare a pochi cm dal pavimento.\n");
            Sollevamentogambe.setFoto("foto");
            Sollevamentogambe.setZona("Addome");
            Sollevamentogambe.setRipetizioni(20);
            Sollevamentogambe.setSerie(3);
            Sollevamentogambe.setLivello(2L);
            esercizioRepository.save(Sollevamentogambe);


            Esercizio Squat = new Esercizio();
            Squat.setNome("Squat");
            //Squat.setDescrizione("Parti in piedi, gambe distanti circa 40-50 cm tra loro. Si esegue la discesa piegando le ginocchia e mantenendo le braccia distese lungo i fianchi. Il bacino si muove all’indietro e la schiena scende in linea verticale.");
            Squat.setFoto("Foto");
            Squat.setZona("Gambe");
            Squat.setSerie(3);
            Squat.setRipetizioni(15);
            Squat.setLivello(1L);


            Esercizio SquatGlutei = new Esercizio();
            SquatGlutei.setNome("Squat");
            //SquatGlutei.setDescrizione("La posizione di partenza è in piedi, gambe distanti circa 40-50 cm tra loro, con alcune possibili varianti legate alla posizione delle mani. Nel suo esercizio base si esegue la discesa piegando le ginocchia e mantenendo le braccia distese lungo i fianchi. Il bacino si muove all’indietro e la schiena scende in linea verticale, i talloni dovranno poi mantenere il contatto con il terreno o l’esercizio risulterà mal eseguito.");
            SquatGlutei.setFoto("Foto");
            SquatGlutei.setZona("Glutei");
            SquatGlutei.setSerie(3);
            SquatGlutei.setRipetizioni(12);
            SquatGlutei.setLivello(1L);
            esercizioRepository.save(SquatGlutei);

            Esercizio ClimberGlutei = new Esercizio();
            ClimberGlutei.setNome("Climber");
            //ClimberGlutei.setDescrizione("Assumi la posizione di Push up; con le braccia dritte e il corpo fermo crea una linea retta dalla testa fino ai piedi. Spingi le punte dei piedi in avanti e indietro portando le ginocchia verso il petto; alterna gamba destra e sinistra.");
            ClimberGlutei.setFoto("foto");
            ClimberGlutei.setZona("Glutei");
            ClimberGlutei.setRipetizioni(20);
            ClimberGlutei.setSerie(3);
            ClimberGlutei.setLivello(1L);
            esercizioRepository.save(Climber);

            Esercizio Ponte = new Esercizio();
            Ponte.setNome("Ponte");
            //Ponte.setDescrizione("In posizione prena, piega le gambe e tieni i piedia terra. Braccia lungo i fianchi. Alza i glutei dal suolo il più possibile, come per formare un ponte.");
            Ponte.setFoto("foto");
            Ponte.setZona("Glutei");
            Ponte.setRipetizioni(12);
            Ponte.setSerie(3);
            Ponte.setLivello(1L);
            esercizioRepository.save(Ponte);

            Esercizio AffondoIncrociato = new Esercizio();
            AffondoIncrociato.setNome("Affondo incrociato");
            //AffondoIncrociato.setDescrizione("Stando in piedi, porta indietro verso destra la gamba sinistra piegando le ginocchia. Torna in posizione eretta e cambia lato.");
            AffondoIncrociato.setFoto("fotofoto");
            AffondoIncrociato.setZona("Glutei");
            AffondoIncrociato.setRipetizioni(15);
            AffondoIncrociato.setSerie(3);
            AffondoIncrociato.setLivello(2L);
            esercizioRepository.save(AffondoIncrociato);

            Esercizio SquatSumo = new Esercizio();
            SquatSumo.setNome("Squat Sumo");
            //SquatSumo.setDescrizione("Stando in piedi, Apri le gambe più che puoi. Tieni le braccia tese in avanti. Abbasati fino a portare le cosce parallele al pavimento. Torna in posizione  di partenza e ripetil'esercizio");
            SquatSumo.setFoto("fotofoto");
            SquatSumo.setZona("Glutei");
            SquatSumo.setRipetizioni(20);
            SquatSumo.setSerie(3);
            SquatSumo.setLivello(2L);
            esercizioRepository.save(SquatSumo);

            Esercizio PonteSollevamento = new Esercizio();
            PonteSollevamento.setNome("Ponte Sollevamento gamba");
            //PonteSollevamento.setDescrizione("Distenditi sulla Schiena e piega le ginocchia tenendo i piedi appoggiati a terra. Quindi distendi una gamba e contemporaneamente solleva il bacino da terra. Ritorna in posizione di partenza dopo le ripetizioni date e cambia lato");
            PonteSollevamento.setFoto("fotofoto");
            PonteSollevamento.setZona("Glutei");
            PonteSollevamento.setRipetizioni(20);
            PonteSollevamento.setSerie(3);
            PonteSollevamento.setLivello(3L);
            esercizioRepository.save(PonteSollevamento);

            Utente esempio = new Utente();
            esempio.setCognome("DI Naccio");
            esempio.setNome("Sara");
            esempio.setEtà(23);
            esempio.setUsername("rebysa");
            esempio.setEmail("sara.dinaccio@gmail.com");
            esempio.setPassword("ciaociao");
            utenteRepository.save(esempio);


            Esercizio PonteSollevamento = new Esercizio();
            PonteSollevamento.setNome("Ponte Sollevamento gamba");
            PonteSollevamento.setDescrizione("Distenditi sulla Schiena e piega le ginocchia tenendo i piedi appoggiati a terra. Quindi distendi una gamba e contemporaneamente solleva il bacino da terra. Ritorna in posizione di partenza dopo le ripetizioni date e cambia lato");
            PonteSollevamento.setFoto("fotofoto");
            PonteSollevamento.setZona("Glutei");
            PonteSollevamento.setRipetizioni(20);
            PonteSollevamento.setSerie(3);
            PonteSollevamento.setLivello(3L);
            esercizioRepository.save(PonteSollevamento);

            Esercizio SquatSumo = new Esercizio();
            SquatSumo.setNome("Squat Sumo");
            SquatSumo.setDescrizione("Stando in piedi, Apri le gambe più che puoi. Tieni le braccia tese in avanti. Abbasati fino a portare le cosce parallele al pavimento. Torna in posizione  di partenza e ripetil'esercizio");
            SquatSumo.setFoto("fotofoto");
            SquatSumo.setZona("Glutei");
            SquatSumo.setRipetizioni(20);
            SquatSumo.setSerie(3);
            SquatSumo.setLivello(2L);
            esercizioRepository.save(SquatSumo);

            SchedaPersonale schedaCreata2 = new SchedaPersonale();
            schedaCreata2.setGoal("Dai ti prego funziona");

            schedaCreata2.getEsercizi().add(PonteSollevamento);
            schedaCreata2.getEsercizi().add(SquatSumo);


            PonteSollevamento.getSchedepersonali().add(schedaCreata2);
            SquatSumo.getSchedepersonali().add(schedaCreata2);

            schedaPersonaleRepository.save(schedaCreata2);
            */

            /*
            Scheda scheda = new Scheda();
            scheda.setLivello("sjdcnf");
            scheda.setZona("edfcvbgf");
            schedaRepository.save(scheda);
            */
            /*
            Squat.getSchedepersonali().add(schedaCreata);
            schedaCreata.getEsercizioSet().add(Squat);
            esercizioRepository.save(Squat);
            schedaPersonaleRepository.save(schedaCreata);
            */





            //            User user = new User();
//            user.setEmail("prova");
//            user.setPassword("prova");
//            user.setName("Davide");
//            user.setSurname("Micarelli");
//            user.setDescription("descrizione di prova prova xxx");
//
//            User user2 = new User();
//            user2.setEmail("d.micarelli27@gmail.com");
//            user2.setPassword("d.micarelli2");
//            user2.setName("davide2");
//            user.setDescription("descrizione di prova prova xxx");
//
//
//            userRepository.save(user);
//            userRepository.save(user2);
//
//            /*
//            CREAZIONE EVENTI
//             */
//            Event event = new Event();
//            event.setTitle("PartyHard1");
//            event.setViews(new Long(100));
//            event.setCity("Roma");
//            event.setAddress("via del corso 77");
//            event.setImage("/home/davide/Scrivania/gianni");
//            event.setPrice(19.68f);
//            event.setDescription("la descrizone dell'evento");
//            event.setDate(new Date(Calendar.getInstance().getTimeInMillis()));
//            event.setCreator(user);
//
//
//
//            Event event2 = new Event();
//            event2.setTitle("PartyHard2");
//            event2.setCity("Roma");
//            event2.setDescription("la descrizone dell'evento2");
//            event2.setDate(new Date(Calendar.getInstance().getTimeInMillis()));
//            event2.setPrice(0f);
//            event2.setCreator(user);
//
//
//            Event event3 = new Event();
//            event3.setTitle("Apecolmorto");
//            event3.setCity("Milano");
//            event3.setPrice(17.69f);
//            event3.setDate(new Date(Calendar.getInstance().getTimeInMillis() + 86400000*2));
//            //event3.setPrice(1.5f);
//            event3.setCreator(user);
//
//            Event event4 = new Event();
//            event4.setTitle("Apecolmorto2");
//            event4.setCity("Milano");
//            //event4.setPrice(18.62f);
//            event4.setDate(new Date(Calendar.getInstance().getTimeInMillis() + 86400000));
//            event4.setPrice(4f);
//
//            event4.setCreator(user);
//
//
//            Category category = new Category();
//            category.setName("FesteInPiscina");
//            category.setDescription("La festa dove ci sta la gnuna");
//            categoryRepository.save(category);
//
//            Category category2 = new Category();
//            category2.setName("Aperitivi snob");
//            category2.setDescription("Ape per le persone con le cravatte");
//            categoryRepository.save(category2);
//
//
//            Service service1 = new Service();
//            service1.setName("service1");
//
//            Service service2 = new Service();
//            service2.setName("service2");
//
//            Service service3 = new Service();
//            service3.setName("service3");
//
//            serviceRepository.save(service1);
//            serviceRepository.save(service2);
//            serviceRepository.save(service3);
//
//            List<Service> services = new ArrayList <>();
//            services.add(service1);
//
//
//
//            List<Category> categories1 = new ArrayList <>();
//            categories1.add(category);
//
//            event.setCategories(categories1);
//            event.setCreator(user);
//            event.setServices(services);
//            eventRepository.save(event);
//            event3.setCategories(categories1);
//            eventRepository.save(event3);
//
//
//            List<Category> categories2 = new ArrayList <>();
//            categories2.add(category2);
//
//            event2.setCategories(categories2);
//            event2.setCreator(user2);
//            eventRepository.save(event2);
//            event4.setCategories(categories2);
//            eventRepository.save(event4);
//
//

        };
    }
}