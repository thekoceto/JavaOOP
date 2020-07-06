package P05_JediGalaxy;

import P05_JediGalaxy.galaxy.Galactic;
import P05_JediGalaxy.galaxy.GalacticCluster;
import P05_JediGalaxy.galaxy.Player;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = readAnyToArray(scanner.nextLine());

        Galactic matrix = new Galactic(dimensions[0], dimensions[1]);
        GalacticCluster cluster = new GalacticCluster(matrix);
        Player player = new Player();

        String command;
        while (!"Let the Force be with you".equals(command = scanner.nextLine())) {
            int[] ivoS = readAnyToArray(command);
            int[] evil = readAnyToArray(scanner.nextLine());

            cluster.moveEvil(evil[0], evil[1]);

            int sum = cluster.movePlayer(ivoS[0], ivoS[1]);
            player.increaseScore(sum);
        }

        System.out.println(player.getScore());

    }

    private static int[] readAnyToArray(String s) {
        return Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
