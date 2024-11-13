import java.sql.*;
import java.util.Scanner;

public class ReportFetcher {

    private static final String URL = "jdbc:mysql://localhost:3306/eventreport_db"; 
    private static final String USERNAME = "root"; 
    private static final String PASSWORD = "Subha04@sece"; 
    
    // Method to insert event details
    public static void insertEvent(Connection conn) throws SQLException {
        String query = "INSERT INTO Event (event_name, event_date, location) VALUES (?, ?, ?)";
        Scanner sc = new Scanner(System.in);  // Scanner instance for this method
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            System.out.println("Enter Event Name: ");
            String eventName = sc.nextLine();
            System.out.println("Enter Event Date (YYYY-MM-DD): ");
            String eventDate = sc.nextLine();
            System.out.println("Enter Event Location: ");
            String location = sc.nextLine();

            stmt.setString(1, eventName);
            stmt.setString(2, eventDate);
            stmt.setString(3, location);

            int rowsInserted = stmt.executeUpdate();
            System.out.println(rowsInserted + " event(s) inserted.");
        } finally {
            sc.close();  // Close Scanner
        }
    }

    // Method to fetch event details
    public static void fetchEvents(Connection conn) throws SQLException {
        String query = "SELECT * FROM Event";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            System.out.println("Event Details:");
            while (rs.next()) {
                int eventId = rs.getInt("event_id");
                String eventName = rs.getString("event_name");
                String eventDate = rs.getString("event_date");
                String location = rs.getString("location");
                System.out.println("Event ID: " + eventId + ", Name: " + eventName + ", Date: " + eventDate + ", Location: " + location);
            }
        }
    }

    // Method to insert volunteer details
    public static void insertVolunteer(Connection conn) throws SQLException {
        String query = "INSERT INTO Volunteer (name, email) VALUES (?, ?)";
        Scanner sc = new Scanner(System.in);  // Scanner instance for this method
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            System.out.println("Enter Volunteer Name: ");
            String name = sc.nextLine();
            System.out.println("Enter Volunteer Email: ");
            String email = sc.nextLine();

            stmt.setString(1, name);
            stmt.setString(2, email);

            int rowsInserted = stmt.executeUpdate();
            System.out.println(rowsInserted + " volunteer(s) inserted.");
        } finally {
            sc.close();  // Close Scanner
        }
    }

    // Method to insert attendance details
    public static void insertAttendance(Connection conn) throws SQLException {
        String query = "INSERT INTO Attendance (event_id, volunteer_id, attended) VALUES (?, ?, ?)";
        Scanner sc = new Scanner(System.in);  // Scanner instance for this method
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            System.out.println("Enter Event ID: ");
            int eventId = sc.nextInt();
            System.out.println("Enter Volunteer ID: ");
            int volunteerId = sc.nextInt();
            System.out.println("Did the volunteer attend? (true/false): ");
            boolean attended = sc.nextBoolean();

            stmt.setInt(1, eventId);
            stmt.setInt(2, volunteerId);
            stmt.setBoolean(3, attended);

            int rowsInserted = stmt.executeUpdate();
            System.out.println(rowsInserted + " attendance record(s) inserted.");
        } finally {
            sc.close();  // Close Scanner
        }
    }

    // Method to insert feedback details
    public static void insertFeedback(Connection conn) throws SQLException {
        String query = "INSERT INTO Feedback (event_id, participant_name, content_quality_rating, speaker_quality_rating, overall_experience_rating, comments) VALUES (?, ?, ?, ?, ?, ?)";
        Scanner sc = new Scanner(System.in);  // Scanner instance for this method
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            System.out.println("Enter Event ID: ");
            int eventId = sc.nextInt();
            sc.nextLine();  // Consume newline character
            System.out.println("Enter Participant Name: ");
            String participantName = sc.nextLine();
            System.out.println("Enter Content Quality Rating (1-5): ");
            double contentRating = sc.nextDouble();
            System.out.println("Enter Speaker Quality Rating (1-5): ");
            double speakerRating = sc.nextDouble();
            System.out.println("Enter Overall Experience Rating (1-5): ");
            double overallRating = sc.nextDouble();
            sc.nextLine();  // Consume newline character
            System.out.println("Enter Comments: ");
            String comments = sc.nextLine();

            stmt.setInt(1, eventId);
            stmt.setString(2, participantName);
            stmt.setDouble(3, contentRating);
            stmt.setDouble(4, speakerRating);
            stmt.setDouble(5, overallRating);
            stmt.setString(6, comments);

            int rowsInserted = stmt.executeUpdate();
            System.out.println(rowsInserted + " feedback record(s) inserted.");
        } finally {
            sc.close();  // Close Scanner
        }
    }

    // Method to fetch feedback details
    public static void fetchFeedback(Connection conn) throws SQLException {
        String query = "SELECT * FROM Feedback";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            System.out.println("Feedback Details:");
            while (rs.next()) {
                int feedbackId = rs.getInt("feedback_id");
                int eventId = rs.getInt("event_id");
                String participantName = rs.getString("participant_name");
                double contentRating = rs.getDouble("content_quality_rating");
                double speakerRating = rs.getDouble("speaker_quality_rating");
                double overallRating = rs.getDouble("overall_experience_rating");
                String comments = rs.getString("comments");
                System.out.println("Feedback ID: " + feedbackId + ", Event ID: " + eventId + ", Participant: " + participantName + ", Content Rating: " + contentRating + ", Speaker Rating: " + speakerRating + ", Overall Rating: " + overallRating + ", Comments: " + comments);
            }
        }
    }

    // Method to generate a report
    public static void generateReport(Connection conn) throws SQLException {
        String query = "INSERT INTO Report (event_id, report_type, report_data) VALUES (?, ?, ?)";
        Scanner sc = new Scanner(System.in);  // Scanner instance for this method
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            System.out.println("Enter Event ID: ");
            int eventId = sc.nextInt();
            sc.nextLine();  // Consume newline character
            System.out.println("Enter Report Type: ");
            String reportType = sc.nextLine();
            System.out.println("Enter Report Data: ");
            String reportData = sc.nextLine();

            stmt.setInt(1, eventId);
            stmt.setString(2, reportType);
            stmt.setString(3, reportData);

            int rowsInserted = stmt.executeUpdate();
            System.out.println(rowsInserted + " report(s) generated.");
        } finally {
            sc.close();  // Close Scanner
        }
    }

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            System.out.println("Connection successful!");

            Scanner sc = new Scanner(System.in);  // Main Scanner
            boolean running = true;

            while (running) {
                System.out.println("\nSelect an action: ");
                System.out.println("1. Insert Event");
                System.out.println("2. Fetch Events");
                System.out.println("3. Insert Volunteer");
                System.out.println("4. Insert Attendance");
                System.out.println("5. Insert Feedback");
                System.out.println("6. Fetch Feedback");
                System.out.println("7. Generate Report");
                System.out.println("8. Exit");

                int choice = sc.nextInt();

                switch (choice) {
                    case 1: insertEvent(conn); break;
                    case 2: fetchEvents(conn); break;
                    case 3: insertVolunteer(conn); break;
                    case 4: insertAttendance(conn); break;
                    case 5: insertFeedback(conn); break;
                    case 6: fetchFeedback(conn); break;
                    case 7: generateReport(conn); break;
                    case 8: 
                        System.out.println("Exiting..."); 
                        running = false; 
                        break;
                    default: System.out.println("Invalid choice! Please try again.");
                }
            }

            // Close the main scanner object after its usage
            sc.close();

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } 
    }
}
