package CounterStriker.models.field;

import CounterStriker.models.players.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FieldImpl implements Field{
    List<Player> terrorists = new ArrayList<>();
    List<Player> counterTerrorists = new ArrayList<>();

    @Override
    public String start(Collection<Player> players) {
        for (Player player : players) {
            if (player.getClass().getSimpleName().equals("Terrorist"))
                terrorists.add(player);
            else if (player.getClass().getSimpleName().equals("CounterTerrorist"))
                counterTerrorists.add(player);
        }

        while (!haveTeamWithDeadPlayers(terrorists, counterTerrorists)){
            attack(terrorists, counterTerrorists);
            attack(counterTerrorists, terrorists);
        }

        return terrorists.stream().mapToInt(Player::getHealth).sum() > 0
                ? "Terrorist wins!"
                : "Counter Terrorist wins!";
    }

    private void attack(List<Player> attackers, List<Player> targets) {
        for (Player attacker : attackers) {
            if (attacker.isAlive()){
                for (Player target : targets) {
                    if (target.isAlive()) {
                        target.takeDamage(attacker.getGun().fire());
                    }
                }
            }
        }
    }

    private boolean haveTeamWithDeadPlayers(List<Player> terrorists, List<Player> counterTerrorists) {
        boolean areAllTerroristsDead = terrorists
                .stream()
                .mapToInt(Player::getHealth)
                .sum() <= 0;

        boolean areAllCounterTerroristsDead = counterTerrorists
                .stream()
                .mapToInt(Player::getHealth)
                .sum() <= 0;

        return areAllTerroristsDead || areAllCounterTerroristsDead;
    }
}
