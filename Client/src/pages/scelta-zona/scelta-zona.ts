import { Component } from '@angular/core';
import { NavController, NavParams, LoadingController, AlertController } from 'ionic-angular';
import { MyApp } from '../../app/app.component';
import { Esercizio } from '../../models/esercizio.model';
import { EsercizioService } from '../../providers/esercizio.provider';
import { schedaPersonale } from '../../models/schedaPersonale.model';
import { SchedaPersonaleService } from '../../providers/schedaPersonale.provider';

/**
 * Generated class for the SceltaZonaPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@Component({
  selector: 'page-scelta-zona',
  templateUrl: 'scelta-zona.html',
})
export class SceltaZonaPage {
  public zoneScelte: Array<String> = [];
  public allEsercizi: Array<Esercizio> = [];

  constructor(
    public navCtrl: NavController, 
    public navParams: NavParams,
    public esercizioService: EsercizioService,
    public schedaPerService: SchedaPersonaleService,
    public loadingCtrl: LoadingController,
    public alertCtrl: AlertController
     ) {

      this.esercizioService. getAllEsercizi()
      .then(result => {
          this.allEsercizi = result;
          console.log(this.allEsercizi);
        
        })
      .catch(msg => { 
      });
  }

  goToOtherPage() {
    //push another page onto the history stack
    //causing the nav controller to animate the new page in
    this.navCtrl.push(MyApp);
  }

  selectZona(zonaScelta) {
    if(this.zoneScelte.indexOf(zonaScelta) == -1) //Vuol dire che nel mio Array non c'è
      this.zoneScelte.push(zonaScelta);
    else {
      let temp : Array<String> = [];
      for (let i=0; i<this.zoneScelte.length; i++) {
        if (this.zoneScelte[i] != zonaScelta)
        temp.push(this.zoneScelte[i]);
      }

      this.zoneScelte.length= 0;
      this.zoneScelte = temp;
      
    }

    console.log("Ho scelto: ");
    console.log(this.zoneScelte); 
  }


  ionViewDidLoad() {
   // document.querySelector(".tabbar")['style'].display = 'none';
    console.log('ionViewDidLoad SceltaZonaPage');
  }

  goToFinishRegistration(){
    console.log(this.zoneScelte);
    var temp : Array<Esercizio>=[];
    for (let i=0; i<this.zoneScelte.length; i++) {
        for (let j=0; j<this.allEsercizi.length; j++){
          if (this.allEsercizi[j].zona == this.zoneScelte[i]){
            temp.push(this.allEsercizi[j]);
          }
        }
    }
    console.log("ecco tutti gli esercizi");
    console.log(this.allEsercizi);
    var scheda = new schedaPersonale();
    scheda.goal = "La tua prima scheda";
    for(let i = 0; i < temp.length; i++) {
      scheda.esercizi.push(temp[i]);
    }

    //scheda.esercizi = this.allEsercizi;
    console.log("Ecco gli esercizi");
    console.log(scheda.esercizi);
    const loading = this.loadingCtrl.create({content: "Caricamento"});
    loading.present();
    this.schedaPerService.creaScheda(scheda)
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
                  this.navCtrl.setRoot("TabsPage");

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
    console.log(this.allEsercizi);

  }

   delay(ms: number) {
     return new Promise( resolve => setTimeout(resolve, ms) );
}

  

}
