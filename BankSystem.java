interface FraudChecker {
    void verify();
}

interface Auditor {
    void generateReport();
}

public class BankSystem {
    public static void main(String[] args) {
        FraudChecker tempScanner = new FraudChecker() {
            @Override
            public void verify() {
                System.out.println("Checking for fraud activity...CLEARED!");
            }
        };

        Auditor oneTimeAuditor = new Auditor() {
            @Override
            public void generateReport() {
                System.out.println("Auditor Report: Integrity check complete.");
            }
        };

        tempScanner.verify();
        oneTimeAuditor.generateReport();
    }
}