import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class day01
{
	public static void main (String[] args) throws FileNotFoundException
	{
		File inputFile = new File("input/input01");	

		// part 1:
		Scanner input = new Scanner(inputFile);
		int a = 0, b = input.nextInt();
		int inc = 0;
		while (input.hasNext())
		{
			a = b;
			b = input.nextInt();

			if (b > a)
				inc++;
			// System.out.println("a="+a+"b="+b+"inc="+inc);
		}
		System.out.println("Part 1: "+inc);
		inc = -1;// offset to -1 because for part2 you increase sum from 0 but
			 // that doesn't count

		// part 2:
		input = new Scanner(inputFile);
		a = 0;
		b = input.nextInt();
		int c = input.nextInt(); 
		int sum = 0;
		while (input.hasNext())
		{
			a = b;
			b = c;
			c = input.nextInt();
			if (a+b+c > sum)
				inc++;
			sum = a+b+c;
			// System.out.println(a+" "+b+" "+c+" "+sum+" "+inc);
		}
		System.out.println("Part 2: "+inc);
	}

}
