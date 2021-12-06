import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/*	advent of code 2021 day 6 parts 1 and 2. 
 */


public class day06
{
	public static void main (String[] args) throws FileNotFoundException
	{
		//File inputFile = new File("input/input06test");	
		File inputFile = new File("input/input06");	
		Scanner input = new Scanner (inputFile);
		input.useDelimiter("[,\n]");

		ArrayList<Integer> nums = new ArrayList<Integer>();
		long[] fish = new long[9];

		while (input.hasNext()) 
		{
			int i = input.nextInt();
			nums.add(i);
			fish[i] ++;
			
		}
		for (int i = 0; i < 80; i++) 
		{
			int newFish = 0;
			for (int j = 0; j < nums.size(); j++) 
			{
				if (nums.get(j) > 0)
					nums.set(j, nums.get(j) - 1);
				else 
				{
					nums.set(j,  6);
					newFish++;
				}
			}
			for (int k =0; k<newFish;k++)
				nums.add(8);

		}
		System.out.println("pt1: "+nums.size());

		// oops i realised that bruteforcing it is dumb
		long [] newFish = new long[9];
		for (int i = 0; i < 256; i++)
		{
			newFish[6]= fish[0] + fish[7]; // fishes at 0 go back to 6
			newFish[0]= fish[1];
			newFish[1]= fish[2];
			newFish[2]=fish[3];
			newFish[3]=fish[4];
			newFish[4]=fish[5];
			newFish[5]=fish[6];
			newFish[7]=fish[8];
			newFish[8]= fish[0]; // fishes at 0 move add to fishes at 8
			fish = newFish.clone(); // THIS TOOK AN HOUR TO REALISE I NEEDED .CLONE()

		}
		long sum = 0;
		for (int i = 0; i < 9; i++)
			sum += fish[i];
		System.out.println("pt2: "+sum);
	}
}
