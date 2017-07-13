package main;

import java.util.ArrayList;
import java.util.Collections;

public class GroupsList {
	private static GroupsList firstInstance = null;
	private static ArrayList<Group> allGroups = new ArrayList<Group>(0);
	
	private GroupsList(){
		
	}
	
	public static GroupsList getInstance(){
		if(firstInstance == null){
			firstInstance = new GroupsList();
		}
		return firstInstance;
	}
	
	public static void addGroup(Group g){
		allGroups.add(g);
	}
	
	public static Group getGroup(int id){
		return allGroups.get(id);
	}
	
	public static int getNewGroupID(){
		//add new group at the end
		return allGroups.size();
	}
	
	public static int getTotalGroups(){
		return allGroups.size();
	}
	
	public static boolean groupExists(int id){
		if(id == 0){
			return true;
		}
		//binary search group list for that id
		Collections.sort(allGroups);
		//-1 means not found return not exists
		if(binarySearch(allGroups, 0, allGroups.size(), id) == -1){
			return false;
		}
		return true;
	}
	
	private static int binarySearch(ArrayList<Group> list, int l, int r, int x){
		if(r >= list.size()){
			//if r > array size then does not exist
			return -1;
		}
		if(r > 1){
			int mid = l + (r-l)/2;
			if(list.get(mid).getGroupID() == x){
				return mid;
			}
			if(list.get(mid).getGroupID() > x){
				return binarySearch(list, l, mid - 1, x);
			}
			return binarySearch(list, mid + 1, r, x);
		}else if(r == 1){
			if(list.get(0).getGroupID() == x){
				return 0;
			}
		}
		return -1;
	}
}
