import { Component } from '@angular/core';
import { Platform, NavController } from 'ionic-angular';
import { StatusBar } from '@ionic-native/status-bar';
import { SplashScreen } from '@ionic-native/splash-screen';
import { HomePage } from '../pages/home/home';
import { RoutinePage } from '../pages/routine/routine';
import { CreaSchedaPage } from '../pages/crea-scheda/crea-scheda';
import { AccountPage }from '../pages/account/account';
//import { InizioPage } from '../pages/inizio/inizio';
/*import { TranslateService } from '@ngx-translate/core';
import { LinguaService } from '../services/lingua.service';*/




@Component({
//  templateUrl: 'app.html'
  template: `

  <ion-tabs id="tabs">
    <ion-tab tabIcon="home" tabTitle="Home" [root]="tab1"></ion-tab>
    <ion-tab tabIcon="checkbox-outline" tabTitle="Routine" [root]="tab2"></ion-tab>
    <ion-tab tabIcon="create" tabTitle="Le tue schede" [root]="tab3"></ion-tab>
    <ion-tab tabIcon="person" tabTitle="Account" [root]="tab4"></ion-tab>

  </ion-tabs>`
 })
export class MyApp {
 // rootPage:any = InizioPage;
  tab1: any;
  tab2: any;
  tab3: any;
  tab4: any;

  constructor(platform: Platform, statusBar: StatusBar, splashScreen: SplashScreen) {
  // constructor(platform: Platform, statusBar: StatusBar, splashScreen: SplashScreen, private linguaService: LinguaService, private translate: TranslateService ) {
    platform.ready().then(() => {
      // Okay, so the platform is ready and our plugins are available.
      // Here you can do any higher level native things you might need.
      statusBar.styleDefault();
      splashScreen.hide();
      //this.initTranslate();

    });

    this.tab1 = HomePage;
    this.tab2 = RoutinePage;
    this.tab3 = CreaSchedaPage;
    this.tab4 = AccountPage;

    

    /*initTranslate() {
      // Set the default language for translation strings, and the current language.
      let linguaPreferita = this.linguaService.getLinguaPreferita();
      this.translate.setDefaultLang(linguaPreferita);
      this.linguaService.getLinguaAttuale().subscribe((lingua: string) => {
        if (lingua != null) {
          this.translate.use(lingua);
        } else {
          this.translate.use(linguaPreferita);
          this.linguaService.updateLingua(linguaPreferita);
        }
      });


  }*/
  }


  
}
