package stopwatch;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * This class is task 3 : append lines to String by use BufferedReader.
 * @author Pimwalun Witchawanitchanun
 */
public class AppendingBufferReaderTask implements Runnable{
	
	private String filename;
	private int size;
	
	/**
	 * Initialize AppendBufferedReaderTask object.
	 * @param filename is value of the file input
	 */
	public AppendingBufferReaderTask(String filename) {
		this.filename = filename;
	}
	
	/**
	 * Read the file by using BufferedReader.
	 * @param filename is value of the file input
	 * @return the result as a string
	 */
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
	
	/**
	 * Call method readFileToBufferedReader() to read the file and keep amount of char length.
	 */
	@Override
	public void run() {
		String string = readFileToBufferedReader(filename);
		this.size = string.length();
	}
	
	/**
	 * Return that describes the task.
	 * @return that describes the task
	 */
	@Override
	public String toString() {
		return String.format("Reading Alice-in-Wonderland.txt using BufferedReader, append lines to String.\nRead %,d chars ", this.size);
	}
}
