package stm;

/**
 * @author mishadoff
 */
public abstract class Context {
    abstract <T> T get(stm.Ref<T> ref);
}
