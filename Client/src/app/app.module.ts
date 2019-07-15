import { BrowserModule } from '@angular/platform-browser';
import { ErrorHandler, NgModule } from '@angular/core';
import { IonicApp, IonicErrorHandler, IonicModule, NavController } from 'ionic-angular';
import { SplashScreen } from '@ionic-native/splash-screen';
import { StatusBar } from '@ionic-native/status-bar';
import {HttpModule} from '@angular/http';
import { HttpClientModule } from '@angular/common/http';

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
import { LongPressModule } from "ionic-long-press";
//import { AggiungiEserciziPage } from '../pages/aggiungi-esercizi/aggiungi-esercizi';
import { FileTransfer, FileTransferObject } from '@ionic-native/file-transfer/ngx';
import { File } from '@ionic-native/file/ngx';
import { FilePath } from '@ionic-native/file-path/ngx';
import { Camera } from '@ionic-native/camera/ngx';
import { IonicStorageModule } from '@ionic/storage';
import {AccountProvider} from '../providers/account.provider';
import { UtentePersistanceProvider } from '../providers/utente-persistance.provider';
import {TabsPageModule} from '../pages/Tabs/tabs.module';
import { AggiungiEserciziPageModule } from '../pages/aggiungi-esercizi/aggiungi-esercizi.module';
//import { TabsPage } from '../pages/Tabs/tabs';

//export function createTranslateLoader(http: HttpModule) {  new TranslateHttpLoader(http, './assets/i18n/', '.json'); } 

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
    GluteiPage,
    //AggiungiEserciziPage
    //TabsPage


  ],
  imports: [
    BrowserModule,
    HttpModule,
    LongPressModule,
    HttpClientModule,
    IonicStorageModule.forRoot(),
    IonicModule.forRoot(MyApp),
    TabsPageModule,
    AggiungiEserciziPageModule
   // TranslateModule.forRoot({ 
    //  loader: { 
     //   provide: TranslateLoader, 
    //    useFactory: (createTranslateLoader), 
    //    deps: [HttpModule] }})
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
    GluteiPage,
    //AggiungiEserciziPage
    //TabsPage

  ],
  providers: [
    StatusBar,
    SplashScreen,
    {provide: ErrorHandler, useClass: IonicErrorHandler},
    AuthService,
    EsercizioService,
    SchedaPersonaleService,  
    FileTransfer,
    FileTransferObject,
    File,
    FilePath,
    AccountProvider,
    Camera,
    UtentePersistanceProvider
  ]
})
export class AppModule {}
