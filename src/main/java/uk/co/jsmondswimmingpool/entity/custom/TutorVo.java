package uk.co.jsmondswimmingpool.entity.custom;

import uk.co.jsmondswimmingpool.entity.Tutor;

public class TutorVo {

	private Tutor tutor;
	private Integer currentPage;
	private Integer pageSize;
	public Tutor getTutor() {
		return tutor;
	}
	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
}
