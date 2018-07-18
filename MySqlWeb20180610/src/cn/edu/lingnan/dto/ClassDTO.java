package cn.edu.lingnan.dto;
public class ClassDTO {
	private String ClassId;
	private String MajorId;
	private String ClassName;
	private int StudentsNumber;
	public String getClassId() {
		return ClassId;
	}
	public void setClassId(String classId) {
		ClassId = classId;
	}
	public String getMajorId() {
		return MajorId;
	}
	public void setMajorId(String majorId) {
		MajorId = majorId;
	}
	public String getClassName() {
		return ClassName;
	}
	public void setClassName(String className) {
		ClassName = className;
	}
	public int getStudentsNumber() {
		return StudentsNumber;
	}
	public void setStudentsNumber(int studentsNumber) {
		StudentsNumber = studentsNumber;
	}	
}