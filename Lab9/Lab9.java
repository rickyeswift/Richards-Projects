/*
Lab9
Richard Elliott Jr
CMSC-255 902
Mar 23, 2022
 */
package Labs.Lab9;

public class Lab9 {

    public static void main(String[] args) {
        int [][] addTo10Input = {
                {  6,  3,  2,  0,  4},
                { 34, 53,  0, 23,  1},
                {  0, 23, 54, 11,  7}
        };

        double [][] findAvgInput = {
                {  5, 4.5,  6.8},
                {  6,  0,  3.4},
                { 7,  8.4,  2.3}
        };

        double [][] findAvgInputLarge = {
                { 6.7,  23.8,  0,  5.9,  12.8,  45.7},
                {  0,  36.8,  13.5,  6.7,  54.9,  67.4},
                {  37.4,  2.5,  39.8,  0,  2.4,  43.6},
                {  44.6,  76.5,  4.5, 2.4,  0, 54.6},
                {  5.4,  76.3,  6.5, 28.5,  54.7,  0},
                {  19.4,  0,  5.3,  65.4,  93.5,  3.5}
        };

        addTo10 (addTo10Input);
        System.out.println();
        findAverage (findAvgInput);
        System.out.println();
        findAverage (findAvgInputLarge);
        }

    public static void addTo10 (int [][] array) {
        int i,j;
       for(i = 0; i < array.length; i++){
           int sum = 0;
           //calculate sum of that row
           for(j = 0; j < array[i].length; j++){
               sum += array[i][j];
           }
           //get that element
           int reZero = 10 - sum;
           j = 0;
           // remove the zero
           while(array[i][j] != 0){
               j++;
           }
           //place reZero in place of the 0
           array[i][j] = reZero;
       }
       for(i = 0; i < array.length; i++){
           for(j = 0; j < array[i].length; j++){
               System.out.print(array[i][j] + " ");
           }
           System.out.println();
       }
    }

    public static void findAverage (double [][] array) {
        int i,j,k,k1;
        //x1 is row average and x2 is column average
        double x1 = 0, x2 = 0;
        for(i = 0; i < array.length; i++){
            for(j = 0; j < array[i].length; j++){
                //if the array position is 0
                if(array[i][j] == 0){
                    for(k = 0; k < array[i].length; k++){
                        //get row average
                        x1 += array[i][k];
                    }
                    x1 = x1 / array[i].length;
                    for(k1 = 0; k1 < array.length; k1++){
                        //get column average
                        x2 += array[k1][j];
                    }
                    x2 = x2 / array.length;
                    //replace zero with max of x1 and x2
                    if(x1 > x2){
                        array[i][j] = x1;
                    }
                    else{
                        array[i][j] = x2;
                    }
                }
            }
        }
        //print
        for(i = 0; i < array.length; i++){
            for(j = 0; j < array[i].length; j++){
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }


}