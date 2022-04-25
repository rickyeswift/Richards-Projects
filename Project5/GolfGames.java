/*
 * Project 5 GolfGames
 * This code will run the numbers for each player of a golf game
 * It will determine the winner find the average score for each hole
 * It will find which players score's for each hole is below the average
 * And display the results to the user
 * Richard Elliott Jr
 * 03/31/2022
 * CMSC 255-902
 */
package Projects.Project5;

import java.util.Scanner;

public class GolfGames {
    /**
     * create a method to get names with commas between
     */
    public static String[] getNames(String inputStringNames) {
        // Create inputStringNames.split(",")
        String names[] = inputStringNames.split(",");
        return names;
    }

    /**
     * create a method to separate each score row <> and assign it to a hole number
     */
    public static int[][] getScores(String inputScoresString) {
        // Create inputScoreString.split("<>")
        String scoresString[] = inputScoresString.split("<>");
        // Assign each hole to the length of each score string
        int holes = scoresString.length;
        // Establish the scores to each player
        int numberOfPlayers = scoresString[0].split(",").length;
        int scores[][] = new int[holes][numberOfPlayers];
        // Create a for loop to count scores for each Hole
        for (int i = 0; i < holes; i++) {
            int individualScores[] = new int[numberOfPlayers];
            String individualScoresString[] = scoresString[i].split(",");

            for (int j = 0; j < numberOfPlayers; j++) {
                individualScores[j] = Integer.parseInt(individualScoresString[j]);
            }
            scores[i] = individualScores;
        }
        return scores;
    }

    /**
     * Create a method to establish the winner
     */
    public static String findWinner(String[] names, int[][] scores) {
        // Create an array to add up scores assign to player
        int[] addedScores = new int[names.length];
        // for loop to assign the scores to addedScores
        for (int i = 0; i < scores.length; i++) {
            for (int j = 0; j < scores[0].length; j++) {
                addedScores[j] += scores[i][j];
            }
        }
        // Make sure the score can't be less than zero
        int minimumTotalIndex = 0;
        for (int i = 0; i < addedScores.length; i++) {
            if (addedScores[i] < addedScores[minimumTotalIndex]) {
                minimumTotalIndex = i;
            }
        }
        return names[minimumTotalIndex];
    }

    /**
     * create a method to find the average for each Hole
     */
    public static double findAvgForHole(int[][] scores, int holeNum) {
        double total = 0;
        // Create a for loop to find the total sum of each player's score
        for (int i = 0; i < scores[0].length; i++) {
            total += scores[holeNum - 1][i];
        }
        // divide the total by the score length to get the average score
        return total / scores[0].length;
    }

    /**
     * create a method to find the player below the average
     */
    public static String[] searchPlayersBelowAvg(String names[], int[][] scores, int holeNum, double avgForHole) {
        int belowAvgPlayers = 0;
        // Create a for loop to compare player's average to the average score of a hole
        for (int i = 0; i < names.length; i++) {
            if (scores[holeNum - 1][i] < avgForHole) {
                belowAvgPlayers++;
            }
        }
        String[] result = new String[belowAvgPlayers];
        int index = 0;
        for (int i = 0; i < names.length; i++) {
            if (scores[holeNum - 1][i] < avgForHole) {
                result[index++] = names[i];
            }
        }
        return result;
    }

    /**
     * Main method
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //prompt user to enter names
        System.out.print("Enter names: ");
        String inputStringNames = sc.nextLine();
        // prompt user to enter scores
        System.out.print("Enter scores: ");
        String inputScoresString = sc.nextLine();
        // call getNames method
        String names[] = getNames(inputStringNames);
        // call getScores method
        int scores[][] = getScores(inputScoresString);
        // call findWinner method
        String winner = findWinner(names, scores);

        // prompt user to enter the hole number they want to see
        System.out.print("Enter hole number: ");
        int holeNumber = sc.nextInt();
        // get the average for the scores for each hole number
        double avgForHole = findAvgForHole(scores, holeNumber);
        // find the player with a below average score
        String[] playersBelowAverage = searchPlayersBelowAvg(names, scores, holeNumber, avgForHole);

        // print winner, average number on that hole, and the names of players below the average
        System.out.println("The winner is: " + winner);
        System.out.println("The average for Hole " + holeNumber + " is: " + avgForHole);
        System.out.print("The player below the average for Hole " + holeNumber + " are: ");

        // for loop to find the players below average
        for (int i = 0; i < playersBelowAverage.length; i++) {
            System.out.print(playersBelowAverage[i] + "");
        }
    }
}

