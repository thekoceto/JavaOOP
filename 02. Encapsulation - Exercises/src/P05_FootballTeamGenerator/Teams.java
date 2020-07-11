package P05_FootballTeamGenerator;

import java.util.HashMap;

public class Teams {
    private HashMap<String, Team> teams;

    public Teams() {
        this.teams = new HashMap<>();
    }

    public void addTeam(String teamName){
        if (!this.teams.containsKey(teamName))
            teams.put(teamName, new Team(teamName));
    }

    public void addPlayerToTeam (String teamName, String name, int endurance,
                                 int sprint, int dribble, int passing, int shooting) {
        if (!teams.containsKey(teamName))
            throw new IllegalArgumentException("Team " + teamName + " does not exist.");

        try {
            Player player = new Player(name, endurance, sprint, dribble, passing, shooting);
            teams.get(teamName).addPlayer(player);
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
    }

    public void removePlayerFromTeam(String teamName, String playerName) {
        if (!teams.containsKey(teamName))
            throw new IllegalArgumentException("Team " + teamName+ " does not exist.");
        if (teams.get(teamName).findPlayer(playerName))
            teams.get(teamName).removePlayer(playerName);
        else
            throw new IllegalArgumentException("Player " + playerName + " is not in " + teamName + " team.");
    }

    public double getRating(String teamName) {
        return teams.get(teamName).getRating();
    }

}