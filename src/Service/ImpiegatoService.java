package Service;

import Entity.Impiegato;
import Repository.ImpiegatoRepository;

import java.util.ArrayList;

public class ImpiegatoService {

    ImpiegatoRepository impiegatoRepository = new ImpiegatoRepository();

    public void createImpigato(String nome,String cognome,int livello){
        Impiegato impiegato = new Impiegato();
        impiegato.setNome(nome);
        impiegato.setCognome(cognome);
        impiegato.setLivello(livello);
        impiegatoRepository.createImpiegato(impiegato);
    }

    public ArrayList<Impiegato> readImpiegato(){
        return impiegatoRepository.readImpiegato();
    }

    public void deleteImpiegato(int id){
        Impiegato impiegato=new Impiegato();
        impiegato.setId(id);
        impiegatoRepository.deleteImpiegato(impiegato);
    }

    public void updateImpiegato(int id,String nome,String cognome,int livello){
        Impiegato impiegato=new Impiegato();
        impiegato.setId(id);
        impiegato.setNome(nome);
        impiegato.setCognome(cognome);
        impiegato.setLivello(livello);
        impiegatoRepository.updateImpiegato(impiegato);

    }
}
