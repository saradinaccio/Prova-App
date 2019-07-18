import { Injectable } from '@angular/core';
import { Routine } from '../models/routine.model';
import {URL_BASE, URL} from '../constants';
import { Http, Response} from '@angular/http';
import { AccountProvider } from '../providers/account.provider';
import { ResponseServer} from '../types';

@Injectable()
export class RoutineProvider{

constructor(
private http: Http,
private _sAccount: AccountProvider
) {}

getRoutineByTipo(tipo: number): Promise<Array<Routine>>{
    return new Promise((resolve, reject) =>{
        this.http.get(URL.ROUTINE + '/' + this._sAccount.getUtente().token + '/tipo' + '/' + tipo)
        .toPromise()
        .then((res: Response) => {
            const json = res.json() as any as ResponseServer; 
            console.log (json.data);
            if (json.result == true) {
            console.log("dai");
            console.log(json.data);
            resolve(json.data);
            } else {
            reject(res);
            }
        })
    .catch((err: Response) => {reject(err)});
        })
    }
}