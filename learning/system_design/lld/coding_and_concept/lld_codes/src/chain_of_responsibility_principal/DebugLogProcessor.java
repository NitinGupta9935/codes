package chain_of_responsibility_principal;

public class DebugLogProcessor extends LogProcessor{
    public DebugLogProcessor(LogProcessor loggerProcessor) {
        super(loggerProcessor);
    }

    public void log(int logLevel, String message) {
        if (logLevel == DEBUG)
            System.out.println("DEBUG " + message);
        else
            super.log(logLevel, message);
    }

}
