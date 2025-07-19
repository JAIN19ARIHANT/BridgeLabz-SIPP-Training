package AgroBot;

public class DripSystem extends IrrigationUnit {
    double flowRate;

    public DripSystem(String unitId, double flowRate) {
        super(unitId);
        this.flowRate = flowRate;
        System.out.println("Drip system " + unitId + " configured with a flow rate of " + flowRate + " lt/hr\n");
    }

    @Override
    public void startWatering() {
        System.out.println("Drip system : " + unitId + " starts watering with flow rate : " + flowRate + " lt/hr\n");
    }
}
