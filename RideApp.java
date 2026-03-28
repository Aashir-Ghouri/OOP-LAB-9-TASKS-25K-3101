interface GPSTracking {
    void trackLocation();
}

interface PaymentSystem {
    void processPayment(double amount);
}

class Ride implements GPSTracking, PaymentSystem {
    private String rideID;

    public Ride(String rideID) {
        this.rideID = rideID;
    }

    @Override
    public void trackLocation() {
        System.out.println("Fetching GPS coordinates for the ride : " + rideID);
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Amount for ride #" + rideID + " : " + amount);
    }

    static class CompanyRules {
        static final int BASE_FARE = 200;
        static final String SAFETY_POLICY = "Always wear a seatbelt.";

        static void displayRules() {
            System.out.println("--- Company Policies ---");
            System.out.println("Standard Base Fare: " + BASE_FARE);
            System.out.println("Safety First: " + SAFETY_POLICY);
        }
    }
}

public class RideApp {
    public static void main(String[] args) {
        Ride.CompanyRules.displayRules();

        Ride currentRide = new Ride("RIDE-804");

        currentRide.trackLocation();
        currentRide.processPayment(500.0);
    }
}