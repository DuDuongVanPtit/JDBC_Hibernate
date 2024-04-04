package org.example.logic;

import org.example.customException.PhoneNumberFormatException;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import static org.example.converter.ConvertId.convertDriverId;

public class Driver {
    private String driverCode;
    private String driverName;
    private String driverAddress;
    private String driverPhoneNumber;
    private String driverQualification;
    private Map<Route, Integer> routes = new LinkedHashMap<>();

    private int totalRound = 0;
    public Driver(String code, String driverName, String driverAddress, String driverPhoneNumber, String driverQualification) {
        this.driverCode = code;
        this.driverName = driverName;
        this.driverAddress = driverAddress;
        this.driverPhoneNumber = driverPhoneNumber;
        this.driverQualification = driverQualification;
    }
    public static Driver inputDriver(Scanner scanner){
        System.out.println("\nEnter 4 line to add a new driver.");
        String code = null;
        while (true){
            System.out.print("Driver code(Enter 5 characters): ");
            String c = scanner.nextLine();
            if(c.length() == 5){
                code = c;
                break;
            }
            else{
                System.out.println("Please enter 5 characters.");
            }
        }
        System.out.print("Driver name: ");
        String name = scanner.nextLine();
        System.out.print("Driver address: ");
        String address = scanner.nextLine();
        String phoneNumber = null;
        while (true){
            System.out.print("Driver phone number: ");
            try {
                String phoneNumberCheck = scanner.nextLine();
                phoneNumberValidate(phoneNumberCheck);
                phoneNumber = phoneNumberCheck;
                break;
            }
            catch (PhoneNumberFormatException e){
                System.out.println(e);
            }
        }
        String qualification = null;
        while(true){
            System.out.println("Qualification(Enter the number to chose qualification for driver " + name + ":\n" +
                    "\t1: A\n" +
                    "\t2: B\n" +
                    "\t3: C\n" +
                    "\t4: D\n" +
                    "\t5: E\n" +
                    "\t6: F");
            String t = scanner.nextLine();
            switch (t){
                case "1":
                    qualification = "A";
                    break;
                case "2":
                    qualification = "B";
                    break;
                case "3":
                    qualification = "C";
                    break;
                case "4":
                    qualification = "D";
                    break;
                case "5":
                    qualification = "E";
                    break;
                case "6":
                    qualification = "F";
            }
            if(t.equals("1") || t.equals("2") || t.equals("3") || t.equals("4") || t.equals("5") || t.equals("6")){
                break;
            }
            else System.out.println("Please chose the correct number.");
        }
        return new Driver(code, name, address, phoneNumber, qualification);
    }
    public static void phoneNumberValidate(String studentPhoneNumber){
        boolean check = true;
        if(studentPhoneNumber.matches("\\d+")){
            check = false;
        }
        if(studentPhoneNumber.length() < 10 || studentPhoneNumber.length() > 12 || check){
            throw new PhoneNumberFormatException("Please enter the correct phone number.");
        }
    }
    @Override
    public String toString() {
        return  "Driver code: " + driverCode +
                "\n\tName: " + driverName +
                "\n\tAddress: " + driverAddress +
                "\n\tPhone Number: " + driverPhoneNumber +
                "\n\tQualification: " + driverQualification +"\n";
    }

    public int getTotalRound() {
        return totalRound;
    }

    public void setTotalRound(int totalRound) {
        this.totalRound = totalRound;
    }

    public Map<Route, Integer> getRoutes() {
        return routes;
    }
    public void setRoutes(Route route, int round) {
        this.routes.put(route, round);
    }

    public String getDriverCode() {
        return driverCode;
    }

    public void setDriverCode(String driverCode) {
        this.driverCode = driverCode;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverAddress() {
        return driverAddress;
    }

    public void setDriverAddress(String driverAddress) {
        this.driverAddress = driverAddress;
    }

    public String getDriverPhoneNumber() {
        return driverPhoneNumber;
    }

    public void setDriverPhoneNumber(String driverPhoneNumber) {
        this.driverPhoneNumber = driverPhoneNumber;
    }

    public String getDriverQualification() {
        return driverQualification;
    }

    public void setDriverQualification(String driverQualification) {
        this.driverQualification = driverQualification;
    }
}