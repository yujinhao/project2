package cn.edu.lingnan.dto;

public class MajorDTO {
	private String MajorId;
	private String DeptId;
	private String MajorName;
	private int ClassNumber;
	public String getMajorId() {
		return MajorId;
	}
	public void setMajorId(String majorId) {
		MajorId = majorId;
	}
	public String getDeptId() {
		return DeptId;
	}
	public void setDeptId(String deptId) {
		DeptId = deptId;
	}
	public String getMajorName() {
		return MajorName;
	}
	public void setMajorName(String majorName) {
		MajorName = majorName;
	}
	public int getClassNumber() {
		return ClassNumber;
	}
	public void setClassNumber(int classNumber) {
		ClassNumber = classNumber;
	}
}