package stopwatch;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * This class is task 2 : append chars to a StringBuilder.
 * @author Pimwalun Witchawanitchanun
 */
public class AppendingStringBuilderTask implements Runnable {

	private String filename;
	private int size;

	/**
	 * Initialize AppendStringBuilderTask object.
	 * @param filename is value of the input
	 */
	public AppendingStringBuilderTask(String filename) {
		this.filename = filename;
	}

	/**
	 * Read the file by using StringBuilder.
	 * @param filename is value of the file input
	 * @return the result as a string
	 */
	public static String readFileToStringBuilder(String filename) {
		// create a string for the data to read
		StringBuilder data = new StringBuilder();
		InputStream in = null;
		InputStreamReader reader = null;
		try {
			// open the file
			in = new FileInputStream(filename);
			// read as characters, so what to do?
			reader = new InputStreamReader(in);
			// read the file
			int c;
			while (true) { // while((c=reader.read()) >= 0) it same thing
				c = reader.read();
				if (c < 0)
					break;
				data.append((char) c);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		// close the file
		if (reader != null) {
			try {
				reader.close();
			} catch (IOException e) {
				// ignore it
			}
		}
		return data.toString();
	}

	/**
	 * Call method readFileToStringBuilder() to read the file and keep amount of char length.
	 */
	@Override
	public void run() {
		String string = readFileToStringBuilder(filename);
		this.size = string.length();
	}

	/**
	 * Return that describes the task.
	 * @return that describes the task
	 */
	@Override
	public String toString() {
		return String.format("Reading Alice-in-Wonderland.txt using FileReader, append to StringBuilder.\nRead %,d chars ", this.size);
	}
}
