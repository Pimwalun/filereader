package stopwatch;

import java.io.*;

public class AppendingStringTask implements Runnable {

	private String filename;
	private int size;

	public AppendingStringTask(String filename) {
		this.filename = filename;
	}

	public static String readFileToString(String filename) {
		InputStream in = null;
		InputStreamReader reader = null;
		// create String for the data to read
		String data = "";
		try {
			// open the file
			in = new FileInputStream(filename);
			// read as characters
			reader = new InputStreamReader(in);
			// read the file
			int c;
			while (true) { // while((c=reader.read()) >= 0)
				c = reader.read();
				if (c < 0)
					break;
				data = data + (char) c;
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		// close the file
		if (reader != null)
			try {
				reader.close();
			} catch (IOException e) {
			}
		return data;
	}

	@Override
	public void run() {
		String string = readFileToString(filename);
		this.size = string.length();
	}

	@Override
	public String toString() {
		return String.format("Reading Alice-in-Wonderland.txt using FileReader, append to String.\nRead %,d chars ", this.size);
	}
}
