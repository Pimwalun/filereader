package stopwatch;

public class Main {
	/** 
	 * Creates the tasks and pass each task to the TaskTimer to compare the speed of time. 
	 */
	public static void main(String[] args){
		TaskTimer taskTimer = new TaskTimer();
		String filename = "./Alice in wonderland.txt";
		taskTimer.measureAndPrint(new AppendingStringTask(filename));
		taskTimer.measureAndPrint(new AppendingStringBuilder(filename));
		taskTimer.measureAndPrint(new AppendingBufferReader(filename));
	}
}
