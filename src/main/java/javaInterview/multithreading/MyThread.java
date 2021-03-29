package javaInterview.multithreading;

class MyThread extends Thread
{
    public static void main(String [] args) 
    {
        MyThread t = new MyThread(); /* Line 5 */
        t.run();  /* Line 6 */
    }

    public void run() 
    {
        for(int i=1; i < 3; ++i) 
        {
            System.out.print(i + "..");
        }
    }
}