package com.eventreport.main;

import com.eventreport.model.attendance;
import com.eventreport.model.feedback;
import com.eventreport.model.volunteer;
//import com.eventreport.report.AttendanceReport;
//import com.eventreport.report.FeedbackReport;
//import com.eventreport.report.VolunteerReport;

//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Sample data collection for Attendance
       /* System.out.print("Enter Event ID: ");
        int eventId = scanner.nextInt();
        scanner.nextLine(); // consume newline*/

        System.out.println("Enter Attendance details (type 'done' to finish):");
        List<attendance> attendanceList = new ArrayList<>();
        while (true) {
            System.out.print("Attendee Name: ");
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("done")) break;

            System.out.print("Is Present (true/false): ");
            boolean isPresent = scanner.nextBoolean();
            scanner.nextLine(); // consume newline

            attendanceList.add(new attendance(name, isPresent));
        }

        // Create and generate Attendance Report
       /* AttendanceReport attendanceReport = new AttendanceReport(eventId, attendanceList);
        attendanceReport.generateReport();
        saveReportToFile("AttendanceReport.txt", attendanceReport.getReportData());*/

        // Sample data collection for Feedback
        System.out.println("\nEnter Feedback details (type 'done' to finish):");
        List<feedback> feedbackList = new ArrayList<>();
        while (true) {
            System.out.print("Participant Name: ");
            String participantName = scanner.nextLine();
            if (participantName.equalsIgnoreCase("done")) break;

            System.out.print("Content Quality Rating (1-5): ");
            int contentRating = scanner.nextInt();

            System.out.print("Speaker Quality Rating (1-5): ");
            int speakerRating = scanner.nextInt();

            System.out.print("Overall Experience Rating (1-5): ");
            int overallRating = scanner.nextInt();
            scanner.nextLine(); // consume newline

            System.out.print("Comments: ");
            String comments = scanner.nextLine();

            feedbackList.add(new feedback(participantName, contentRating, speakerRating, overallRating, comments));
        }

        // Create and generate Feedback Report
      /*  FeedbackReport feedbackReport = new FeedbackReport(eventId, feedbackList);
        feedbackReport.generateReport();
        saveReportToFile("FeedbackReport.txt", feedbackReport.getReportData());*/

        // Sample data collection for Volunteer participation
        System.out.println("\nEnter Volunteer details (type 'done' to finish):");
        List<volunteer> volunteerList = new ArrayList<>();
        while (true) {
            System.out.print("Volunteer Name: ");
            String volunteerName = scanner.nextLine();
            if (volunteerName.equalsIgnoreCase("done")) break;

            System.out.print("Role in Event: ");
            String role = scanner.nextLine();

            volunteerList.add(new volunteer(volunteerName, role));
        }

        // Create and generate Volunteer Report
       /* VolunteerReport volunteerReport = new VolunteerReport(eventId, volunteerList);
        volunteerReport.generateReport();
        saveReportToFile("VolunteerReport.txt", volunteerReport.getReportData());*/

        System.out.println("\nReports generated and saved successfully!");

        scanner.close();
    }

    // Method to save report data to a file
  /*  private static void saveReportToFile(String fileName, String reportData) {
        try (FileWriter writer = new FileWriter(new File(fileName))) {
            writer.write(reportData);
            System.out.println("Saved " + fileName + " successfully.");
        } catch (IOException e) {
            System.err.println("Error saving report to file: " + e.getMessage());
        }
    }*/
}
