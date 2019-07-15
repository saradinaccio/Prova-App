import { Component, Inject, ViewChild } from '@angular/core';
import { Platform, NavController } from 'ionic-angular';
import { StatusBar } from '@ionic-native/status-bar';
import { SplashScreen } from '@ionic-native/splash-screen';
import {AccountProvider} from '../providers/account.provider';
import { LoginPage } from '../pages/login/login';

/*import { TranslateService } from '@ngx-translate/core';
import { LinguaService } from '../services/lingua.service';*/




@Component({
//  templateUrl: 'app.html'
template: `<ion-nav [root]="rootPage"></ion-nav>`
 /* template: `

  <ion-tabs id="tabs">
    <ion-tab tabIcon="home" tabTitle="Home" [root]="tab1"></ion-tab>
    <ion-tab tabIcon="checkbox-outline" tabTitle="Routine" [root]="tab2"></ion-tab>
    <ion-tab tabIcon="create" tabTitle="Le tue schede" [root]="tab3"></ion-tab>
    <ion-tab tabIcon="person" tabTitle="Account" [root]="tab4"></ion-tab>

  </ion-tabs>`*/
 })
export class MyApp {
        rootPage: any;
  
      constructor(
          platform: Platform,
          statusBar: StatusBar,
          splashScreen: SplashScreen,
          sAccount: AccountProvider
         
      ) {
          platform.ready().then(() => {
              let promises = [] as Promise<any>[];
              promises.push(sAccount.initialize());
  
              Promise.all(promises).then(() => {
                  if (sAccount.isLogged()) {
console.log("LOGGATA");
                      this.rootPage = 'TabsPage';
                  } else {
                    console.log("NON LOGGATO");
                      this.rootPage = LoginPage;
                  }
              });
  
              // Okay, so the platform is ready and our plugins are available.
              // Here you can do any higher level native things you might need.
              statusBar.styleDefault();
              splashScreen.hide();
          });
      }
  }