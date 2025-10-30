package testcase;

//to read json through java, we do serialization and decerialization

//the data from java class is been stored into the json file - serialization

//the data from json file is being imported in the java class

public class ReadingPojo {

	private String email;
	private String password;

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
	
    @Override
    public String toString() {
        return "ReadingPojo{Email='" + email + "', Password=" + password + "}";
    }
}