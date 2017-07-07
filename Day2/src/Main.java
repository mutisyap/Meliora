import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by petro on 7/6/17.
 */
public class Main {

    public static void main(String args[]) throws InterruptedException {

        Number integer = new Number(new AtomicInteger(0));

        System.out.println(integer);

        ExecutorService service = Executors.newFixedThreadPool(2);

        System.out.println("After service start");

        for(int i=0; i<5000; i++){
            service.submit(new Worker(integer));
        }



        System.out.println("After service scheduling");

        service.shutdown();
        Thread.currentThread().interrupt();
        //service.shutdown();

        System.out.println("After service shutdown");

        int y =0;
        while(true){

            if(service.isTerminated()){
                break;
            }

            System.out.println("Service is still running - integer "+(y++)+": "+integer);

            //Thread.sleep(1);

        }
    }
}
