package main;

public class SelfFollowException extends Exception {
	public SelfFollowException(){
		super("Cannot follow yourself");
	}
}
