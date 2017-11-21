package intro_to_file_io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class Encryption {

	void encrypt() throws IOException {
		String x = JOptionPane.showInputDialog("Encrypt a message:");
		String coded = "";
		for (int i = 0; i < x.length(); i++) {
			Character a = x.charAt(i);
			int ascii = (int) a;
			coded += ascii + " ";
		}
		PrintWriter out = new PrintWriter(new File("./src/intro_to_file_io/test.txt"));
		out.print(coded);
		out.close();
		//return coded;
	}

	public static void main(String[] args) throws IOException {
		Encryption pete = new Encryption();
		pete.encrypt();
	}
	
}
