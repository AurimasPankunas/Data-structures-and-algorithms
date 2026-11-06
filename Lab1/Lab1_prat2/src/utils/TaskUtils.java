package utils;
import models.Player;
import models.Team;

public class TaskUtils {
    public static LinkedList<Player> findSpecificPositionPlayers(LinkedList<Player> players, String position)
    {
        LinkedList<Player> specificPositionPlayers = new LinkedList<Player>();
        for(Player player : players)
        {
            if (player.position.equals(position))
            {
                specificPositionPlayers.push_back(player);
            }
        }

        return specificPositionPlayers;
    }

    public static LinkedList<Player> copy(LinkedList<Player> players)
    {
        LinkedList<Player> copyPlayers = new LinkedList<Player>();
        for (Player player : players)
        {
            copyPlayers.push_back(player);
        }
        return copyPlayers;
    }

    public static void scoreCount(LinkedList<Team> teams)
    {
        for (Team team : teams)
        {
            team.scoreCount += team.wonGames * 3 + team.drawnGames;
        }
    }

    public static String findBestTeam(LinkedList<Team> teams)
    {
        String bestTeam = "";
        int maxScore = 0;
        for (Team team : teams)
        {
            if (team.scoreCount > maxScore)
            {
                maxScore = team.scoreCount;
                bestTeam = team.teamName;
            }
        }
        return bestTeam;
    }

    public static LinkedList<Player> bestTeamPlayers(LinkedList<Player> players, String bestTeam)
    {
        LinkedList<Player> bestTeamPlayers = new LinkedList<Player>();
        for (Player player : players)
        {
            if (player.teamName.equals(bestTeam))
            {
                bestTeamPlayers.push_back(player);
            }
        }
        return bestTeamPlayers;
    }

    public static LinkedList<Player> foundPlayersByTeam(LinkedList<Player> players, String teamName)
    {
        LinkedList<Player> foundPlayers = new LinkedList<Player>();
        for (Player player : players)
        {
            if (player.teamName.equals(teamName))
            {
                foundPlayers.push_back(player);
            }
        }
        return foundPlayers;
    }
}
