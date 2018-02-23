package stopwatch;

public class TaskTimer {
	
	/**
	 * Runs a task, measures and prints its running time to the console.
	 * @param runnable it's use call method in Runnable 
	 */
	public void measureAndPrint(Runnable runnable){
		Stopwatch timer = new Stopwatch();
		timer.start();
		runnable.run();
		timer.stop();
		System.out.print(runnable.toString());
		System.out.printf("in %f sec.\n", timer.getElapsed());
	}
}
