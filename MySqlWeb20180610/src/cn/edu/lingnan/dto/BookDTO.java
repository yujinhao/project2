package cn.edu.lingnan.dto;

public class BookDTO {
	private String BookId;
	private String BookName;
	private float BookPrice;
	private String BookContent;
	private String BookWriter;
	private String BookPublish;
	public String getBookId() {
		return BookId;
	}
	public void setBookId(String bookId) {
		BookId = bookId;
	}
	public String getBookName() {
		return BookName;
	}
	public void setBookName(String bookName) {
		BookName = bookName;
	}
	public float getBookPrice() {
		return BookPrice;
	}
	public void setBookPrice(float bookPrice) {
		BookPrice = bookPrice;
	}
	public String getBookContent() {
		return BookContent;
	}
	public void setBookContent(String bookContent) {
		BookContent = bookContent;
	}
	public String getBookWriter() {
		return BookWriter;
	}
	public void setBookWriter(String bookWriter) {
		BookWriter = bookWriter;
	}
	public String getBookPublish() {
		return BookPublish;
	}
	public void setBookPublish(String bookPublish) {
		BookPublish = bookPublish;
	}
}
