package com.sixt.sixtfront.model;

import java.util.Date;

public class RegisterForm {

    private String firstName;
    private String lastname;
    private Date dateOfBirth;
    private int licenseNumber;
    private Date licenseAcquisitionDate;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(int licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public Date getLicenseAcquisitionDate() {
        return licenseAcquisitionDate;
    }

    public void setLicenseAcquisitionDate(Date licenseAcquisitionDate) {
        this.licenseAcquisitionDate = licenseAcquisitionDate;
    }
}
