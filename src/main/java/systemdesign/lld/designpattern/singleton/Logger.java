package systemdesign.lld.designpattern.singleton;

/**
 * This is singleton logger class
 */
public class Logger {
    //Make logger object as static
    private static Logger logger;

    //make constructor private
    private Logger() {

    }

    public static Logger getLogger() {
        if (null == logger) {
            logger = new Logger();
        }
        return logger;
    }

    public void log(Object obj, String message) {
        System.out.println(obj.getClass().getSimpleName() + ": " + message);
    }
}
