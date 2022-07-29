package com.tunbobo.HashMap;

import java.util.ArrayList;
import java.util.HashMap;

public class HashMapDemo{

//        public void add() {
//            System.out.println("Add");
//        }

        public static String add(ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
        // Write your code here.
        // map to store the resultes -> compare score

        //1. Create a hashmap to store results : name of team, score
            HashMap<String,Integer> mapOfResults = new HashMap<String,Integer>();
            // set round before loop
            int round = 1;

        //2.create mapping relations between team and score
        // 2.1 iterate the arrayList to add score into map
        for (ArrayList<String> competition : competitions) {
            //get team name from arrayList
            String homeTeam = competition.get(0);
            String awayTeam = competition.get(1);
            //set score into map -> *** whether need to initialize
            int scoreOfHomeTeam = 0;
            int scoreOfAwayTeam = 0;

            //check result to modify score

            if (results.get(round-1) == 0) {
                if (mapOfResults.get(awayTeam)!= null){
                    scoreOfAwayTeam = mapOfResults.get(awayTeam) + 3;
                    if(mapOfResults.get(homeTeam)!=null) {
                        scoreOfHomeTeam = mapOfResults.get(homeTeam);
                    }
                }
                else {
                    //if there is no element in map
                    scoreOfAwayTeam = 3;
                    if(mapOfResults.get(homeTeam)!=null) {
                        scoreOfHomeTeam = mapOfResults.get(homeTeam);
                    }
                }
                round++;
            }
            else{
                if(mapOfResults.get(homeTeam) != null) {
                    scoreOfHomeTeam = mapOfResults.get(homeTeam) +3;
                    if(mapOfResults.get(awayTeam)!=null) {
                        scoreOfAwayTeam = mapOfResults.get(awayTeam);
                    }
                }
                else {
                    scoreOfHomeTeam = 3;
                    if(mapOfResults.get(awayTeam)!=null) {
                        scoreOfAwayTeam = mapOfResults.get(awayTeam);};
                }
                round++;
            }

            //put result into map: team ,score
            mapOfResults.put(homeTeam,scoreOfHomeTeam);
            mapOfResults.put(awayTeam,scoreOfAwayTeam);

        }

        //3. check which key has the highest number
        //3.1 iterate a map
        //3.2 create a variable to renew the score
        int temp = 0;
        String winner = null;
        for (String team:mapOfResults.keySet()) {
            if (mapOfResults.get(team) > temp){
                temp = mapOfResults.get(team);
                winner = team;
            }
        }
        return winner;
    }


    public static String optimize(ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results){
            //create a map to store team and score
        HashMap<String,Integer> map = new HashMap<String,Integer>();

        //create a container to store the current highest score
        String highest = "";
        //initialize the round
        int round = 1;

        //after each competition, add the winner into the map, and its score
        for (ArrayList<String> competition : competitions) {
            //create winner and score to store data
            String winner;

            //iterate over the results
            int result = results.get(round-1);

            //use ? : to get the winner
            winner = result ==0? competition.get(1):competition.get(0);

            //put winner and score into a map, getOrDefault -> return the value or if the key x exist, return the default value
            map.put(winner,map.getOrDefault(winner,0)+3);

            //return the team with the highest score
            highest = map.getOrDefault(highest,0) > map.get(winner)? highest:winner;

            round++;
        }
            return highest;
    }


}




//problems:
//1.for each loop format -> iterate key of map -> for (Type collection :collections)
//2. add elements to map -> map.put(k,v)
//3. bug -> add score,should add to origin score ->
//4. overwrite the result each iteration : renew score to 0

// O(N) time com + O(k) time
//optimize -> reduce the need to iterate over a whole map, after iteration of the competition, return the result

