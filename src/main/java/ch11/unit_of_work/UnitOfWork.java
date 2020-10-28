package ch11.unit_of_work;

/**
 * 작업 단위
 */
public class UnitOfWork {
    private static ThreadLocal current = new ThreadLocal(); // 아니 제네릭 왜 안쓰냐?

    public static void newCurrent() {
        setCurrent(new UnitOfWork());
    }

    public static void setCurrent(UnitOfWork unitOfWork) {
        current.set(unitOfWork);
    }

    public static UnitOfWork getCurrent() {
        return (UnitOfWork) current.get();
    }

    public void registerNew(DomainObject domainObject) {

    }

    public void registerClean(DomainObject domainObject) {
    }

    public void registerDirty(DomainObject domainObject) {
    }

    public void registerRemoved(DomainObject domainObject) {
    }

    public void commit() {

    }
}
