package Entity;

import java.util.Objects;

public class Impiegato{
    private int id;
    private String nome;
    private String cognome;
    private int livello;

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getCognome(){
        return cognome;
    }
    public void setCognome(String cognome){
        this.cognome = cognome;
    }
    public int getLivello(){
        return livello;
    }
    public void setLivello(int livello){
        this.livello = livello;
    }

    public String toString(){
        return id+"\t "+nome+"\t "+cognome+"\tlivello: "+livello;
    }

    public boolean equals(Object o){
        if(this==o) return true;
        if(o==null || getClass() != o.getClass()) return false;
        Impiegato i = (Impiegato)o;
        return id==i.id;
    }

    public int hashCode(){
        return Objects.hash(id);
    }

}