import { Esercizio } from '../models/esercizio.model';

export class schedaPersonale{
public id_schedapersonale: number = -1;
public goal: string ="";
public esercizi: Array<Esercizio> = [];


  constructor (obj ? : any){
    this.set(obj);
  }
  set(obj ? : any){
    if (obj) {
      this.esercizi = obj.esercizi || this.esercizi;
      this.id_schedapersonale = (typeof obj.id === "number") ? obj.id : this.id_schedapersonale;
      this.goal = obj.goal || this.goal;
    }
  }
}
