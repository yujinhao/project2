package cn.edu.lingnan.dto;

public class StudentsDTO {
	private String StudentId;
	private String ClassId;
	private String StudentName;
	private String StudentSex;
	private int StudentAge;
	private String EntranceTime;
	private String StudentPassw;
	public String getStudentId() {
		return StudentId;
	}
	public void setStudentId(String studentId) {
		StudentId = studentId;
	}
	public String getClassId() {
		return ClassId;
	}
	public void setClassId(String classId) {
		ClassId = classId;
	}
	public String getStudentName() {
		return StudentName;
	}
	public void setStudentName(String studentName) {
		StudentName = studentName;
	}
	public String getStudentSex() {
		return StudentSex;
	}
	public void setStudentSex(String studentSex) {
		StudentSex = studentSex;
	}
	public int getStudentAge() {
		return StudentAge;
	}
	public void setStudentAge(int studentAge) {
		StudentAge = studentAge;
	}
	public String getEntranceTime() {
		return EntranceTime;
	}
	public void setEntranceTime(String entranceTime) {
		EntranceTime = entranceTime;
	}
	public String getStudentPassw() {
		return StudentPassw;
	}
	public void setStudentPassw(String studentPassw) {
		StudentPassw = studentPassw;
	}
}
