/*
* Team.java
* this code uses an object to encapsulate the data values associated with a team.
* Richard Elliott Jr
* 04/20/2022
* CMSC 255-902
 */
package Labs.Lab13;

public class Team {
        // Instance Variables
        private String name;
        private int numGoals;
        private double numShots;

        /**
         * Default Constructor
         */
        Team() {
            this.name = "";
            this.numGoals = 0;
            this.numShots = 0;
        }

        /**
         * Parameterized Constructor
         *
         * @param name     name of the team
         * @param numGoals number of goals
         * @param numShots number of shots
         */
        Team(String name, int numGoals, double numShots) {
            this.name = name;
            this.numGoals = numGoals;
            this.numShots = numShots;
        }

        // Getters

        /**
         * Returns the name of the team
         *
         * @return name
         */
        String getName() {
            return name;
        }

        /**
         * Returns the number of goals of the team
         *
         * @return numGoals
         */
        int getNumGoals() {
            return numGoals;
        }

        /**
         * Returns the number of shots of the team
         *
         * @return numShots
         */
        double getNumShots() {
            return numShots;
        }

        // Setters

        /**
         * Sets the name of the team
         *
         * @param name
         */
        void setName(String name) {
            this.name = name;
        }

        /**
         * Sets the number of goals of the team
         *
         * @param numGoals
         */
        void setNumGoals(int numGoals) {
            this.numGoals = numGoals;
        }

        /**
         * Sets the number of goals of the team
         *
         * @param numShots
         */
        void setNumShots(double numShots) {
            this.numShots = numShots;
        }
    }
