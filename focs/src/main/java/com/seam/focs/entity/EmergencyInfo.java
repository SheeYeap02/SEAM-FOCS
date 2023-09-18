package com.seam.focs.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

@Data
public class EmergencyInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId
    private Long emergencyInfoId;

    private String fullName;
    private String relationship;
    private String address;
    private String postcode;
    private String state;
    private String country;
    private String contactNo;
    private String email;
    private Long profileInfoId;

    public EmergencyInfo() {

    }
    public EmergencyInfo(Long emergencyInfoId, String fullName, String relationship, String address, String postcode, String state, String country, String contactNo, String email, Long profileInfoId) {
        this.emergencyInfoId = emergencyInfoId;
        this.fullName = fullName;
        this.relationship = relationship;
        this.address = address;
        this.postcode = postcode;
        this.state = state;
        this.country = country;
        this.contactNo = contactNo;
        this.email = email;
        this.profileInfoId = profileInfoId;
    }

    public Long getEmergencyInfoId() {
        return emergencyInfoId;
    }

    public void setEmergencyInfoId(Long emergencyInfoId) {
        this.emergencyInfoId = emergencyInfoId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
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

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getProfileInfoId() {
        return profileInfoId;
    }

    public void setProfileInfoId(Long profileInfoId) {
        this.profileInfoId = profileInfoId;
    }
}
