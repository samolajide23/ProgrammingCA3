package org.example;

public class Desktops extends Computer{
    private String monitor;

    public Desktops(String manufacturer, String processor, String ram, String diskSize, String weight, String assetTag, String strDate,String monitor) {
        super(manufacturer, processor, ram, diskSize, weight, assetTag, strDate);
        this.monitor = monitor;
    }

    public String getMonitor() {
        return monitor;
    }

    public void setMonitor(String monitor) {
        this.monitor = monitor;
    }

    @Override
    public String toString() {
        return  Colours.PURPLE + "\nDesktops" + Colours.RESET + "{" +
                super.toString() +
                "monitor='" + monitor + '\'' +
                '}';
    }
}
