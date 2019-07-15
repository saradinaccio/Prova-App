import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { EsercizioService } from '../../services/esercizio.service';
import { Esercizio } from '../../models/esercizio.model';


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
  public eserciziScelti : Array<String> =  [];

  constructor(public navCtrl: NavController, public navParams: NavParams, public esercizioService : EsercizioService) {
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad AggiungiEserciziPage');

    this.esercizioService.allEsercizi().subscribe((data: Array<Esercizio>) => {
      this.allEsercizi = data;

      console.log(data);
      console.log ('Primo');

    })


  }



   selectEsercizi (esercizioScelto) {
     if(this.eserciziScelti.indexOf(esercizioScelto.nome) == -1) //Vuol dire che nel mio Array non c'è
      this.eserciziScelti.push(esercizioScelto.nome);
    else {
      let arraydiappoggio : Array<String> = [];
      for (let i=0; i<this.eserciziScelti.length; i++) {
        if (this.eserciziScelti[i]!= esercizioScelto.nome)
        arraydiappoggio.push(this.eserciziScelti[i]);
      }

      this.eserciziScelti.length= 0;
      this.eserciziScelti = arraydiappoggio;
      
    }

    console.log(this.eserciziScelti);   
  } 

}
