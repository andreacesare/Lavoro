package Controller;

import Entity.Impiegato;
import Entity.Ordine;
import Service.OrdineService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class OrdineController {
    OrdineService ordineService = new OrdineService();
    Scanner scanner = new Scanner(System.in);

   public void createOrdine() {
       ImpiegatoController impiegatoController = new ImpiegatoController();
       System.out.println("Inserisci cliente");
       String cliente = scanner.nextLine();
       DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd/MM/yyyy");
       LocalDate data=null;
       boolean x=false;
       while (!x) {
           try{
               System.out.println("Inserisci la data formato dd/mm/yyyy");
               data=LocalDate.parse(scanner.nextLine(),formatter);
               x=true;
           }catch(DateTimeParseException e){
               System.out.println("Errore,inserisci la data formato dd/mm/yyyy");
           }
       }
       System.out.println("Inserisci l'importo");
       int importo = scanner.nextInt();
       scanner.nextLine();
       impiegatoController.readImpiegato();;
       System.out.println("Inserisci l'id dell'impiegato cha gestito l'ordine");
       int idi=scanner.nextInt();
       scanner.nextLine();
       ordineService.createOrdine(cliente,data,importo,idi);


   }

   public void readOrdine() {
       System.out.println("Ecco la lista degli ordini");
       ArrayList<Ordine> ordine = ordineService.readOrdine();
       for(Ordine o:ordine){
           if(o.getId()!=0){System.out.println(o);}
       }
   }

   public void deleteOrdine() {
       readOrdine();
       System.out.println("Inserisci l'id dell'ordine da eliminare");
       int id=scanner.nextInt();
       scanner.nextLine();
       ordineService.deleteOrdine(id);
   }

   public void updateOrdine() {
       readOrdine();
       System.out.println("Inserisci l'id dell'ordine da modificare");
       int id=scanner.nextInt();
       scanner.nextLine();
       ImpiegatoController impiegatoController = new ImpiegatoController();
       System.out.println("Inserisci nuovo cliente");
       String cliente = scanner.nextLine();
       DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd/MM/yyyy");
       LocalDate data=null;
       boolean x=false;
       while (!x) {
           try{
               System.out.println("Inserisci la nuova data formato dd/mm/yyyy");
               data=LocalDate.parse(scanner.nextLine(),formatter);
               x=true;
           }catch(DateTimeParseException e){
               System.out.println("Errore,inserisci la data formato dd/mm/yyyy");
           }
       }
       System.out.println("Inserisci nuovo importo");
       int importo = scanner.nextInt();
       scanner.nextLine();
       impiegatoController.readImpiegato();;
       System.out.println("Inserisci l'id dell'impiegato cha gestito l'ordine");
       int idi=scanner.nextInt();
       scanner.nextLine();
       ordineService.updateOrdine(id,cliente,data,importo,idi);


   }

   public void impiegatixCliente(){
       readOrdine();
       System.out.println("inserisci cliente");
       String cliente = scanner.nextLine();
       List<Impiegato> lista=ordineService.impiegatixCliente(cliente);
       for(Impiegato i:lista){
           System.out.println(i);
       }
   }

   public void ordinixImpiegato(){
       ImpiegatoController impiegatoController = new ImpiegatoController();
       impiegatoController.readImpiegato();
       System.out.println("Inserisci l'id dell'Impiegato");
       int id=scanner.nextInt();
       scanner.nextLine();
       List<Ordine> lista=ordineService.ordinixImpiegato(id);
       for(Ordine o:lista){
           System.out.println(o);
       }
   }

   public void ordiniFebbraio(){
       List<Ordine> lista=ordineService.ordiniFebbraio();
       for(Ordine o:lista){
           System.out.println(o);
       }

   }

   public void ClientiSpesa(){
       List<Map.Entry<String,Double>> lista=ordineService.ClientiSpesa();
       for(Map.Entry<String,Double> o:lista){
           System.out.println(o);
       }
   }
   public void livelliOrdini(){
       List<Map.Entry<Integer,Long>> lista=ordineService.livelliOrdini();
       for(Map.Entry<Integer,Long> o:lista){
           System.out.println(o);
       }
   }
   public void impiegatiSoldiTot(){
       List<Map.Entry<Impiegato,Double>> lista=ordineService.impiegatiSoldiTot();
       for(Map.Entry<Impiegato,Double> o:lista){
           System.out.println(o);
       }
   }

   public void livelloSoldiTot(){
       List<Map.Entry<Integer,Double>> lista=ordineService.livelliSoldiTot();
       for(Map.Entry<Integer,Double> o:lista){
           System.out.println(o);
       }
   }
   public void impiegatiOrdini(){
       List<Map.Entry<Impiegato,Long>> lista=ordineService.impiegatiOrdini();
       for(Map.Entry<Impiegato,Long> o:lista){
           System.out.println(o);
       }
   }
}
