export class Esercizio { 
    public id: number = -1;
    public nome: string = "";
    public descrizione: string = "";
    public foto: string = "";
    public ripetizioni: string = "";
    public serie : string = "";
    constructor (obj ? : any){
        this.set(obj);
    }
    set(obj ? : any){
        if (obj) {
            this.id = (typeof obj.id === "number") ? obj.id : this.id;
            this.nome = obj.nome || this.nome;
            this.descrizione = obj.descrizione || this.descrizione;
            this.foto = obj.foto || this.foto;
            this.ripetizioni = obj.ripetizioni || this.ripetizioni;
            this.serie = obj.serie || this.serie;
        }
    }
}