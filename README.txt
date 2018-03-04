John Strobel - strob105@umn.edu

This is a partial solution to the requested problem, because I ran out of time while working on other projects.

This solution solves all three mazes, making use of the Breadth First Search algorithm. It does not, unfortunately, do so as a web service, nor does it have the capacity to read or write to or from JSON files.

The directory 'src' contains all the source code, in java files. There are three main parts to these files.

1. MAZE
	Maze is a class that represents the character array given. The arrays themselves are usually modified to present output. This is also where the Breadth-First Search algorithm is located.
2. COORDINATE
	Coordinates are objects representing specific points. Included in their definition is a "parent," useful for backtracking and identifying the actual path once the algorithm has completed iterating.
3. MAZE_SOLUTION
	Main. Includes File I/O.