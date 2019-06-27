package kr.or.ddit.user.model;

public class PageVo {

	private int page;
	private int pageSize;
	public int getPage() {
		return page == 0?1:page;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + page;
		result = prime * result + pageSize;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PageVo other = (PageVo) obj;
		if (page != other.page)
			return false;
		if (pageSize != other.pageSize)
			return false;
		return true;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageSize() {
		return pageSize == 0?10 : pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public PageVo(int page, int pageSize) {
		super();
		this.page = page;
		this.pageSize = pageSize;
	}
	
	public PageVo(){
		
	}
	
	@Override
	public String toString() {
		return "pageVo [page=" + page + ", pageSize=" + pageSize + "]";
	}
	
}
