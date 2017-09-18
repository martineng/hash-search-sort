package hashbasic;

import java.util.Scanner;
import java.util.Random;

public class HashBasicLauncher
{
    User theUser = new User();
    HashTable theHashTable = new HashTable();
    
    Scanner inputScanner = new Scanner(System.in);
    
    public void run()
    {
        homeMenu();
        requestHashTableSize();
        mainMenu();
        //populateData();
        //System.out.println("===================================");
        //displayHashTable();
    }
    
    public void homeMenu()
    {
        System.out.println("Welcome to the Hash Basic!");
        System.out.println("===================================");
        System.out.println("In this program, you will first request to create \n"
                         + "a hash table with your desire size.\n\n"
                         + "You will then required to enter a name for a user.\n"
                         + "The user digital address will be randomly generated.\n"
                         + "The program will then hash the address and insert to your table.\n");
        System.out.println("===================================");
    }
    
    public void requestHashTableSize()
    {
        int inputHashTableSize = 0;
        
        System.out.println("Please enter your the size of your hash table: (any integer number):");
        System.out.print("Enter:> ");
        inputHashTableSize = inputScanner.nextInt();
        theHashTable = new HashTable(inputHashTableSize);
        
        System.out.println("Your hash table has been created with size: " + theHashTable.getArraySize() + "\n");
    }
    
    public void requestUsername()
    {
        String inputUsername = "";
        
        System.out.println("Please enter a username:");
        inputUsername = inputScanner.next();
        theUser = new User(inputUsername);
    }
    
    public void generateUserAddress()
    {
        Random rand = new Random();
        int rndInt = rand.nextInt(899999);
        rndInt = rndInt + 100000;
        theUser.setAddress(rndInt);
        
        System.out.println("The user's address is: " + theUser.getAddress() + "\n");
    }
    
    public void populateData()
    {
        int selectionInt = 0;
        String selectionString = "N";
        
        do
        {
            requestUsername();
            generateUserAddress();
            theHashTable.insert(theUser);
            
            do
            {
                System.out.println("Would you like to create another user? (Y/N)");
                //System.out.println("Enter:>");
                selectionString = inputScanner.next();
                
                if (selectionString.equalsIgnoreCase("Y"))
                {
                    selectionInt = 1;
                }
                else if (selectionString.equalsIgnoreCase("N"))
                {
                    selectionInt = 0;
                }
                else // Invalid input
                {
                    System.out.println("\n!!! INVALID INPUT !!!\n");
                    selectionInt = -1;
                }
               
            } while (!(selectionString.equalsIgnoreCase("Y")) && !(selectionString.equalsIgnoreCase("N")));
            
        } while (selectionInt != 0);
    } // END populateData();
    
    public void displayHashTable()
    {
        for (int count = 0; count != theHashTable.getArraySize();count++)
        {
            if (theHashTable.getUser(count) == null)
            {
                System.out.println( (count+1) + ": ");
            }
            else
            {
                System.out.println((count+1) + ": " + theHashTable.getUser(count).getUsername() + 
                                   ", " + theHashTable.getUser(count).getAddress());
            }
        } 
    } // END displayHashTable()
    
    public void requestSearch()
    {
        theUser = new User();
        int inputAddress = 0;
        
        do
        {
            System.out.println("Please enter the address you would like to search: ");
            System.out.println("Enter:> ");
            inputAddress = inputScanner.nextInt();
            
            if (inputAddress < 100000 || inputAddress > 999999)
            {
                System.out.println("\n!!! INVALID INPUT !!!\n");
            }
        } while (inputAddress < 100000 || inputAddress > 999999);
        
        System.out.println("Searching for address: " + inputAddress + "...");
        
        theUser = theHashTable.find(inputAddress);
        
        if (theUser == null)
        {
            System.out.println("Not user found on address " + inputAddress + "!\n");
        }
        else
        {
            System.out.println("User " + theUser.getUsername() + " found on address " + inputAddress + "!\n");
        }
    } // END requestSearch()
    
    public void deleteData()
    {
        int inputAddress = 0;
        theUser = new User();
        
        do
        {
            System.out.println("Please enter the address of the user you would like to delete: ");
            System.out.println("Enter:> ");
            inputAddress = inputScanner.nextInt();
            
            if (inputAddress < 100000 || inputAddress > 999999)
            {
                System.out.println("\n!!! INVALID INPUT !!!\n");
            }
        } while(inputAddress < 100000 || inputAddress > 999999);
        
        theUser = theHashTable.delete(inputAddress);
        
        if (theUser == null)
        {
            System.out.println("No user found on address " + inputAddress + "!\n");
        }
        else
        {
            System.out.println(theUser.getUsername() + " on address " + inputAddress + " deleted!\n");
        }
        
    }
    
    public void mainMenu()
    {
        int selection = 0;
        
        do 
        {
            System.out.println("Please enter index number:");
            System.out.println("(1) - Create a User\n"
                             + "(2) - Delete a User\n"
                             + "(3) - Find a User\n"
                             + "(0) - Exit");
            System.out.println("Enter:> ");

            selection = inputScanner.nextInt();

            switch(selection)
            {
                case 1:
                    populateData();
                    break;
                case 2:
                    deleteData();
                    break;
                case 3:
                    requestSearch();
                    break;
                case 0:
                    break;
                default:
                    break;
            } // END SWITCH

            displayHashTable();
        } while (selection != 0);
        
    } // END mainMenu();
    
}
