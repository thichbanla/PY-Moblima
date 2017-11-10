package system;

import java.io.*;

public class Person implements Serializable {

	private String name;
	private int contact;
	private String email;
	private String id;
	private String pw;

	public Person() {
	}

	public Person(String name, String id, String pw, String email, int contact) {
		this.setName(name);
		this.setContact(contact);
		this.setEmail(email);
		this.id = id;
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getContact() {
		return contact;
	}

	public void setContact(int contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getID()
	{
		return id;
	}
	
	public String getPW()
	{
		return pw;
	}

	// Concrete methods
	public boolean login() {
		return false;
	}

}
