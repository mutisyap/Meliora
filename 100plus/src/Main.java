import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by petro on 7/5/17.
 */
public class Main {
    public static  void main(String args[]){


        ExecutorService service  = Executors.newFixedThreadPool(50);

        System.out.println("Starting the job");

        for (int count = 1; count<=100; count++){
            service.submit(new ProductThread());
        }

        System.out.println("Scheduling finished");

        service.shutdown();

        System.out.println("Processing finished");

    }

}
