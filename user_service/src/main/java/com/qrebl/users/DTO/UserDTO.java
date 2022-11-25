package com.qrebl.users.DTO;


public class UserDTO {
    private String userName;
    private String emailId;
    private String password;
    private String firstname;
    private String lastName;

    public UserDTO(String userName, String emailId, String password, String firstname, String lastName) {
        this.userName = userName;
        this.emailId = emailId;
        this.password = password;
        this.firstname = firstname;
        this.lastName = lastName;
    }

    public UserDTO() {
    }

    public String getUserName() {
        return userName;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
