package main;

import java.util.ArrayList;
import java.util.Collections;

public class UsersList {
	private static ArrayList<User> allUsers = new ArrayList<User>(0);
	
	public static void addUser(User u) throws NewUserException{
		//if user exists already then throw an exception
		if(userExists(u.getUserID())){
			throw new NewUserException();
		}else{
			allUsers.add(u);
		}
	}
	
	public static int getNewUserID(){
		//add new user at the end
		return allUsers.size();
	}
	
	public static int getTotalUsers(){
		return allUsers.size();
	}
	
	public static String getUsername(int id){
		return allUsers.get(id).getUsername();
	}
	
	public static User getUser(int id){
		for(int i = 0; i < allUsers.size(); i++){
			if(allUsers.get(i).getUserID() == id){
				return allUsers.get(i);
			}
		}
		return null;
	}
	
	public static boolean userExists(int id){
		for(int i = 0; i < allUsers.size(); i++){
			if(allUsers.get(i).getUserID() == id){
				return true;
			}
		}
		return false;
	}
}
