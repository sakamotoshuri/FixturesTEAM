package dto;

public class Fixturesdto {
	private int fixtures_id;
	private String fixtures_name;
	private int quantity;
	private String category;
	private String content;
	public int getFixtures_id() {
		return fixtures_id;
	}
	public void setFixtures_id(int fixtures_id) {
		this.fixtures_id = fixtures_id;
	}
	public String getFixtures_name() {
		return fixtures_name;
	}
	public void setFixtures_name(String fixtures_name) {
		this.fixtures_name = fixtures_name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Fixturesdto(int fixtures_id, String fixtures_name, int quantity, String category, String content) {
		super();
		this.fixtures_id = fixtures_id;
		this.fixtures_name = fixtures_name;
		this.quantity = quantity;
		this.category = category;
		this.content = content;
	}
	
}
