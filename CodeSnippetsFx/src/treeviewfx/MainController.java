package treeviewfx;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class MainController implements Initializable {
	
	@FXML TreeView<String> treeView;
	@FXML Label txtLabel;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		// Initialize treeView with top node and three subnodes
		Image nodeIcon = new Image(getClass().getResourceAsStream("folder.png"));
		TreeItem<String> root = new TreeItem<>("Root", new ImageView(nodeIcon));
		root.setExpanded(true);
		treeView.setRoot(root);
		
		HashMap<String, TreeItem<String>> sub = initTree(root, "Eka", "Toka", "Kolmas");
		initTree(sub.get("Eka"), "node1", "node2", "node3", "node4");
		initTree(sub.get("Toka"), "node5", "node6", "node7", "node8");
		sub.get("Eka").setExpanded(true);
		
	}
	
	// Helper function to create and attach subnodes to parent TreeItem node.
	private HashMap<String, TreeItem<String>> initTree(TreeItem<String> parent,
			String ... children) {
		
		HashMap<String, TreeItem<String>> nodes = new HashMap<>();
		
		for (int i = 0; i < children.length; i++) {
			nodes.put(children[i], new TreeItem<String>(children[i]));
			parent.getChildren().add(nodes.get(children[i]));
		}
		return nodes;
	}
	
	// Do something on mouse clicking an item in the tree
	public void mouseClick(MouseEvent event) {
		
		TreeItem<String> item = treeView.getSelectionModel().getSelectedItem();
		String breadCrumb = item.getValue();
		
		if (event.getClickCount() == 2) { // Add full path on doubleclick
			while (item.getParent() != null) {
				item = item.getParent();
				breadCrumb = item.getValue() + " - " + breadCrumb;
			}
		}
		txtLabel.setText(breadCrumb);
		
	}
	
}
