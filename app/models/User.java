package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;

@Entity
public class User extends Model {
    public String email;
    public String password;    
	public String fullName;
    public boolean isAdmin;
    
    public User(String email, String password, String fullName, boolean isAdmin) {
		super();
		this.email = email;
		this.password = password;
		this.fullName = fullName;
		this.isAdmin = isAdmin;
	}

	public User(String email, String password, String fullName) {
		super();
		this.email = email;
		this.password = password;
		this.fullName = fullName;
	}
    
    public static User connect(String email,String password) {
    	return find("byEmailAndPassword",email,password).first();
    }
    
    
}
