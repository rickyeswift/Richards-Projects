/*
* Lab13.java
* this coded will process the file SoccerStats and create the file SoccerSummary
* Richard Elliott Jr
* 04/20/2022
* CMSC 255-902
 */
package Labs.Lab13;
import java.io.File;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;


public class Lab13 {

    public static void processFile(File inputFile, File outputFile) throws FileNotFoundException {
        // Scanner instance to read File in Java
        Scanner in = new Scanner(inputFile);

        // Get number of lines in file to create teams array
        int numLines = getLinesCountInFile(inputFile);

        // Team array to store teams info
        Team[] teams = new Team[numLines];

        int i = 0;
        // Read data from file row by row
        while (in.hasNextLine()) {
            // Read row
            String row = in.nextLine();

            // Create string array from row
            String[] arr = row.split(",");

            // Create Team object from data
            String teamName = arr[0];
            int numGoals = Integer.parseInt(arr[1]);
            double numShots = Double.parseDouble(arr[2]);

            // Add to teams array
            teams[i] = new Team(teamName, numGoals, numShots);

            i++;
        }

        // Close Scanner
        in.close();

        // Team with max and min goals
        Team maxTeam = getTeamWithMaxGoals(teams);
        Team minTeam = getTeamWithMinGoals(teams);

        // Create data to write to file
        String data = "Maximum goals Scored: " + maxTeam.getName() + " " + maxTeam.getNumGoals() + "\n"
                + "Minimum goals Scored: " + minTeam.getName() + " " + minTeam.getNumGoals() + "\n"
                + "Average shots per game: " + averageShotsPerGame(teams) + "\n";

        // Write data to the output file
        try (FileWriter fw = new FileWriter(outputFile)) {
            fw.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Calculates the number of lines in a file and returns it
     *
     * @param file
     * @return numLines
     */
    static int getLinesCountInFile(File file) throws FileNotFoundException {
        Scanner in = new Scanner(file);

        int numLines = 0;
        while (in.hasNextLine()) {
            numLines++;
            in.nextLine();
        }

        in.close();

        return numLines;
    }

    /**
     * Returns the team with max number of goals
     *
     * @param teams
     * @return maxTeam
     */
    static Team getTeamWithMaxGoals(Team[] teams) {
        // initialize max with first team
        Team maxTeam = teams[0];

        // find max
        for (int i = 1; i < teams.length; i++) {

            if (teams[i].getNumGoals() > maxTeam.getNumGoals()) {
                maxTeam = teams[i];
            }
        }

        return maxTeam;
    }

    /**
     * Returns the team with min number of goals
     *
     * @param teams
     * @return minTeam
     */
    static Team getTeamWithMinGoals(Team[] teams) {
        // initialize min with first team
        Team minTeam = teams[0];

        // find min
        for (int i = 1; i < teams.length; i++) {
            if (teams[i].getNumGoals() < minTeam.getNumGoals()) {
                minTeam = teams[i];
            }
        }

        return minTeam;
    }

    /**
     * Calculates the average shots per game and return it
     *
     * @param teams
     * @return
     */
    static double averageShotsPerGame(Team[] teams) {
        double sum = 0;

        for (int i = 0; i < teams.length; i++) {
            sum += teams[i].getNumShots();
        }

        return Math.round(sum / teams.length * 1000.0) / 1000.0;
    }

    public static void main(String[] args) {
        // Read filenames from command line arguments and create File Objects
        File inputFile = new File("SoccerStats.txt");
        File outputFile = new File("soccerSummary.txt");

        try {
            processFile(inputFile, outputFile);
        } catch (FileNotFoundException e) {
            System.out.println("Exception: " + e);
        }
    }
}