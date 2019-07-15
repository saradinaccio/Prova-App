import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { AggiungiEserciziPage } from './aggiungi-esercizi';

@NgModule({
  declarations: [
    AggiungiEserciziPage,
  ],
  imports: [
    IonicPageModule.forChild(AggiungiEserciziPage),
  ],
})
export class AggiungiEserciziPageModule {}
