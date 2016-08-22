package tiyinc.noobs;

/**
 * Created by Yehia830 on 8/18/16.
 */
public class SampleThread implements Runnable {
    public void run() {
        System.out.println("Running " + Thread.currentThread().getId());

        try {
            Thread.sleep(2000);
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        System.out.println("Done running " + Thread.currentThread().getId());
    }
}
