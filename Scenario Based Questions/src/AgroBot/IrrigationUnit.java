package AgroBot;

import java.text.DecimalFormat;

public abstract class IrrigationUnit {
    String unitId;
    private final double calibrationValue;

    IrrigationUnit(String unitId) {
        this.unitId = unitId;
        this.calibrationValue = calibrate();
        System.out.println("\nIrrigation unit " + unitId + " initialized\n");
    }

    private double calibrate() {
        double cValue = Double.parseDouble(new DecimalFormat("#.0").format(Math.random() * 100));
        System.out.println("\nCalibrating " + unitId);
        return cValue;
    }

    public void runDiagnostics() {
        System.out.println("Running Diagnostics on " + unitId + "\nCalibration : " + calibrationValue + "\n");
    }

    public abstract void startWatering();

}
