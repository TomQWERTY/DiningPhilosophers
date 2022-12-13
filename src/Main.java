public class Main {
    public static void main(String[] args)
    {
        int philosophersCount = 5;
        boolean swapFixEnabled = false;
        Philosopher[] philosophers = new Philosopher[philosophersCount];
        Object[] forks = new Object[philosophersCount];
        for (int i = 0; i < philosophersCount; i++)
        {
            forks[i] = new Object();
        }
        for (int i = 0; i < philosophersCount - 1; i++)
        {
            Object leftFork = forks[i];
            Object rightFork = forks[(i + 1) % forks.length];
            philosophers[i] = new Philosopher(i + 1, leftFork, rightFork);
        }
        if (swapFixEnabled)
        {
            philosophers[4] = new Philosopher(5, forks[0], forks[4]);
        }
        else
        {
            philosophers[4] = new Philosopher(5, forks[4], forks[0]);
        }
        for (int i = 0; i < philosophersCount; i++)
        {
            philosophers[i].start();
        }
    }
}