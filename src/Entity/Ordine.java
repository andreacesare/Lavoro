package Entity;

import java.time.LocalDate;

public class Ordine {
    private int id;
    private String cliente;
    private LocalDate data;
    private int importo;
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
}
