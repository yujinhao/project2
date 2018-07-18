package cn.edu.lingnan.dto;

public class UsersDTO {
	private String UserId;
	private String UserName;
	private String UserPassw;
	private int UserRoot;
	public String getUserId() {
		return UserId;
	}
	public void setUserId(String userId) {
		UserId = userId;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getUserPassw() {
		return UserPassw;
	}
	public void setUserPassw(String userPassw) {
		UserPassw = userPassw;
	}
	public int getUserRoot() {
		return UserRoot;
	}
	public void setUserRoot(int userRoot) {
		UserRoot = userRoot;
	}
}