//aka John Strobel
//Created on 2/13/2018
//Stud ID#5218472
//Strob105@umn.edu
public class coordinate {
    private int[] coord;
    private coordinate parent;

    public coordinate(int a, int b){
        coord = new int[] {a,b};
        parent = null;
    }//constructor

    public coordinate(int a, int b, coordinate p){
        coord = new int[] {a,b};
        parent = p;

    }//constructor

    public void setx(int n){
        coord[0] = n;
    }

    public void sety(int n){
        coord[1] = n;
    }

    public void setParent(coordinate p){
        parent = p;
    }//setParent

    public int getx(){
        return coord[0];
    }

    public int gety(){
        return coord[1];
    }

    public coordinate getParent(){return parent;}

    public int[] getcoordinates(){
        return coord;
    }

    public String toString(){
        if(parent==null){
            return ("x:" + coord[0] + " y: " + coord[1] + " parent: null");
        }
        else {
            return ("x:" + coord[0] + " y: " + coord[1] + " parent: " + "(" + parent.getx() + "," + parent.gety() + ")");
        }
    }

    public coordinate getnorth(){
        return new coordinate(this.coord[0]-1,this.coord[1]);
    }

    public coordinate geteast(){
        return new coordinate(this.coord[0],this.coord[1]+1);
    }

    public coordinate getsouth(){
        return new coordinate(this.coord[0]+1,this.coord[1]);
    }

    public coordinate getwest(){
        return new coordinate(this.coord[0],this.coord[1]-1);
    }

    public coordinate[] getadjacent(){
        coordinate n = new coordinate(this.coord[0]-1,this.coord[1]);
        coordinate e = new coordinate(this.coord[0],this.coord[1]+1);
        coordinate s = new coordinate(this.coord[0]+1,this.coord[1]);
        coordinate w = new coordinate(this.coord[0],this.coord[1]-1);
        return new coordinate[] {n,e,s,w};
    }//getadjacent

    public boolean equals(coordinate other) {
        return (this.getx()==other.getx() && this.gety()==other.gety());
    }//equals
}//coordinate class
