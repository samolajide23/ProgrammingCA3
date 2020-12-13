package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class ComputerDB {
    private ArrayList<Computer> computers;
    private static Scanner keyboard = new Scanner(System.in);

    public ComputerDB(){
        this.computers = new ArrayList<>();
    }

    public void loadDesktopComputersFromFile(){
        try (Scanner computersFile = new Scanner(new BufferedReader(new FileReader("desktopComputers.txt")))) {
            String input;
            while (computersFile.hasNextLine()) {
                input = computersFile.nextLine();
                String[] data = input.split(",");
                String manufacturer = data[0];
                String processor = data[1];
                String ram = data[2];
                String diskSize = data[3];
                String weight = data[4];
                String assetTag = data[5];
                String strDate = data[6];
                String monitor = data[7];

                Desktops readInComputer = new Desktops(manufacturer,processor,ram,diskSize,weight,assetTag,strDate,monitor);
                this.computers.add(readInComputer);
            }
        } catch (FileNotFoundException fne) {
            System.out.println(Colours.PURPLE + "Could not load desktopComputers.txt." + "If this is the first time you are running the program this is fine." + Colours.RESET);
        }
    }
    public void loadLaptopComputersFromFile() {
        try (Scanner computersFile = new Scanner(new BufferedReader(new FileReader("laptopComputers.txt")))) {
            String input;
            while (computersFile.hasNextLine()) {
                input = computersFile.nextLine();
                String[] data = input.split(",");
                String manufacturer = data[0];
                String processor = data[1];
                String ram = data[2];
                String diskSize = data[3];
                String weight = data[4];
                String assetTag = data[5];
                String strDate = data[6];
                String ScreenSize = data[7];
                String batteryLife = data[8];
                Laptops readInComputer = new Laptops(manufacturer,processor,ram,diskSize,weight,assetTag,strDate,ScreenSize,batteryLife);
                this.computers.add(readInComputer);
            }
        } catch (FileNotFoundException fne) {
            System.out.println(Colours.PURPLE + "Could not load LaptopComputers.txt." + "If this is the first time you are running the program this is fine." + Colours.RESET);
        }

    }
    public void loadRaspberryPiComputersFromFile() {

        try (Scanner computersFile = new Scanner(new BufferedReader(new FileReader("raspberryPiComputers.txt")))) {
            String input;
            while (computersFile.hasNextLine()) {
                input = computersFile.nextLine();
                String[] data = input.split(",");
                String manufacturer = data[0];
                String processor = data[1];
                String ram = data[2];
                String sdCard = data[3];
                String weight = data[4];
                String assetTag = data[5];
                String strDate = data[6];
                String gpioPins = data[7];

                RaspberryPi readInComputer = new RaspberryPi(manufacturer,processor,ram,sdCard,weight,assetTag,strDate,gpioPins);
                this.computers.add(readInComputer);
            }
        } catch (FileNotFoundException fne) {
            System.out.println(Colours.PURPLE + "Could not load desktopComputers.txt." + "If this is the first time you are running the program this is fine." + Colours.RESET);
        }
    }

    public void printComputer(){

        System.out.println("Enter ID of Student:");
        System.out.println(filterComputer(keyboard.nextLine()));
    }

    public void printAllComputers(){
        System.out.println(computers);
    }

    private Computer filterComputer(String id){
        for(Computer computer : computers)
        {
            if(computer.getAssetTag().equals(id))
            {
                return computer;
            }
        }
        return null;
    }

}
