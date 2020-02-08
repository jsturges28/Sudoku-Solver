import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SolveSudoku {


    public static boolean isComplete(int[][] theTable){
        for(int r = 0; r < theTable.length; r++){
            for(int c = 0; c < theTable[r].length; c++){
                if(theTable[r][c] == 0){

                    return false;
                }
            }
        }

        return true;
    }

    public static boolean solveSudoku(int[][] thePuzzle) {

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (thePuzzle[r][c] == 0) {
                    for (int k = 1; k <= 9; k++) {
                        thePuzzle[r][c] = k;
                        if (isValidPuzzle(thePuzzle) && solveSudoku(thePuzzle)) {
                            return true;
                        }
                        thePuzzle[r][c] = 0;
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isValidPuzzle(int[][] theTable){

        boolean result = true;
        int one, two, three, four, five, six, seven, eight, nine = 0;

        //check column
        for (int c = 0; c < theTable.length; c++) {
            one = 0; two = 0; three = 0; four = 0; five = 0; six = 0; seven = 0; eight = 0; nine = 0;
            for (int r = 0; r < theTable[c].length; r++) {
                switch (theTable[r][c]) {
                    case 1:
                        one++;
                        break;
                    case 2:
                        two++;
                        break;
                    case 3:
                        three++;
                        break;
                    case 4:
                        four++;
                        break;
                    case 5:
                        five++;
                        break;
                    case 6:
                        six++;
                        break;
                    case 7:
                        seven++;
                        break;
                    case 8:
                        eight++;
                        break;
                    case 9:
                        nine++;
                        break;
                    default:
                        break;
                }
            }
            if(one <=1 && two<=1 && three<=1 && four<=1 && five<=1 && six<=1 && seven<=1 && eight<=1 && nine<=1){
                result = true;
            } else return false;
        }
        //check row
        for (int r = 0; r < theTable.length; r++) {
            one = 0; two = 0; three = 0; four = 0; five = 0; six = 0; seven = 0; eight = 0; nine = 0;
            for (int c = 0; c < theTable[r].length; c++) {
                switch (theTable[r][c]) {
                    case 1:
                        one++;
                        break;
                    case 2:
                        two++;
                        break;
                    case 3:
                        three++;
                        break;
                    case 4:
                        four++;
                        break;
                    case 5:
                        five++;
                        break;
                    case 6:
                        six++;
                        break;
                    case 7:
                        seven++;
                        break;
                    case 8:
                        eight++;
                        break;
                    case 9:
                        nine++;
                        break;
                    default:
                        break;
                }
            }
            if(one <=1 && two<=1 && three<=1 && four<=1 && five<=1 && six<=1 && seven<=1 && eight<=1 && nine<=1){
                result = true;
            } else return false;
        }

        //check matrix
        for (int i = 0; i < 9; i+=3) {
            for (int j = 0; j < 9; j+=3) {
                one = 0;
                two = 0;
                three = 0;
                four = 0;
                five = 0;
                six = 0;
                seven = 0;
                eight = 0;
                nine = 0;
                for (int x = i; x < i + 2; x++) {
                    for (int y = j; y < j + 2; y++) {

                        switch (theTable[x][y]) {
                            case 1:
                                one++;
                                break;
                            case 2:
                                two++;
                                break;
                            case 3:
                                three++;
                                break;
                            case 4:
                                four++;
                                break;
                            case 5:
                                five++;
                                break;
                            case 6:
                                six++;
                                break;
                            case 7:
                                seven++;
                                break;
                            case 8:
                                eight++;
                                break;
                            case 9:
                                nine++;
                                break;
                            default:
                                break;
                        }
                    }
                }
                if(one <=1 && two<=1 && three<=1 && four<=1 && five<=1 && six<=1 && seven<=1 && eight<=1 && nine<=1){
                    result = true;
                } else return false;
            }
        }
        return result;
    }

    public static boolean isSolvedPuzzle(int[][] theTable){
        boolean result = false;
        if(isValidPuzzle(theTable)){
            result = true;
        } else return false;
        if (isComplete(theTable)) {
            result = true;
        } else return false;
        System.out.println("Puzzle is solved!");
        displayTable(theTable);

        //check column
        for (int c = 0; c < theTable.length; c++) {
            int sum = 0;
            for (int r = 0; r < theTable[c].length; r++) {

                sum += theTable[r][c];
            }
            if(sum == 45){
                result = true;
            } else {

                return false;
            }
        }
        //check row
        for (int r = 0; r < theTable.length; r++) {
            int sum = 0;
            for (int c = 0; c < theTable[r].length; c++) {

                sum += theTable[r][c];
            }
            if(sum == 45){
                result = true;
            } else {

                return false;
            }
        }

        //check matrix
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                int sum = 0;
                for (int p = i; p < i + 3; p++) {
                    for (int q = j; q < j + 3; q++) {
                        sum += theTable[p][q];
                    }
                }
                if (sum == 45) {
                    result = true;
                } else {

                    return false;
                }
            }
        }

        return result;


    }

    public static void displayTable(int [][] theTable){
        for(int r = 0; r < theTable.length; r++){
            for(int c = 0; c < theTable[r].length; c++){
                System.out.print(theTable[r][c] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args){

        System.out.println("Hello, welcome to Sudoku Solver!");
        String fileName;
        int numRows = 9;
        int numCols = 9;
        if(args.length == 1){
            fileName = args[0];
        } else {
            Scanner s = new Scanner(System.in);
            System.out.print("Please enter name of file containing 9x9 Sudoku Puzzle: ");
            fileName = s.next();
        }
        System.out.println();

        int [][] myTable = new int [numRows][numCols];
        System.out.println();
        System.out.println("Reading from file " + fileName + "...");
        System.out.println();
        try {
            Scanner f = new Scanner(new File(fileName));

            System.out.println();
            for(int r = 0; r < myTable.length; r++){
                for(int c = 0; c < myTable[r].length; c++) {
                    String temp = f.next();
                    if(temp.charAt(0) == '-'){
                        myTable[r][c] = 0;
                    } else {myTable[r][c] = Integer.parseInt(temp);}
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Exception!");
            System.out.println(e.toString());
            System.exit(0);
        }
        System.out.println("Solving Puzzle:\n");
        displayTable(myTable);
        System.out.println();
        System.out.println("- - -  - - -  - - -");
        System.out.println();
        solveSudoku(myTable);
        if(solveSudoku(myTable)){
            displayTable(myTable);
            System.out.println("\nSee solved puzzle above!");
        } else System.out.println("ERROR: This Puzzle is unsolvable :(");
    }
}