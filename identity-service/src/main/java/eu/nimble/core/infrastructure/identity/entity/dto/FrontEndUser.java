package eu.nimble.core.infrastructure.identity.entity.dto;

import eu.nimble.core.infrastructure.identity.config.NimbleConfigurationProperties;
import org.joda.time.LocalDate;

import java.util.Map;

public class FrontEndUser {
    private String username = null;

    private String firstname = null;

    private String lastname = null;

    private String email = null;

    private LocalDate dateOfBirth = null;

    private String placeOBirth = null;

    private String phoneNumber = null;

    private Long userID = null;

    private String companyID = null;

    private Map<NimbleConfigurationProperties.LanguageID, String> companyName = null;

    private String accessToken = null;

    private String rocketChatToken = null;

    private String rocketChatUsername = null;

    private String rocketChatUserID = null;

    private Boolean showWelcomeInfo = false;

    private String vat = null;

    public Map<NimbleConfigurationProperties.LanguageID, String> getCompanyName() {
        return companyName;
    }

    public void setCompanyName(Map<NimbleConfigurationProperties.LanguageID, String> companyName) {
        this.companyName = companyName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPlaceOBirth() {
        return placeOBirth;
    }

    public void setPlaceOBirth(String placeOBirth) {
        this.placeOBirth = placeOBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getCompanyID() {
        return companyID;
    }

    public void setCompanyID(String companyID) {
        this.companyID = companyID;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Boolean getShowWelcomeInfo() {
        return showWelcomeInfo;
    }

    public void setShowWelcomeInfo(Boolean showWelcomeInfo) {
        this.showWelcomeInfo = showWelcomeInfo;
    }

    public String getRocketChatToken() {
        return rocketChatToken;
    }

    public void setRocketChatToken(String rocketChatToken) {
        this.rocketChatToken = rocketChatToken;
    }

    public String getRocketChatUsername() {
        return rocketChatUsername;
    }

    public void setRocketChatUsername(String rocketChatUsername) {
        this.rocketChatUsername = rocketChatUsername;
    }

    public String getRocketChatUserID() {
        return rocketChatUserID;
    }

    public void setRocketChatUserID(String rocketChatUserID) {
        this.rocketChatUserID = rocketChatUserID;
    }

    public String getVat() {
        return vat;
    }

    public void setVat(String vat) {
        this.vat = vat;
    }

    @Override
    public String toString() {
        return "FrontEndUser{" +
                "username='" + username + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", placeOBirth='" + placeOBirth + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", userID=" + userID +
                ", companyID='" + companyID + '\'' +
                ", companyName='" + companyName + '\'' +
                ", showWelcomeInfo=" + showWelcomeInfo +
                ", vat='" + vat + '\'' +
                '}';
    }
}
