package org.example;

public class Laptops extends Computer {
    private String screenSize;
    private String batteryLife;

    public Laptops(String manufacturer, String processor, String ram, String diskSize, String weight, String assetTag, String strDate,String screenSize,String batteryLife) {
        super(manufacturer, processor, ram, diskSize, weight, assetTag, strDate);
        this.screenSize = screenSize;
        this.batteryLife = batteryLife;
    }

    public String getBatteryLife() {
        return batteryLife;
    }

    public void setBatteryLife(String batteryLife) {
        this.batteryLife = batteryLife;
    }

    public String getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(String screenSize) {
        this.screenSize = screenSize;
    }

    @Override
    public String toString() {
        return Colours.PURPLE + "\n\nLaptops" + Colours.RESET + "{" +
                super.toString() +
                "screenSize='" + screenSize + '\'' +
                ", batteryLife='" + batteryLife + '\'' +
                '}';
    }
}
