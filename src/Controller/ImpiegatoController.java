package Controller;

import Entity.Impiegato;
import Service.ImpiegatoService;

import java.util.ArrayList;
import java.util.Scanner;

public class ImpiegatoController {
    Scanner scanner = new Scanner(System.in);
    ImpiegatoService impiegatoService = new ImpiegatoService();

    public void createImpiegato(){
        System.out.println("Inserisci nome");
        String nome = scanner.nextLine();
        System.out.println("Inserisci cognome");
        String cognome = scanner.nextLine();
        System.out.println("Inserisci livello");
        int livello = scanner.nextInt();
        scanner.nextLine();
        impiegatoService.createImpigato(nome,cognome,livello);
    }

    public void readImpiegato(){
        System.out.println("Ecco la lista degli impiegati");
        ArrayList<Impiegato> lista=impiegatoService.readImpiegato();
        for(Impiegato i:lista){
            System.out.println(i);
        }

    }

    public void deleteImpiegato(){
        readImpiegato();
        System.out.println("Inserisci l'id dell'impiegato da eliminare");
        int id = scanner.nextInt();
        scanner.nextLine();
        impiegatoService.deleteImpiegato(id);
    }

    public void updateImpiegato(){
        readImpiegato();
        System.out.println("Inserisci l'id dell'impiegato da modidifcare");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Inserisci nuovo nome");
        String nome = scanner.nextLine();
        System.out.println("Inserisci nuovo cognome");
        String cognome = scanner.nextLine();
        System.out.println("Inserisci nuovo livello");
        int livello = scanner.nextInt();
        scanner.nextLine();
        impiegatoService.updateImpiegato(id,nome,cognome,livello);

    }
}
