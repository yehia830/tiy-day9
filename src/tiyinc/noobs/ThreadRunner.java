package tiyinc.noobs;
import tiyinc.noobs.SampleThread;

import java.text.*;
import java.time.Instant;
public class ThreadRunner {
    public static void main(String[] args) {
        System.out.println("ThreadRunner running");

        int numThreadsStarted = 0;
        DecimalFormat timerFormatter = new DecimalFormat("###,###");

        long startMillis = Instant.now().toEpochMilli();

        while (true) {
            System.out.println("Number of threads started = " + numThreadsStarted);
            SampleThread sampleCode = new SampleThread();
            Thread anotherActualThread = new Thread(sampleCode);
            //localThread.run();
            anotherActualThread.start();
            numThreadsStarted++;
            if (numThreadsStarted > 10) {
                break;
            }
        }

        long endMillis = Instant.now().toEpochMilli();

        System.out.println("Ran in " + timerFormatter.format(endMillis - startMillis) + " ms");

        System.out.println("ThreadRunner done!");
    }

}



