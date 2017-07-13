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
		for(int i = 0; i < allGroups.size(); i++){
			if(allGroups.get(i).getGroupID() == id){
				return true;
			}
		}
		return false;
	}
}
