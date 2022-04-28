package gUtilities;

public class GeneralUtility
{
	//----------------General Utility functions----------------------
		public static void fixedWait(int timeInSec)
		{
			try {
				Thread.sleep(timeInSec *1000); ////2 * 1000 = 2000 = 2 seconds
			} catch (InterruptedException e)
			{
				e.printStackTrace();
				//we can do any action here to resolve the error			
			} 
		}

}