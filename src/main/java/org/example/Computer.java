package org.example;

public class Computer {


    private String manufacturer;
    private String processor;
    private String ram;
    private String diskSize;
    private String weight;
    private String assetTag;
    private String PurchaseDate;

    public Computer(String manufacturer, String processor, String ram, String diskSize, String weight, String assetTag, String purchaseDate) {
        this.manufacturer = manufacturer;
        this.processor = processor;
        this.ram = ram;
        this.diskSize = diskSize;
        this.weight = weight;
        this.assetTag = assetTag;
        PurchaseDate = purchaseDate;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        processor = processor;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getDiskSize() {
        return diskSize;
    }

    public void setDiskSize(String diskSize) {
        this.diskSize = diskSize;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getAssetTag() {
        return assetTag;
    }

    public void setAssetTag(String assetTag) {
        this.assetTag = assetTag;
    }

    public String getPurchaseDate() {
        return PurchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        PurchaseDate = purchaseDate;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "manufacturer='" + manufacturer + '\'' +
                ", Processor='" + processor + '\'' +
                ", ram='" + ram + '\'' +
                ", diskSize='" + diskSize + '\'' +
                ", weight='" + weight + '\'' +
                ", assetTag='" + assetTag + '\'' +
                ", PurchaseDate='" + PurchaseDate + '\'' +
                '}';
    }
}