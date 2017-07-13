package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.JScrollPane;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;

public class AdminWindow extends JFrame {

	private JPanel contentPane;
	private JTextField userID;
	private JTextField groupID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUserId = new JLabel("User Id:");
		lblUserId.setBounds(400, 16, 69, 20);
		contentPane.add(lblUserId);
		
		JLabel lblGroupId = new JLabel("Group Id:");
		lblGroupId.setBounds(400, 53, 78, 20);
		contentPane.add(lblGroupId);
		
		JButton btnOpenUserView = new JButton("Open User View");
		btnOpenUserView.setBounds(400, 89, 363, 29);
		contentPane.add(btnOpenUserView);
		
		JButton btnAddUser = new JButton("Add User");
		btnAddUser.setBounds(599, 12, 164, 29);
		contentPane.add(btnAddUser);
		
		JButton btnAddGroup = new JButton("Add Group");
		btnAddGroup.setBounds(599, 49, 164, 29);
		contentPane.add(btnAddGroup);
		
		userID = new JTextField();
		userID.setBounds(493, 13, 71, 26);
		contentPane.add(userID);
		userID.setColumns(10);
		
		groupID = new JTextField();
		groupID.setBounds(493, 50, 71, 26);
		contentPane.add(groupID);
		groupID.setColumns(10);
		
		JButton btnShowTotalUsers = new JButton("<html><center>" + "Show Total<br>Users" + "</center></html>");
		btnShowTotalUsers.setBounds(400, 200, 164, 60);
		contentPane.add(btnShowTotalUsers);
		
		JButton btnShowTotalGroups = new JButton("<html><center>" + "Show Total<br>Groups" + "</center></html>");
		btnShowTotalGroups.setBounds(599, 200, 164, 60);
		contentPane.add(btnShowTotalGroups);
		
		JButton btnShowTotalMessages = new JButton("<html><center>" + "Show Total<br>Messages" + "</center></html>");
		btnShowTotalMessages.setBounds(400, 268, 164, 60);
		contentPane.add(btnShowTotalMessages);
		
		JButton btnShowPositivePercentage = new JButton("<html><center>" + "Show Positive<br>Percentage" + "</center></html>");
		btnShowPositivePercentage.setBounds(599, 268, 164, 60);
		contentPane.add(btnShowPositivePercentage);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 18, 363, 310);
		contentPane.add(scrollPane);
		
		JTree tree = new JTree();
		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("Root") {
				{
					DefaultMutableTreeNode node_1;
					node_1 = new DefaultMutableTreeNode("Group1");
						node_1.add(new DefaultMutableTreeNode("Group1a"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Group2");
						node_1.add(new DefaultMutableTreeNode("Group2a"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Group3");
						node_1.add(new DefaultMutableTreeNode("Group3a"));
					add(node_1);
				}
			}
		));
		scrollPane.setViewportView(tree);
	}
}
