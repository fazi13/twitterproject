package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class ShowUserWindow extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowUserWindow frame = new ShowUserWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ShowUserWindow() {
		setTitle("User View");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUserId = new JLabel("User id to follow: ");
		lblUserId.setBounds(15, 16, 154, 20);
		contentPane.add(lblUserId);
		
		JButton btnFollowUser = new JButton("Follow User");
		btnFollowUser.setBounds(298, 12, 115, 29);
		contentPane.add(btnFollowUser);
		
		textField_1 = new JTextField();
		textField_1.setBounds(151, 13, 132, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblCurrentlyFollowing = new JLabel("Currently Following:");
		lblCurrentlyFollowing.setBounds(15, 56, 154, 20);
		contentPane.add(lblCurrentlyFollowing);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 92, 398, 115);
		contentPane.add(scrollPane);
		
		JList followersList = new JList();
		scrollPane.setViewportView(followersList);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(15, 223, 268, 22);
		contentPane.add(textArea);
		
		JButton btnPostTweet = new JButton("Post Tweet");
		btnPostTweet.setBounds(298, 223, 115, 29);
		contentPane.add(btnPostTweet);
		
		JLabel lblNewsFeed = new JLabel("News Feed:");
		lblNewsFeed.setBounds(15, 261, 115, 20);
		contentPane.add(lblNewsFeed);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(15, 301, 398, 127);
		contentPane.add(scrollPane_1);
		
		JList newsFeedList = new JList();
		scrollPane_1.setViewportView(newsFeedList);
	}
}
