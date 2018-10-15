import { Component } from '@angular/core';
import { NavController, NavParams } from 'ionic-angular';
import { LoginPage } from '../login/login';

/**
 * Generated class for the AccountPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@Component({
   selector: 'page-account',
   templateUrl: 'account.html',

})

export class AccountPage {

  cambio:boolean=true;
  utente:any={nome:"Sara",cognome:" Di Naccio"}

  constructor(public navCtrl: NavController, public navParams: NavParams) {
  }

  goToOtherPage() {
    //push another page onto the history stack
    //causing the nav controller to animate the new page in
    this.navCtrl.push(LoginPage);
  }

  cambia() {

    if (this.cambio==true){
      this.cambio=false;
    }
  }



  ionViewDidLoad() {
    console.log('ionViewDidLoad AccountPage');
  }

}

