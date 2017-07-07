import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by petro on 7/6/17.
 */
public class whoEatsWho {
    public static void main(String args[])
            throws InterruptedException {
        String importantInfo[] = {
                "Mares eat oats",
                "Does eat oats",
                "Little lambs eat ivy",
                "A kid will eat ivy too"
        };

        AtomicInteger i = new AtomicInteger();
        i.incrementAndGet()

        for (int i = 0;
             i < importantInfo.length;
             i++) {
            //Pause for 4 seconds
            Thread.sleep(4000);
            //Print a message
            System.out.println(importantInfo[i]);
        }
    }
}
