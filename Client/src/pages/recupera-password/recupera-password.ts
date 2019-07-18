import { Component } from '@angular/core';
import { NavController, NavParams, AlertController } from 'ionic-angular';
import {AccountProvider} from '../../providers/account.provider';


@Component({
  selector: 'page-recupera-password',
  templateUrl: 'recupera-password.html',
})
export class RecuperaPasswordPage {
	public email: string = "";

  constructor(
  	public navCtrl: NavController, 
  	public navParams: NavParams, 
  	public alertCtrl: AlertController, 
    public sAccount: AccountProvider
    ) {
    }

  ionViewDidLoad() {
    console.log('ionViewDidLoad RecuperaPasswordPage');
  }

  recupera() {
    this._validate().then(() => {
        this.sAccount.recuperaPassword(this.email).then(() => {
            this.alertCtrl.create({
                title: "FitWoman",
                message: "Password cambiata correttamente. Controlla la tua casella di posta elettronica",
                buttons: ["Ok"]
            }).present();
            this.navCtrl.setRoot("LoginPage");
        }).catch(() => {
        	this.alertCtrl.create({
                title: "FitWoman",
                message: "Attenzione la password non è stata cambiata. Forse ci sono dei problemi con il server ",
                buttons: ["Ok"]
            }).present();
    	});
    }).catch(() => {});

    }

  private _validate(){
    return new Promise((resolve, reject) => {
            
	    if (this.email.trim() === "") {
	        this.alertCtrl.create({
	            title: "FitWoman",
	            message: "Attenzione, non hai inserito la email",
	            buttons: ["Ok"]
	        }).present();
	        reject();
	    } else {
	        resolve();
	    }
	});
  }	
}