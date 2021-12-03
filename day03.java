import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/*	advent of code 2021 day 3 parts 1 and 2. 
 *	this code is so god-awful and terribly done its embarassing
 */


public class day03
{
	public static void main (String[] args) throws FileNotFoundException
	{
		File inputFile = new File("input/input03");	

		// part 1:
		Scanner input = new Scanner(inputFile);
		String line;
		int[] totals = new int[12];
		while (input.hasNext())
		{
			line = input.next();
			// System.out.println("Line: " + line);
			for (int i = 0; i < line.length() ; i++)
			{
				//System.out.println(i);
				totals[i] += Character.getNumericValue(line.charAt(i));
			}
			//System.out.println(Arrays.toString(totals));
		}
		String gammaRateBinary = "";
		String eRB = "";
		for (int i : totals)
		{
			//System.out.println(i);
			gammaRateBinary += String.valueOf(Math.round((double)i/1000.00));
			//gammaRateBinary += String.valueOf(Math.round((double)i/12.00));
			eRB += String.valueOf(Math.abs(1 - (Math.round((double)i/1000.00))));
			//eRB += String.valueOf(Math.abs(1 - (Math.round((double)i/12.00))));
		}
		// String eRB = gammaRateBinary.replace('1','2').replace('0','1').replace('2','0');
		//System.out.println("gRB="+gammaRateBinary);
		//System.out.println("eRB="+eRB);
		int gammaRate = Integer.parseInt(gammaRateBinary, 2); // convert binary string to decimal
		//System.out.println("gammaRate="+gammaRate);
		int epsilonRate = Integer.parseInt(eRB, 2);
		//System.out.println("epsilonRate="+epsilonRate);
		System.out.println("pt 1: "+gammaRate*epsilonRate );

		// part 2:
		input = new Scanner(inputFile);

		int ogr = 0;

		String[] numbers = new String[1000]; // ew 
		int commonValue = Character.getNumericValue(gammaRateBinary.charAt(0));
		int numsLeft = 0; // numbers that start with whatever

		//System.out.println("numbers now must start with: "+commonValue+" at index 0.");
		for (int i = 0; input.hasNext(); i++)
		{ // clear list of values that don't start with commonValue
			line = input.next();
			if (Character.getNumericValue(line.charAt(0)) == commonValue )
			{
				numbers[i] = line;
				numsLeft++;
			}
			else
			{
				numbers[i] = "";
			}
		}
		//System.out.println("numsLeft = "+numsLeft);
		
		// for loop to do the rest:
		// i should be using recursion to do this
		for (int index = 1; index < 12; index++)
		{
			// figure out commonValue
			numsLeft = 0;
			double sum = 0;
			for (String str : numbers) 
			{
				if (str.equals("")) // if string is not blank, add (index) to sum
					;
				else
				{
					//System.out.println( Character.getNumericValue(str.charAt(index)));
					sum += Character.getNumericValue(str.charAt(index));
					numsLeft++;
					// System.out.print("sum="+sum+" ");
				}
			}
			commonValue = (int) Math.round(sum / numsLeft );
			// System.out.println ("commonValue="+commonValue+" ("+sum+"/"+numsLeft+")");
			// System.out.println("numbers now must start with: "+commonValue+" at index "+index);
			// remove numbers that dont start with commonValue
			for (int j = 0; j < 1000; j++) 
			{
				if (! numbers[j].equals(""))
				{
					if ( Character.getNumericValue(numbers[j].charAt(index)) == commonValue )
						ogr = Integer.parseInt(numbers[j],2);
					else
					{
						//System.out.println(str+"is invalid.");
						numbers[j] = "";
					}
				}
			}
		}
		// System.out.println("oxygen generator rating: " + ogr);

		// ----------------------co2 part -------------------
		int csr = 0; // CO2 scrubber rating
		input = new Scanner(inputFile);
		numbers = new String[1000]; // ew 
		commonValue = Character.getNumericValue(eRB.charAt(0));
		numsLeft = 0; // numbers that start with whatever

		for (int i = 0; input.hasNext(); i++)
		{ // clear list of values that don't start with commonValue
			line = input.next();
			if (Character.getNumericValue(line.charAt(0)) == commonValue )
			{
				numbers[i] = line;
				numsLeft++;
			}
			else
			{
				numbers[i] = "";
			}
		}
		
		for (int index = 1; index < 12; index++)
		{
			// figure out commonValue
			numsLeft = 0;
			double sum = 0;
			for (String str : numbers) 
			{
				if (str.equals("")) // if string is not blank, add (index) to sum
					;
				else
				{
					//System.out.println( Character.getNumericValue(str.charAt(index)));
					sum += Character.getNumericValue(str.charAt(index));
					numsLeft++;
					// System.out.print("sum="+sum+" ");
				}
			}
			commonValue = Math.abs(1 - (int) Math.round(sum / numsLeft ));
			for (int j = 0; j < 1000; j++) 
			{
				if (! numbers[j].equals(""))
				{
					if ( Character.getNumericValue(numbers[j].charAt(index)) == commonValue )
						csr = Integer.parseInt(numbers[j],2);
					else
					{
						numbers[j] = "";
					}
				}
			}
		}
		// System.out.println("CO2 scrubber rating: " + csr);

		System.out.println("pt 2: " + ogr*csr );
	}
}
