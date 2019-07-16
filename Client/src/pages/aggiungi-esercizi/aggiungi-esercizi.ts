import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams, LoadingController, AlertController } from 'ionic-angular';
import { EsercizioService } from '../../services/esercizio.service';
import { Esercizio } from '../../models/esercizio.model';
import { Utente } from '../../models/utente.model';
import { UtentePersistanceProvider } from '../../providers/utente-persistance.provider';
import { schedaPersonale } from '../../models/schedaPersonale.model';
import { SchedaPersonaleService } from '../../services/schedaPersonale.service';


/**
 * Generated class for the AggiungiEserciziPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-aggiungi-esercizi',
  templateUrl: 'aggiungi-esercizi.html',
})
export class AggiungiEserciziPage {

  public allEsercizi : Array<Esercizio>;
  public eserciziScelti : Array<number> =  [];
  public nome : "";
  public utente : Utente;
  public schedaCreata: schedaPersonale = null;

  constructor(public navCtrl: NavController, 
    public navParams: NavParams, 
    public esercizioService : EsercizioService, 
    public SchedaService: SchedaPersonaleService,
    public sAccount : UtentePersistanceProvider,
    public loadingCtrl: LoadingController,
    public alertCtrl: AlertController
    ) {
    this.nome = this.navParams.get("nome");
    console.log(this.nome);

    const loading = this.loadingCtrl.create({content: "Caricamento"});
    loading.present();
    this.esercizioService.getAllEsercizi()
            .then(result => {
                this.allEsercizi = result;
                console.log(this.allEsercizi);
                loading.dismiss();
            })
            .catch(msg => { 
                loading.dismiss();
                this.alertCtrl.create({
                    title: "FitWoman",
                    message: "Non è stato possibile recuperare gli esercizi",
                    buttons: ["Ok"]
                }).present();
            });
    /*
    this.esercizioService.allEsercizi(this.utente).subscribe((data: Array<Esercizio>) => {
      console.log("Sono in aggiunta esercizi");
      console.log(data)
      this.allEsercizi = data;
    })*/
    
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad AggiungiEserciziPage');
  
  }
  
   selectEsercizi (esercizioScelto) {
     if(this.eserciziScelti.indexOf(esercizioScelto.id) == -1) //Vuol dire che nel mio Array non c'è
      this.eserciziScelti.push(esercizioScelto.id);
    else {
      let temp : Array<number> = [];
      for (let i=0; i<this.eserciziScelti.length; i++) {
        if (this.eserciziScelti[i]!= esercizioScelto.id)
        temp.push(this.eserciziScelti[i]);
      }

      this.eserciziScelti.length= 0;
      this.eserciziScelti = temp;
      
    }
    console.log("Ho scelto: ");
    console.log(this.eserciziScelti);   
  } 

  crea(){
    let temp : Array<Esercizio> = [];
    for (let i=0; i<this.allEsercizi.length; i++) {
      for (let j=0; j<this.eserciziScelti.length; j++){
        if (this.eserciziScelti[j]== this.allEsercizi[i].id){
          temp.push(this.allEsercizi[i]);
        }
      }
    }
      this.schedaCreata = new schedaPersonale();
      this.schedaCreata.goal = this.nome;
      this.schedaCreata.esercizi = temp;

      const loading = this.loadingCtrl.create({content: "Caricamento"});
      loading.present();
      this.SchedaService.creaScheda(this.schedaCreata)
              .then((result) => {
                console.log(result);
                if(result){
                  loading.dismiss();
                  this.alertCtrl.create({
                    title: "Creazione Scheda",
                    message: "Scheda creata con successo!",
                    buttons: [{
                        text: "OK",
                        handler: () => {
                            this.navCtrl.setRoot("CreaSchedaPage");

                        }
                    }]
                }).present();

                }
              })
              .catch(msg => { 
                  loading.dismiss();
                  this.alertCtrl.create({
                      title: "FitWoman",
                      message: "Non è stato possibile creare la scheda",
                      buttons: ["Ok"]
                  }).present();
              });
  }

}
