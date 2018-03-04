//John Strobel
//Created on 2/12/2018
import java.util.*;
import java.util.LinkedList;
import java.io.*;
import java.util.Arrays;

public class maze_solution {
    public static void main(String[] args) {
        //read in maze

        String[] mazes = {"maze1.txt","maze2.txt","maze3.txt"};
        maze maze1 = new maze();
        maze maze2 = new maze();
        maze maze3 = new maze();


        String[] lines;//not sufficient for exceptionally large arrays, but certainly enough for all the examples given
        int lineptr = 0;

        for(int i = 0;i<mazes.length;i++) {
            lines = new String[100];
            try {
                FileReader f = new FileReader(mazes[i]);
                BufferedReader reader = new BufferedReader(f);

                lines[lineptr] = reader.readLine();
                while (lines[lineptr]!= null) {
                    lineptr++;
                    lines[lineptr] = reader.readLine();
                }//while

                switch(i){
                    case 0: maze1 = new maze(lines.length,lines[0].length());
                            maze1.setGrid(lines);
                            break;
                    case 1: maze2 = new maze(lines.length,lines[0].length());
                            maze2.setGrid(lines);
                            break;
                    case 2: maze3 = new maze(lines.length,lines[0].length());
                            maze3.setGrid(lines);
                            break;
                }//switch

                reader.close();
            }//try
            catch (FileNotFoundException ex) {
                System.out.println("Unable to open file " + mazes[i]);
            }//catch file not found
            catch (IOException ex) {
                System.out.println("Error reading file " + mazes[i]);
            }//catch ioexception
        }//for i
        if(maze1==null || maze2==null || maze3==null){
            System.out.println("bad something");
            return;
        }
        coordinate m1start = maze1.findStart();
        coordinate m1end = maze1.findEnd();
        coordinate m2start = maze2.findStart();
        coordinate m2end = maze2.findEnd();
        coordinate m3start = maze3.findStart();
        coordinate m3end = maze3.findEnd();

        coordinate[] m1solution = maze1.bfs(m1start,m1end);
        coordinate[] m2solution = maze2.bfs(m2start,m2end);
        coordinate[] m3solution = maze3.bfs(m3start,m3end);

        maze1.getSolution(m1solution);
        maze2.getSolution(m2solution);
        maze3.getSolution(m3solution);

        System.out.println("Maze 1:\n" + maze1.toString() +
                           "Maze 2:\n" + maze2.toString() +
                           "Maze 3:\n" + maze3.toString());


    }//main
}//grid_solution class
