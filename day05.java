import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/*	advent of code 2021 day 5 parts 1 and 2. 
 */


public class day05
{
	public static void main (String[] args) throws FileNotFoundException
	{
		File inputFile = new File("input/input05");	

		Scanner input = new Scanner (inputFile);
		String line; 
		int[][] plot = new int[1000][1000];
		int[][] plot2 = new int[1000][1000]; // part 2
		while (input.hasNext()) {
			line = input.nextLine();
            int indexOfComma = line.indexOf(",");
            int indexOfSpace = line.indexOf(" ");
            int x1 = Integer.parseInt(line.substring(0, indexOfComma));
            int y1 = Integer.parseInt(line.substring(indexOfComma+1, indexOfSpace));
            indexOfSpace = line.indexOf(" ", indexOfSpace+1);
            indexOfComma = line.indexOf(",", indexOfComma+1);
            int x2 = Integer.parseInt(line.substring(indexOfSpace+1, indexOfComma));
            int y2 = Integer.parseInt(line.substring(indexOfComma+1, line.length()));

            if(x1 == x2){
                if(y1<y2){
                    for(int j = y1; j<=y2; j++){
                        plot[x1][j]+=1;
                        plot2[x1][j]+=1;
                    }
                }
                else{
                    for(int j = y2; j<=y1; j++){
                        plot[x1][j]+=1;
                        plot2[x1][j]+=1;
                    }
                }
            }
            else if(y1 == y2){
                if(x1<x2){
                    for(int j = x1; j<=x2; j++){
                        plot[j][y1]+=1;
                        plot2[j][y1]+=1;
                    }
                }
                else{
                    for(int j = x2; j<=x1; j++){
                        plot[j][y1]+=1;
                        plot2[j][y1]+=1;
                    }
                }
            }
			else{
                if(x1>x2&&y1>y2){
                    for(int j = x2; j<x1; j++){
                        for(int k = y2; k<=y1; k++){
                            plot2[j][k]+=1;
                            j++;
                        }
                    }
                }
                else if(x1>x2&&y1<y2){
                    for(int j = x2; j<x1; j++){
                        for(int k = y2; k>=y1; k--){
                            plot2[j][k]+=1;
                            j++;
                        }
                    }
                }
                else if(x1<x2&&y1>y2){
                    for(int j = x2; j>=x1; j--){
                        for(int k = y2; k<=y1; k++){
                            plot2[j][k]+=1;
                            j--;
                        }
                    }
                }
                else if(x1<x2&&y1<y2){
                    for(int j = x2; j>=x1; j--){
                        for(int k = y2; k>=y1; k--){
                            plot2[j][k]+=1;
                            j--;
                        }
                    }
                }
            }
        }
        int counter = 0;
		int counter2 = 0;
        for(int i = 0; i < 1000; i++) {
            for(int j = 0; j < 1000; j++) {
                if(plot[i][j] >=2){
                    counter++;
                }
				if (plot2[i][j] >=2){
					counter2++;
				}
            }
        }
        System.out.println("pt1: "+counter);
        System.out.println("pt2: "+counter2);


	}
}
