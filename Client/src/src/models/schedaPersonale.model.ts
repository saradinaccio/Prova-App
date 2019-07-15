export class schedaPersonale{
public id_schedapersonale: number = -1;
public goal: string ="";


  constructor (obj ? : any){
    this.set(obj);
  }
  set(obj ? : any){
    if (obj) {
      this.id_schedapersonale = (typeof obj.id === "number") ? obj.id : this.id_schedapersonale;
      this.goal = obj.goal || this.goal;
    }
  }
}
