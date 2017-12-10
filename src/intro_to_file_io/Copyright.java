package intro_to_file_io;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Copyright {
	public static void main(String[] args) {
		String fileName = "";
		JFileChooser jfc = new JFileChooser();
		int returnVal = jfc.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			fileName = jfc.getSelectedFile().getAbsolutePath();
			System.out.println(fileName);
		}
		Copyright hey = new Copyright();
		hey.writeTo(fileName);
	}
	
	void writeTo (String x) {
		try {
			FileWriter fw = new FileWriter(x, true);
			
			
			
			
			
			
			
			
			
			
			
			
			fw.write("\n\n//Copyright © 2017 by katherine");
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
}
