package uk.co.jsmondswimmingpool.entity;

public class CourseChoosing {
    private Long id;

    private Long tutorid;

    private Long studentid;

    private Long courseid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTutorid() {
        return tutorid;
    }

    public void setTutorid(Long tutorid) {
        this.tutorid = tutorid;
    }

    public Long getStudentid() {
        return studentid;
    }

    public void setStudentid(Long studentid) {
        this.studentid = studentid;
    }

    public Long getCourseid() {
        return courseid;
    }

    public void setCourseid(Long courseid) {
        this.courseid = courseid;
    }
}