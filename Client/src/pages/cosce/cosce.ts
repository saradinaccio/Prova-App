import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { EsercizioService} from "../../services/esercizio.service";
import { Esercizio} from "../../models/esercizio.model";

/**
 * Generated class for the CoscePage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-cosce',
  templateUrl: 'cosce.html',
})
export class CoscePage {
  public value : any;
  public title : String ="";
  esercizio: Array<Esercizio>

  constructor(public navCtrl: NavController, public navParams: NavParams, public esercizioService: EsercizioService) {

    this.value = navParams.get('Item');
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad CoscePage');
    console.log(this.value);
    switch(this.value){
      case 1: this.title = 'Principiante Gambe';
     break;
     case 2: this.title = 'Intermedio Gambe';
     break;
     case 3: this.title = 'Avanzato Gambe';
     break;
    }
    
      this.esercizioService.esercizi(this.value, 'Gambe').subscribe((data: Array<Esercizio>) => {
      this.esercizio = data;

      console.log(data);
      console.log ('Primo');

    })
  
  }
};
