import { Component } from '@angular/core';
import { NavController, NavParams } from 'ionic-angular';
import { RiscaldamentoPage } from '../riscaldamento/riscaldamento';
import { StretchingPage } from '../stretching/stretching';
import { AggiungiEserciziPage } from '../aggiungi-esercizi/aggiungi-esercizi';

/**
 * Generated class for the RoutinePage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@Component({
  selector: 'page-routine',
  templateUrl: 'routine.html',

})

export class RoutinePage {

  constructor(
    public navCtrl: NavController, 
    public navParams: NavParams
    ) {
    
  }

  goToOtherPage() {
    //push another page onto the history stack
    //causing the nav controller to animate the new page in
    this.navCtrl.push(AggiungiEserciziPage);
  }

  riscaldamento(){
    this.navCtrl.push(RiscaldamentoPage);
  }


  stretching(){
    this.navCtrl.push(StretchingPage);
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad RoutinePage');
  }



}
