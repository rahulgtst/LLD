
// Bill Pugh Pattern
public class Main
{
	public static void main(String[] args) {
        Runnable task1 = () -> {
            Logger logger = Logger.getInstance();
            logger.info("Message from Thread A, instance: " + logger.hashCode());
        };

        Runnable task2 = () -> {
            Logger logger = Logger.getInstance();
            logger.info("Message from Thread B, instance: " + logger.hashCode());
        };

        Thread threadA = new Thread(task1);
        Thread threadB = new Thread(task2);

        threadA.start();
        threadB.start();
		return;
	}
}

class Logger {
    private Logger(){}
    
    private static class LoggerHelper {
        private static final Logger INSTANCE = new Logger();
    }
    
    public static Logger getInstance() {
        return LoggerHelper.INSTANCE;
    }
    
    public void info(String message) {
        System.out.println("INFO: "+ message);
    }
    
    public void error(String message) {
        System.out.println("ERROR: "+message);
    }
}
