package P05_FootballTeamGenerator;

import java.util.ArrayList;
import java.util.List;

public class Team {
    //-	name: String
    //-	players: List<Player>
    private String name;
    private final List<Player> players;

    //+ Team (String)
    public Team(String name) {
        this.setName(name);
        this.players = new ArrayList<>();
    }

    //-	setName(String) : void
    private void setName(String name) {
        if (name == null || name.isEmpty())
            throw new IllegalArgumentException("A name should not be empty.");
        this.name = name;
    }

    //+	getName(): String
    public String getName() {
        return this.name;
    }

    //+	addPlayer(Player) : void
    public void addPlayer(Player player) {
        this.players.add(player);
    }

    //+	removePlayer(String) : void
    public void removePlayer(String playerName) {
        this.players.removeIf(player -> player.getName().equals(playerName));
    }

    public boolean findPlayer(String playerName) {
        return this.players
                .stream()
                .filter(player -> player.getName().equals(playerName))
                .findAny()
                .orElse(null) != null;

    }

    //+	getRating() : double
    public double getRating() {
        return players
                .stream()
                .mapToDouble(Player::overallSkillLevel)
                .sum()/players.size();
    }

}

//•	If you receive a command to remove a missing player, print "Player {Player name} is not in {Team name} team."
//•	If you receive a command to add a player to a missing team, print "Team {team name} does not exist."
//•	If you receive a command to show stats for a missing team, print "Team {team name} does not exist."