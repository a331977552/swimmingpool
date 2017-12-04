package uk.co.jsmondswimmingpool.entity.custom;

public class PageBean {

	private Integer currentPage;
	private Integer totalPage;
	private Integer startCount;
	public Integer getStartCount() {
		return startCount;
	}
	public void setStartCount(Integer startCount) {
		this.startCount = startCount;
	}
	private Integer totalCount;
	
	private Integer pageSize;
	
	
	
	public PageBean(Integer currentPage, Integer totalCount, Integer pageSize) {
		
		this.currentPage = currentPage;
		
		this.totalCount = totalCount;
		this.pageSize = pageSize;
		if(pageSize==null || pageSize<=0) 
		{
			this.pageSize=3;
			
		}
		this.totalPage = (totalCount+ this.pageSize-1)/this.pageSize;
		
		if(currentPage==null)
			this.currentPage=0;
		
		if(	this.currentPage>=totalPage)
			this.currentPage=(this.totalPage-1);
		
		if(	this.currentPage<0)
			this.currentPage=0;
		
	   	startCount=	this.currentPage*this.pageSize;
		
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	
}
