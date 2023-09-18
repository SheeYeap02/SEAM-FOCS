package com.seam.focs.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class ProfileInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId
    private Long profileInfoId;

    private String fullName;
    private String mykadNo;
    private String nationality;
    private LocalDateTime dateOfBirth;
    private char gender;
    private String maritalStatus;
    private String race;
    private String religion;
    private String address;
    private String postcode;
    private String state;
    private String country;
    private String homeTelNo;
    private String mobileNo;
    private Long applicantId;

    // Constructors, getters, and setters


    public ProfileInfo() {
    }

    public ProfileInfo(Long profileInfoId, String fullName, String mykadNo, String nationality, LocalDateTime dateOfBirth, char gender, String maritalStatus, String race, String religion, String address, String postcode, String state, String country, String homeTelNo, String mobileNo, Long applicantId) {
        this.profileInfoId = profileInfoId;
        this.fullName = fullName;
        this.mykadNo = mykadNo;
        this.nationality = nationality;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
        this.race = race;
        this.religion = religion;
        this.address = address;
        this.postcode = postcode;
        this.state = state;
        this.country = country;
        this.homeTelNo = homeTelNo;
        this.mobileNo = mobileNo;
        this.applicantId = applicantId;
    }

    public Long getProfileInfoId() {
        return profileInfoId;
    }

    public void setProfileInfoId(Long profileInfoId) {
        this.profileInfoId = profileInfoId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMykadNo() {
        return mykadNo;
    }

    public void setMykadNo(String mykadNo) {
        this.mykadNo = mykadNo;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public LocalDateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHomeTelNo() {
        return homeTelNo;
    }

    public void setHomeTelNo(String homeTelNo) {
        this.homeTelNo = homeTelNo;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public Long getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(Long applicantId) {
        this.applicantId = applicantId;
    }
}


