/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalprojectdogrescue;

/**
 *
 * @author apary
 */
public class DogRescue {
   //private String dogName;
   //private double vetCost;
   //private double foodCost;
   private String[] myDogs = new String[100];
   private double[] myVet = new double[100];
   private double[] myFood = new double[100]; 
   
   public String getDogName(int number)
   {
      return myDogs[number];
   }
   public void setDogName(int number, String name)
   {
      myDogs[number] = name;
   }
   
   public double getVetCost(int number)
   {
      return myVet[number];
   }
   public void setVetCost(int number, double cost)
   {
      //vetCost = cost;
      myVet[number] = cost;
   }
   
   public double getFoodCost(int number)
   {
      return myFood[number];
   }
   public void setFoodCost(int number, double cost)
   {
      //foodCost = cost;
      myFood[number] = cost;
   }
   
   public static void displayMenu()
   {
      System.out.println("*********************");
      System.out.println("*** Dog Rescue Menu ***");
      System.out.println("*********************");
      System.out.println("1. Add Dog");
      System.out.println("2. Display Dogs");
      System.out.println("3. Display Avg Costs");
      System.out.println("4. Quit");
      System.out.println("-------------------");

   }
    
}
