package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.SelfFollowException;
import main.User;
import main.UserNotExistException;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ShowUserWindow extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tweetBox;
	private User curUser;

	/**
	 * Create the dialog.
	 */
	public ShowUserWindow(User u) {
		setTitle("User View");
		curUser = u;
		setBounds(100, 100, 450, 743);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblCurrentUser = new JLabel("Current User: ");
			lblCurrentUser.setBounds(15, 16, 101, 20);
			contentPanel.add(lblCurrentUser);
		}
		{
			JLabel lblUsername = new JLabel(curUser.getUsername());
			lblUsername.setBounds(118, 16, 69, 20);
			contentPanel.add(lblUsername);
		}
		{
			JLabel lblUserIdTo = new JLabel("User id to follow: ");
			lblUserIdTo.setBounds(97, 48, 128, 20);
			contentPanel.add(lblUserIdTo);
		}
		{
			JTextArea followID = new JTextArea();
			followID.setBounds(240, 48, 43, 22);
			contentPanel.add(followID);
			{
				JButton btnFollowUser = new JButton("Follow User");
				btnFollowUser.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int uid = 0;
						try{
							uid = Integer.parseInt(followID.getText());
							curUser.startFollowing(uid);
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
					}
				});
				btnFollowUser.setBounds(298, 44, 115, 29);
				contentPanel.add(btnFollowUser);
			}
		}
		{
			JLabel lblCurrentlyFollowing = new JLabel("Currently following: ");
			lblCurrentlyFollowing.setBounds(15, 74, 146, 20);
			contentPanel.add(lblCurrentlyFollowing);
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(15, 110, 398, 118);
			contentPanel.add(scrollPane);
			{
				JList followingList = new JList();
				scrollPane.setViewportView(followingList);
			}
		}
		{
			tweetBox = new JTextField();
			tweetBox.setBounds(15, 244, 268, 26);
			contentPanel.add(tweetBox);
			tweetBox.setColumns(10);
		}
		{
			JButton btnPostTweet = new JButton("Post Tweet");
			btnPostTweet.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					curUser.newMessage(tweetBox.getText());
				}
			});
			btnPostTweet.setBounds(298, 244, 115, 29);
			contentPanel.add(btnPostTweet);
		}
		{
			JLabel lblNewsFeed = new JLabel("News Feed:");
			lblNewsFeed.setBounds(15, 286, 82, 20);
			contentPanel.add(lblNewsFeed);
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(15, 322, 398, 331);
			contentPanel.add(scrollPane);
			{
				JList list = new JList();
				scrollPane.setViewportView(list);
			}
		}
	}

}
