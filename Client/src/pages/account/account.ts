import { Component } from '@angular/core';
import { NavController, NavParams, LoadingController, App } from 'ionic-angular';
import {InizioPage} from "../inizio/inizio";
import { File } from '@ionic-native/file/ngx';
import { FileTransfer, FileTransferObject } from '@ionic-native/file-transfer/ngx';
import { FilePath } from '@ionic-native/file-path/ngx';
import { ActionSheetController } from 'ionic-angular';
import { Camera, CameraOptions, PictureSourceType } from '@ionic-native/camera/ngx';
import { Platform } from 'ionic-angular';
import { AccountProvider} from '../../providers/account.provider';
import { Utente } from '../../models/utente.model';

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
  lastImage: string = 'http://dominiotestprova.altervista.org/image/avatars/avatardefault.png';
  cambio:boolean=true;
  image: string = "avatardefault.png";
  file: any;
  utente: Utente;

  foto: String = "http://dominiotestprova.altervista.org/image/avatars/avatardefault.png";
  



  constructor(public navCtrl: NavController,
     public navParams: NavParams, 
     public transfer: FileTransfer, 
     public File: File, 
     public filePath: FilePath, 
     public loadingCtrl: LoadingController,  
     public actionSheetCtrl: ActionSheetController, 
     public camera : Camera, 
     public plt: Platform,
     public sAccount : AccountProvider,
     public app: App
     ) {
       this.utente=this.sAccount.getUtente();
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
      title: "SELEZIONA FOTO",
      buttons: [
      {
        icon: "md-image",
        text: "GALLERIA",
        cssClass: "action_gallery",
        handler: () => {
          this.takePicture(this.camera.PictureSourceType.PHOTOLIBRARY);
        }
      }, {
        icon: 'md-camera',
        text: "FOTO",
        cssClass: "action_gallery",
        handler: () => {
          this.takePicture(this.camera.PictureSourceType.CAMERA);
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

public takePicture(sourceType : PictureSourceType) { 

  // Create options for the Camera Dialog
  var options: CameraOptions = {
    quality: 50,
    sourceType: sourceType,
    saveToPhotoAlbum: false,
    correctOrientation: true
  };

  // Get the data of an image
  this.camera.getPicture(options).then((imagePath) => {
    // Special handling for Android library
    if (this.plt.is('android') && sourceType === this.camera.PictureSourceType.PHOTOLIBRARY) {
      this.filePath.resolveNativePath(imagePath)
        .then(filePath => {
          let correctPath = filePath.substr(0, filePath.lastIndexOf('/') + 1);
          let currentName = imagePath.substring(imagePath.lastIndexOf('/') + 1, imagePath.lastIndexOf('?'));
          this.copyFileToLocalDir(correctPath, currentName, this.createFileName());
        });
    } else {
      var currentName = imagePath.substr(imagePath.lastIndexOf('/') + 1);
      var correctPath = imagePath.substr(0, imagePath.lastIndexOf('/') + 1);
      this.copyFileToLocalDir(correctPath, currentName, this.createFileName());
    }
  }, (err) => {
       console.log(err);
  
  });
}

private copyFileToLocalDir(namePath, currentName, newFileName) {
  let bool = this.file.checkDir(cordova.file.externalRootDirectory, "Cityshop");
  if(!bool){
      this.file.createDir(cordova.file.externalRootDirectory, "Cityshop", false)
        .then(()=>{
            alert("entra4");
            let path = cordova.file.externalRootDirectory + "Cityshop";
            this.file.copyFile(namePath, currentName, path, newFileName).then(() => {
              this.lastImage = newFileName;
              this.uploadImage();
            });
         });
  } else {
     let path = cordova.file.externalRootDirectory + "Cityshop";
        this.file.copyFile(namePath, currentName, path, newFileName).then(() => {
          this.lastImage = newFileName;
          this.uploadImage();
        }); 
  }
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
    var targetPath = cordova.file + "Cityshop/" ;

    // File name only
    var filename = "Ciao";

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


logout() {
              const loading = this.loadingCtrl.create({content: "CARICAMENTO"});
              loading.present();

              this.sAccount.logout()
                  .then(() => {
                      loading.dismiss().then(() => {
                          this.app.getRootNav().setRoot(InizioPage);
                      });
                  })
                  .catch(() => {

                  });
          }

onLink(url: string) {
  window.open(url);
}

}

