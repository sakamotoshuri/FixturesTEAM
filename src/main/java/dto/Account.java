package dto;

public class Account {
	private int id;
	private String name;
	private String mail;
	private String salt;
	private String pw;
	private String hashedPassword;
	
	public Account(int id, String name, String mail, String salt, String pw, String hashedPassword) {
		super();
		this.id = id;
		this.name = name;
		this.mail = mail;
		this.salt = salt;
		this.pw = pw;
		this.hashedPassword = hashedPassword;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getHashedPassword() {
		return hashedPassword;
	}

	public void setHashedPassword(String hashedPassword) {
		this.hashedPassword = hashedPassword;
	}
	
	
}
