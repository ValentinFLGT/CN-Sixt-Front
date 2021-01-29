package com.sixt.sixtfront.model;

import java.util.Date;

public class Client {

    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private Integer licenseNumber;
    private Date licenseAcquisitionDate;

    public Client() {
    }

    public Client(String firstName, String lastName, Date dateOfBirth, Integer licenseNumber, Date licenseAcquisitionDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.licenseNumber = licenseNumber;
        this.licenseAcquisitionDate = licenseAcquisitionDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(Integer licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public Date getLicenseAcquisitionDate() {
        return licenseAcquisitionDate;
    }

    public void setLicenseAcquisitionDate(Date licenseAcquisitionDate) {
        this.licenseAcquisitionDate = licenseAcquisitionDate;
    }
}
