package com.miit.hibernateTraining;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
 
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
 
@Entity
@Table(name="MEETING")
public class Meeting {
 
    @Id
    @Column(name="MEETING_ID")
    @GeneratedValue
    private Long meetingId;
 
    	@Column(name="SUBJECT")
    private String subject;
     
    @Column(name="MEETING_DATE")
    private Date meetingDate;
     
    @ManyToMany(mappedBy="meetings")
    /*@ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="STUDENT_MEETING",
                joinColumns={@JoinColumn(name="MEETING_ID")},
                inverseJoinColumns={@JoinColumn(name="STUDENT_ID")})
    */private Set<Student> students = new HashSet<Student>();
     
    public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public Meeting(String subject) {
        this.subject = subject;
        this.meetingDate = new Date();
    }
     
    // Getter and Setter methods
    public Long getMeetingId() {
		return meetingId;
	}

	public void setMeetingId(Long meetingId) {
		this.meetingId = meetingId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Date getMeetingDate() {
		return meetingDate;
	}

	public void setMeetingDate(Date meetingDate) {
		this.meetingDate = meetingDate;
	}


}
