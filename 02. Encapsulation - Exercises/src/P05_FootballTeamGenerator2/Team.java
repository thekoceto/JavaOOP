package P05_FootballTeamGenerator2;

import java.util.ArrayList;
import java.util.List;

class Team {
    private String name;
    private List<Player> players;
    private double ratting;

    public Team(String name){
        setName(name);
        this.players=new ArrayList<>();
        this.ratting=0;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if(name.isEmpty()){
            throw  new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    public void addPlayer(Player player){
        this.players.add(player);
    }

    public void removePlayer(Player player){
        if(!players.contains(player)){
            throw new IllegalArgumentException("Player " + player.getName() +" is not in " + this.name+" team.");
        }
        this.players.remove(player);
    }

    public void setRatting(){
        double currRating = 0d;
        for (Player player : this.players) {
            currRating += player.getOverallSkill();
        }
        if(currRating==0){
            this.ratting=currRating;
        }else {
            this.ratting = Math.round(currRating / players.size());
        }
    }

    public double getRatting(){
        return this.ratting;
    }
}