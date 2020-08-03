package viceCity.core;

import viceCity.common.ConstantMessages;
import viceCity.core.interfaces.Controller;
import viceCity.models.guns.Gun;
import viceCity.models.guns.Pistol;
import viceCity.models.guns.Rifle;
import viceCity.models.neighbourhood.GangNeighbourhood;
import viceCity.models.neighbourhood.Neighbourhood;
import viceCity.models.players.CivilPlayer;
import viceCity.models.players.MainPlayer;
import viceCity.models.players.Player;

import java.util.ArrayList;
import java.util.List;

public class ControllerImpl implements Controller {
    private final Player mainPlayer;
    private final List<Player> civilPlayers;
    private final List<Gun> guns;
    private final Neighbourhood neighbourhood;

    public ControllerImpl() {
        this.mainPlayer = new MainPlayer();
        this.civilPlayers = new ArrayList<>();
        this.guns = new ArrayList<>();
        this.neighbourhood = new GangNeighbourhood();
    }

    @Override
    public String addPlayer(String name) {
        civilPlayers.add(new CivilPlayer(name));
        return String.format(ConstantMessages.PLAYER_ADDED, name);
    }

    @Override
    public String addGun(String type, String name) {
        if (type.equals("Pistol")){
            guns.add(new Pistol(name));
            return String.format(ConstantMessages.GUN_ADDED,name, type);
        } else if (type.equals("Rifle")){
            guns.add(new Rifle(name));
            return String.format(ConstantMessages.GUN_ADDED,name, type);
        }
        return ConstantMessages.GUN_TYPE_INVALID;
    }

    @Override
    public String addGunToPlayer(String name) {
        Player civilPlayer = civilPlayers
                .stream()
                .filter(player -> player.getName().equals(name))
                .findFirst()
                .orElse(null);

        if (guns.isEmpty()) {
            return ConstantMessages.GUN_QUEUE_IS_EMPTY;
        }else  if (name.equals("Vercetti")){
            Gun gun = guns.remove(0);
            mainPlayer.getGunRepository().add(gun);
            return String.format(ConstantMessages.GUN_ADDED_TO_MAIN_PLAYER,
                    gun.getName(), "Tommy Vercetti");
        }else if (civilPlayer == null){
            return ConstantMessages.CIVIL_PLAYER_DOES_NOT_EXIST;
        }
        Gun gun = guns.remove(0);
        civilPlayer.getGunRepository().add(gun);
        return String.format(ConstantMessages.GUN_ADDED_TO_CIVIL_PLAYER,
                gun.getName(), civilPlayer.getName());
    }

    @Override
    public String fight() {
        this.neighbourhood.action(this.mainPlayer, this.civilPlayers);
        long deadCivilPlayers = this.civilPlayers
                .stream()
                .filter(player -> !player.isAlive())
                .count();

        if (this.mainPlayer.getLifePoints() == 100 && this.civilPlayers.stream().allMatch(player -> player.getLifePoints() == 50)) {
            return ConstantMessages.FIGHT_HOT_HAPPENED;
        } else {
            return  ConstantMessages.FIGHT_HAPPENED + System.lineSeparator()
                    + String.format(ConstantMessages.MAIN_PLAYER_LIVE_POINTS_MESSAGE, this.mainPlayer.getLifePoints())
                    + System.lineSeparator()
                    + String.format(ConstantMessages.MAIN_PLAYER_KILLED_CIVIL_PLAYERS_MESSAGE, deadCivilPlayers)
                    + System.lineSeparator()
                    + String.format(ConstantMessages.CIVIL_PLAYERS_LEFT_MESSAGE, this.civilPlayers.size() - deadCivilPlayers);
        }
    }
}
