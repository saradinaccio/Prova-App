import { Component } from '@angular/core';
import { NavController, NavParams } from 'ionic-angular';
import { MyApp } from '../../app/app.component';

/**
 * Generated class for the SceltaZonaPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@Component({
  selector: 'page-scelta-zona',
  templateUrl: 'scelta-zona.html',
})
export class SceltaZonaPage {

  constructor(public navCtrl: NavController, public navParams: NavParams) {
  }

  goToOtherPage() {
    //push another page onto the history stack
    //causing the nav controller to animate the new page in
    this.navCtrl.push(MyApp);
  }


  ionViewDidLoad() {
    document.querySelector(".tabbar")['style'].display = 'none';
    console.log('ionViewDidLoad SceltaZonaPage');
  }

  

}
