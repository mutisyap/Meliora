import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by petro on 7/6/17.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        int time = 100; //Integer.parseInt(args[0]);
        Queue<Integer> queue = new LinkedList<>();
//        ExecutorService waiterService = Executors.newFixedThreadPool(20);
//        System.out.println("Waiters Created");

        Thread generatorThread = new Thread(new CustomerGenerator(queue),"generator-thread-1");
        generatorThread.start();

        Thread generatorThread2 = new Thread(new CustomerGenerator(queue),"generator-thread-2");
        generatorThread2.start();

        List<Thread> consumers = new ArrayList<>();
        int count = 3;

        System.out.println("Main thread is creating and starting waiter threads");
        for(int i=0;i<count;i++){
            Thread consumer = new Thread(new Waiters(queue),"waiter-thread-"+i);
            consumer.start();
            consumers.add(consumer);
        }


        while(true){
            Thread.sleep(3000);
            for(int i=0; i<count;i++){

                System.err.println("#|"+consumers.get(i).getName()+"|thread-state: "+consumers.get(i).getState());
            }
        }


//
//        System.out.println("Generator threads Created");

//        System.out.println("Main thread sleeping for 1 minute");

//        Thread.sleep(10000);
//        System.out.println("Main thread is back and about to interrupt generator threads");

//        generatorThread.interrupt();
//        generatorThread2.interrupt();
//
//        System.out.println("Main thread is back and about to interrupt waiter threads");
//
//        for(int i=0; i<count;i++){
//            consumers.get(i).interrupt();
//        }

//        System.out.println("Main thread finished interrupting generator threads");

//
//
//
//        int customer=1;
//        while (true){
//            //Customer generator
//            queue.add(customer);
//            ++customer;
//
//            //Server
//        }
//
//        for (int i = time; i >= 0; i--)
//            queue.add(i);
//
//        while (!queue.isEmpty()) {
//            System.out.println(queue.remove());
//            Thread.sleep(1000);
//        }
    }
}
