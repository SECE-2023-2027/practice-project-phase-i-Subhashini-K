package com.eventreport.model;

public class event {

	    private int eventId;
	    private String eventName;
	    private String eventDate;
	    private String location;

	    // Constructor
	    public event(int eventId, String eventName, String eventDate, String location) {
	        this.eventId = eventId;
	        this.eventName = eventName;
	        this.eventDate = eventDate;
	        this.location = location;
	    }

	    // Getters
	    public int getEventId() {
	        return eventId;
	    }

	    public String getEventName() {
	        return eventName;
	    }

	    public String getEventDate() {
	        return eventDate;
	    }

	    public String getLocation() {
	        return location;
	    }

	    // Setters
	    public void setEventId(int eventId) {
	        this.eventId = eventId;
	    }

	    public void setEventName(String eventName) {
	        this.eventName = eventName;
	    }

	    public void setEventDate(String eventDate) {
	        this.eventDate = eventDate;
	    }

	    public void setLocation(String location) {
	        this.location = location;
	    }

	    // ToString method to display event details
	    @Override
	    public String toString() {
	        return "Event ID: " + eventId + "\nEvent Name: " + eventName + 
	               "\nEvent Date: " + eventDate + "\nLocation: " + location;
	    }
	

}
