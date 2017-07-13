package main;

import java.util.ArrayList;
import java.util.Arrays;

public class Message {
	private int userID;
	private String msg;
	private boolean positive;
	private final String[] KEYWORDS = {"good", ":)", "cool", "great", "happy", "excellent"};
	private static int totalMsgs;
	private static int totalPositive;
	
	public Message(int i, String m){
		userID = i;
		msg = m;
		positive = checkPositive(m);
		totalMsgs++;
	}
	
	public String toString(){
		//convert userID to username
		String username = UsersList.getUsername(userID);
		return username + ": " + msg;
	}
	
	public boolean getPositive(){
		return positive;
	}
	
	private boolean checkPositive(String msg){
		//split the message into an array of Strings seperated by a space
		String[] str = msg.split(" ");
		//convert array to a list to use contains
		ArrayList<String> list = (ArrayList<String>) Arrays.asList(str);
		//now check if str array contains keywords
		for(int i = 0; i < KEYWORDS.length; i++){
			if(list.contains(KEYWORDS[i])){
				totalPositive++;
				return true;
			}
		}
		return false;
	}
	
	public static int getTotalMessages(){
		return totalMsgs;
	}
	
	public static double getTotalPositive(){
		return (totalPositive / (double) totalMsgs);
	}
}
