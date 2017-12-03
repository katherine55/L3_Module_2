package intro_to_file_io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;

public class Decrypted {

	public static void main(String[] args) {

		String fileName = "";
		JFileChooser jfc = new JFileChooser();
		int returnVal = jfc.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			fileName = jfc.getSelectedFile().getAbsolutePath();
			System.out.println(fileName);
		}

		Decrypted chuck = new Decrypted();
		chuck.decrypt(fileName);
	}

	String decrypt(String n) { // input: file name
		String x = null;
		String decoded = "";
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(n));
			x = br.readLine();
			br.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		decoded = "";
		String[] numbers = x.split(" ");
		for (int i = 0; i < numbers.length; i++) {
			int ascii = Integer.parseInt(numbers[i]);
			decoded += (char) ascii;
		}
		
		System.out.println(decoded);

		return decoded;
	}

}
