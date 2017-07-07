/**
 * Created by petro on 7/6/17.
 */
public class HelloKenya extends Thread{
    public void run() {
        System.out.println("Hello Kenya. Am a thread");
    }

    public static void main (String args[]){
        (new HelloKenya()).start();
    }
}
