import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * Created by petro on 7/6/17.
 */

//Simulates how customers enter a queue
public class CustomerGenerator implements Runnable{

    Queue <Integer> q;

    public CustomerGenerator(Queue queue){
        this.q = queue;
    }

    @Override
    public void run() {

        while (true){
            Random rand = new Random();

            int sleepTime = rand.nextInt(3000);

            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            int  n = rand.nextInt(500) + 1;

            synchronized (this.q){
                this.q.add(n);
                this.q.notifyAll();
            }


            System.out.println(Thread.currentThread().getName()+"|added value to the queue: "+n+"|queue-size:"+this.q.size());
        }


    }
}
