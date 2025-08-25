class SmartDeviceControlInterface {
    public static void main(String[] args) {
        SmartDevice diningRoomLight = new Light("Dining Room");
        SmartDevice bedRoomAc = new AC("Bedroom");
        SmartDevice samsungTv = new TV("Samsung", "110\" Class MICRO LED TV");
        SmartDevice lgTv = new TV("LG", "OLED Evo AI");

//        diningRoomLight.turnOn();
        bedRoomAc.turnOn();
        samsungTv.turnOn();
        lgTv.turnOn();

        bedRoomAc.turnOff();

        DeviceAction turnOnAction = diningRoomLight::turnOn;
        DeviceAction turnOffAction = () -> samsungTv.turnOff();

        turnOnAction.execute();
        turnOffAction.execute();
    }
}