public class Team {
    private String name;
    private String baseLocation;
    private String coachName;
    private Player[] players = new Player[18];
    private Player captain;

    public void addPlayer(Player player){
        for(int i =0; i< players.length;i++)
        {
            if(players[i] == null)
            {
                players[i] = player;
                System.out.println("Player add with success");
                return;
            }
        }
        System.out.println("Error: The team has already reached the max of 18 players");
    }
    public void removePlayer(Player player)
    {
        for(int i =0; i< players.length;i++)
        {
            if(players[i] == player && players[i] != null)
            {
                players[i] = null;
                System.out.println("Player removed with success");
                return;
            }
        }
        System.out.println("Error: player doesn't exist on the team");
    }
    public void substitute(Player substitute, Player starter)
    {
        boolean starterFound = false;
        boolean substituteFound = false;
        for (Player player : players) {
            if (player == starter)
                starterFound = true;
            if(player == substitute)
                substituteFound=true;

        }
        if(starterFound && substituteFound){
            starter.setFielded(false);
            substitute.setFielded(true);
            System.out.println("Player substituted with success");
        }
        else
            System.out.println("Error: One or both players doesn't exist on the team");


    }

    public void setCaptain(Player captain) {
        this.captain = captain;
    }

    public Player[] getFieldedPlayers()
    {
        int count=0;
        for (Player player : players) {
            if (player != null && player.isFielded())
                count++;
        }
        Player[] fieldedPlayers = new Player[count];
        int i = 0;
        for(Player player : players){
            if (player != null && player.isFielded()) {
                fieldedPlayers[i] = player;
                i++;
            }
        }
        return fieldedPlayers;

    }
    public Player[] getOutfieldedPlayers()
    {
        int count=0;
        for (Player player : players) {
            if (player != null && !player.isFielded())
                count++;
        }
        Player[] outfieldedPlayers = new Player[count];
        int i = 0;
        for(Player player : players){
            if (player != null && player.isFielded()) {
                outfieldedPlayers[i] = player;
                i++;
            }
        }
        return outfieldedPlayers;
    }
    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }
}
