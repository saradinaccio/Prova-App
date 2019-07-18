import {Component} from '@angular/core';
import {IonicPage, NavParams, ViewController} from 'ionic-angular';
import { Platform } from 'ionic-angular';
import { StatusBar } from '@ionic-native/status-bar';
import {SplashScreen} from '@ionic-native/splash-screen';
import { HomePage } from '../home/home';
import { RoutinePage } from '../routine/routine';
import { CreaSchedaPage } from '../crea-scheda/crea-scheda';
import { AccountPage }from '../account/account';

@IonicPage()
@Component({
    templateUrl: 'tabs.html'
})
export class TabsPage {

  public tab1: any;
  public  tab2: any;
  public  tab3: any;
  public  tab4: any;
  public  data: any;


    constructor(
      public platform : Platform, 
        public params: NavParams, 
        public statusBar : StatusBar, 
        public splashScreen : SplashScreen,
        public viewCtrl : ViewController) {
          // constructor(platform: Platform, statusBar: StatusBar, splashScreen: SplashScreen, private linguaService: LinguaService, private translate: TranslateService ) {
    platform.ready().then(() => {
        // Okay, so the platform is ready and our plugins are available.
        // Here you can do any higher level native things you might need.
        statusBar.styleDefault();
        splashScreen.hide();
        //this.initTranslate();
  
      });

      this.data = {
        viewCtrl: this.viewCtrl
      }
     
      this.tab1 = HomePage;
      this.tab2 = RoutinePage;
      this.tab3 = CreaSchedaPage;
      this.tab4 = AccountPage;
  
    }
}
