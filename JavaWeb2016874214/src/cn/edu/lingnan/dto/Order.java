package cn.edu.lingnan.dto;

public class Order {
	private static String oid;
	private static String uid;
	private static String rid;
	private static String rname;
	private static String rtype;
	private static String price;

	public static String getOid() {
		return oid;
	}
	public static void setOid(String oid) {
		Order.oid = oid;
	}
	public static String getUid() {
		return uid;
	}
	public static void setUid(String uid) {
		Order.uid = uid;
	}
	public static String getRid() {
		return rid;
	}
	public static void setRid(String rid) {
		Order.rid = rid;
	}
	public static String getRname() {
		return rname;
	}
	public static void setRname(String rname) {
		Order.rname = rname;
	}
	public static String getRtype() {
		return rtype;
	}
	public static void setRtype(String rtype) {
		Order.rtype = rtype;
	}
	public static String getPrice() {
		return price;
	}
	public static void setPrice(String price) {
		Order.price = price;
	}
	
}

