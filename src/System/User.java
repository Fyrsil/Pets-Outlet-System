package System;

public class User {
    private String username;
    private String emailAddress;
    private String password;

    public User(String username, String emailAddress, String password){
    	this.username = username;
    	this.emailAddress = emailAddress;
    	this.password = password;
    }

    public String getUsername(){
        return username;
    }
    
    public String getEmail(){
        return emailAddress;
    }

    public String getPassword(){
        return password;
    }
    
    public void setUsername(String username){
        this.username = username;
    }

    public void setEmail(String emailAddress){
        this.emailAddress = emailAddress;
    }

    public void setPassword(String password){
        this.password = password;
    }
    
    public String toFileString() {
	    return username + ", " + emailAddress + ", " + password;
	}
}

