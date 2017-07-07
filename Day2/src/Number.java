import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by petro on 7/6/17.
 */
public class Number {

    AtomicInteger i;

    public Number(AtomicInteger i){
        this.i = i;
    }

    public  int increment(){
        return i.incrementAndGet();
    }

    @Override
    public String toString() {
        return "Number{" +
                "i=" + i +
                '}';
    }
}
