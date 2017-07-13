package main;

public class GroupNotExistException extends Exception {
	public GroupNotExistException(){
		super("Group does not exist");
	}
}
