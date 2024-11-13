package com.eventreport.report;

import java.util.List;
import com.eventreport.model.feedback;

public class FeedbackReport extends Report {
   private List<feedback> feedbackList;

   public FeedbackReport(int eventId, List<feedback> feedbackList) {
       super(eventId);
       this.feedbackList = feedbackList;
   }

   @Override
   public void generateReport() {
       reportData = "Feedback Report for Event ID: " + eventId + "\n";
       reportData += "---------------------------------\n";

       for (feedback feedback : feedbackList) {
           reportData += "Participant: " + feedback.getParticipantName() + "\n";
           reportData += "Content Quality Rating: " + feedback.getContentQualityRating() + "\n";
           reportData += "Speaker Quality Rating: " + feedback.getSpeakerQualityRating() + "\n";
           reportData += "Overall Experience Rating: " + feedback.getOverallExperienceRating() + "\n";
           reportData += "Comments: " + feedback.getComments() + "\n";
           reportData += "---------------------------------\n";
       }
   }
}

