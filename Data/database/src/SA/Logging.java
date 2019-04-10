package SA;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.logging.*;

public class Logging {

    public static void main(String args[]) throws IOException,SecurityException {

        //日志文件
        String  path = System.getProperty("user.dir");//获取项目绝对路径
        String logPath = path + "\\db_info.log";
        Logger log = Logger.getLogger(logPath);
        log.setLevel(Level.INFO);
        FileHandler fileHandler = new FileHandler(logPath,true);//true是以追加的形式
        fileHandler.setLevel(Level.INFO);
        fileHandler.setFormatter(new Formatter() {
            @Override
            public String format(LogRecord record) {
                Date date = new Date();
                String sDate = date.toString();
                return "[" + sDate + "]" + "[" + record.getLevel() + "]"
                        + record.getMessage() + "\n";
            }
        });
        log.addHandler(fileHandler);
        log.info("Order：");
        fileHandler.close();
    }
}
