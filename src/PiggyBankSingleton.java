/**
 * Piggy bank singleton class is used to put money into the piggy bank,
 * and then take the money whenever needed, by breaking the piggy bank.
 * <p>
 * This singleton class makes use of "double-checked locking" to
 * ensure that there is no issue caused during multi-threading.
 */
public class PiggyBankSingleton {
    /*  The volatile keyword ensures that multiple threads
        handle the singleInstance variable correctly when it
        is being initialized to the Singleton instance.  */
    private volatile static PiggyBankSingleton singleInstance;
    private Integer money = 0;

    /**
     * Private constructor to make sure that a new instance is
     * not created more than once.
     */
    private PiggyBankSingleton() {
    }

    /**
     * Unique instance.
     *
     * @return PiggyBankSingleton instance.
     */
    public static PiggyBankSingleton getInstance() {
        // Making use of "double-checked locking"
        if (singleInstance == null) {
            synchronized (PiggyBankSingleton.class) {
                if (singleInstance == null) {
                    singleInstance = new PiggyBankSingleton();
                }
            }
        }
        return singleInstance;
    }

    /**
     * Break the piggy bank and take the money.
     *
     * @return Any or no amount present in the piggy bank.
     */
    Integer breakAndTakeMoney() {
        if (money != 0) {
            int amount = money;
            money = 0;
            return amount;
        } else {
            return money;
        }
    }

    /**
     * Add money to the piggy bank.
     *
     * @param money Amount of money to be added.
     */
    void addMoney(Integer money) throws NegativeMoneyException {
        if (money < 0)
            throw new NegativeMoneyException();

        this.money += money;
    }
}
