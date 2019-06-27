package kr.or.ddit.prod.model;

public class ProdVo {
	
	private String prod_id;
	private String prod_name;
	private String prod_lgu;
	public String getProd_id() {
		return prod_id;
	}
	public void setProd_id(String prod_id) {
		this.prod_id = prod_id;
	}
	public String getProd_name() {
		return prod_name;
	}
	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}
	public String getProd_lgu() {
		return prod_lgu;
	}
	public void setProd_lgu(String prod_lgu) {
		this.prod_lgu = prod_lgu;
	}
	@Override
	public String toString() {
		return "ProdVo [prod_id=" + prod_id + ", prod_name=" + prod_name
				+ ", prod_lgu=" + prod_lgu + "]";
	}
	public ProdVo(String prod_id, String prod_name, String prod_lgu) {
		super();
		this.prod_id = prod_id;
		this.prod_name = prod_name;
		this.prod_lgu = prod_lgu;
	}
	
	public ProdVo(){
		
	}
	
	
	

}
