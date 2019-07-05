import { Component } from '@angular/core';
import { NavController, NavParams, LoadingController } from 'ionic-angular';
import {InizioPage} from "../inizio/inizio";
import { File } from '@ionic-native/file/ngx';
import { FileTransfer, FileTransferObject } from '@ionic-native/file-transfer/ngx';
import { FilePath } from '@ionic-native/file-path/ngx';
import { ActionSheetController } from 'ionic-angular';

declare let cordova : any;
/**
 * Generated class for the AccountPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@Component({
   selector: 'page-account',
   templateUrl: 'account.html',

})

export class AccountPage {

  cambio:boolean=true;
  utente:any={nome:"Sara",cognome:" Di Naccio"}

  constructor(public navCtrl: NavController, public navParams: NavParams, public transfer: FileTransfer, public File: File, public filePath: FilePath, public loadingCtrl: LoadingController,  public actionSheetCtrl: ActionSheetController) {
  }

  goToOtherPage() {
    //push another page onto the history stack
    //causing the nav controller to animate the new page in
    this.navCtrl.push(InizioPage);
  }

  cambia() {

    if (this.cambio==true){
      this.cambio=false;
    }
  }



  ionViewDidLoad() {
    console.log('ionViewDidLoad AccountPage');
  }


  presentActionSheet() {
    let actionSheet = this.actionSheetCtrl.create({
        title: "SELEZIONA LA FOTO",
        buttons: [
        {
          icon: "md-image",
          text: "FOGLIA LA GALLERIA",
          cssClass: "action_gallery",
          handler: () => {
           
          }
        }, {
          cssClass: "action_cancel",
          text: "CANCELLA",
          role: 'cancel',
        }
      ]
    });
    actionSheet.present();
}

private createFileName() {
  var d = new Date(),
  n = d.getTime(),
  newFileName ="IMG_" + n + ".jpg";
  return newFileName;
}

  public uploadImage() {
    let loading = this.loadingCtrl.create({
        content: "ATTENDI"
      });

      loading.present();
    
    // Destination URL
    var url = "http://dominiotestprova.altervista.org/upload.php";

    // File for Upload
    var targetPath = cordova.file + "Cityshop/" + this.lastImage;

    // File name only
    var filename = this.lastImage;

    var options = {
      fileKey: "file",
      fileName: filename,
      chunkedMode: false,
      mimeType: "multipart/form-data",
      params : {'fileName': filename}
    };

    const fileTransfer: FileTransferObject = this.transfer.create();

    // Use the FileTransfer to upload the image
    fileTransfer.upload(targetPath, url, options).then(data => {
        this.image = filename;
        this.foto = "http://dominiotestprova.altervista.org/image/avatars/" + filename;
        loading.dismiss();
    }, err => {
        loading.dismiss();
        alert("SI E' VERIFICATO UN ERRORE");
    });
}

}

