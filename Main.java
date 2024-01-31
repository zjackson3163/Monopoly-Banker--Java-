import java.util.*;
public class Main {

    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Welcome to the Monopoly Banker! This makes it easy to keep track of each players balance, properties, & other assets. Would you like to see common commands?: "); //small intro
        String answer = input.nextLine();
        if (answer.equalsIgnoreCase("yes")) //asks answer to wanting instuctions
        {
            System.out.println();
            System.out.println("Common Commands include... \nskip: this will skip a players turn (used if they are in jail) \nbuy: this will allow the player to buy property, houses, or hotels from the property manager and add it to their owned properties \npay: this will allow the player to pay the bank or pay/donate to another player \ntrade: this will allow the player to trade properties with another player");
            System.out.println("Okay! To begin...");
            System.out.println();

        }
        else 
        {
            System.out.println();
            System.out.println("Okay! To begin...");
            System.out.println();
        }
        ArrayList<Player> players = new ArrayList<Player>(); //creates array list of all players
        playerList(players); //call to players method (populates ArrayList)

        System.out.println("List of players: " + players);  //prints all players
        System.out.println();
        gameplay(players); //starts gameplay
    }

    public static void gameplay(ArrayList<Player> p)
    {
        Properties allProperties = new Properties();
        Scanner input = new Scanner(System.in); 
        int turn = 0; //keeps track of turns so each player gets one, then it restarts
        boolean finish = false; //end of game status
        while (!finish)
        {
            while (turn < p.size())
            {
                System.out.println(p.get(turn).playerAssets(p.get(turn))); //list all of current players assets
                System.out.print("What would you like to do for " + p.get(turn) + "'s turn?: ");
                String action = input.next();
                if (action.equalsIgnoreCase("skip")) //done
                {
                    System.out.println();
                    turn++;
                }
                else if (action.equalsIgnoreCase("buy"))
                {
                    System.out.print("What are you trying to buy?: ");
                    String buyAns = input.next();
                    if (buyAns.equalsIgnoreCase("property")) //done
                    {
                        int balanceb4 = p.get(turn).getBalance();
                        int propertiesOwned = p.get(turn).numPropertiesOwned();
                        System.out.print("What property are you buying?: ");
                        String property = input.nextLine();
                        property = input.nextLine();
                        allProperties.addProperty(p.get(turn), property);
                        if(propertiesOwned < p.get(turn).numPropertiesOwned())
                        {
                            System.out.println("You've bought \"" + p.get(turn).lastBought() + "\" for $" + (balanceb4 - p.get(turn).getBalance()) + ". You now have $" + p.get(turn).getBalance() +"."); 
                        }
                        else 
                        {
                            System.out.print("What property are you buying? (\"none\" if you give up): ");
                            property = input.nextLine();
                            if(property.equalsIgnoreCase("none"))
                            {
                                action = "";
                            }
                            else 
                            {
                                allProperties.addProperty(p.get(turn), property);   
                            }
                        }
                    }
                    else if (buyAns.equalsIgnoreCase("house"))
                    {
                        System.out.print("What property are you buying houses for?: ");
                    }
                    else if (buyAns.equalsIgnoreCase("hotel"))
                    {
                        System.out.print("What property are you buying hotels for?: ");
                    }
                }
                
                else if (action.equalsIgnoreCase("trade"))
                {
                    System.out.print("Who are you trading with: ");
                    String trade = input.next();
                    if (p.get(0).getName().equalsIgnoreCase(trade) || p.get(1).getName().equalsIgnoreCase(trade) || p.get(2).getName().equalsIgnoreCase(trade) || p.get(3).getName().equalsIgnoreCase(trade) || p.get(4).getName().equalsIgnoreCase(trade) || p.get(5).getName().equalsIgnoreCase(trade)) 
                    {
                        int index = 0;
                        for (int i = 0; i < p.size(); i++)
                        {
                            if (p.get(i).getName().equalsIgnoreCase(trade))
                            {
                                index = i;
                            }
                        }
                        System.out.print("What are you trading: ");
                        String trading = input.nextLine();
                        trading = input.nextLine();
                        if (trading.equalsIgnoreCase("property"))
                        {
                            System.out.print("Are you giving or taking?: ");
                            String giveOrTake = input.next();
                            if (giveOrTake.equalsIgnoreCase("taking"))
                            {
                                System.out.print("What property are you receiving?: ");
                                String property = input.nextLine();
                                property = input.nextLine();
                                if (p.get(index).checkProperty(property) == true)
                                {
                                    p.get(turn).addProperty(p.get(index).property(property));
                                    p.get(index).remProperties(property);
                                }
                                else 
                                {
                                    System.out.println("That's not a property. Try again? (Hint: Proper spelling is important!)");   
                                }
                            }
                            else if (giveOrTake.equalsIgnoreCase("giving"))
                            {
                                System.out.print("What property are you giving?: ");
                                String property = input.nextLine();
                                property = input.nextLine();
                                if (p.get(turn).checkProperty(property) == true)
                                {
                                    p.get(index).addProperty(p.get(turn).property(property));
                                    p.get(turn).remProperties(property);
                                }
                                else 
                                {
                                    System.out.println("That's not a property. Try again? (Hint: Proper spelling is important!)");   
                                }
                            }
                            else 
                            {
                                System.out.println("Sorry, that's not an option. (Hint: Type \"giving\" or \"taking\".)");    
                            }
                        }
                        else if (trading.equalsIgnoreCase("cards"))
                        {

                        }
                        else if (trading.equalsIgnoreCase("money"))
                        {
                            System.out.print("Are you giving or taking?: ");
                            String giveOrTake = input.next();
                            if (giveOrTake.equalsIgnoreCase("taking"))
                            {
                                System.out.println("How much?: ");
                                int amount = input.nextInt();
                                p.get(turn).addBalance(amount);
                                p.get(index).subBalance(amount);
                            }
                            else if (giveOrTake.equalsIgnoreCase("giving"))
                            {
                                System.out.println("How much?: ");
                                int amount = input.nextInt();
                                p.get(index).addBalance(amount);
                                p.get(turn).subBalance(amount);
                            }
                            else 
                            {
                                System.out.println("Sorry, that's not an option. (Hint: Type \"giving\" or \"taking\".)");
                            }
                        }
                        else 
                        {
                            System.out.println("Sorry, that's not something you can trade. Try Again?");
                        }
                    }
                    else 
                    {
                        System.out.println("Sorry, that's not someone you can trade with. Try again?");
                    }
                    System.out.println("Is that all that you are trading?: ");
                    String answer = input.next();
                    if (answer.equalsIgnoreCase("yes"))
                    {

                    }

                }
                else if (action.equalsIgnoreCase("pay")) //done
                {
                    int subtract;
                    System.out.print("Who are you paying? (if another player, make sure spelling is correct): ");
                    String pay = input.next();
                    if (pay.equalsIgnoreCase("bank"))
                    {   
                        System.out.print("How much are you paying?: ");
                        subtract = input.nextInt();
                        p.get(turn).subBalance(subtract);
                        System.out.println("You have paid the bank. You now have $" + p.get(turn).getBalance());
                    }
                    else if (p.get(0).getName().equalsIgnoreCase(pay) || p.get(1).getName().equalsIgnoreCase(pay) || p.get(2).getName().equalsIgnoreCase(pay) || p.get(3).getName().equalsIgnoreCase(pay) || p.get(4).getName().equalsIgnoreCase(pay) || p.get(5).getName().equalsIgnoreCase(pay)) 
                    {
                        int index = 0;
                        for (int i = 0; i < p.size(); i++)
                        {
                            if (p.get(i).getName().equalsIgnoreCase(pay))
                            {
                                index = i;
                            }
                        }
                        System.out.print("How much are you paying?: ");
                        subtract = input.nextInt();
                        //p.get(turn).giveMoney(p.get(turn), p.get(index), subtract);
                    }
                    else 
                    {
                        System.out.println("Sorry, that's not someone you can pay. Try again?");
                    }
                }
                else 
                {
                    System.out.println("Sorry, that's not an action available. Try again?");
                }
                
                if(action.equals("skip") == false) //done
                {
                    System.out.print("Is this the end of your turn?: ");
                        String endOfTurn = input.next();
                        if (endOfTurn.equalsIgnoreCase("yes"))
                        {
                            turn++;
                        }
                }
            }
            
            System.out.println();

            turn = 0;
            System.out.print("Is this the end of the game?: ");
            String fin = input.next();
            if (fin.equalsIgnoreCase("yes"))
            {
                finish = true;
            } 
            else 
            {
                finish = false;
            }
            System.out.println();
        }
    }

    

    public static void playerList(ArrayList<Player> p)
    {
        
        Scanner input = new Scanner(System.in);
        System.out.print("How many players are there?: ");
        int playerNum = input.nextInt();
        if (playerNum > 6)
        {
            System.out.println("Sorry, no more than 6 players can play.");

        }
        else if (playerNum <= 1)
        {
            System.out.println("Sorry, you have to have at least 2 players to play.");
        }

        else 
        {
            if (playerNum == 6)
            {
                System.out.print("Enter first player's name: ");
                Player player1 = new Player(input.next());
                p.add(player1);

                System.out.print("Enter second player's name: ");
                Player player2 = new Player(input.next());
                p.add(player2);

                System.out.print("Enter third player's name: ");
                Player player3 = new Player(input.next());
                p.add(player3);

                System.out.print("Enter fourth player's name: ");
                Player player4 = new Player(input.next());
                p.add(player4);

                System.out.print("Enter fifth player's name: ");
                Player player5 = new Player(input.next());
                p.add(player5);

                System.out.print("Enter sixth player's name: ");
                Player player6 = new Player(input.next());
                p.add(player6);
            }
            else if (playerNum == 5)
            {
                System.out.print("Enter first player's name: ");
                Player player1 = new Player(input.next());
                p.add(player1);

                System.out.print("Enter second player's name: ");
                Player player2 = new Player(input.next());
                p.add(player2);

                System.out.print("Enter third player's name: ");
                Player player3 = new Player(input.next());
                p.add(player3);

                System.out.print("Enter fourth player's name: ");
                Player player4 = new Player(input.next());
                p.add(player4);

                System.out.print("Enter fifth player's name: ");
                Player player5 = new Player(input.next());
                p.add(player5);
            }
            else if (playerNum == 4)
            {
                System.out.print("Enter first player's name: ");
                Player player1 = new Player(input.next());
                p.add(player1);

                System.out.print("Enter second player's name: ");
                Player player2 = new Player(input.next());
                p.add(player2);

                System.out.print("Enter third player's name: ");
                Player player3 = new Player(input.next());
                p.add(player3);

                System.out.print("Enter fourth player's name: ");
                Player player4 = new Player(input.next());
                p.add(player4);
            }
            else if (playerNum == 3)
            {
                System.out.print("Enter first player's name: ");
                Player player1 = new Player(input.next());
                p.add(player1);

                System.out.print("Enter second player's name: ");
                Player player2 = new Player(input.next());
                p.add(player2);

                System.out.print("Enter third player's name: ");
                Player player3 = new Player(input.next());
                p.add(player3);
            }
            else
            {
                System.out.print("Enter first player's name: ");
                Player player1 = new Player(input.next());
                p.add(player1);

                System.out.print("Enter second player's name: ");
                Player player2 = new Player(input.next());
                p.add(player2);
            }
        }

    }

}
