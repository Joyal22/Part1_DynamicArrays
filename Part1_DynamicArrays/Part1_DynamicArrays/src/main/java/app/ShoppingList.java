package app;

import java.util.Scanner;

import utils.DynamicArrayList;

/**
 *
 * @author michelle
 */
public class ShoppingList {
    public static void main(String[] args) throws IllegalAccessException {
        //create an instance of DynamicArraylist to Store the shopping list
        DynamicArrayList ShoppingList = new DynamicArrayList();

        //create scanner object to read user input
boolean done = true;
    Scanner sc = new Scanner(System.in);
//asking user how many entires they want in their shopping list
System.out.println("how many entries would you like in your list ");
int entryNum = sc.nextInt();

//propmt the user to enter each entry and add it to shopping list

for(int i = 0; i<entryNum; i++){
    System.out.println("enter product "+ i+1 +" :");
    String product = sc.nextLine();
    ShoppingList.add(product);
}

//display the products in the shoping list

System.out.println("shopping list");
for(int i = 0;i<ShoppingList.Size();i++){
    System.out.println("product "+ (i+1 )+" :" + ShoppingList.get(i));
}
// Offer a menu of actions for the user to interact with the shopping list
while (done) {
    System.out.println("\nMenu:");
    System.out.println("1. Add item");
    System.out.println("2. Find item");
    System.out.println("3. Remove item");
    System.out.println("4. Show all items");
    System.out.println("5. Exit");

    System.out.print("Choose an action: ");
    int choice = sc.nextInt();
   

    switch (choice) {
        //using add methode adding a new item
        case 1:
            System.out.print("Enter item to add: ");
            String newItem = sc.nextLine();
            ShoppingList.add(newItem);
            System.out.println("Item added successfully.");
            break;

            //using index of methode finding an item
        case 2:
            System.out.print("Enter item to find: ");
            String itemtoFind = sc.nextLine();
            int position = ShoppingList.indexOf(itemtoFind);
            if (position != -1) {
                System.out.println("Item found at position " + (position + 1));
            } else {
                System.out.println("Item not found.");
            }
            break;
        case 3:
       // using remove methode removing an item
            System.out.print("Enter item to remove: ");
            String itemToRemove = sc.nextLine();
            boolean removed = ShoppingList.remove(itemToRemove);
            if (removed) {
                System.out.println("Item removed successfully.");
            } else {
                System.out.println("Item not found in the list.");
            }
            break;
        case 4:
        // using clone printing shoping list
            System.out.println("Shopping List:");
            for (int i = 0;i<ShoppingList.Size();i++)
           System.out.println((i+1)+":"+ShoppingList.clone());
           case 5:
               done= false;
           // Exit program
           System.out.println("Exiting program...");

           break;
       default:
           System.out.println("Invalid choice. Please choose a valid action.");
   

    }
}
    }
}
    


