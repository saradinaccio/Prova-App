import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import {EsercizioService } from '../../services/esercizio.service';
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
  public title : String = "";
  constructor(public navCtrl: NavController, public navParams: NavParams, public esercizioService: EsercizioService) {
    this.value = navParams.get('Item');

  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad GluteiPage');
    console.log(this.value);
    switch(this.value){
      case 1: this.title = 'Principiante Glutei';
     break;
     case 2: this.title = 'Intermedio Glutei';
     break;
     case 3: this.title = 'Avanzato Glutei';
     break;
    }
    
      this.esercizioService.esercizi(this.value, 'Glutei').subscribe((data: Array<Esercizio>) => {
      this.esercizio = data;

      console.log(data);
      console.log ('Primo');

    })
  }

}
