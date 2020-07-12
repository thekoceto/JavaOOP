package P05_FootballTeamGenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Teams teams = new Teams();
        StringBuilder report = new StringBuilder();

        String input;
        while (!"END".equals(input = reader.readLine())){
            String[] token = input.split(";");
            String teamName = token[1];
            switch (token[0]){
                case "Team":
                    teams.addTeam(teamName);
                    break;
                case "Add":
                    String playerName = token[2];
                    try {
                        teams.addPlayerToTeam(teamName, playerName,
                                Integer.parseInt(token[3]), Integer.parseInt(token[4]),
                                Integer.parseInt(token[5]), Integer.parseInt(token[6]),
                                Integer.parseInt(token[7]));
                    }catch (IllegalArgumentException ex) {
                        report.append(ex.getMessage()).append(System.lineSeparator());
                    }
                    break;
                case "Remove":
                    try{
                        teams.removePlayerFromTeam(teamName, token[2]);
                    }catch (IllegalArgumentException ex) {
                        report.append(ex.getMessage()).append(System.lineSeparator());
                    }
                    break;
                case "Rating":
                    try{
                        long rating = Math.round(teams.getRating(teamName));
                        report.append(teamName).append(" - ").append(rating);
                        report.append(System.lineSeparator());
                    }catch (IllegalArgumentException ex){
                        report.append(ex.getMessage()).append(System.lineSeparator());
                    }
                    break;
            }
        }
        System.out.print(report.toString().trim());
    }
}
