package uk.co.jsmondswimmingpool.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Attendance {
    private Long id;

    private Long studentid;
    
    @JsonFormat(pattern="yyy-MM-dd")
    private Date recordDate;

    private Long courseid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentid() {
        return studentid;
    }

    public void setStudentid(Long studentid) {
        this.studentid = studentid;
    }

    public Date getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }

    public Long getCourseid() {
        return courseid;
    }

    public void setCourseid(Long courseid) {
        this.courseid = courseid;
    }
}