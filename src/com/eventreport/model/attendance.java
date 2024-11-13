package com.eventreport.model;

public class attendance {
    private String attendeeName;
    private boolean isPresent;

    public attendance(String attendeeName, boolean isPresent) {
        this.attendeeName = attendeeName;
        this.isPresent = isPresent;
    }

    public String getAttendeeName() {
        return attendeeName;
    }

    public boolean isPresent() {
        return isPresent;
    }
}
