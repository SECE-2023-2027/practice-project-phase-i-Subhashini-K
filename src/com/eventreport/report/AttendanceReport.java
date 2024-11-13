package com.eventreport.report;


public class AttendanceReport extends Report {
    private int totalAttendees;
    private int present;
    private int absent;

    public AttendanceReport(int eventId, int totalAttendees, int present, int absent) {
        super(eventId);
        this.totalAttendees = totalAttendees;
        this.present = present;
        this.absent = absent;
    }

    @Override
    public void generateReport() {
        reportData = "Attendance Report for Event ID: " + eventId + "\n";
        reportData += "Total Attendees: " + totalAttendees + "\n";
        reportData += "Present: " + present + "\n";
        reportData += "Absent: " + absent + "\n";
    }
}

