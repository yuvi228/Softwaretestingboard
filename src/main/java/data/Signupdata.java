package data;

public class Signupdata {

	String firstName;
	String lastName;
	String email;
	String password;
	
	private static Signupdata instance;
	
	
	private Signupdata() {}

    public static Signupdata getInstance() {
        if (instance == null) {
            instance = new Signupdata();
        }
        return instance;
    }


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
