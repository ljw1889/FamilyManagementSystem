package log;

public class loggerTester {

	public static void main(String[] args) {
		EventLogger logger = new EventLogger("log.txt");
		logger.log("test");
	}
}
