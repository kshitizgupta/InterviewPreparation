package javaInterview.multithreading;

class MyThread1 extends Thread
{
	MyThread1()
	{
		System.out.print(" MyThread");
	}
	public void run() 
	{
		System.out.print(" bar");
	}
	public void run(String s) 
	{
		System.out.println(" baz");
	}
}
class ThreadDemo1
{
	public static void main (String [] args) 
	{
		Thread t = new MyThread()
		{
			public void run()
			{
//				System.out.println(" foo");
			}
		};
		t.start();


		//

		System.out.print("1 ");
		synchronized(args)
		{
			System.out.print("2 ");
			try
			{
				args.wait(); /* Line 11 */
			}
			catch(InterruptedException e){ }
		}
		System.out.print("3 ");
	}
}