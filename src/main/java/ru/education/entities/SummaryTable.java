package ru.education.entities;

public class SummaryTable implements BaseEntity{
    private long id;
    private long studentId;
    private long assessmentId;
    private long topicId;
    private String value;

    public SummaryTable() {
    }

    public SummaryTable(long id, long studentId, long assessmentId, long topicId, String value) {
        this.id = id;
        this.studentId = studentId;
        this.assessmentId = assessmentId;
        this.topicId = topicId;
        this.value = value;
    }

    public SummaryTable(long studentId, long assessmentId, long topicId, String value) {
        this.studentId = studentId;
        this.assessmentId = assessmentId;
        this.topicId = topicId;
        this.value = value;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public long getAssessmentId() {
        return assessmentId;
    }

    public void setAssessmentId(long assessmentId) {
        this.assessmentId = assessmentId;
    }

    public long getTopicId() {
        return topicId;
    }

    public void setTopicId(long topicId) {
        this.topicId = topicId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "SummaryTable{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", assessmentId=" + assessmentId +
                ", topicId=" + topicId +
                ", value='" + value + '\'' +
                '}';
    }
}
