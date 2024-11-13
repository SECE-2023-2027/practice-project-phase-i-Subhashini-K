package com.eventreport.model;

public class feedback {
    private String participantName;
    private int contentQualityRating;
    private int speakerQualityRating;
    private int overallExperienceRating;
    private String comments;

    public feedback(String participantName, int contentQualityRating, int speakerQualityRating, int overallExperienceRating, String comments) {
        this.participantName = participantName;
        this.contentQualityRating = contentQualityRating;
        this.speakerQualityRating = speakerQualityRating;
        this.overallExperienceRating = overallExperienceRating;
        this.comments = comments;
    }

    public String getParticipantName() {
        return participantName;
    }

    public int getContentQualityRating() {
        return contentQualityRating;
    }

    public int getSpeakerQualityRating() {
        return speakerQualityRating;
    }

    public int getOverallExperienceRating() {
        return overallExperienceRating;
    }

    public String getComments() {
        return comments;
    }
}
