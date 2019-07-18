export class Routine { 
    public id: number = -1;
    public nome: string = "";
    public descrizione: string = "";
    public durata: number;
    public tipo: number;

    constructor (obj ? : any){
        this.set(obj);
    }
    set(obj ? : any){
        if (obj) {
            this.id = (typeof obj.id === "number") ? obj.id : this.id;
            this.nome = obj.nome || this.nome;
            this.descrizione = obj.descrizione || this.descrizione;
            this.durata = obj.durata || this.durata;
            this.tipo = obj.tipo || this.tipo;
        }
    }
}