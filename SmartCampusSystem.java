interface Wifi {
    void connect();
}

interface Bluetooth {
    void connect();
}

class Device implements Wifi, Bluetooth{
    @Override
    public void connect(){
        System.out.println("Device connecting via Wifi & Bluetooth.");
    }
}

class FAST{
    String campus = "FAST-NUCES";

    class Department{
        String dept;

        Department(String name){
            this.dept = name;
        }

        void displayInfo(){
            System.out.println("Department : " + dept + " at Campus : " + campus);
        }
    }
}

public class SmartCampusSystem {
    public static void main(String[] args){
        FAST uni = new FAST();
        FAST.Department se = uni.new Department("Software Engineering");
        se.displayInfo();

        Device laptop = new Device();
        laptop.connect();
    }
}
