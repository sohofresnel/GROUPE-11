package gestionnaire_parking;

import java.time.LocalDateTime;

public class Vehicle {
    private String plateNumber;
    private LocalDateTime entryTime;

    public Vehicle(String plateNumber, LocalDateTime entryTime) {
        this.plateNumber = plateNumber;
        this.entryTime = entryTime;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }
}
