package utils;

public class ThreadUtils {

	public static void sleep(int mlSecond) {
		try {
		Thread.sleep(mlSecond);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
}
