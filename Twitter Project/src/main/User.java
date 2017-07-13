package main;

import java.util.ArrayList;

public class User {
	private int id;
	private String username;
	private ArrayList<Message> messages;
	private ArrayList<Integer> followerIDs;
	
	public User(String u){
		id = UsersList.getNewUserID();
		username = u;
	}

	public int getUserID() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String u) {
		username = u;
	}

	public boolean isAdmin() {
		return false;
	}

	public ArrayList<Message> getMessages() {
		return messages;
	}

	public void newMessage(String newMessage) {
		//this is a user created message
		//add to own message list
		Message m = new Message(id, newMessage);
		messages.add(m);
		//now add to followers messages
		updateFollowers(m);
	}
	
	private void updateFollowers(Message m){
		for(int i = 0; i < followerIDs.size(); i++){
			//u = follower user
			User u = UsersList.getUser(followerIDs.get(i));
			//show new message on u
			u.newMessage(m);
		}
	}
	
	public void newMessage(Message m){
		//do not add new msg to followers since this is not a user created message
		messages.add(m);
	}
	
	public void startFollowing(int userID){
		User u = UsersList.getUser(userID);
		u.addFollower(id);
	}
	
	public void addFollower(int userID){
		followerIDs.add(userID);
	}
	
	public String showFollowers(){
		//print string of followers eg: bob, jake, chris
		String followers = "";
		//get username based on each userid
		for(int i = 0; i < followerIDs.size(); i++){
			followers += UsersList.getUsername(followerIDs.get(i));
			if(i < followerIDs.size()-1){
				//add commas except for last follower
				followers += ", ";
			}
		}
		return followers;
	}
}