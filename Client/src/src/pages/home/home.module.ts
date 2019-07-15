import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { HomePage } from './home';
import { MyApp } from '../../app/app.component';
import { AppModule } from '../../app/app.module';

@NgModule({
  declarations: [
    HomePage,
  ],
  imports: [
    IonicPageModule.forChild(HomePage),
    AppModule
  ],
})
export class HomePageModule {}
