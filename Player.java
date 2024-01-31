import java.util.*; 
public class Player
{
    private String name;
    private static int count = 0;
    private int balance;
    private ArrayList<String> properties;

    public Player()
    {
        count++;
        name = "Player " + count;
        balance = 1500;
        properties = new ArrayList<String>();
    }

    public Player(String n)
    {
        name = n;  
        balance = 1500;
        properties = new ArrayList<String>(); 
    }

    public String getName()
    {
        return name;
    }
    
    public int getBalance()
    {
        return balance;
    }

    public void subBalance(int n)
    {
        if (balance >= n)
        {
            balance -= n;
        }
        else 
        {
            System.out.println("Sorry, you don't have enough to make that payment.");   
        }
    }

    public void addBalance(int n)
    {
        balance += n;
    }

    public ArrayList<String> getProperties()
    {
        return properties;
    } 

    public void addProperty(String p)
    {
        properties.add(p);
    }

    public boolean checkProperty(String property)                          //?
    {
        for (int i = 0; i < properties.size(); i++)
        {
            if (properties.get(i).equalsIgnoreCase(property))
            {
                return true;
            }
        }
        return false;
    }

    public String property(String property)                              //?
    {
        for (int i = 0; i < properties.size(); i++)
        {
            if (properties.get(i).equalsIgnoreCase(property))
            {
                return properties.get(i);
            }
        }
        return "Not there";
    }

    public String lastBought()
    {
        return properties.get(properties.size()-1);
    }

    public int numPropertiesOwned()
    {
        int count = 0;
        for (int i = 0; i < properties.size(); i++)
        {
            count++;
        }
        return count;
    }

    public void remProperties(String p)
    {
        for (int i = 0; i < properties.size(); i++)
        {
            if(properties.get(i).equalsIgnoreCase(p))
            {
                properties.remove(i);
            }
        }
    }


    /*public void buyHouses(String property)
    {
        if (property.equalsIgnoreCase("Meditarreanean Avenue") || property.equalsIgnoreCase("Baltic Avenue"))
        {
            if (properties.checkProperty("Meditarreanean Avenue") == true && properties.checkProperty("Baltic Avenue") == true)
            {
                if(property.equalsIgnoreCase("Meditarreanean Avenue"))
                {
                    int mediHouses = 0;
                    if (houses > 3)
                    {
                        if (p.subBalance(50))
                        {
                            mediHouses++;
                        }
                    }
                    else 
                    {
                        System.out.println("Sorry, you can't buy anymore houses for this property. Try buying a hotel now.");
                    }
                }
                else if (property.equalsIgnoreCase("Baltic Avenue"))
                {
                    int balHouses = 0;
                    if (houses > 3)
                    {
                        balHouses++;
                    }
                }
                else 
                {
                    
                }
            }
            else 
            {
                System.out.println("Sorry you don't own all the properties in the color set.");    
            }
        }
        else if (property.equalsIgnoreCase("Oriental Avenue") || property.equalsIgnoreCase("Vermont Avenue") || property.equalsIgnoreCase("Connecticut Avenue"))
        {
            if (properties.checkProperty("Oriental Avenue") == true && properties.checkProperty("Vermont Avenue") == true && properties.checkProperty("Connecticut Avenue") == true)
            {

            }
            else 
            {
                System.out.println("Sorry you don't own all the properties in the color set.");    
            }
        }
        else if (property.equalsIgnoreCase("St. Cahrles Place") || property.equalsIgnoreCase("States Avenue") || property.equalsIgnoreCase("Virgnia Avenue"))
        {
            if (properties.checkProperty("St. Cahrles Place") && properties.checkProperty("States Avenue") && properties.checkProperty("Virgnia Avenue"))
            {

            }
            else 
            {
                System.out.println("Sorry you don't own all the properties in the color set.");    
            }
        }
        else if (property.equalsIgnoreCase("St. James Place") || property.equalsIgnoreCase("Tennessee Avenue") || property.equalsIgnoreCase("New York Avenue"))
        {
            if (properties.checkProperty("St. James Place") && properties.checkProperty("Tennessee Avenue") && properties.checkProperty("New York Avenue"))
            {

            }
            else 
            {
                System.out.println("Sorry you don't own all the properties in the color set.");    
            }
        }
        else if (property.equalsIgnoreCase("Kentucky Avenue") || property.equalsIgnoreCase("Indiana Avenue") || property.equalsIgnoreCase("Illinois Avenue"))
        {
            if (properties.checkProperty("Kentucky Avenue") && properties.checkProperty("Indiana Avenue") && properties.checkProperty("Illinois Avenue"))
            {

            }
            else 
            {
                System.out.println("Sorry you don't own all the properties in the color set.");    
            }
        }
        else if (property.equalsIgnoreCase("Atlantic Avenue") || property.equalsIgnoreCase("Ventnor Avenue") || property.equalsIgnoreCase("Marvin Gardens"))
        {
            if (properties.checkProperty("Atlantic Avenue") && properties.checkProperty("Ventnor Avenue") && properties.checkProperty("Marvin Gardens"))
            {

            }
            else 
            {
                System.out.println("Sorry you don't own all the properties in the color set.");    
            }
        }
        else if (property.equalsIgnoreCase("Pacific Avenue") || property.equalsIgnoreCase("North Carolina Avenue") || property.equalsIgnoreCase("Pennsylvania Avenue"))
        {
            if (properties.checkProperty("Pacific Avenue") && properties.checkProperty("North Carolina Avenue") && properties.checkProperty("Pennsylvania Avenue"))
            {

            }
            else 
            {
                System.out.println("Sorry you don't own all the properties in the color set.");    
            }
        }
        else if (property.equalsIgnoreCase("Park Place") || property.equalsIgnoreCase("Boardwalk"))
        {
            if (properties.checkProperty("Park Place") && properties.checkProperty("Boardwalk"))
            {

            }
            else 
            {
                System.out.println("Sorry you don't own all the properties in the color set.");    
            }
        }
    }

    public void giveMoney(Player one, Player two, int amount)
    {
        one.subBalance(amount);
        two.addBalance(amount);
        System.out.println("You have now paid " + two + " $" + amount + "\nYou now have $" + one.getBalance());
    }*/

    public String playerAssets(Player p)
    {
        return name + "\nBalance: $" + balance + "\nOwned Properties: " + properties;
    }

    public String toString()
    {
        return name;
    }
}