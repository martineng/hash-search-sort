/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashbasic;

public class HashTable
{
    User[] userArray;
    int arraySize;
    User deletedUser;
    
    // Default Constructor
    public HashTable()
    {
        // empty
    }
    
    public HashTable(int inArraySize)
    {
        arraySize = inArraySize;
        userArray = new User[inArraySize];
        deletedUser = new User(-1);
    }
    
    public int getArraySize()
    {
        return arraySize;
    }
    
    public int hashFunction(int inAddress)
    {
        return inAddress % getArraySize();
    }
    
    // Inserting hashed user into the table
    public void insert(User inUser)
    {
        //Hashing the id
        int hashAddress = hashFunction(inUser.getAddress());
        
        while(userArray[hashAddress] != null &&
              userArray[hashAddress].getAddress() != -1)
        {
            ++hashAddress; // go to next
            hashAddress %= arraySize;
        }
        
        userArray[hashAddress] = inUser;
    } // END insert()
    
    // Delete an user
    public User delete(int inAddress)
    {
        int hashAddress = hashFunction(inAddress);
        
        // Loop through and find the user
        while(userArray[hashAddress] != null)
        {
            if (userArray[hashAddress].getAddress() == inAddress)
            {
                User tempUser = userArray[hashAddress];
                userArray[hashAddress] = deletedUser;
                return tempUser;
            } // END IF
            
            ++hashAddress;
            hashAddress %= arraySize;
        } // END WHILE
        
        return null; // No item found
    }
    
    public User find(int inAddress)
    {
        int hashAddress = hashFunction(inAddress);
        
        while(userArray[hashAddress] != null)
        {
            if (userArray[hashAddress].getAddress() == inAddress)
            {
                return userArray[hashAddress];
            } // END IF
            
            ++hashAddress;
            hashAddress %= arraySize;
        } // END WHILE
        
        return null; // No item found
    }
    
    public User getUser(int inPosition)
    {
        return userArray[inPosition];
    }
    
    
}
