import { Component } from '@angular/core';
import { NavController, AlertController, LoadingController, IonicPage } from 'ionic-angular';
import { AccountProvider } from '../../providers/account.provider';

//interfaces
import {UtenteRegisterInterface} from '../../interfaces/utenteRegisterInterface.interface';

//providers
import {UtentePersistanceProvider} from '../../providers/utente-persistance.provider';
import { SceltaZonaPage } from '../scelta-zona/scelta-zona';
import { Utente } from '../../models/utente.model';
 
@IonicPage()
@Component({
  selector: 'page-register',
  templateUrl: 'register.html',
})

export class RegisterPage {
  utente: Utente;
  public nome: string = "";
  public cognome: string = "";
  public email: string = "";
  public password: string = "";
  public altezza: Number;
  public peso: Number;
  public eta: Number;
  public username: String = "";
  public type = 'password';
  createSuccess = false;
  public showPass = false;
 
  constructor(private nav: NavController, private acntProvider: AccountProvider, private alertCtrl: AlertController, private _sUtentePersistance: UtentePersistanceProvider, private loadingCtrl: LoadingController) 
  { 
  }
 
  public register() {
    this._validate().then(() => {
      const loading = this.loadingCtrl.create({content: "Caricamento"});
      loading.present();
      this.utente = new Utente();
      this.utente.nome = this.nome;
      this.utente.cognome = this.cognome;
      this.utente.email = this.email;
      this.utente.password = this.password;
      this.utente.altezza = this.altezza;
      this.utente.peso = this.peso;
      this.utente.eta = this.eta;
      this.utente.username = this.username;
      console.log("eccomi");
      console.log(this.utente);
      this.acntProvider.register(this.utente)
              .then((utente: Utente) => {
                this.utente = utente;

                loading.dismiss().then(() => {
                    this.nav.setRoot(SceltaZonaPage);
                });

              })
              .catch(msg => { 
                  loading.dismiss();
                  this.alertCtrl.create({
                      title: "FitWoman",
                      message: "Registrazione non effettuata. Forse il server è in manutenzione, oppure hai inserito una email già esistente",
                      buttons: ["Ok"]
                  }).present();
              });
      }).catch(() => {});
  }

  private _validate() {
        return new Promise((resolve, reject) => {
            let msg = "";

            if (this.email.trim() === "") {
                msg = "Non hai inserito la email";
            }

            else if (this.password.trim() === "") {
                msg = "Non hai inserito la password";
            }
            else if (this.nome.trim() === "") {
                msg = "Non hai inserito il nome";
            }
            else if (this.cognome.trim() === "") {
                msg = "Non hai inserito il cognome";
            }
            else if (this.username.trim() === "") {
                msg = "Non hai inserito l'username";
            }

            if (msg !== "") {
                this.alertCtrl.create({
                    title: "FitWoman",
                    message: msg,
                    buttons: ["Ok"]
                }).present();

                reject();
            } else {
                resolve();
            }
        });
    }
 
  showPopup(title, text) {
    let alert = this.alertCtrl.create({
      title: title,
      subTitle: text,
      buttons: [
        {
          text: 'OK',
          handler: data => {
            if (this.createSuccess) {
              this.nav.popToRoot();
            }
          }
        }
      ]
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
