package stm;

/**
 * @author mishadoff
 */
public final class STM {
    private STM() {}

    public static final Object commitLock = new Object();

    public static void transaction(TransactionBlock block) {
        //boolean committed = false;
        //while (!committed) {
        while (true) {
            try {
                Transaction tx = new Transaction();
                block.setTx(tx);
                block.run();
                tx.commit();
            } catch (CommitException ex) {
                continue;
            }
            break;
        }
    }

}
