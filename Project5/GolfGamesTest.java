package Projects.Project5;

import org.junit.Assert;
import org.junit.Test;

public class GolfGamesTest {




    private final int[][] givenScores = {{8,4,6,2,5},{9,8,7,5,2},{6,7,5,4,7},{4,5,9,5,3},{4,5,4,9,3},{5,3,7,8,9},{7,4,2,11,6},{4,8,3,5,1},{9,3,8,6,8}};
    private final String[] givenNames = {"Juan","Sophia","Omar","Andre","Emina"};

    private final int[][] unknownScores = {
            {5,3,4,5,3,5,5,4,4,4,4},
            {4,3,4,4,4,4,4,3,4,4,5},
            {4,4,5,4,5,5,5,4,4,4,4},
            {3,3,4,3,3,3,3,3,3,3,4},
            {4,4,6,5,4,4,5,5,5,4,4},
            {3,3,3,4,3,3,3,3,4,3,3},
            {4,4,3,4,4,5,3,4,6,4,4},
            {4,4,4,5,4,5,5,5,6,4,5},
            {3,4,4,3,4,4,5,4,4,4,4},
            {4,4,4,3,3,4,4,4,4,4,4},
            {4,4,4,4,4,5,4,5,4,4,5},
            {4,2,2,3,5,3,3,3,3,3,4},
            {4,5,4,4,3,4,4,4,5,4,4},
            {4,4,3,3,4,4,4,3,3,4,3},
            {6,4,4,5,3,5,6,4,5,6,5},
            {4,3,6,3,4,2,4,2,3,3,2},
            {4,4,4,3,4,4,4,4,4,4,5},
            {5,4,4,5,4,4,3,5,3,4,3}};

    private final String[] unknownNames = {"Hideki Matsuyama","Jon Rahm","Xander Schauffele","Jordan Spieth","Will Zalatoris","Marc Leishman","Justin Rose","Patrick Reed","Corey Conners","Cameron Smith","Tony Finau"};


    @Test
    public void getNamesGivenDataTest(){
        String[] expected = givenNames;
        Assert.assertArrayEquals( expected, GolfGames.getNames("Juan,Sophia,Omar,Andre,Emina"));
    }

    @Test
    public void getNamesUnknownDataTest(){
        String[] expected = unknownNames;
        Assert.assertArrayEquals( expected, GolfGames.getNames("Hideki Matsuyama,Jon Rahm,Xander Schauffele,Jordan Spieth,Will Zalatoris,Marc Leishman,Justin Rose,Patrick Reed,Corey Conners,Cameron Smith,Tony Finau"));
    }


    @Test
    public void getScoresGivenDataTest(){
        int[][] expected = givenScores;
        Assert.assertArrayEquals( expected, GolfGames.getScores("8,4,6,2,5<>9,8,7,5,2<>6,7,5,4,7<>4,5,9,5,3<>4,5,4,9,3<>5,3,7,8,9<>7,4,2,11,6<>4,8,3,5,1<>9,3,8,6,8"));
    }

    @Test
    public void getScoresUnknownDataTest(){
        int[][] expected = unknownScores;
        Assert.assertArrayEquals( expected, GolfGames.getScores("5,3,4,5,3,5,5,4,4,4,4<>4,3,4,4,4,4,4,3,4,4,5<>4,4,5,4,5,5,5,4,4,4,4<>3,3,4,3,3,3,3,3,3,3,4<>4,4,6,5,4,4,5,5,5,4,4<>3,3,3,4,3,3,3,3,4,3,3<>4,4,3,4,4,5,3,4,6,4,4<>4,4,4,5,4,5,5,5,6,4,5<>3,4,4,3,4,4,5,4,4,4,4<>4,4,4,3,3,4,4,4,4,4,4<>4,4,4,4,4,5,4,5,4,4,5<>4,2,2,3,5,3,3,3,3,3,4<>4,5,4,4,3,4,4,4,5,4,4<>4,4,3,3,4,4,4,3,3,4,3<>6,4,4,5,3,5,6,4,5,6,5<>4,3,6,3,4,2,4,2,3,3,2<>4,4,4,3,4,4,4,4,4,4,5<>5,4,4,5,4,4,3,5,3,4,3"));
    }


    @Test
    public void findWinnerGivenDataTest(){
        String expected = "Emina";
        Assert.assertEquals( expected, GolfGames.findWinner(givenNames,givenScores));
    }

    @Test
    public void findWinnerUnknownDataTest(){
        String expected = "Jon Rahm";
        Assert.assertEquals( expected, GolfGames.findWinner(unknownNames,unknownScores));
    }

    @Test
    public void findAvgForHoleGivenDataTest(){

        Assert.assertEquals("When checking the result of findAvgForHole for hole #6, we",6.4,GolfGames.findAvgForHole(givenScores,6),.001);

        Assert.assertEquals("When checking the result of findAvgForHole for hole #2, we",6.2,GolfGames.findAvgForHole(givenScores,2),.001);
    }

    @Test
    public void findAvgForHoleUnknownDataTest(){

        Assert.assertEquals("When checking the result of findAvgForHole for hole #17, we",4.0,GolfGames.findAvgForHole(unknownScores,17),.001);

        Assert.assertEquals("When checking the result of findAvgForHole for hole #9, we",3.909090909090909,GolfGames.findAvgForHole(unknownScores,9),.001);
    }


    @Test
    public void searchPlayersBelowAvgGivenDataTest(){

        Assert.assertArrayEquals("When checking the result of searchPlayersBelowAvg for hole #1, we",new String[] {"Sophia","Andre"},GolfGames.searchPlayersBelowAvg(givenNames,givenScores,1,5.0));

        Assert.assertArrayEquals("When checking the result of searchPlayersBelowAvg for hole #5, we",new String[]{"Juan","Omar","Emina"},GolfGames.searchPlayersBelowAvg(givenNames,givenScores,5,5.0));

        Assert.assertArrayEquals("When checking the result of searchPlayersBelowAvg for hole #9, we",new String[]{"Sophia","Andre"},GolfGames.searchPlayersBelowAvg(givenNames,givenScores,9,6.8));
    }

    @Test
    public void searchPlayersBelowAvgUnknownDataTest(){

        Assert.assertArrayEquals("When checking the result of searchPlayersBelowAvg for hole #5, we",new String[]{"Hideki Matsuyama","Jon Rahm","Will Zalatoris","Marc Leishman","Cameron Smith","Tony Finau"},GolfGames.searchPlayersBelowAvg(unknownNames,unknownScores,5,4.545454545454546));

        Assert.assertArrayEquals("When checking the result of searchPlayersBelowAvg for hole #10, we",new String[]{"Jordan Spieth","Will Zalatoris"},GolfGames.searchPlayersBelowAvg(unknownNames,unknownScores,10,3.8181818181818183));

        Assert.assertArrayEquals("When checking the result of searchPlayersBelowAvg for hole #18, we",new String[]{"Justin Rose","Corey Conners","Tony Finau"},GolfGames.searchPlayersBelowAvg(unknownNames,unknownScores,18,4.0));
    }


}
