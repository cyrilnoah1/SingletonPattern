/**
 * Class containing the main method.
 */
public class MainClass {

    /**
     * Main method.
     *
     * @param args String arguments.
     */
    public static void main(String args[]) {
        // Piggy bank process.
        try {
            piggyBankProcess();
        } catch (NegativeMoneyException nME) {
            nME.printStackTrace();
        }
    }

    /**
     * Process of adding money to the piggy bank, and taking the
     * money whenever needed, by breaking the piggy bank.
     *
     * @throws Exception "Negative money cannot be added".
     */
    private static void piggyBankProcess() throws NegativeMoneyException {
        PiggyBankSingleton piggyBank = PiggyBankSingleton.getInstance();

        // TODO: Make the money adding process dynamic.
        // Adding money to the piggy bank.
        piggyBank.addMoney(100);
        piggyBank.addMoney(230);
        piggyBank.addMoney(5);

        // Breaking the piggy bank and taking the money.
        int money = piggyBank.breakAndTakeMoney();
        if (money == 0) {
            System.out.println("Broke my piggy bank and found no money! :'(");
        } else if (money == 1) {
            System.out.println("Broke my piggy bank and found only "
                    + money + " rupee.");
        } else {
            System.out.println("Broke my piggy bank and found "
                    + money + " rupees. Wohoo!");
        }
    }
}
