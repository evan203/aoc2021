import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class day02
{
	public static void main (String[] args) throws FileNotFoundException
	{
		File inputFile = new File("input/input02");	

		// part 1:
		int depth = 0, hpos = 0;
		String dir;
		int amt;
		Scanner input = new Scanner(inputFile);
		while (input.hasNext())
		{
			dir = input.next();
			amt = input.nextInt();
			// System.out.println(dir+" "+amt);
			if (dir.equals("forward"))
				hpos+=amt;
			else if (dir.equals("down"))
				depth+=amt;
			else if (dir.equals("up"))
				depth-=amt;
			//System.out.println(depth+" "+amt);
		}
		System.out.println("pt 1: "+ depth*hpos);

		// part 2:
		input = new Scanner(inputFile);
		hpos = 0;
		depth = 0;
		int aim = 0;
		while (input.hasNext())
		{
			dir = input.next();
			amt = input.nextInt();
			if (dir.equals("forward"))
			{
				hpos+=amt;
				depth+=aim*amt;
			}
			else if (dir.equals("down"))
				aim+=amt;
			else if (dir.equals("up"))
				aim-=amt;
		}
		System.out.println("pt 2: " + depth*hpos);

	}
}
