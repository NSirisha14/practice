package OOPS.Door;

public class lockDoor extends Door implements IlockDoor {



    lockDoor(double length,double breadth,double width,String material)
    {
        super(length,breadth,width,material);
    }

    @Override
    public void lock() {
        System.out.println("lock");
    }
    public void lock(String password) {
        System.out.println("lock with password");
    }
    @Override
    public void unLock() {
        System.out.println("unLock");
    }
    public void unLock(String password) {
        System.out.println("unLock with password");
    }
}
