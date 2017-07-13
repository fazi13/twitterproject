package main;

import java.util.ArrayList;

public class UsersList {
	private static ArrayList<User> allUsers;
	
	public static void addUser(User u){
		allUsers.add(u);
	}
	
	public static int getNewUserID(){
		return allUsers.size();
	}
	
	public static int getTotalUsers(){
		return allUsers.size();
	}
	
	public static String getUsername(int id){
		return allUsers.get(id).getUsername();
	}
	
	public static User getUser(int id){
		return allUsers.get(id);
	}
}
