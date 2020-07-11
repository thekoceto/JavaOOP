package P05_FootballTeamGenerator;

public class Player {
    //-	name: String
    //-	endurance:  int
    //-	sprint:  int
    //-	dribble: int
    //-	passing: int
    //-	shooting: int
    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    //+ 	Player (String, int, int, int, int, int)
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
        return name;
    }

    //•	Stats should be in the range 0..100. If not, print "{Stat name} should be between 0 and 100."
    //-	setEndurance (int) : void
    private void setEndurance(int endurance) {
        if (endurance < 0 || endurance > 100)
            throw new IllegalArgumentException("Endurance should be between 0 and 100.");
        this.endurance = endurance;
    }

    //-	setSprint (int) : void
    private void setSprint(int sprint) {
        if (sprint < 0 || sprint > 100)
            throw new IllegalArgumentException("Sprint should be between 0 and 100.");
        this.sprint = sprint;
    }

    //-	setDribble (int) : void
    private void setDribble(int dribble) {
        if (dribble < 0 || dribble > 100)
            throw new IllegalArgumentException("Dribble should be between 0 and 100.");
        this.dribble = dribble;
    }

    //-	setPassing (int) : void
    private void setPassing(int passing) {
        if (passing < 0 || passing > 100)
            throw new IllegalArgumentException("Passing should be between 0 and 100.");
        this.passing = passing;
    }

    //-	setShooting (int) : void
    private void setShooting(int shooting) {
        if (shooting < 0 || shooting > 100)
            throw new IllegalArgumentException("Dribble Shooting be between 0 and 100.");
        this.shooting = shooting;
    }

    //+	overallSkillLevel() : double
    public double overallSkillLevel(){
        return (this.dribble + this.endurance + this.passing + this.shooting + this.sprint)/5.0;
    }
}