//John Strobel
//Created on 2/12/2018
import java.util.*;
import java.util.LinkedList;
import java.util.Arrays;

public class maze_solution {
    public static void main(String[] args) {

/*
1. Read in data
2. re-format data to match my code
    2.1 initialize local variables to match data
3. clear out walls
4. run BFS algorithm
5. write shortest path onto grid
6. return length of path & final grid to a json file
 */


//        maze grid = new maze(8,10);
//        char [][] arr =
//                       {{'#','#','#','#','#','#','#','#','#','#'},
//                        {'#','A','.','.','.','#','.','.','.','#'},
//                        {'#','.','#','.','#','#','.','#','.','#'},
//                        {'#','.','#','.','#','#','.','#','.','#'},
//                        {'#','.','#','.','.','.','.','#','B','#'},
//                        {'#','.','#','.','#','#','.','#','.','#'},
//                        {'#','.','.','.','.','#','.','.','.','#'},
//                        {'#','#','#','#','#','#','#','#','#','#'}};
//                        //format: arr[0][1] = arr row 0 column 1; A is at test[1][1], B is at test[4][8]
//
//        grid.setGrid(arr);

        maze grid = new maze(4,5);
        grid.setGrid("hello\nhello\nhello\nmario");

        System.out.println(grid.toString());


//input grid from... whatever. have the user choose

//find start and end points

//        coordinate s = new coordinate(1,1);
//        coordinate d = new coordinate(4,8);
//
//        //real work
//        coordinate[] solutions = grid.bfs(s,d);
//        int numsolutions = 0;
//        System.out.println("solutions:");
//        for(int i = 0;i<solutions.length;i++){
//            if(solutions[i] == null){break;}
//            System.out.println(solutions[i].toString());
//            numsolutions++;
//
//            System.out.println("equals start?: " + solutions[i].equals(s));
//            if(!solutions[i].equals(s) && !solutions[i].equals(d)) {
//                grid.changeCoord(solutions[i], '@');
//            }
//        }//for
//
//        System.out.println("steps: " + numsolutions);
//        System.out.println(grid.toString());


    }//main
}//grid_solution class
