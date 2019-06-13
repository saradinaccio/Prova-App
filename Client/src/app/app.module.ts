import { BrowserModule } from '@angular/platform-browser';
import { ErrorHandler, NgModule } from '@angular/core';
import { IonicApp, IonicErrorHandler, IonicModule } from 'ionic-angular';
import { SplashScreen } from '@ionic-native/splash-screen';
import { StatusBar } from '@ionic-native/status-bar';
import { TranslateModule, TranslateLoader, TranslateService } from '@ngx-translate/core';
import {TranslateHttpLoader} from '@ngx-translate/http-loader';
import {HttpClient, HttpClientModule} from '@angular/common/http';

import { MyApp } from './app.component';
import { HomePage } from '../pages/home/home';
import { LoginPage } from '../pages/login/login';
import { AuthService } from '../providers/auth-service/auth-service';
import { RegisterPage } from '../pages/register/register';
import { CreaSchedaPage } from '../pages/crea-scheda/crea-scheda';
import { AccountPage } from '../pages/account/account';
import AddomiPage from "../pages/addomi/addomi";
import { RoutinePage } from '../pages/routine/routine';
import { SceltaZonaPage } from '../pages/scelta-zona/scelta-zona';
import { InizioPage } from '../pages/inizio/inizio';
import { RiscaldamentoPage } from '../pages/riscaldamento/riscaldamento';
import { StretchingPage } from '../pages/stretching/stretching';
import { EsercizioService } from '../services/esercizio.service';
import {CoscePage} from "../pages/cosce/cosce";
import {GluteiPage} from "../pages/glutei/glutei";
import {SchedaPersonaleService} from "../services/schedaPersonale.service";


export function createTranslateLoader(http: HttpClient) { return new TranslateHttpLoader(http, './assets/i18n/', '.json'); } 

@NgModule({
  declarations: [
    MyApp,
    HomePage,
    LoginPage,
    CreaSchedaPage,
    AccountPage,
    SceltaZonaPage,
    RoutinePage,
    InizioPage,
    RegisterPage,
    RiscaldamentoPage,
    StretchingPage,
    AddomiPage,
    CoscePage,
    GluteiPage


  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    IonicModule.forRoot(MyApp),
    TranslateModule.forRoot({ 
      loader: { 
        provide: TranslateLoader, 
        useFactory: (createTranslateLoader), 
        deps: [HttpClient] }})
  ],
  bootstrap: [IonicApp],
  entryComponents: [
    MyApp,
    HomePage,
    LoginPage,
    CreaSchedaPage,
    AccountPage,
    SceltaZonaPage,
    RoutinePage,
    InizioPage,
    RegisterPage,
    RiscaldamentoPage,
    StretchingPage,
    AddomiPage,
    CoscePage,
    GluteiPage

  ],
  providers: [
    StatusBar,
    SplashScreen,
    {provide: ErrorHandler, useClass: IonicErrorHandler},
    AuthService,
    EsercizioService,
    SchedaPersonaleService
  ]
})
export class AppModule {}
