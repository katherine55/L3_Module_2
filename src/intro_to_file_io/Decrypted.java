package intro_to_file_io;

public class Decrypted {

	String decrypt(String x) {
		String decoded = "";
		String[] numbers = x.split(" ");
		for(int i = 0; i < numbers.length; i++) {
			int ascii = Integer.parseInt(numbers[i]);
			decoded+= (char) ascii;
		}	
		System.out.println(decoded);
		return decoded;
	}
	
}
