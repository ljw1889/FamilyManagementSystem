package log;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;



public class EventLogger {
	FileHandler filehandler;
	LogManager logmanager;
	Logger logger; 
	//필드 
	public EventLogger(String fileName) { //생성자. 파일이름(파일)을 받으면, 바로 작성 할 수 있게
		try {
			logmanager = LogManager.getLogManager();
			logger = logmanager.getLogger(Logger.GLOBAL_LOGGER_NAME);
			filehandler = new FileHandler(fileName);
			logger.addHandler(filehandler);
			filehandler.setFormatter(new SimpleFormatter());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void log(String logMessage) {
		logger.info(logMessage);
	}
}
