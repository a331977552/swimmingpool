package uk.co.jsmondswimmingpool.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Course {
    private Long id;

    private String note;

    private String name;
    
    @JsonFormat(pattern="yyy-MM-dd")
    private Date startDate;
    
    @JsonFormat(pattern="yyy-MM-dd")
    private Date endDate;

    private String tutorname;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getTutorname() {
        return tutorname;
    }

    public void setTutorname(String tutorname) {
        this.tutorname = tutorname == null ? null : tutorname.trim();
    }
}