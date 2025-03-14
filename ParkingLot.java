package gestionnaire_parking;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

public class ParkingLot {
    private Queue<Vehicle> entryQueue = new LinkedList<>();
    private Stack<Vehicle> exitStack = new Stack<>();
    private Map<String, LocalDateTime> parkedVehicles = new HashMap<>();
    private static final double RATE_PER_HOUR = 2.0; // Tarif par heure

    // Ajouter un véhicule à l'entrée
    public void vehicleEntry(String plateNumber) {
        LocalDateTime entryTime = LocalDateTime.now();
        Vehicle vehicle = new Vehicle(plateNumber, entryTime);
        entryQueue.add(vehicle);
        parkedVehicles.put(plateNumber, entryTime);
        System.out.println("Véhicule " + plateNumber + " entré à " + entryTime);
    }

    // Traiter une sortie de véhicule
    public void vehicleExit(String plateNumber) {
        LocalDateTime exitTime = LocalDateTime.now();
        if (!parkedVehicles.containsKey(plateNumber)) {
            System.out.println("Véhicule non trouvé !");
            return;
        }

        LocalDateTime entryTime = parkedVehicles.remove(plateNumber);
        Vehicle vehicle = new Vehicle(plateNumber, entryTime);
        exitStack.push(vehicle);
        double amountDue = calculateFee(entryTime, exitTime);
        System.out.println("Véhicule " + plateNumber + " sorti à " + exitTime);
        System.out.println("Montant à payer : " + amountDue + "€");
    }

    // Calcul des frais
    private double calculateFee(LocalDateTime entryTime, LocalDateTime exitTime) {
        long minutes = Duration.between(entryTime, exitTime).toMinutes();
        return (minutes / 5.0); // 1€ toutes les 5 minutes
    }


    // Afficher les véhicules en attente d'entrée
    public void displayQueue() {
        System.out.println("Véhicules en attente d'entrée : " + entryQueue);
    }

    // Afficher les véhicules récemment sortis
    public void displayExitStack() {
        System.out.println("Véhicules récemment sortis : " + exitStack);
    }
}
