import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { URL } from '../constants';
import { schedaPersonale } from '../models/schedaPersonale.model';
import { AccountProvider } from '../providers/account.provider';
import { ResponseServer } from '../types';
import { Http, Response} from '@angular/http';

@Injectable()

export class SchedaPersonaleService{

  public _scheda: schedaPersonale = null;
  

  constructor (private http: Http, private _sAccount: AccountProvider){

  }
/*
  schedePersonali(): Observable<Array<schedaPersonale>>{
    console.log("Ciao");
    return this.http.get<Array<schedaPersonale>>(URL.SCHEDEPERSONALI + '/2904899154611209978' + '/personale/1'); //Richiama sul server UrlSchedePersonali e prende i dati dal database

  }*/

  getSchedePersonali() : Promise<Array<schedaPersonale>> {
    return new Promise((resolve, reject) =>{
        this.http.get(URL.SCHEDEPERSONALI + '/'+ this._sAccount.getUtente().token + '/personale')
            .toPromise()
            .then((res: Response) => {
              console.log("sei tu ?"); 
                const json = res.json() as ResponseServer;
                console.log("sei tu undefined?"); 
                console.log (json.data);
                if(json.result == true) {
                    console.log("Lo fai?");
                    resolve(json.data);
                }
                else {
                  reject(json.data);
                }
            })
        .catch((err: Response) => {reject(err)});
    })
}
/*
  crea(SchedaPersonale : schedaPersonale): Observable<boolean>{
    console.log("LOG.CREA_SCHEDA: " + URL.SCHEDEPERSONALI);
    return this.http.post<boolean>(URL.CREASCHEDEPERSONALI, SchedaPersonale, {observe: 'response'})
      .map((resp: HttpResponse<boolean>) => {
    //  console.log("resp.body.valueOf():" + resp.body.valueOf());
    console.log("resp.body.valueOf()");
      return resp.body;

    });

  }
*/
  getSchedaById(id: String): Promise<any> {
    return new Promise((resolve, reject) => {
    this._scheda = null;
    this.http.get(URL.SCHEDE + '/' + this._sAccount.getUtente().token + '/personale/' + id)
    .toPromise()
      .then((res: Response) => {
              const json = res.json() as ResponseServer; 
          if (json.result == true) {
              this._scheda = new schedaPersonale(json.data);
              resolve(this._scheda);
          } else {
              reject(this._scheda);
          }
      })
      .catch((err: Response) => reject(`Errore status: ${err.status}`));
});

  }

  creaScheda(scheda: schedaPersonale): Promise<any>{
    return new Promise((resolve, reject) =>{
        this.http.post(URL.SCHEDEPERSONALI + '/' + this._sAccount.getUtente().token + '/personale', scheda)
            .toPromise()
            .then((res: Response) => {
              console.log(res);
              
                const json = res.json() as ResponseServer; 
                if (json.result == true) {
                    console.log(json.result);
                    resolve(json.result);
                } else {
                    reject(res);
                }
            })
        .catch((err: Response) => {reject(err)});
    })
}

deleteSchedaPersonale(id: number): Promise<any>{
  console.log(id);
  return new Promise((resolve, reject) =>{
    this.http.delete(URL.SCHEDEPERSONALI + '/' + this._sAccount.getUtente().token + '/personale/' + id)
        .toPromise()
        .then((res: Response) => {
          console.log("sono dentro delete");
          console.log(res);
          
            const json = res.json() as ResponseServer; 
            if (json.result == true) {
                console.log(json.result);
                resolve(json.result);
            } else {
                reject(res);
            }
        })
    .catch((err: Response) => {reject(err)});
})
}
}