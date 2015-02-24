package company.citymanagerweb.models;

public abstract class DBUserInfo {
	private String uid;
	private String pwd;
	private String cat;
	
	public DBUserInfo() {
		
	}
	
	public DBUserInfo(String userID, String password, String catalog) {
		uid = userID;
		pwd = password;
		cat = catalog;
	}

	public String getUserID() {
		return uid;
	}
	public void setUserID(String value) {
		this.uid = value;
	}
	public String getPassword() {
		return pwd;
	}
	public void setPassword(String value) {
		this.pwd = value;
	}
	public String getCatalog() {
		return cat;
	}
	public void setCatalog(String value) {
		this.cat = value;
	}
}
