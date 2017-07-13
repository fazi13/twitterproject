package main;

public class NewUserException extends Exception{
	public NewUserException(){
		super("User with that ID already exists");
	}
}
