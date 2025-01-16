package chain_of_responsibility_principal;

public class ErrorLogProcessor extends LogProcessor{

    public ErrorLogProcessor(LogProcessor loggerProcessor) {
        super(loggerProcessor);
    }

    public void log(int logLevel, String message) {
        if (logLevel == ERROR)
            System.out.println("ERROR " + message);
        else
            super.log(logLevel, message);
    }
}




