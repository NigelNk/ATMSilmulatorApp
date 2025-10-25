package com.example.fdhbankatmsimulator.backend;

import java.io.Serializable;
import java.time.LocalDate;

public class StageOneData implements Serializable {

    private String name;
    private String fatherName;
    private String email;
    private String address;
    private String city;
    private String pin;
    private String state;
    private LocalDate dob;
    private String gender;
    private String maritalStatus;

    // Constructor
    public StageOneData(String name, String fatherName, String email, String address,
                        String city, String pin, String state, LocalDate dob,
                        String gender, String maritalStatus) {
        this.name = name;
        this.fatherName = fatherName;
        this.email = email;
        this.address = address;
        this.city = city;
        this.pin = pin;
        this.state = state;
        this.dob = dob;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getFatherName() { return fatherName; }
    public void setFatherName(String fatherName) { this.fatherName = fatherName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getPin() { return pin; }
    public void setPin(String pin) { this.pin = pin; }

    public String getState() { return state; }
    public void setState(String state) { this.state = state; }

    public LocalDate getDob() { return dob; }
    public void setDob(LocalDate dob) { this.dob = dob; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getMaritalStatus() { return maritalStatus; }
    public void setMaritalStatus(String maritalStatus) { this.maritalStatus = maritalStatus; }

}
