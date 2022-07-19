
public class ThreadClass {

	public static void main(String[] args){
		NewThread nt = new NewThread();
		nt.t.start();
		try
		{
			for(int i = 0; i < 10; i++)
			{
				System.out.println("BMS College of Engineering");
				Thread.sleep(10000);
			}
		}
		catch(InterruptedException e)
		{
			System.out.println("Main thread Interruped");
		}
		
	}
	
}

class NewThread implements Runnable
{
	Thread t;
	NewThread()
	{
		t = new Thread(this, "Child Thread");
	}
	public void run()
	{
		try
		{
			for(int i = 1; i <=40; i++)
			{
				System.out.println("CSE");
				Thread.sleep(2000);
			}
		}
		catch(InterruptedException e)
		{
			System.out.println("Child Interrupted");
		}
	}
}
