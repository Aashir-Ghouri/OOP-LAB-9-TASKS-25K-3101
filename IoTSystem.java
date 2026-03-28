interface IoTDevice {
    default void update() {
        System.out.println("Update successful.");
    }

    static void info() {
        System.out.println("IoT Standard v2.1: This device supports WiFi and Bluetooth.");
    }
}

class SmartBulb implements IoTDevice {
    String model = "Phillips Smart Bulb";

    void operate() {
        System.out.println(model + " is now turned on.");
    }
}

public class IoTSystem {
    public static void main(String[] args) {

        IoTDevice.info();

        SmartBulb b1 = new SmartBulb();
        b1.update();
        b1.operate();
    }
}