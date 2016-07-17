class Count implements Runnable
{
   Thread mythread ;
   Count()
   { 
      mythread = new Thread(this, "my runnable thread");
      System.out.println("Thread 2 started");
      mythread.start();
   }
   public void run()
   {
      try
      {
        for (int i=0 ;i<20;i++)
        {
          System.out.println("Thread 2 count " + i);
          Thread.sleep(1000);
        }
     }
     catch(InterruptedException e)
     {
        System.out.println("thread 2 interrupted");
     }
     System.out.println("Thread 2's run is over" );
   }
}
class RunnableExample
{
    public static void main(String args[])
    {System.out.println("Thread 1 started");
       Count cnt = new Count();
       try
       {
          while(cnt.mythread.isAlive())
          {
            System.out.println("Thread 1"); 
            Thread.sleep(3000);
          }
       }
       catch(InterruptedException e)
       {
          System.out.println("thread 1 interrupted");
       }
       System.out.println("Thread 1's run is over" );
    }
}
