package com.company;

import models.Player;
import models.Team;
import utils.DataReader;
import utils.InOutUtils;
import utils.LinkedList;
import utils.TaskUtils;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        File result = new File("Result.txt");
        if(result.exists()) {
            result.delete();
        }
        String filepathPlayers = "U21a.txt";
        String filepathTeams = "U21b.txt";
        LinkedList<Player> mainPlayers = new LinkedList<Player>();
        LinkedList<Team> mainTeams = new LinkedList<Team>();
        DataReader.readFromFilePlayer(filepathPlayers, mainPlayers);
        DataReader.readFromFileTeam(filepathTeams, mainTeams);


        //Task 1
        LinkedList<Player> forwardPosition = TaskUtils.copy(mainPlayers);
        LinkedList<Player> defenderPosition = TaskUtils.copy(mainPlayers);
        LinkedList<Player> midfielderPosition = TaskUtils.copy(mainPlayers);
        LinkedList<Player> goalkeeperPosition = TaskUtils.copy(mainPlayers);

        forwardPosition = TaskUtils.findSpecificPositionPlayers(forwardPosition, "Forward");
        defenderPosition = TaskUtils.findSpecificPositionPlayers(defenderPosition, "Defender");
        midfielderPosition = TaskUtils.findSpecificPositionPlayers(midfielderPosition, "Midfielder");
        goalkeeperPosition = TaskUtils.findSpecificPositionPlayers(goalkeeperPosition, "Goalkeeper");
        LinkedList<Player> forwardPlayers = TaskUtils.findSpecificPositionPlayers(mainPlayers, "Forward");

        forwardPosition.sort();
        defenderPosition.sort();
        midfielderPosition.sort();
        goalkeeperPosition.sort();

        InOutUtils.printPlayersToTxt(forwardPosition, result, "Forward Players");
        InOutUtils.printPlayersToTxt(defenderPosition, result, "Defender Players");
        InOutUtils.printPlayersToTxt(midfielderPosition, result, "Midfielder Players");
        InOutUtils.printPlayersToTxt(goalkeeperPosition, result, "Goalkeeper Players");
        InOutUtils.printPlayersToScreen(forwardPosition,"Forward Players");
        InOutUtils.printPlayersToScreen(defenderPosition,"Defender Players");
        InOutUtils.printPlayersToScreen(midfielderPosition, "Midfielder Players");
        InOutUtils.printPlayersToScreen(goalkeeperPosition, "Goalkeeper Players");

        //Task 2
        TaskUtils.scoreCount(mainTeams);
        LinkedList<Player> bestTeamPlayers = TaskUtils.bestTeamPlayers(mainPlayers, TaskUtils.findBestTeam(mainTeams));
        InOutUtils.printPlayersToTxt(bestTeamPlayers, result, "Best Team Players");
        InOutUtils.printPlayersToScreen(bestTeamPlayers, "Best Team Players");
    }
}