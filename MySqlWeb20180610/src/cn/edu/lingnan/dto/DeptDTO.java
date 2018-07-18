package cn.edu.lingnan.dto;

public class DeptDTO {
	private String DeptId;
	private String DeptName;
	private String DeptChairman;
	private String DeptTel;
	public String getDeptId() {
		return DeptId;
	}
	public void setDeptId(String deptId) {
		DeptId = deptId;
	}
	public String getDeptName() {
		return DeptName;
	}
	public void setDeptName(String deptName) {
		DeptName = deptName;
	}
	public String getDeptChairman() {
		return DeptChairman;
	}
	public void setDeptChairman(String deptChairman) {
		DeptChairman = deptChairman;
	}
	public String getDeptTel() {
		return DeptTel;
	}
	public void setDeptTel(String deptTel) {
		DeptTel = deptTel;
	}
}