/**
 * Created by petro on 7/6/17.
 */
public class Worker implements Runnable {
    Number i;


    public Worker(Number i){
        this.i = i;
    }


    @Override
    public void run() {



        for(int x=0; x<100; x++){

            this.i.increment();

            //System.out.println(Thread.currentThread().getName()+"|"+this.i);
        }

    }
}
