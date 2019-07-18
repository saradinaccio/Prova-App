import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams, AlertController, LoadingController } from 'ionic-angular';
import { RoutineProvider } from "../../providers/routine.provider";
import { Routine } from '../../models/routine.model';

@Component({
selector: 'page-stretching',
templateUrl: 'stretching.html',
})
export class StretchingPage {

    routines : Array<Routine> = [];

    constructor(public navCtrl: NavController, 
    public navParams: NavParams, 
    public alertCtrl: AlertController, 
    public sRoutine: RoutineProvider, 
    public loadingCtrl: LoadingController) {

        const loading = this.loadingCtrl.create({content: "Caricamento"});
        loading.present();
        this.sRoutine.getRoutineByTipo(2)
        .then(result => {
        console.log("dfgh");
        this.routines = result;
        console.log(this.routines);
        loading.dismiss();
    })
    .catch(msg => { 
        loading.dismiss();
        this.alertCtrl.create({
        title: "FitWoman",
        message: "Non è stato possibile recuperare le routine",
        buttons: ["Ok"]
        }).present();
        });
    }

    doAlert(routine: Routine) {
        let alert = this.alertCtrl.create({
        title: routine.nome,
        message: routine.descrizione,
        buttons: ['Ok']
        });
        alert.present()
    }

    ionViewDidLoad() {
      console.log('ionViewDidLoad StretchingPage');
    }
}
