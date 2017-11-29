package uk.co.jsmondswimmingpool.entity;

public class Finishstatus {
    private Long studentid;

    private Long courseid;

    private Integer status;

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

    @Override
	public String toString() {
		return "Finishstatus [studentid=" + studentid + ", courseid=" + courseid + ", status=" + status + "]";
	}

	public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}