/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashbasic;

public class User
{
    int address;
    String username;
    
    // Contrusctors
    public User()
    {
        // EMPTY
    }
    
    public User(int inAddress)
    {
        setAddress(inAddress);
    }
    
    public User(String inString)
    {
        setUsername(inString);
    }
    
    public User(int inAddress, String inUsername)
    {
        setAddress(inAddress);
        setUsername(inUsername);
    }
    
    // Mutators
    public void setAddress(int inAddress)
    {
        address = inAddress;
    }
    
    public void setUsername(String inUsername)
    {
        username = inUsername;
    }
    
    // Accessors
    public int getAddress()
    {
     return address;   
    }
    
    public String getUsername()
    {
        return username;
    }
}
