import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams, AlertController, LoadingController } from 'ionic-angular';
import {EsercizioService } from '../../providers/esercizio.provider';
import { Esercizio } from '../../models/esercizio.model';

/**
 * Generated class for the GluteiPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-glutei',
  templateUrl: 'glutei.html',
})
export class GluteiPage {

  public value : any;
  public esercizio : Array<Esercizio>;
  public title : string = "";
  public titolo : string = "";
  public message : string = "";

  constructor(
    public navCtrl: NavController, 
    public navParams: NavParams, 
    public alertCtrl: AlertController, 
    public esercizioService: EsercizioService,
    public loadingCtrl: LoadingController
    ) {
    this.value = navParams.get('Item');

  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad GluteiPage');
    console.log(this.value);
    switch(this.value){
      case 1: this.titolo = 'Principiante Glutei';
     break;
     case 2: this.titolo = 'Intermedio Glutei';
     break;
     case 3: this.titolo = 'Avanzato Glutei';
     break;
    }
    /*
      this.esercizioService.esercizi(this.value, 'Glutei').subscribe((data: Array<Esercizio>) => {
      this.esercizio = data;

      console.log(data);
      console.log ('Primo');

    })*/

    console.log(this.value);
    const loading = this.loadingCtrl.create({content: "Caricamento"});
    loading.present();
    this.esercizioService.esercizi(this.value, 'Glutei')
            .then(result => {
                this.esercizio = result;
                console.log(this.esercizio);
                loading.dismiss();
            })
            .catch(msg => { 
                loading.dismiss();
                this.alertCtrl.create({
                    title: "FitWoman",
                    message: "Non è stato possibile recuperare gli esercizi per i glutei",
                    buttons: ["Ok"]
                }).present();
            });
  }

  
  doAlert(x: any) {
    this.title = x[0];
    this.message=x.desc;
    console.log(this.title);
    let alert = this.alertCtrl.create({
      title: this.title,
      message: x[3],
      buttons: ['Ok']
    });
    alert.present()
  }


}
