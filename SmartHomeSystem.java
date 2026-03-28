interface VoiceControl {
    void executeCommand(String command);
}

interface RemoteControl {
    void executeCommand(String command);
}

abstract class Appliance {
    String deviceName;

    public Appliance(String name) {
        this.deviceName = name;
    }

    abstract void turnOn();

    class Settings {
        private int brightness = 50;
        private String wifiPassword = "mujhe nahi pata";

        void adjustBrightness(int Plevel) {
            this.brightness = Plevel;
            System.out.println(deviceName + " brightness set to: " + brightness + "%");
        }

        void showConfig() {
            System.out.println("---Settings for " + deviceName + "---");
            System.out.println("Brightness : " + brightness);
            System.out.println("WiFi password : " + wifiPassword);
        }
    }
}

class SmartLight extends Appliance implements VoiceControl, RemoteControl {

    private Settings deviceSettings;

    public SmartLight(String name) {
        super(name);
        this.deviceSettings = new Settings();
    }

    @Override
    void turnOn() {
        System.out.println(deviceName + " turned on.");
    }

    @Override
    public void executeCommand(String command) {
        System.out.println(deviceName + " control request received : " + command);
        if (command.equalsIgnoreCase("Brighten")) {
            deviceSettings.adjustBrightness(100);
        }
    }

    public Settings getSettings() {
        return deviceSettings;
    }
}

public class SmartHomeSystem {
    public static void main(String[] args) {
        SmartLight bedroom = new SmartLight("BedRoom light");

        bedroom.turnOn();
        bedroom.executeCommand("Brighten");
        bedroom.getSettings().showConfig();
    }
}
