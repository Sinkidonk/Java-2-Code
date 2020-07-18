/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalprojectdogrescue;

import java.util.Scanner;

/**
 *
 * @author apary
 */
public class UseDogRescue {
    public static void main(String[] args)
   {
      
      int dogs;
      int response = 0;
      double vetCost;
      double foodCost;
      String dogName;
      final int QUIT = 4;
      int iDogCount = 0;
      
      // Create new Dog object
      DogRescue aDog = new DogRescue();
            
      Scanner keyboard = new Scanner(System.in);
   
      while(response != QUIT)      
      {
         // Display Dog Rescue Menu
         DogRescue.displayMenu();
         
         // Ask user to enter a choice
         System.out.print("Select a menu item >> ");
         response = keyboard.nextInt();
         
         // Remove the enter key 
         keyboard.nextLine();
         
         switch (response)
         {
            case 1: // Add Dog
                  // Get Dog Name
                  System.out.print("Enter name of dog >> ");
                  dogName = keyboard.nextLine();
                  
                  // Extra Credit
                  if (dogName.length() == 0)
                  {
                     System.out.println("Dog name is required!");
                     break; 
                  }
                  
                  aDog.setDogName(iDogCount, dogName);
                  
                  // Get Food Cost
                  System.out.print("Enter the food cost >> ");
                  foodCost = keyboard.nextLong();
                  aDog.setFoodCost(iDogCount, foodCost);
                  
                  // Get Vet Cost
                  System.out.print("Enter the vet cost >> ");
                  vetCost = keyboard.nextLong();
                  aDog.setVetCost(iDogCount, vetCost);
                  
                  iDogCount = iDogCount + 1;
                  
                  break;
            case 2: // Display Dogs
                  displayDogs(aDog, iDogCount);
                  break;
            case 3: // Display Avg Cost
                  displayAvgCost(aDog, iDogCount);
                  break;
         } 
               
      }
      
   }
   
   public static void displayDogs(DogRescue aDog, int iDogCount)
   {

      System.out.println("****************");
      System.out.println("***** Dogs *****");
      System.out.println("****************");
      
      System.out.println("There are " + iDogCount + " dogs.");
      
      for (int i = 0; i < iDogCount; i++)
      {
         System.out.println("Dog Name: " + i + ". " + aDog.getDogName(i) );
      }
   }
   
   public static void displayAvgCost(DogRescue aDog, int iDogCount)
   {
      double totVetCost = 0;
      double totFoodCost = 0;      
      
      System.out.println("******************");
      System.out.println("** Average Cost **");
      System.out.println("******************");
      
      System.out.println("There are " + iDogCount + " dogs.");
      
      for (int i = 0; i < iDogCount; i++)
      {
         totVetCost = totVetCost + aDog.getVetCost(i);
         totFoodCost = totFoodCost + aDog.getFoodCost(i);
         
      }
      
      System.out.println("Avg Food Cost: $" + totFoodCost / iDogCount );
      System.out.println("Avg Vet Cost: $" + totVetCost / iDogCount );

   }

    
}
