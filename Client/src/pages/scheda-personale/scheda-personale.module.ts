import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { SchedaPersonalePage } from './scheda-personale';

@NgModule({
  declarations: [
    SchedaPersonalePage,
  ],
  imports: [
    IonicPageModule.forChild(SchedaPersonalePage),
  ],
})
export class SchedaPersonalePageModule {}
