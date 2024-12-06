import Controller.ImpiegatoController;
import Controller.OrdineController;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        int choice1;
        int choice2;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("1)Impiegato \n 2)Ordine \n 3) Exit");
            System.out.println("Inserisci la tua scelta");
            choice1 = scanner.nextInt();
            scanner.nextLine();
            if (choice1 == 1) {
                System.out.println("Classe Impiegato");
                System.out.println("****MENU****");
                System.out.println("1. Crea un nuovo Impiegato");
                System.out.println("2. Aggiorna un Impiegato");
                System.out.println("3. Visualizza la lista degli ImpiegatI");
                System.out.println("4. Elimina un Impiegato");
                System.out.println("9. Exit");
                System.out.print("inserisci la tua scelta: ");
                choice2 = scanner.nextInt();
                scanner.nextLine();
                ImpiegatoController impiegatoController = new ImpiegatoController();
                switch (choice2) {
                    case 1:
                        impiegatoController.createImpiegato();
                        break;
                    case 2:
                        impiegatoController.updateImpiegato();
                        break;
                    case 3:
                        impiegatoController.readImpiegato();
                        break;
                    case 4:
                        impiegatoController.deleteImpiegato();
                        break;
                    case 5:
                        break;
                    case 6:

                        break;
                    case 7:
                        break;
                    case 9:
                        System.out.println("Exiting");
                        break;
                    default:
                        System.out.println("Insersci un numero valido");
                }
            }
            else if (choice1 == 2) {
                System.out.println("Classe Ordine");
                System.out.println("****MENU****");
                System.out.println("1. Crea un nuovo ordine");
                System.out.println("2. Aggiorna un ordine");
                System.out.println("3. Visualizza la lista degli ordini ");
                System.out.println("4. Elimina un ordine");
                System.out.println("5. Lista di impiegati che lavorano per un cliente");
                System.out.println("6. Lista ordini fatti da uno specifico impiegato");
                System.out.println("7. Oridni di febbraio");
                System.out.println("8. Lista Clienti e la loro spesa complessiva");
                System.out.println("10. Lista #ordini per livello impiegato");
                System.out.println("11. Lista impiegati con importi complessivi");
                System.out.println("12 Lista livelli con importi complessivi");
                System.out.println("13. Lista #ordini per Impiegato");
                System.out.println("9. Exit");
                System.out.print("inserisci la tua scelta: ");
                choice2 = scanner.nextInt();
                scanner.nextLine();
                OrdineController ordineController = new OrdineController();
                switch (choice2) {
                    case 1:
                        ordineController.createOrdine();
                        break;
                    case 2:
                        ordineController.updateOrdine();
                        break;
                    case 3:
                        ordineController.readOrdine();
                        break;
                    case 4:
                        ordineController.deleteOrdine();
                        break;
                    case 5:
                        ordineController.impiegatixCliente();
                        break;
                    case 6:
                        ordineController.ordinixImpiegato();
                        break;
                    case 7:
                        ordineController.ordiniFebbraio();
                        break;
                    case 8:
                        ordineController.ClientiSpesa();
                        break;
                    case 10:
                        ordineController.livelliOrdini();
                        break;
                    case 11:
                        ordineController.impiegatiSoldiTot();
                        break;
                    case 12:
                        ordineController.livelloSoldiTot();;
                        break;
                    case 13:
                        ordineController.impiegatiOrdini();
                    case 9:
                        System.out.println("Exiting");
                        break;
                    default:
                        System.out.println("Insersci un numero valido");
                }
            }
        } while (choice1 != 3);

    }
}