interface Insurance {
    void displayStatus();
}

interface Emergency {
    void displayStatus();
}

abstract class Patient {
    String name;
    String patientID;

    public Patient(String Pname, String PpatientID) {
        this.name = Pname;
        this.patientID = PpatientID;
    }

    abstract void getTreatment();

    class MedicalHistory {
        private String records = "Medical history is clear.";

        void updateHistory(String detail) {
            this.records = detail;
            System.out.println("History Updated for " + name);
        }

        void viewHistory() {
            System.out.println("Medical Records for " + patientID + " " + records);
        }
    }
}

class CriticalPatient extends Patient implements Insurance, Emergency {

    private MedicalHistory history;

    public CriticalPatient(String name, String id) {
        super(name, id);
        this.history = new MedicalHistory();
    }

    @Override
    void getTreatment() {
        System.out.println("Treatment: Commencing immediate surgery for " + name);
    }

    @Override
    public void displayStatus() {
        System.out.println("Service status for " + name);
        System.out.println("Insurance: Premium Coverage Active (ID: 9982).");
        System.out.println("Emergency: Trauma Team dispatched to Room 804.");
    }

    public MedicalHistory getHistory() {
        return history;
    }
}

public class HospitalSystem {
    public static void main(String[] args){
        CriticalPatient p1 = new CriticalPatient("Ali Butt", "A-1011");

        p1.getTreatment();
        p1.getHistory().updateHistory("Diagnosed with Dengue fever");
        p1.getHistory().viewHistory();
        p1.displayStatus();

    }
}
