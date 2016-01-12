package fr.ichida.example.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * This class represents a conference. It's described by a speaker and a subject.
 * Additionally, a mark can be set representing the average mark of the conference.
 *
 * @author shoun
 * @since 10/12/2015
 */
public class Conference {
    /**
     * Identifier of the conference
     */
    private Integer id;

    /**
     * The speaker of the conference
     */
    private String speaker;
    /**
     * The subject of the conference
     */
    private String subject;
    /**
     * The average mark of the conference
     */
    private Double mark;

    /**
     * The all marks of the conference
     */
    private List<Double> markHistory = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSpeaker() {
        return speaker;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Double getMark() {
        return mark;
    }

    public void setMark(Double mark) {
        this.mark = mark;
    }

    public void addMark(double mark) {
        if (null == markHistory) {
            markHistory = new ArrayList<>();
        }
        markHistory.add(mark);
        setMark(markHistory.stream().mapToDouble(a -> a).average().getAsDouble());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conference that = (Conference) o;
        return Objects.equals(speaker, that.speaker) &&
                Objects.equals(subject, that.subject) &&
                Objects.equals(mark, that.mark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(speaker, subject, mark);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Conference{");
        sb.append("id=").append(id);
        sb.append(", speaker='").append(speaker).append('\'');
        sb.append(", subject='").append(subject).append('\'');
        sb.append(", mark=").append(mark);
        sb.append('}');
        return sb.toString();
    }
}
