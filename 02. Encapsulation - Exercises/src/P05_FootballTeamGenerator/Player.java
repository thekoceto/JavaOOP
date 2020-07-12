package P05_FootballTeamGenerator;

public class Player {
    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
        this.setName(name);
        this.setEndurance(endurance);
        this.setSprint(sprint);
        this.setDribble(dribble);
        this.setPassing(passing);
        this.setShooting(shooting);
    }

    //-	setName(String) : void
    //•	A name cannot be null, empty or white space. If not, print "A name should not be empty."
    private void setName(String name) {
        if (name == null || name.isEmpty())
            throw new IllegalArgumentException("A name should not be empty.");
        this.name = name;
    }

    //+	getName(): String
    public String getName() {
        return this.name;
    }

    //•	Stats should be in the range 0..100. If not, print "{Stat name} should be between 0 and 100."
    //-	setEndurance (int) : void
    private void setEndurance(int endurance) {
        statValidator(endurance, "Endurance");
        this.endurance = endurance;
    }

    //-	setSprint (int) : void
    private void setSprint(int sprint) {
        statValidator(sprint, "Sprint");
        this.sprint = sprint;
    }

    //-	setDribble (int) : void
    private void setDribble(int dribble) {
        statValidator(dribble, "Dribble");
        this.dribble = dribble;
    }

    //-	setPassing (int) : void
    private void setPassing(int passing) {
        statValidator(passing, "Passing");
        this.passing = passing;
    }

    //-	setShooting (int) : void
    private void setShooting(int shooting) {
        statValidator(shooting, "Shooting");
        this.shooting = shooting;
    }

    //+	overallSkillLevel() : double
    public double overallSkillLevel(){
        return (this.dribble + this.endurance + this.passing + this.shooting + this.sprint)/5d;
    }

    private void statValidator (int stat, String statName){
        if (stat < 0 || stat > 100)
            throw new IllegalArgumentException(statName + " should be between 0 and 100.");
    }
}