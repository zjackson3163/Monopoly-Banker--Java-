import java.util.*;
public class Properties
{
    private ArrayList<String> properties;
    private ArrayList<Integer> propertiesCost; 

    public Properties()
    {
        properties = new ArrayList<String>();
        properties.add("Meditarreanean Avenue");
        properties.add("Baltic Avenue");

        properties.add("Oriental Avenue");
        properties.add("Vermont Avenue");
        properties.add("Conneticut Avenue");

        properties.add("St. Charles Place");
        properties.add("States Avenue");
        properties.add("Virginia Avenue");

        properties.add("St. James Place");
        properties.add("Tennessee Avenue");
        properties.add("New York Avenue");

        properties.add("Kentucky Avenue");
        properties.add("Indiana Avenue");
        properties.add("Illinois Avenue");

        properties.add("Atlantic Avenue");
        properties.add("Ventnor Avenue");
        properties.add("Marvin Gardens");

        properties.add("Pacific Avenue");
        properties.add("North Carolina Avenue");
        properties.add("Pennsylvania Avenue");

        properties.add("Park Place");
        properties.add("Boardwalk");

        properties.add("Reading Railroad");
        properties.add("Pennsylvania Railroad");
        properties.add("B&O. Railroad");
        properties.add("Short Line");

        properties.add("Electric Company");
        properties.add("Water Works");

        propertiesCost = new ArrayList<Integer>();
        propertiesCost.add(60); //medi
        propertiesCost.add(60); //baltic

        propertiesCost.add(100); //oriental
        propertiesCost.add(100); //vermont
        propertiesCost.add(120); //connet

        propertiesCost.add(140); //St. Charles
        propertiesCost.add(140); //States
        propertiesCost.add(160); //Virginia

        propertiesCost.add(180); //St.James
        propertiesCost.add(180); //Tennessee
        propertiesCost.add(200); //New York 

        propertiesCost.add(220); //Kentucky
        propertiesCost.add(220); //Indiana
        propertiesCost.add(240); //Illinois

        propertiesCost.add(260); //Atlantic
        propertiesCost.add(260); //Ventnor
        propertiesCost.add(280); //Marvin

        propertiesCost.add(300); //Pacific
        propertiesCost.add(300); //North Carolina
        propertiesCost.add(320); //Pennsylvania

        propertiesCost.add(350); //Park Place
        propertiesCost.add(400); //Boardwalk

        propertiesCost.add(200); //Reading
        propertiesCost.add(200); //Pennsylvania
        propertiesCost.add(200); //B&O
        propertiesCost.add(200); //Short

        propertiesCost.add(150); //Electric
        propertiesCost.add(150); //Water

    }

    public void addProperty(Player p, String pro)
    {
        for (int i = 0; i < properties.size(); i++)
        {
            if (pro.equalsIgnoreCase(properties.get(i)))
            {
                p.addProperty(properties.get(i));
                p.subBalance(propertiesCost.get(i));
                properties.remove(i);
                propertiesCost.remove(i);
                break; 
            }
        } 
        System.out.println("That's not a property. Try again? (Hint: Proper spelling is important!)");
    }  
}