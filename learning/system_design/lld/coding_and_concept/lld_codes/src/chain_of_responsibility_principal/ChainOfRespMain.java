package chain_of_responsibility_principal;

public class ChainOfRespMain {

    public static void main(String args[]) {

        int INFO = 1;
        int DEBUG = 2;
        int ERROR = 3;

        LogProcessor logger = new DebugLogProcessor(new ErrorLogProcessor(new InfoLogProcessor(null)));
        logger.log(ERROR, " Getting some error");
        logger.log(INFO, " This is message");
        logger.log(DEBUG, " I am debbuging the message");

    }
}
