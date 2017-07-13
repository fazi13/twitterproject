package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.JScrollPane;
import javax.swing.tree.DefaultTreeModel;

import main.Group;
import main.GroupNotExistException;
import main.GroupsList;
import main.Message;
import main.NewUserException;
import main.User;
import main.UsersList;

import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminWindow extends JFrame {

	private JPanel contentPane;
	private JTextField boxUserId;
	private JTextField boxGroupId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		//create root user and root group
		User u = new User("root");
		UsersList.addUser(u);
		Group g = new Group("root");
		GroupsList.addGroup(g);
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminWindow frame = new AdminWindow();
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
	public AdminWindow() {
		setTitle("Admin Control Panel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUserId = new JLabel("User Id:");
		lblUserId.setBounds(400, 16, 69, 20);
		contentPane.add(lblUserId);
		
		JLabel lblGroupId = new JLabel("Parent Group:");
		lblGroupId.setBounds(400, 53, 108, 20);
		contentPane.add(lblGroupId);
		
		JButton btnOpenUserView = new JButton("Open User View");
		btnOpenUserView.setBounds(400, 89, 363, 29);
		contentPane.add(btnOpenUserView);
		
		JButton btnAddUser = new JButton("Add User");
		btnAddUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int userID = 0;
				String input = boxUserId.getText();
				try{
					//if no user id input, generate a new user id
					if(input.equals("")){
						userID = UsersList.getNewUserID();
					}else{
						userID = Integer.parseInt(input);
					}
					//open new user box
					String username = JOptionPane.showInputDialog("Enter username");
					User u = new User(userID, username);
					UsersList.addUser(u);
				}catch(NumberFormatException e1){
					JOptionPane.showMessageDialog(null, "User id must be an integer", "Input Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace(System.out);
				}catch (NewUserException e2){
					JOptionPane.showMessageDialog(null, "User id " + userID + " already exists", "User ID Error", JOptionPane.ERROR_MESSAGE);
					e2.printStackTrace();
				}
			}
		});
		btnAddUser.setBounds(599, 12, 164, 29);
		contentPane.add(btnAddUser);
		
		JButton btnAddGroup = new JButton("Add Group");
		btnAddGroup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int parentGroup = 0;
				String input = boxGroupId.getText();
				try{
					//get the parent group id
					if(input.equals("")){
						//if empty assume 0 or root
						parentGroup = 0;
					}else{
						parentGroup = Integer.parseInt(input);
					}
					//open new group box
					String groupname = JOptionPane.showInputDialog("Enter group name");
					Group g = new Group(groupname, parentGroup);
					GroupsList.addGroup(g);
				}catch(GroupNotExistException e1){
					JOptionPane.showMessageDialog(null, "Parent group " + parentGroup + " does not exist", "Group ID Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace(System.out);
				}
			}
		});
		btnAddGroup.setBounds(599, 49, 164, 29);
		contentPane.add(btnAddGroup);
		
		boxUserId = new JTextField();
		boxUserId.setBounds(523, 13, 61, 26);
		contentPane.add(boxUserId);
		boxUserId.setColumns(10);
		
		boxGroupId = new JTextField();
		boxGroupId.setBounds(523, 50, 61, 26);
		contentPane.add(boxGroupId);
		boxGroupId.setColumns(10);
		
		//show total users
		JButton btnShowTotalUsers = new JButton("<html><center>" + "Show Total<br>Users" + "</center></html>");
		btnShowTotalUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "There are currently " + UsersList.getTotalUsers() + " user(s) created.");
			}
		});
		btnShowTotalUsers.setBounds(400, 200, 164, 60);
		contentPane.add(btnShowTotalUsers);
		
		JButton btnShowTotalGroups = new JButton("<html><center>" + "Show Total<br>Groups" + "</center></html>");
		btnShowTotalGroups.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "There are currently " + GroupsList.getTotalGroups() + " group(s) created.");
			}
		});
		btnShowTotalGroups.setBounds(599, 200, 164, 60);
		contentPane.add(btnShowTotalGroups);
		
		JButton btnShowTotalMessages = new JButton("<html><center>" + "Show Total<br>Messages" + "</center></html>");
		btnShowTotalMessages.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "There are currently " + Message.getTotalMessages() + " message(s) written.");
			}
		});
		btnShowTotalMessages.setBounds(400, 268, 164, 60);
		contentPane.add(btnShowTotalMessages);
		
		JButton btnShowPositivePercentage = new JButton("<html><center>" + "Show Positive<br>Percentage" + "</center></html>");
		btnShowPositivePercentage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, Message.getTotalPositive() + "% of messages are positive messages.");
			}
		});
		btnShowPositivePercentage.setBounds(599, 268, 164, 60);
		contentPane.add(btnShowPositivePercentage);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 18, 363, 310);
		contentPane.add(scrollPane);
		
		JTree Groups = new JTree();
		scrollPane.setViewportView(Groups);
	}
}
