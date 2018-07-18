package cn.edu.lingnan.dto;

public class CourseDTO {
	private String CourseId;
	private String CourseName;
	private int CourseCredit;
	private int CourseClass;
	private String CourseDesc;
	private String ClassTime;
	private String Address;
	private int Volume;
	private int Remain;
	public String getCourseId() {
		return CourseId;
	}
	public void setCourseId(String courseId) {
		CourseId = courseId;
	}
	public String getCourseName() {
		return CourseName;
	}
	public void setCourseName(String courseName) {
		CourseName = courseName;
	}
	public int getCourseCredit() {
		return CourseCredit;
	}
	public void setCourseCredit(int courseCredit) {
		CourseCredit = courseCredit;
	}
	public int getCourseClass() {
		return CourseClass;
	}
	public void setCourseClass(int courseClass) {
		CourseClass = courseClass;
	}
	public String getCourseDesc() {
		return CourseDesc;
	}
	public void setCourseDesc(String courseDesc) {
		CourseDesc = courseDesc;
	}
	public String getClassTime() {
		return ClassTime;
	}
	public void setClassTime(String classTime) {
		ClassTime = classTime;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public int getVolume() {
		return Volume;
	}
	public void setVolume(int volume) {
		Volume = volume;
	}
	public int getRemain() {
		return Remain;
	}
	public void setRemain(int remain) {
		Remain = remain;
	}
}