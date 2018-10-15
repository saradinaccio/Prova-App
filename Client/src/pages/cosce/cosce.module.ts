import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { CoscePage } from './cosce';

@NgModule({
  declarations: [
    CoscePage,
  ],
  imports: [
    IonicPageModule.forChild(CoscePage),
  ],
})
export class CoscePageModule {}
