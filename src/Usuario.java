
public class Usuario {
	private String UserName;
	private String Password;
	private String Email;
	
	public Usuario() {
		
	}
	
	public Usuario(String userName, String password, String email) {
		super();
		UserName = userName;
		Password = password;
		Email = email;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
}
