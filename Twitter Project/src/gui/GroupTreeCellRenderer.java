package gui;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeCellRenderer;

import main.Group;

public class GroupTreeCellRenderer implements TreeCellRenderer{
    private JLabel label;

    public GroupTreeCellRenderer() {
        label = new JLabel();
    }
    
	@Override
	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
		Object o = ((DefaultMutableTreeNode) value).getUserObject();
		label.setIcon(new ImageIcon("src/folder.png"));
		if(o instanceof Group){
			Group g = (Group) o;
			String name = g.getGroupname();
			label.setText("123");
			return label;
		}	
		return null;
	}
	
}
