public class Philosopher extends Thread
{
    private Object leftFork;
    private Object rightFork;
    private int number;
    public Philosopher(int number_, Object leftFork_, Object rightFork_) {
        number = number_;
        leftFork = leftFork_;
        rightFork = rightFork_;
    }

    private void Think() throws InterruptedException {
        System.out.println("Philosopher " + number + " is thinking");
        //Thread.sleep((int)(Math.random() * 100));
        Thread.sleep(100);
    }

    private void PickUpFork(int forkNum) throws InterruptedException {
        System.out.println("Philosopher " + number +
                (forkNum == 1 ? " has picked up first fork" : " has picked up second fork and started eating"));
        Thread.sleep((int)(Math.random() * 100));
    }

    private void PutDownFork(int forkNum) throws InterruptedException {
        System.out.println("Philosopher " + number +
                (forkNum == 2 ? " has put down second fork" : " has put down first fork and started thinking"));
        Thread.sleep((int)(Math.random() * 100));
    }

    private void GetHungry() throws InterruptedException {
        System.out.println("Philosopher " + number + " got hungry");
    }

    @Override
    public void run() {
        try {
            while (true)
            {
                Think();
                GetHungry();
                synchronized (leftFork)
                {
                    PickUpFork(1);
                    synchronized (rightFork)
                    {
                        PickUpFork(2);
                        PutDownFork(2);
                    }
                    PutDownFork(1);
                }
            }
        } catch (InterruptedException e) { }
    }
}
