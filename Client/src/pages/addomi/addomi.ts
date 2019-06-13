import { Component } from '@angular/core';
import { NavController, NavParams, AlertController } from 'ionic-angular';
import {EsercizioService } from '../../services/esercizio.service';
import { Esercizio } from '../../models/esercizio.model';

/**
 * Generated class for the AddomiPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@Component({
  selector: 'page-addomi',
  templateUrl: 'addomi.html',
  


})
export default class AddomiPage {

  public value : any;
  public title : string = "";
  public message : string= "";
  public esercizio : Array<Esercizio>;
  constructor(public navCtrl: NavController, public navParams: NavParams, public alerCtrl: AlertController, public esercizioService: EsercizioService){
  
    this.value = navParams.get('Item');
  }

  ionViewDidLoad() {
    
    console.log('ionViewDidLoad AddomiPage');
   switch(this.value){
     case 1: this.title = 'Principiante Addome';
    break;
    case 2: this.title = 'Intermedio Addome';
    break;
    case 3: this.title = 'Avanzato Addome';
    break;
   }

    console.log(this.value);
      this.esercizioService.esercizi(this.value, 'Addome').subscribe((data: Array<Esercizio>) => {
      this.esercizio = data;

      console.log(data);
      console.log ('Primo');

    })
  }

  doAlert(x: any) {
    this.title=x.scheda;
    this.message=x.desc;
    console.log(this.title);
    let alert = this.alerCtrl.create({
      title: this.title,
      message: this.message,
      buttons: ['Ok']
    });
    alert.present()
  }

}
