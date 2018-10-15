import { Component } from '@angular/core';
import { NavController, NavParams, AlertController } from 'ionic-angular';

/**
 * Generated class for the AddomiPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@Component({
  selector: 'page-addomi',
  templateUrl: 'addomi.html',


})
export class AddomiPage {


  public schede : any = [{ id:1, scheda:'squat', desc:'ciao sono sara'}, {id:2, scheda: 'plank', desc: 'ciao sono sara'}];
  public title : string = "";
  public message : string= "";
  constructor(public navCtrl: NavController, public navParams: NavParams, public alerCtrl: AlertController) {
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad AddomiPage');
  }

  doAlert(x: any) {
    this.title=x.scheda;
    this.message=x.desc;
    console.log(this.title);
    let alert = this.alerCtrl.create({
      title: this.title,
      message: this.message,
      buttons: ['Ok']
    });
    alert.present()
  }

}
