import org.apache.log4j.Logger;
import java.io.IOException;
import java.sql.SQLException;
//import java.util.logging.Logger;

/**
 * Created by petro on 7/7/17.
 */
public class LogSample {
    /* Get actual class name to be printed on */
    static Logger log = Logger.getLogger(LogSample.class.getName());

    public static void main(String[] args)throws IOException,SQLException {
        log.debug("Hello this is a debug message");
        log.info("Hello this is an info message");
    }
}
