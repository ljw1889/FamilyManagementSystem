

import javax.swing.JFrame;
import javax.swing.JPanel;

public class WindowFrame extends JFrame {
	
	FamilyManager familyManager;
	
	MenuSelection menuselection;
	FamilyAdder familyadder;
	FamilyViewer familyviewer;
	
	
	public WindowFrame(FamilyManager familyManager) {
		this.familyManager = familyManager;
		this.menuselection = new MenuSelection(this);
		this.familyadder = new FamilyAdder(this);
		this.familyviewer = new FamilyViewer(this,this.familyManager);
		this.setSize(500,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setupPanel(menuselection);
		
		this.setVisible(true);
	}
	
	public void setupPanel(JPanel panel) {
		this.getContentPane().removeAll();
		this.getContentPane().add(panel);
		this.revalidate();
		this.repaint();
	}
	public MenuSelection getMenuselection() {
		return menuselection;
	}
	public void setMenuselection(MenuSelection menuselection) {
		this.menuselection = menuselection;
	}
	public FamilyAdder getFamilyadder() {
		return familyadder;
	}
	public void setFamilyadder(FamilyAdder familyadder) {
		this.familyadder = familyadder;
	}
	public FamilyViewer getFamilyviewer() {
		return familyviewer;
	}
	public void setFamilyviewer(FamilyViewer familyviewer) {
		this.familyviewer = familyviewer;
	}
}
