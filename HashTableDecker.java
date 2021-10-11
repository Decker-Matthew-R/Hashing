import java.util.*;

public class HashTableDecker
{

   //Function to format table array when printed 
   public static void printArrayTable(int table[][])
    {
       int size = 50;
       System.out.println("");
       System.out.println("Index \tKey \t probes");
       System.out.println("--------------------------");
        
        for (int i = 0; i < table.length; i++) 
        {
            System.out.println("  " + i +  "\t\t" + table[i][0] + "\t\t" + table[i][1]);
        }
        
        System.out.println("-------------------------------");
        System.out.println("Sum of probe values = " + sumProbes(table, size) + " probes.");
   }

  
   public static int sumProbes(int table[][], int size)
   {
      //Sum of the number of probes in second col of the table
      int sum = 0;
      for(int i = 0; i< size; i++)
      {
         sum = sum + table[i][1];
      }
      return sum;
    }
   
   public static void HF1(int table [][], int keys[], int size)
   {
       //Iterate through the keys array
      for(int i = 0; i< size; i++)
      {
         int probes = 0;
         int d = keys[i] % size;
         
         //Insert in table if the index is available - no collision
         if(table[d][0] == -1)//meaning there is space, go ahead and place keys value into table
         {
           table[d][0] = keys[i];
           table[d][1] = probes;
         }
         else
         {
            //If collision, iterate through possible quadratic values computing new hash value
            //int probes = 0;
            for (int j = 0; j < size; j++)
            {
               probes++;
               int t = (d + j) % size;
               if(table[t][0] == -1)
               {
                  table[t][0] = keys[i];
                  table[t][1] = probes;
                  break;
                  //put the total of probes into the 2D Array here
               }
               //probes++;
              // table[t][1] = probes;
             }
          }
       }
        printArrayTable(table);
    }
   
   public static void HF2(int table [][], int keys[], int size)
   {
      //Iterate through the keys array
      for(int i = 0; i< size; i++)
      {
         int probes = 0;
         int d = keys[i] % size;
         
         //Insert in table if the index is available - no collision
         if(table[d][0] == -1)
         {
           table[d][0] = keys[i];
           table[d][1] = probes;
         }
         else
         {
            //If collision, iterate through possible quadratic values computing new hash value
            //int probes = 0;
            for (int j = 0; j < size; j++)
            {
               probes++;
               int t = (d + j*j) % size;
               if(table[t][0] == -1)
               {
                  table[t][0] = keys[i];
                  table[t][1] = probes;
                  break;
               }
             }
           }
        }
        printArrayTable(table);
      }

    
   public static void HF3(int table [][], int keys[], int size)
   {
      //Iterate through the keys array
      for(int i = 0; i< size; i++)
      {
         int probes = 0;
         int d = keys[i] % size;
   
        //Insert key in table if the index is available - no collision
         if(table[d][0] == -1)
         {
           table[d][0] = keys[i];
           table[d][1] = probes;
         }
         else
         {
            //Compute new hash value (double hash)
            for (int j = 1; j <= size; j++)
            {
               int r = (d + j * (30 - keys[i] % 25)) % size;
               probes++;
                  
               //check how many times key has been rehashed, if greater than 50, break
               if (probes == 51)
               {
                  System.out.println("Unable to store key " + keys[i] + " to the table.");
                  break;
                }
                 
                 //check if space available in table
                 if(table[r][0] == -1)
                 {
                     table[r][0] = keys[i];
                     table[r][1] = probes;
                     break;
                 }
                  
                  //check how many times key has been rehashed, if greater than 50, break
                  if (probes == size)
                  {
                     System.out.println("Unable to store key " + keys[i] + " to the table.");
                  }
               }
           }
        }
         printArrayTable(table);
    }

   public static void HF4(int table[][], int keys[], int size)
   {
      //Iterate through the keys array
      for(int i = 0; i< size; i++)
      {
         int probes = 0;
         int d = keys[i] % size;
   
        //Insert key in table if the index is available - no collision
         if(table[d][0] == -1)
         {
           table[d][0] = keys[i];
           table[d][1] = probes;
         }
         else
         {
            //Compute new hash value (double hash)
            for (int j = 1; j <= size; j++)
            {
               int r = (d + j * (35 - keys[i] % 35)) % size;
               probes++;
                  
               //check how many times key has been rehashed, if greater than 50, break
               if (probes == 51)
               {
                  System.out.println("Unable to store key " + keys[i] + " to the table.");
                  break;
                }
                 
                 //check if space available in table
                 if(table[r][0] == -1)
                 {
                     table[r][0] = keys[i];
                     table[r][1] = probes;
                     break;
                 }
                  
                  //check how many times key has been rehashed, if greater than 50, break
                  if (probes == size)
                  {
                     System.out.println("Unable to store key " + keys[i] + " to the table.");
                  }
               }
           }
        }
         printArrayTable(table);
    }

   public static void main (String[] args)
   {
	   //code to enter user input
	   Scanner input = new Scanner(System.in);
	   int answer;
      int rerun;
      int keys [] = {1234, 8234, 7867, 1009, 5438, 4312, 3420, 9487, 5418, 5299,
                 5078, 8239, 1208, 5098, 5195, 5329, 4543, 3344, 7698, 5412,
                 5567, 5672, 7934, 1254, 6091, 8732, 3095, 1975, 3843, 5589,
                 5439, 8907, 4097, 3096, 4310, 5298, 9156, 3895, 6673, 7871,
                 5787, 9289, 4553, 7822, 8755, 3398, 6774, 8289, 7665, 5523};
      int size = 50;
       
      //Initialize the hash table
      int table[][] = new int[size][2];
      for(int i = 0; i < size; i++)
      { 
         table[i][0] = -1;
      }
  
   do
   {
	   do
	   {
	      
         //Build main menu
		   System.out.println("-----------MAIN MENU-----------\r\n"
				+ "0 - Exit Program\r\n"
				+ "1 - Run HF1 (Division with Linear Probing)\r\n"
				+ "2 - Run HF2 (Division with Quadratic Probing)\r\n"
				+ "3 - Run HF3 (Division with Double Hashing)\r\n"
				+ "4 - Run HF4 (Student-Designed Function)\r\n");
		
		   //Allow user to input menu choice
         System.out.print("Please Select A Function: ");
		   answer = input.nextInt();
		
		   if (answer < 0 || answer > 4)
		   {
			   System.out.println("");
			   System.out.println("Invalid Entry");
		   }
         
         if (answer == 1)
         {
            System.out.println("Hash table resulted from HF1:");
            HF1(table, keys, size);
         }
      
         if (answer == 2)
         {
             System.out.println("Hash table resulting from HF2:");
             HF2(table, keys, size);
         }
         
         if (answer == 3)
         {
            System.out.println("Hash table resulting from HF3:");
            System.out.println("");
            HF3(table, keys, size);
         }
          
         if (answer == 4)
         {
            System.out.println("Hash table resulting from HF3:");
            HF4(table, keys, size);
         }
         
            //Space in code
	         System.out.println("");
	   
            // Prompt User to Retry
	         System.out.print("Press 1 to Rerun the Program or Press 0 To Terminate the Program: ");
            rerun = input.nextInt();
		      System.out.println("");
		
	   }
		   while (rerun != 0);
	
   }
    while (rerun != 0);
	{
	System.out.println(" ");
	System.out.println("Program Terminated! Have a Good Day!");
	}
		
	}
}
