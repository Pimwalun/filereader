package stopwatch;

public class Stopwatch {
	private static final double NANOSECOND = 1.0E-9;
	private long startTime;
	private long stopTime;
	private boolean running;

	public Stopwatch() {
		this.running = false;
	}

	public void start() {
		this.startTime = System.nanoTime();
		running = true;
	}

	public void stop() {
		this.stopTime = System.nanoTime();
		running = false;
	}

	public boolean isRunning() {
		return running;
	}

	public double getElapsed() {
		// No Magic in Code - "Code Complete"
		if (running)
			return (System.nanoTime() - startTime) * NANOSECOND;
		return (this.stopTime - this.startTime) * NANOSECOND;
	}
}
