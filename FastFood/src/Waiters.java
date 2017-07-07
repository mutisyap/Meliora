import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * Created by petro on 7/6/17.
 */
public class Waiters implements Runnable {

    Queue<Integer> queue = new LinkedList<Integer>();

    public Waiters(Queue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        while(true){



            Random rand = new Random();

            int sleepTime = rand.nextInt(1001) + 1000;

            synchronized (queue){
                if(queue.isEmpty()){
                    try {

                        System.err.println(Thread.currentThread().getName()+"|queue is empty - waiting |queue-size:"+this.queue.size());
                        queue.wait();
                    } catch (Exception e) {
                        System.err.println(Thread.currentThread().getName()+"|thread interrupted |queue-size:"+this.queue.size());
                        break;
                    }
                }
            }

            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                System.err.println(Thread.currentThread().getName()+"|thread interrupted |queue-size:"+this.queue.size());
                break;
            }

            if(!queue.isEmpty()){
                int value = queue.remove();
                System.err.println(Thread.currentThread().getName()+"|served customer: "+value+" |queue-size:"+this.queue.size());

            }

        }


    }
}
