import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import family.FamilyInput;

public class FamilyViewer extends JPanel {
	
	WindowFrame frame;
	FamilyManager familyManager;
	
	public FamilyManager getFamilyManager() {
		return familyManager;
	}

	public void setFamilyManager(FamilyManager familyManager) {
		this.familyManager = familyManager;
		this.removeAll();
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Name");
		model.addColumn("Relation");
		model.addColumn("Birth");
		model.addColumn("Adress");
		
		for (int i = 0 ; i <familyManager.size() ; i++) {
			Vector row = new Vector();
			FamilyInput fi = familyManager.get(i);
			row.add(fi.getName());
			row.add(fi.getRelation());
			row.add(fi.getBirth());
			row.add(fi.getAdress());
			model.addRow(row);
		}
		 
		JTable table = new JTable(model);
		JScrollPane sp = new JScrollPane(table);
		
		this.add(sp);
	}

	public FamilyViewer(WindowFrame frame,FamilyManager familyManager) {
		this.familyManager = familyManager;
		this.frame = frame;
		
//		System.out.println("*** °¡Á· ¼ö size: "+familyManager.size());
		
//		String column[] = {"Name","Relation","Birth","Adress"};
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Name");
		model.addColumn("Relation");
		model.addColumn("Birth");
		model.addColumn("Adress");
		
		for (int i = 0 ; i <familyManager.size() ; i++) {
			Vector row = new Vector();
			FamilyInput fi = familyManager.get(i);
			row.add(fi.getName());
			row.add(fi.getRelation());
			row.add(fi.getBirth());
			row.add(fi.getAdress());
			model.addRow(row);
		}
		 
		JTable table = new JTable(model);
		JScrollPane sp = new JScrollPane(table);
		
		this.add(sp);
	}
}
