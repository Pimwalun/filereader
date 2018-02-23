package stopwatch;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AppendingBufferReader implements Runnable{
	
	private String filename;
	private int size;
	
	public AppendingBufferReader(String filename) {
		this.filename = filename;
	}
	
	public static String readFileToBufferedReader(String filename) {
		// create a string for the data to read
		FileReader reader;
		BufferedReader br = null;
		String result = "";
		String line;
		try {
			reader = new FileReader(filename);
			br = new BufferedReader(reader);
			while ((line = br.readLine()) != null)
				result = result + line + '\n';
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		// close the file
		if (br != null)
			try {
				br.close();
			} catch (IOException e) {
				// ignore it
			}
		return result;
	}
	@Override
	public void run() {
		String string = readFileToBufferedReader(filename);
		this.size = string.length();
	}
	
	@Override
	public String toString() {
		return String.format("Reading Alice-in-Wonderland.txt using BufferedReader, append lines to String.\nRead %,d chars ", this.size);
	}
}
