import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { CreaSchedaPage } from './crea-scheda';

@NgModule({
  declarations: [
    CreaSchedaPage,
  ],
  imports: [
    IonicPageModule.forChild(CreaSchedaPage),
  ],
})
export class CreaSchedaPageModule {}
