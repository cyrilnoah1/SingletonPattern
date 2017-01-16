/**
 * Class to throw an exception when negative money is added
 * to the piggy bank.
 */
public class NegativeMoneyException extends Throwable {

    /**
     * Default constructor with default message.
     */
    public NegativeMoneyException() {
        super("Negative money cannot be added");
    }

    /**
     * Constructor with user's custom error message.
     *
     * @param message Error message to be thrown.
     */
    public NegativeMoneyException(String message) {
        super(message);
    }
}
