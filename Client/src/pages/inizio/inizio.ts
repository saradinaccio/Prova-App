import { Component } from '@angular/core';
import { NavController, NavParams } from 'ionic-angular';
import { LoginPage } from '../login/login';
import { RegisterPage } from '../register/register';
import {RecuperaPasswordPage} from '../recupera-password/recupera-password';
import { SceltaZonaPage } from '../scelta-zona/scelta-zona';

/**
 * Generated class for the InizioPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@Component({
  selector: 'page-inizio',
  templateUrl: 'inizio.html',
})
export class InizioPage {

  constructor(public navCtrl: NavController, public navParams: NavParams) {
  }

  ionViewDidLoad() {
   //document.querySelector(".tabbar")['style'].display = 'none';
    console.log('ionViewDidLoad InizioPage');
  }

  goToLogin() {
    //push another page onto the history stack
    //causing the nav controller to animate the new page in
    this.navCtrl.push(LoginPage);
  }

  goToCreateAccount() {
    this.navCtrl.push(RegisterPage);
  }

  goToRecuperaPassword() {
    this.navCtrl.push(RecuperaPasswordPage);
  }

}
