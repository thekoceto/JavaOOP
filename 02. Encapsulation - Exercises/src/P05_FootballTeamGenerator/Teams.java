package P05_FootballTeamGenerator;

import java.util.ArrayList;

public class Teams {
    private ArrayList<Team> teams;

    public Teams() {
        this.teams = new ArrayList<>();
    }

    public void addTeam(String teamName){
        teams.add(new Team(teamName));
    }

    public void addPlayerToTeam (String teamName, String name, int endurance,
                                 int sprint, int dribble, int passing, int shooting) {
        Team team = findTeam(teamName);
        try {
            team.addPlayer(new Player(name, endurance, sprint, dribble, passing, shooting));
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
    }

    public void removePlayerFromTeam(String teamName, String playerName) {
        Team team = findTeam(teamName);
        if (team.findPlayer(playerName))
            team.removePlayer(playerName);
        else
            throw new IllegalArgumentException("Player " + playerName + " is not in " + teamName + " team.");
    }

    public double getRating(String teamName) {
        return findTeam(teamName).getRating();
    }

    private Team findTeam(String teamName) {
        Team team = teams
                .stream()
                .filter(t -> teamName.equals(t.getName()))
                .findAny()
                .orElse(null);
        if (team == null)
            throw new IllegalArgumentException("Team " + teamName+ " does not exist.");

        return team;
    }

}