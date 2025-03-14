package gestionnaire_parking;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Entrer un véhicule");
            System.out.println("2. Sortir un véhicule");
            System.out.println("3. Afficher la file d'attente");
            System.out.println("4. Afficher la pile des sorties");
            System.out.println("5. Quitter");
            System.out.print("Choix : ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Numéro d'immatriculation : ");
                    String plateIn = scanner.nextLine();
                    parkingLot.vehicleEntry(plateIn);
                    break;
                case 2:
                    System.out.print("Numéro d'immatriculation : ");
                    String plateOut = scanner.nextLine();
                    parkingLot.vehicleExit(plateOut);
                    break;
                case 3:
                    parkingLot.displayQueue();
                    break;
                case 4:
                    parkingLot.displayExitStack();
                    break;
                case 5:
                    System.out.println("Fermeture du système.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Choix invalide !");
            }
        }
    }
}
