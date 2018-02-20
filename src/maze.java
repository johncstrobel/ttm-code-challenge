//John Strobel
//Created on 2/12/2018

import java.util.*;
//import JSON reading stuff?


public class maze {
    private int xlen;
    private int ylen;
    public String toString(){
        String returnString = "";
        for(int i = 0;i<this.grid.length;i++){//traverse rows
            for(int j = 0;j<this.grid[i].length;j++){//traverse columns
                returnString = returnString + this.grid[i][j];
            }//for
            returnString = returnString + "\n";
        }//for
        return returnString;
    }//printmaze

    private char[][] grid;

    public maze(int x, int y){
        xlen = x;
        ylen = y;
        grid = new char[x][y];
    }//constructor

    public maze(){
        xlen = 0;
        ylen = 0;
        grid = null;
    }

    public int getXlen(){return xlen;}
    public int getYlen(){return ylen;}
    public void setXlen(int x){xlen = x;}
    public void setYlen(int y){ylen = y;}

    public boolean inBounds(coordinate c){
        return c.getx()>=0 && c.getx()<xlen && c.gety()>=0 &&c.gety()<ylen;
    }

    public void changeCoord(coordinate c, char x){
        grid[c.getx()][c.gety()] = x;
    }

    public coordinate[] getwalls(){
        //finds all walls ('#') and returns their locations in an array of coordinates.
        //used to eliminate all walls from consideration before the BFS algorithm starts.
        coordinate returncoord[] = new coordinate[(xlen*ylen)];//array at maximum possible size is wasteful,
                                                               //but also best way to prevent memory leaks
        int ptr = 0;//current location in returncoord
        for(int i = 0;i<xlen;i++){
            for (int j = 0;j<ylen;j++){
                if('#' == grid[i][j] ){
                    returncoord[ptr] = new coordinate(i,j);
                    ptr++;
                }//if
            }//for j
        }//for i
        return returncoord;
    }//getwalls

    public coordinate[] bfs(coordinate start,coordinate dest){
        //"to view" queue
        LinkedList <coordinate> Q = new LinkedList<coordinate>();

        //list of viewed coords
        coordinate[] viewed = new coordinate[xlen*ylen];
        int viewedptr = 0;

        //solution list - order should not matter
        coordinate[] solutions = new coordinate[xlen*ylen];
        int solptr = 0;

        //add walls to viewed
        coordinate temp[] = this.getwalls();
        int i = 0;
        while(i < temp.length && temp[i] != null){
            viewed[viewedptr] = temp[i];
            i++;
            viewedptr++;
        }//while

        //proper bfs algorithm
        Q.addFirst(start);
        coordinate current = null;
        while(!Q.isEmpty()){//main loop
            current = Q.removeFirst();
            coordinate[] adjacent = current.getadjacent();

            for(i = 0; i < adjacent.length;i++){//traverse children
                if(this.inBounds(adjacent[i])) {//make sure child is valid
                    //step one: check if child is in viewed
                    boolean seen = false;
                    for (int j = 0; j < viewedptr; j++) {
                        if (viewed[j].equals(adjacent[i])) {
                            seen = true;
                        }//if
                    }//for j

                    //step 2:add child to queue/set parent as current
                    if (!seen) {//if not seen and in bounds
                        adjacent[i].setParent(current);
                        Q.addLast(adjacent[i]);
                    }//if
                }//if
            }//for i (add children)

            if(current.equals(dest)){
                break;
            }//if
        }//while

        //populate solutions with the backtracked stuff
        coordinate backtrack = current;
        while(!current.equals(start)){
            solutions[solptr] = current;
            current = current.getParent();
            solptr++;
        }//while
        solutions[solptr] = start;

        return solutions;
    }//bfs

    public void setGrid (String arr) throws IllegalArgumentException{
        //case 1: newlines are present in the string
        String[] stringList = arr.split("\n");
        char[][] charList = new char[stringList.length][];
        for(int i = 0; i < stringList.length; i++){
            charList[i] =  stringList[i].toCharArray();
        }

        this.setGrid(charList);


        ///something something something

    }//setGrid (string)

    public void setGrid(char[][] arr) throws IllegalArgumentException{
        if(arr.length != xlen || arr[0].length != ylen ) {//assuming square arrays
            throw new IllegalArgumentException("Array entered has bad coordinates");
        }//if
        try {
            for (int i = 0; i < xlen; i++) {
                for (int j = 0; j < ylen; j++) {
                    grid[i][j] = arr[i][j];
                }//for(j)
            }//for(i)
        }//try
        catch(ArrayIndexOutOfBoundsException e){
            throw new IllegalArgumentException("Array entered has bad coordinates");
        }//catch
    }//setGrid(char array)

}//maze
