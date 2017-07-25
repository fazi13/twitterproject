package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.Message;
import main.SelfFollowException;
import main.User;
import main.UserNotExistException;
import main.UsersList;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;

public class ShowUserWindow extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tweetBox;
	private User curUser;
	DefaultListModel dm = new DefaultListModel();
	DefaultListModel fm = new DefaultListModel();

	/**
	 * Create the dialog.
	 */
	public ShowUserWindow(User myUser) {
		setTitle("User View");
		curUser = myUser;
		String lastUpdated = "";
		setBounds(100, 100, 450, 743);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
			JLabel lblCurrentUser = new JLabel("Current User: ");
			lblCurrentUser.setBounds(15, 16, 101, 20);
			contentPanel.add(lblCurrentUser);
		
		
			JLabel lblUsername = new JLabel(curUser.getUsername());
			lblUsername.setBounds(106, 16, 69, 20);
			contentPanel.add(lblUsername);
		
		
			JLabel lblUserIdTo = new JLabel("User id to follow: ");
			lblUserIdTo.setBounds(227, 44, 128, 20);
			contentPanel.add(lblUserIdTo);
		
		
			//follow user
			JTextArea followID = new JTextArea();
			followID.setBounds(370, 44, 43, 22);
			contentPanel.add(followID);
			{
				JButton btnFollowUser = new JButton("Follow User");
				btnFollowUser.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int uid = 0;
						try{
							uid = Integer.parseInt(followID.getText());
							//start following
							curUser.startFollowing(uid);
							User following = UsersList.getUser(uid);
							//update following list
							addFollowing(following);
						}catch(NumberFormatException e1){
							//error please enter an int
							JOptionPane.showMessageDialog(null, "Please enter valid user id", "Input Error", JOptionPane.ERROR_MESSAGE);
						} catch (UserNotExistException e1) {
							//error user does not exist
							JOptionPane.showMessageDialog(null, "User id: " + Integer.toString(uid) + " does not exist", "Input Error", JOptionPane.ERROR_MESSAGE);
						} catch (SelfFollowException e1) {
							//cant follow urself
							JOptionPane.showMessageDialog(null, "You can't follow yourself", "Following Error", JOptionPane.ERROR_MESSAGE);
						}
						//clear textbox after click
						followID.setText("");
					}
				});
				btnFollowUser.setBounds(298, 70, 115, 29);
				contentPanel.add(btnFollowUser);
			}
		
		
			JLabel lblCurrentlyFollowing = new JLabel("Currently following: ");
			lblCurrentlyFollowing.setBounds(15, 74, 146, 20);
			contentPanel.add(lblCurrentlyFollowing);
			
			//get last updated	
			lastUpdated = getLastUpdated();
			JLabel lbllastUpdated = new JLabel("(last updated " + lastUpdated + ")");
			lbllastUpdated.setBounds(106, 286, 177, 20);
			contentPanel.add(lbllastUpdated);
		
		//followings box
		
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(15, 110, 398, 118);
			contentPanel.add(scrollPane);
			
			JList following = new JList();
			scrollPane.setViewportView(following);	
			following.setModel(fm);
			addAllFollowing(curUser.getFollowings());
		
		
			tweetBox = new JTextField();
			tweetBox.setBounds(15, 244, 268, 26);
			contentPanel.add(tweetBox);
			tweetBox.setColumns(10);
		
		//post tweet
		
			JButton btnPostTweet = new JButton("Post Tweet");
			btnPostTweet.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String msg = tweetBox.getText();
					//update messages box with new tweet
					Message m = new Message(curUser.getUserID(), msg);
					curUser.newMessage(m);
					addMessages(m);
					
					//clear textbox after posting
					tweetBox.setText("");
					
					//also update last updated
					String lastUpdated = getLastUpdated();
					lbllastUpdated.setText("(last updated " + lastUpdated + ")");
				}
			});
			btnPostTweet.setBounds(298, 244, 115, 29);
			contentPanel.add(btnPostTweet);
		
		
			JLabel lblNewsFeed = new JLabel("News Feed:");
			lblNewsFeed.setBounds(15, 286, 82, 20);
			contentPanel.add(lblNewsFeed);
		
		
			JScrollPane scrollPane1 = new JScrollPane();
			scrollPane1.setBounds(15, 322, 398, 331);
			contentPanel.add(scrollPane1);
			
			//newsfeed
			JList newsfeed = new JList();
			//add all msgs on open
			addAllMessages(curUser.getMessages());
			scrollPane1.setViewportView(newsfeed);
			newsfeed.setModel(dm);
			
			JLabel lblUserId = new JLabel("User id:");
			lblUserId.setBounds(305, 16, 69, 20);
			contentPanel.add(lblUserId);
			
			JLabel lblId = new JLabel(Integer.toString(curUser.getUserID()));
			lblId.setBounds(389, 16, 24, 20);
			contentPanel.add(lblId);

			//get creation time for cur user
			long millis = curUser.getCreationTime();
			//convert to a date
			SimpleDateFormat df = new SimpleDateFormat("MM/dd/yy HH:mm");
			Date date = new Date(millis);
			String created = df.format(date.getTime());
			JLabel lblTime = new JLabel(created);
			lblTime.setBounds(106, 44, 123, 20);
			contentPanel.add(lblTime);
			
			JLabel lblNewLabel = new JLabel("Created on:");
			lblNewLabel.setBounds(15, 44, 101, 20);
			contentPanel.add(lblNewLabel);
		
			JButton btnRefresh = new JButton("Refresh");
			btnRefresh.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					addAllMessages(curUser.getMessages());
					//also update last updated text
					String lastUpdated = getLastUpdated();
					lbllastUpdated.setText("(last updated " + lastUpdated + ")");
				}
			});
			btnRefresh.setBounds(298, 282, 115, 29);
			contentPanel.add(btnRefresh);
	}
	
	private void addMessages(Message m){
		dm.add(0, m);
	}
	
	private String getLastUpdated(){
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/yy HH:mm");
		long millis = curUser.getLastUpdated();
		Date lastDate = new Date(millis);
		return df.format(lastDate.getTime());
	}
	
	private void addAllMessages(ArrayList<Message> messages){
		dm.clear();
		if(messages.size() == 0){
			//if no msgs do nothing
		}else{
			//add each message from newest(end) to oldest(first
			for(int i = messages.size()-1; i >= 0; i--){
				dm.addElement(messages.get(i));
			}
		}
	}
	
	private void addFollowing(User u1){
		fm.addElement(u1);
	}
	
	private void addAllFollowing(ArrayList<Integer> follUserID){
		fm.clear();
		for(int i = 0; i < follUserID.size(); i++){
			//get user from their id
			User u1 = UsersList.getUser(follUserID.get(i));
			//add to list
			fm.addElement(u1);
		}
	}
}
