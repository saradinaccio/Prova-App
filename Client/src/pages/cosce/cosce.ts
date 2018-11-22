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

  esercizi: Array<Esercizio>

  constructor(public navCtrl: NavController, public navParams: NavParams, public esercizioService: EsercizioService) {
  }

  ionViewDidLoad() {
    this.esercizioService.esercizi().subscribe((data: Array<Esercizio>) => {
      this.esercizi = data;
    });
    console.log('ionViewDidLoad CoscePage');
  }

};
