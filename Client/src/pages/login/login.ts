import { Component } from '@angular/core';
import { NavController, NavParams,  AlertController, LoadingController, Loading } from 'ionic-angular';

import {AccountProvider} from '../../providers/account.provider';
import { Utente } from '../../models/utente.model';
import { TabsPage } from '../Tabs/tabs';

/**
 * Generated class for the LoginPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */


@Component({
  selector: 'page-login',
  templateUrl: 'login.html',
})

export class LoginPage {
  public type = 'password';
  public showPass = false;
  public loading: Loading;
  public username = '';
  public password = '';
  public utente: Utente;

  constructor(
    public nav: NavController, 
    public acntProvider: AccountProvider, 
    public alertCtrl: AlertController, 
    public loadingCtrl: LoadingController
    ) {
  }

  public createAccount() {
    this.nav.push('RegisterPage');
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad Login');
}

  public login() {
    this._validate().then(() => {
      const loading = this.loadingCtrl.create({content: "Caricamento"});
      loading.present();

       this.acntProvider.login(this.username, this.password)
            .then((utente: Utente) => {
              this.utente = utente;

              loading.dismiss().then(() => {
                  this.nav.setRoot(TabsPage);
              });
            })
            .catch((msg) => {
              loading.dismiss();
              this.alertCtrl.create({
                title: "FitWoman",
                message: "Non mi sono riuscito a loggare",
                buttons: ["OK"]
                }).present();
                console.log("errore login: non mi sono riuscito a loggare");

            });
    }).catch(() => {
  });
}


private _validate() {
    return new Promise((resolve, reject) => {
        let msg = "";
        if (this.username.trim() === "") {
            msg = "L'USERNAME E' VUOTO";
        } else if (this.password.trim() === "") {
            msg = "LA PASSWORD E' VUOTA";
        }
        
        if (msg !== "") {
            this.alertCtrl.create({
                title: "FitWoman",
                message: msg,
                buttons: ["OK"]
            }).present();
            
            reject();
        } else {
            resolve();
        }
    });
}

  showLoading() {
    this.loading = this.loadingCtrl.create({
      content: 'Please wait...',
      dismissOnPageChange: true
    });
    this.loading.present();
  }
 
  showError(text) {
    this.loading.dismiss();
 
    let alert = this.alertCtrl.create({
      title: 'Fail',
      subTitle: text,
      buttons: ['OK']
    });
    alert.present();
  }

 showPassword() {
    this.showPass = !this.showPass;
 
    if(this.showPass){
      this.type = 'text';
    } else {
      this.type = 'password';
    }
 }
}
