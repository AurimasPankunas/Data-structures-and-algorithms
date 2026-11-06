package utils;
import models.Team;
import models.Player;

import java.time.LocalDate;
import java.io.FileInputStream;
import java.util.Scanner;

public class DataReader {

    public static void readFromFilePlayer(String fileName, LinkedList<Player> players) {
        FileInputStream filestream = null;
        Scanner scanner = null;

        try {
            filestream = new FileInputStream(fileName);
            scanner = new Scanner(filestream, "UTF-8");
            while (scanner.hasNextLine()) {
                String[] lines = scanner.nextLine().split(",");
                players.push_back(new Player(lines[0], lines[1], lines[2], LocalDate.parse(lines[3]), Integer.parseInt(lines[4]), lines[5], Integer.parseInt(lines[6]), Integer.parseInt(lines[7])));
            }
            filestream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if(scanner != null) scanner.close();
        }
    }

    public static void readFromFileTeam(String fileName, LinkedList<Team> teams) {
        FileInputStream filestream = null;
        Scanner scanner = null;

        try {
            filestream = new FileInputStream(fileName);
            scanner = new Scanner(filestream, "UTF-8");
            while (scanner.hasNextLine()) {
                String[] lines = scanner.nextLine().split(",");
                teams.push_back(new Team(lines[0], Integer.parseInt(lines[1]), Integer.parseInt(lines[2]), Integer.parseInt(lines[3])));
            }
            filestream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if(scanner != null) scanner.close();
        }
    }
}
