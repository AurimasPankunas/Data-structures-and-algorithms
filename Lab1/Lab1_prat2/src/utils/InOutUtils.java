package utils;

import models.Player;
import models.Team;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class InOutUtils {
    public static void printPlayersToTxt(LinkedList<Player> players, File fileName, String header)
    {
        try (FileWriter writer = new FileWriter(fileName, true))
        {
            writer.append(header).append("\n");
            writer.write("-".repeat( 145)+"\n");
            for (Player player : players)
            {
                writer.write(player.toString()+"\n");
            }
            writer.write("-".repeat( 145)+"\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void printPlayersToScreen(LinkedList<Player> players, String header) {
        System.out.print(header + "\n");
        System.out.print("-".repeat( 145)+"\n");
        for(Player player : players) {
            System.out.print(player.toString() + "\n");
        }
        System.out.print("-".repeat( 145)+"\n");
    }
}
