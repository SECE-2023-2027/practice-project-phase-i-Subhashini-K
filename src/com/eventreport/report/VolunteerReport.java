package com.eventreport.report;

import java.util.Map;

public class VolunteerReport extends Report {
    private Map<String, Integer> volunteerHours;

    public VolunteerReport(int eventId, Map<String, Integer> volunteerHours) {
        super(eventId);
        this.volunteerHours = volunteerHours;
    }

    @Override
    public void generateReport() {
        reportData = "Volunteer Report for Event ID: " + eventId + "\n";
        reportData += "---------------------------------\n";
        reportData += "Volunteer Name\tHours Contributed\n";

        for (Map.Entry<String, Integer> entry : volunteerHours.entrySet()) {
            reportData += entry.getKey() + "\t" + entry.getValue() + "\n";
        }
        reportData += "---------------------------------\n";
    }
}
