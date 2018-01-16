package section11.challenge;

import section11.generics.BaseballPlayer;
import section11.generics.FootballPlayer;
import section11.generics.SoccerPlayer;
import section11.generics.Team;

public class GenericsApp {

    // Create a generic class to implement a league table for a sport.
    // The class should allow teams to be added to the list, and store
    // a list of teams that belong to the league.
    //
    // Your class should have a method to print out the teams in order,
    // with the team at the top of the league printed first.
    //
    // Only teams of the same type should be added to any particular
    // instance of the league class - the program should fail to compile
    // if an attempt is made to add an incompatible team.

    public static void main(String[] args) {
        League<Team<FootballPlayer>> footballLeague = new League<>("AFL");
        Team<FootballPlayer> hawthorn = new Team<>("Hawthorne");
        Team<FootballPlayer> fremantle = new Team<>("Fremantle");
        Team<FootballPlayer> adelaideCrows = new Team<>("AdelaideCrows");
        Team<FootballPlayer> melbourne = new Team<>("Melbourne");

        footballLeague.add(adelaideCrows);
        footballLeague.add(fremantle);
        footballLeague.add(hawthorn);
        footballLeague.add(melbourne);

        hawthorn.matchResult(fremantle,1, 0);
        hawthorn.matchResult(adelaideCrows, 4, 8);
        adelaideCrows.matchResult(fremantle, 2, 1);

        footballLeague.showLeagueTable();

        BaseballPlayer pat = new BaseballPlayer("Pat");
        SoccerPlayer beckham = new SoccerPlayer("Beckham");

        Team<SoccerPlayer> rawTeam = new Team("Raw Team");
        rawTeam.addPlayer(beckham); // unchecked warning
        //rawTeam.addPlayer(pat); // uncheck warning

        //footballLeague.add(rawTeam); // unchecked warning

        League<Team<SoccerPlayer>> rawLeage = new League<>("raw");
        rawLeage.add(rawTeam); // no warning
        //rawLeage.add(adelaideCrows); // no warning


    }

}
