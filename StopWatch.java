// Purpose: 
// This Class is the Stopwatch Class which 
// helps to identify the time Radix Sort uses
// Programmer: Carl Ashie Nikoi
// Date: Nov 2024

public class StopWatch {
    private long startTime;
    private long endTime;

    public void start() {
        startTime = System.nanoTime();
    }

    public void stop() {
        endTime = System.nanoTime();
    }

    public long getElapsedTime() {
        return (endTime - startTime) / 1000; 
    }
}