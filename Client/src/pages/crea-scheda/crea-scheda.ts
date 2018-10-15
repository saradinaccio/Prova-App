import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams, AlertController } from 'ionic-angular';
import { HomePage } from '../home/home';
import { RoutinePage } from '../routine/routine';
import { AccountPage } from '../account/account';

/**
 * Generated class for the CreaSchedaPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-crea-scheda',
  templateUrl: 'crea-scheda.html',
})

export class CreaSchedaPage {

  // public schede : any = [{ id:1, scheda:'squat', desc:'ciao sono sara'}, {id:2, nome: 'plank', desc: 'ciao sono sara'}];
  
  public schede : any = [];
  public var : string = "";

  constructor(public navCtrl: NavController, public navParams: NavParams, public alertCtrl: AlertController) {
  }

  doPrompt() {
    let prompt = this.alertCtrl.create({
      title: 'Inserisci il nome della tua scheda',
      inputs: [
        {
          name: 'nome',
          placeholder: 'Nome'
        },
      ],
      buttons: [
        {
          text: 'Cancella',
          handler: data => {
            console.log('Cancel clicked');
          }
        },
        {
          text: 'Salva',
          handler: data => {
            console.log('Saved clicked', data);
            this.schede.push(data);
          }
        }
      ]
    });
    prompt.present();

    }

 

  ionViewDidLoad() {
    console.log('ionViewDidLoad CreaSchedaPage');
  }


  esciIDati(data: any){
    this.schede.push(data);
  }

}
