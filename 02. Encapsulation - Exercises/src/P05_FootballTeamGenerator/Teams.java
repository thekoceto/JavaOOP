package P05_FootballTeamGenerator;

import java.util.HashMap;

public class Teams {
    private final HashMap<String, Team> teams;

    public Teams() {
        this.teams = new HashMap<>();
    }

    public void addTeam(String teamName){
        this.teams.put(teamName, new Team(teamName));
    }

    public void addPlayerToTeam (String teamName, String playerName, int endurance, int sprint,
                                 int dribble, int passing, int shooting) {

        doesTheTeamExist(teamName);

        try {
            this.teams.get(teamName).addPlayer(new Player(playerName, endurance, sprint, dribble, passing, shooting));
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
    }
    public void removePlayerFromTeam(String teamName, String playerName) {
        doesTheTeamExist(teamName);

        if (this.teams.get(teamName).findPlayer(playerName))
            this.teams.get(teamName).removePlayer(playerName);
        else
            throw new IllegalArgumentException("Player " + playerName + " is not in " + teamName + " team.");
    }

    public double getRating(String teamName) {
        doesTheTeamExist(teamName);
        return teams.get(teamName).getRating();
    }

    private void doesTheTeamExist(String teamName) {
        if (!teams.containsKey(teamName))
            throw new IllegalArgumentException("Team " + teamName + " does not exist.");
    }


}