package main;

import java.util.ArrayList;
import java.util.Collections;

public class UsersList {
	private static ArrayList<User> allUsers = new ArrayList<User>(0);
	
	public static void addUser(User u){
		allUsers.add(u);
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
		return allUsers.get(id);
	}
	
	public static boolean userExists(int id){
		//binary search user list for that id
		Collections.sort(allUsers);
		//-1 means not found return not exists
		if(binarySearch(allUsers, 0, allUsers.size(), id) == -1){
			return false;
		}
		return true;
	}
	
	private static int binarySearch(ArrayList<User> list, int l, int r, int x){
		if(r >= list.size()){
			//if r > array size then does not exist
			return -1;
		}
		if(r > 1){
			int mid = l + (r-l)/2;
			if(list.get(mid).getUserID() == x){
				return mid;
			}
			if(list.get(mid).getUserID() > x){
				return binarySearch(list, l, mid - 1, x);
			}
			return binarySearch(list, mid + 1, r, x);
		}else if(r == 1){
			if(list.get(0).getUserID() == x){
				return 0;
			}
		}
		return -1;
	}
}
