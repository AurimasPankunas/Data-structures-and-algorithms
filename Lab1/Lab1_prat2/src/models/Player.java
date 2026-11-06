package models;
import java.time.LocalDate;
import java.util.Comparator;

public class Player implements Comparable<Player>
{
    public String teamName;
    public String name;
    public String surName;
    public LocalDate birthDate;
    public int height;
    public String position;
    public int playedGames;
    public int goals;

    public Player(String teamName, String name, String surName, LocalDate birthDate, int height, String position, int playedGames, int goals)
    {
        this.teamName = teamName;
        this.name = name;
        this.surName = surName;
        this.birthDate = birthDate;
        this.height = height;
        this.position = position;
        this.playedGames = playedGames;
        this.goals = goals;
    }

    /// <summary>
    /// Public string override
    /// </summary>
    /// <returns>String format</
    @Override
    public String toString()
    {
        return String.format("| %15s | %15s | %15s | %15tF | %15d | %15s | %15d | %15d |", teamName, name, surName, birthDate, height, position, playedGames, goals);
    }

    /// <summary>
    /// CompareTo() method for Player class
    /// </summary>
    /// <param name="other"></param>
    /// <returns>Integer value</returns>

    @Override
    public int compareTo(Player other)
    {
        if (this.goals == other.goals)
        {
            return Integer.compare(this.playedGames, other.playedGames);
        }
        else
        {
            return Integer.compare(other.goals, this.goals);
        }
    }

    /// <summary>
    /// Equals() method for Player class
    /// </summary>
    /// <param name="player"></param>
    /// <returns>Boolean</returns>
    public boolean Equals(Player player)
    {
        return this.goals == player.goals;
    }
}