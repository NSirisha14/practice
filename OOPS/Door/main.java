package OOPS.Door;

public class main {
    public static void main(String[] args)
    {
        lockDoor ld=new lockDoor(20,10,3,"Wood");
        ld.open();
        ld.close();
        ld.lock();
        ld.unLock();
    }
}
