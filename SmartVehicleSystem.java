interface ElectricSystem {
    void displayStatus();
}

interface GPSSystem {
    void displayStatus();
}

abstract class Vehicle {
    String model;

    public Vehicle(String Pmodel) {
        this.model = Pmodel;
    }

    abstract void startEngine();

    class Engine {
        void initializeInternalComponents() {
            System.out.println("Engine initialized for : " + model);
        }
    }
}

class SmartCar extends Vehicle implements ElectricSystem, GPSSystem {

    Engine engine;

    public SmartCar(String modelName) {
        super(modelName);
        this.engine = new Engine();
    }

    @Override
    void startEngine() {
        engine.initializeInternalComponents();
        System.out.println(model + " started via Remote App Signal.");
    }

    @Override
    public void displayStatus() {
        System.out.println("System status report for " + model);
        System.out.println("Electric System: Battery at 85%, Energy Mode: Eco.");
        System.out.println("GPS System: Signal Strong, Currently in Karachi.");
    }
}

public class SmartVehicleSystem {
    public static void main(String[] args) {
        SmartCar myCar = new SmartCar("Deepal S05");

        myCar.startEngine();
        myCar.displayStatus();
    }
}