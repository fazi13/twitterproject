package main;

public class UserNotExistException extends Exception {
	public UserNotExistException(){
		super("That user does not exist");
	}
}
