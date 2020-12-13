package org.example;

import java.time.LocalDate;
    abstract public class Computer {


    private String manufacturer;
    private String processor;
    private String ram;
    private String diskSize;
    private String weight;
    private String assetTag;
    private LocalDate PurchaseDate;

    public Computer(String manufacturer, String processor, String ram, String diskSize, String weight, String assetTag, String strDate) {
        this.manufacturer = manufacturer;
        this.processor = processor;
        this.ram = ram;
        this.diskSize = diskSize;
        this.weight = weight;
        this.assetTag = assetTag;
        this.PurchaseDate = LocalDate.parse(strDate);
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
        this.processor = processor;
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

    public LocalDate getPurchaseDate() {
        return PurchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
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