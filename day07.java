import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/*	advent of code 2021 day 7 parts 1 and 2. 
 */


public class day07
{
	public static long pattern(int n) 
	{
		long sum = 0;
		for (int i = 1; i <= n; i++)
			sum += i;
		return sum;
	}
	public static void main (String[] args) throws FileNotFoundException
	{
		//File inputFile = new File("input/input07test");	
		File inputFile = new File("input/input07");	
		Scanner input = new Scanner (inputFile);
		input.useDelimiter("[,\n]");
		int[] crabs = new int[2000];

		while (input.hasNext()) 
			crabs[input.nextInt()] ++;
		long cheapest = 123456789;
		long cheapest2 = 1234567890;

		int max = 2000;
		for (int i = 0; i < max; i++)
		{
			int totalFuel = 0;
			long totalFuel2 = 0;
			for (int j = 0; j < max; j++ ) 
			{
				totalFuel += crabs[j] * Math.abs(j - i);
				totalFuel2 += crabs[j] * pattern(Math.abs(j-i)); 
			}
			if (totalFuel < cheapest)
				cheapest = totalFuel;
			if (totalFuel2 < cheapest2)
				cheapest2 = totalFuel2;
		}
		System.out.println("Pt1: "+cheapest);
		System.out.println("Pt2: "+cheapest2);

	}
}
