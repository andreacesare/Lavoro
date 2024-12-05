package Entity;

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
}