package org.example;

    public class RaspberryPi extends Computer {
    private String gpioPins;
    private String sdCard;

    public RaspberryPi(String manufacturer, String processor, String ram, String diskSize, String weight, String assetTag, String strDate,String gpioPins) {
        super(manufacturer, processor, ram, diskSize, weight, assetTag, strDate);
        this.gpioPins = gpioPins;
    }

    public String getGpioPins() {
        return gpioPins;
    }

    public void setGpioPins(String gpioPins) {
        this.gpioPins = gpioPins;
    }

    public String getSdCard() {
        return sdCard;
    }

    public void setSdCard(String sdCard) {
        this.sdCard = sdCard;
    }

    @Override
    public String toString() {
        return Colours.PURPLE + "\n\nRasberry Pi" + Colours.RESET + "{" +
                super.toString() +
                "GPIO Pins='" + gpioPins + '\'' +
                "SDCard='" + sdCard + '\'' +
                '}';
    }
}
