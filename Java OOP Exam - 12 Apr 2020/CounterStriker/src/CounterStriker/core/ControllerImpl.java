package CounterStriker.core;

import CounterStriker.common.ExceptionMessages;
import CounterStriker.common.OutputMessages;
import CounterStriker.models.field.Field;
import CounterStriker.models.field.FieldImpl;
import CounterStriker.models.guns.Gun;
import CounterStriker.models.guns.Pistol;
import CounterStriker.models.guns.Rifle;
import CounterStriker.models.players.Player;
import CounterStriker.models.players.Terrorist;
import CounterStriker.models.players.CounterTerrorist;
import CounterStriker.repositories.GunRepository;
import CounterStriker.repositories.PlayerRepository;

import java.util.Comparator;

public class ControllerImpl implements Controller{
    private GunRepository guns;
    private PlayerRepository players;
    private Field field;

    public ControllerImpl() {
        this.guns = new GunRepository();
        this.players = new PlayerRepository();
        this.field = new FieldImpl();
    }

    @Override
    public String addGun(String type, String name, int bulletsCount) {
        switch (type){
            case "Pistol":
                guns.add(new Pistol(name, bulletsCount));
                return String.format(OutputMessages.SUCCESSFULLY_ADDED_GUN, name);
            case "Rifle":
                guns.add(new Rifle(name, bulletsCount));
                return String.format(OutputMessages.SUCCESSFULLY_ADDED_GUN, name);
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_GUN_TYPE);
        }
    }

    @Override
    public String addPlayer(String type, String username, int health, int armor, String gunName) {

        Gun gun = guns.findByName(gunName);
        if (gun == null)
            throw new NullPointerException(ExceptionMessages.GUN_CANNOT_BE_FOUND);

        switch (type) {
            case "Terrorist":
                players.add(new Terrorist(username, health, armor, gun));
                return String.format(OutputMessages.SUCCESSFULLY_ADDED_PLAYER, username);
            case "CounterTerrorist":
                players.add(new CounterTerrorist(username, health, armor, gun));
                return String.format(OutputMessages.SUCCESSFULLY_ADDED_PLAYER, username);
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_PLAYER_TYPE);
        }
    }

    @Override
    public String startGame() {
        return field.start(players.getModels());
    }

    @Override
    public String report() {
        StringBuilder report = new StringBuilder();

        players.getModels()
                .stream()
                .sorted(Comparator.comparing(Player::getUsername))
                .sorted(Comparator.comparingInt(Player::getHealth))
                .sorted(Comparator.comparing(p -> p.getClass().getSimpleName()))
                .forEach(player -> report
                        .append(player.toString())
                        .append(System.lineSeparator())
                );

        return report.toString().trim();
    }
}
