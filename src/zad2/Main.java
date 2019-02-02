/**
 *
 *  @author Trembowska Katarzyna S18233
 *
 */

package zad2;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.AbstractListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

class ListModel extends AbstractListModel {

	Vector vector = new Vector();
	
	ListModel() {}
	
	ListModel(Object[] initial) {
		for (int i=0; i<initial.length; i++) vector.addElement(initial[i]);
	}	
	
	@Override
	public Object getElementAt(int e) { return vector.elementAt(e); }

	@Override
	public int getSize() { return vector.size(); }
	
	
	public void add(Object e) {
		vector.add( getSize(), e);
		fireContentsChanged(vector, 0, this.getSize());
	}

	void remove(int p) {
		vector.removeElementAt(p);
		fireIntervalRemoved(this, p, p);
	}

}


class AddToList implements ActionListener {

	ListModel listModel;
	JTextField textField;
	
	public AddToList(ListModel listModel, JTextField textField) {
		this.listModel = listModel;
		this.textField = textField;
	}

	@Override
	public void actionPerformed(ActionEvent e) { listModel.add(textField.getText()); }	
}

class RemoveFromList implements MouseListener {

	ListModel listModel;
	JList list;
	
	public RemoveFromList(ListModel listModel, JList list) {
		this.listModel = listModel;
		this.list = list;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.isAltDown()) {
			int index = list.getSelectedIndex();
			listModel.vector.remove(index);
		}	
	}

	@Override
	public void mouseEntered(MouseEvent arg0) { }

	@Override
	public void mouseExited(MouseEvent arg0) {	}

	@Override
	public void mousePressed(MouseEvent arg0) { }

	@Override
	public void mouseReleased(MouseEvent arg0) { }
	
}

public class Main {
	public static void main(String ... args) {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 400);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new BorderLayout());
	    String[] start = {"Możesz wpisać tekst na dole okna", "Żeby dodać wpisany tekst wciśnij enter", "Żeby usunąć wciśnij alt+klik" };
	    ListModel listModel = new ListModel(start);
		JList  list = new JList(listModel);
		JTextField textField = new JTextField();
		AddToList add = new AddToList(listModel, textField);
		textField.addActionListener(add);
		RemoveFromList remove = new RemoveFromList(listModel, list);
		list.addMouseListener(remove);
		JScrollPane scrollPane = new JScrollPane(list);
		panel.add(scrollPane);
		frame.add(textField,"South");
		frame.add(panel,"Center");
		frame.setVisible(true);  
	}

	
}