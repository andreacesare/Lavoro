package Entity;

import java.time.LocalDate;
import java.util.Objects;

public class Ordine {
    private int id;
    private String cliente;
    private LocalDate data;
    private int importo;
    private int idimpiegato;
    private Impiegato impiegato;

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getCliente(){
        return cliente;
    }
    public void setCliente(String cliente){
        this.cliente = cliente;
    }
    public LocalDate getData(){
        return data;
    }
    public void setData(LocalDate data){
        this.data = data;
    }
    public int getImporto(){
        return importo;
    }
    public void setImporto(int importo){
        this.importo = importo;
    }
    public Impiegato getImpiegato(){
        return impiegato;
    }
    public void setImpiegato(Impiegato impiegato){
        this.impiegato = impiegato;
    }
    public int getIdimpiegato(){
        return idimpiegato;
    }
    public void setIdimpiegato(int idimpiegato){
        this.idimpiegato = idimpiegato;
    }

    public String toString(){
        return id+"\t"+cliente+"\t"+data+"\t"+importo+"\t"+idimpiegato+"\n";
    }

    public boolean equals(Object o){
        if(this==o) return true;
        if(o==null || getClass() != o.getClass()) return false;
        Ordine ordine = (Ordine)o;
        return id==ordine.id;
    }

    public int hashCode(){
        return Objects.hash(id);
    }

}
