package intro_to_file_io;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

public class ToDoLists implements ActionListener {

	JFrame myFrame;
	JPanel myPanel;
	JButton button1;
	JButton button2;
	JButton button3;
	JButton button4;

	ArrayList<String> myList = new ArrayList<String>();

	public static void main(String[] args) {

		ToDoLists gary = new ToDoLists();
		gary.GUI();
	}

	void GUI() {
		myFrame = new JFrame();
		myPanel = new JPanel();
		button1 = new JButton("add task");
		button2 = new JButton("remove task");
		button3 = new JButton("save");
		button4 = new JButton("load");

		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		myPanel.add(button1);
		myPanel.add(button2);
		myPanel.add(button3);
		myPanel.add(button4);
		myFrame.add(myPanel);

		myFrame.pack();
		myFrame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(button1)) {
			String x = JOptionPane.showInputDialog("Task To Do:");
			myList.add(x);
			System.out.println(myList + "\n");
		}
		if (e.getSource().equals(button2)) {
			int i = Integer.parseInt(JOptionPane.showInputDialog("Check off a task: \n(ex. 1, 2, 3...)"));
			if (i >= 0 && i <= myList.size() - 1) {
				myList.remove(i - 1);
				System.out.println(myList + "\n");
			} else {
				System.out.println("Sorry, you must enter a valid task number");
			}

		}
		if (e.getSource().equals(button3)) {

			try {
				FileWriter fw = new FileWriter("src/intro_to_file_io/groceryList.txt");
				for (int i = 0; i < myList.size(); i++) {
				
				fw.write(myList.get(i) + "\n");
				}
				// The save button will save the current task list to a file.
				fw.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		}
		if (e.getSource().equals(button4)) {
			// The load button will load a new task list into the program and display it.
			try {
				BufferedReader br = new BufferedReader(new FileReader("src/intro_to_file_io/groceryList.txt"));
				
				String line = br.readLine();
				while(line != null){
					System.out.println(line);
					myList.add(line);
					line = br.readLine();
				}
				
				br.close();
			} catch (FileNotFoundException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}

		}

	}
}
