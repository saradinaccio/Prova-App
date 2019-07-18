import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams, AlertController, LoadingController } from 'ionic-angular';
import {schedaPersonale} from '../../models/schedaPersonale.model';
import {SchedaPersonaleService} from "../../providers/schedaPersonale.provider";
import { HttpClient, HttpHeaders} from '@angular/common/http';
import { ActionSheetController } from 'ionic-angular';
import { ThrowStmt } from '@angular/compiler';



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

 // public body : schedaPersonale;

  // public schede : any = [{ id:1, scheda:'squat', desc:'ciao sono sara'}, {id:2, nome: 'plank', desc: 'ciao sono sara'}];
  

  // public SchedaPersonale: schedaPersonale ;
  SchedaPersonale: schedaPersonale = new schedaPersonale();
  public var : string = "";
  public schedaPersonaleLista : Array<schedaPersonale> = [];

  constructor(
    public navCtrl: NavController, 
    public navParams: NavParams, 
    public alertCtrl: AlertController, 
    public schedaPersonaleService: SchedaPersonaleService, 
    public http : HttpClient, 
    public asc : ActionSheetController,
    public loadingCtrl: LoadingController
     ) {
  }


  optionList(id: number){
    let actionSheet = this.alertCtrl.create({
      title: 'Vuoi eliminare la tua scheda?',
      buttons: [
         {
          text: 'Elimina',
          handler: data => {
            const loading = this.loadingCtrl.create({content: "Caricamento"});
             loading.present();
             console.log(id);
              this.schedaPersonaleService.deleteSchedaPersonale(id)
            .then(result => {
              if(result){
                console.log("sono dentro delete 2");
                loading.dismiss();
                this.alertCtrl.create({
                  title: "Creazione Scheda",
                  message: "Scheda eliminata con successo!",
                  buttons: [{
                      text: "OK",
                      handler: () => {
                          this.navCtrl.setRoot("CreaSchedaPage");

                      }
                  }]
              }).present();

              }
            })
            .catch(msg => { 
                loading.dismiss();
                this.alertCtrl.create({
                    title: "FitWoman",
                    message: "Non è stato possibile eliminare la tua scheda",
                    buttons: ["Ok"]
                }).present();
            });
            console.log('Cancel clicked');
          }
        },

        {
          text: 'Annulla',
          handler: data => {
            let navTransition = actionSheet.dismiss();
            return false;
        
          }
        }
      ]
    });
    actionSheet.present();

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
            console.log('Saved clicked', data.nome);
           // this.schede.push(data);
          
            this.SchedaPersonale.goal = data.nome;
            this.navCtrl.push("AggiungiEserciziPage", {nome: data.nome});
         //   this.schedaPersonaleService.crea(this.SchedaPersonale).subscribe((data: Boolean)=> {
           //   console.log(data);
           // }); 
          }
        }
      ]
    });
    prompt.present();

    }

    goToScheda(id: number) {
      this.navCtrl.push("SchedaPersonalePage", {id: id});
    }
 

  ionViewDidLoad() {
    console.log('ionViewDidLoad CreaSchedaPage');
    console.log(this.schedaPersonaleLista);

    const loading = this.loadingCtrl.create({content: "Caricamento"});
    loading.present();
    this.schedaPersonaleService.getSchedePersonali()
            .then(result => {
              console.log("dfgh");
                this.schedaPersonaleLista = result;
                console.log(this.schedaPersonaleLista);
                loading.dismiss();
            })
            .catch(msg => { 
                loading.dismiss();
                this.alertCtrl.create({
                    title: "FitWoman",
                    message: "Non è stato possibile recuperare le tue schede personali",
                    buttons: ["Ok"]
                }).present();
            });

    /*
    this.schedaPersonaleService.schedePersonali().subscribe((schedaP: Array<schedaPersonale>)=> {
      
      this.schedaPersonaleLista= schedaP;
      console.log(this.schedaPersonaleLista[0]);
    })
    */
  }


/*
  esciIDati(data: any){
    this.schede.push(data);
  }
*/

}
