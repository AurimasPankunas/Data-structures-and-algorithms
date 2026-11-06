package models;

public class Team implements Comparable<Team>
{
    public String teamName;
    public int playedGames;
    public int wonGames;
    public int drawnGames;
    public int scoreCount;

    public Team() {}
    public Team(String teamName, int playedGames, int wonGames, int drawnGames)
    {
        this.teamName = teamName;
        this.playedGames = playedGames;
        this.wonGames = wonGames;
        this.drawnGames = drawnGames;
        scoreCount = 0;
    }

    /// <summary>
    /// ToString override
    /// </summary>
    /// <returns>String format</returns>
    public String ToString()
    {
        return String.format("| {%s,15} | {%d,15} | {%d,15} | {%d,15} |", teamName, playedGames, wonGames, drawnGames);
    }

    /// <summary>
    /// Equals() method for Team class
    /// </summary>
    /// <param name="team"></param>
    /// <returns>Boolean</returns>
    /// <exception cref="Exception"></exception>

    public boolean equals(Team team) throws Exception {
        throw new Exception("Equals teams doesn't work");
    }

    /// <summary>
    /// CompareTo() method for Team class
    /// </summary>
    /// <param name="team"></param>
    /// <returns>Integer</returns>
    /// <exception cref="Exception"></exception>
    @Override
    public int compareTo(Team team) {
        return 1;
    }
}