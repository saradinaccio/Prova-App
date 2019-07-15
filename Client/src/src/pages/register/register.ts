import { Component } from '@angular/core';
import { NavController, AlertController, LoadingController } from 'ionic-angular';
import { AccountProvider } from '../../providers/account.provider';

//interfaces
import {UtenteRegisterInterface} from '../../interfaces/utenteRegisterInterface.interface';

//providers
import {UtentePersistanceProvider} from '../../providers/utente-persistance.provider';
 
@IonicPage()
@Component({
  selector: 'page-register',
  templateUrl: 'register.html',
})

export class RegisterPage {
  utente: UtenteRegisterInterface;
  public type = 'password';
  createSuccess = false;
  public showPass = false;
 
  constructor(private nav: NavController, private acntProvider: AccountProvider, private alertCtrl: AlertController, private _sUtentePersistance: UtentePersistanceProvider, private loadingCtrl: LoadingController) 
  { 
    this.utente = {
            nome: "",
            cognome: "",
            email: "",
            password: "",
            username: "",
    };
  }
 
  public register() {
    this._validate().then(() => {
      const loading = this.loadingCtrl.create({content: "Caricamento"});
      loading.present();
      this.acntProvider.signup(this.utente)
              .then((id) => {
                  console.log(id);

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

            if (this.utente.email.trim() === "") {
                msg = "Non hai inserito la email";
            }

            else if (this.utente.password.trim() === "") {
                msg = "Non hai inserito la password";
            }
            else if (this.utente.nome.trim() === "") {
                msg = "Non hai inserito il nome";
            }
            else if (this.utente.cognome.trim() === "") {
                msg = "Non hai inserito il cognome";
            }
            else if (this.utente.username.trim() === "") {
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
