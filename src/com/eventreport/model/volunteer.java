package com.eventreport.model;

public class volunteer {
    private String volunteerName;
    private String role;

    public volunteer(String volunteerName, String role) {
        this.volunteerName = volunteerName;
        this.role = role;
    }

    public String getVolunteerName() {
        return volunteerName;
    }

    public String getRole() {
        return role;
    }
}
