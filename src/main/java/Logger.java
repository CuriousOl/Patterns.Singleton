import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Logger {
    protected int num = 1;

    private static Logger logger;

    private static Date date = new Date();

    private Logger() {
    }

    public static Logger getInstance() {
        if (logger == null) logger = new Logger();

        return logger;
    }

    public void log(String msg) {
        DateFormat df = new SimpleDateFormat("[dd.MM.yyyy HH:mm:ss " + num + "] ");

        System.out.println(df.format(date.getTime()) + msg);

        ++num;
    }
}
