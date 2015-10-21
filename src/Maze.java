import java.awt.Point;
import java.util.*;

public class Maze {
   private char[][] maze;
   private int height;
   private int width;
   private MazeComponent mazeComponent;
   private List<Point> exit = new ArrayList<Point>();
   
   public Maze(char[][] aMaze, MazeComponent component)
   {
      maze = aMaze;
      height = maze.length; // Rows
      width = maze[0].length; // Columns
      mazeComponent = component;
   }
   public boolean escape(int r, int c) {
      if (isEdge(r,c)) {
         exit.add(new Point(r,c));
         return true;
      }
      maze[r][c] = '?';
      mazeComponent.paintMaze();
      if (up(r,c) && escape(r-1,c)) {  
         exit.add(new Point(r,c));
         maze[r][c] = ' ';
         mazeComponent.paintMaze();
         return true;
      } else if (right(r,c) && escape(r,c+1)) {
         exit.add(new Point(r,c));
         maze[r][c] = ' ';
         mazeComponent.paintMaze();
         return true;
      } else if (down(r,c) && escape(r+1,c)) {
         exit.add(new Point(r,c));
         maze[r][c] = ' ';
         mazeComponent.paintMaze();
         return true;
      } else if (left(r,c) && escape(r,c-1)) {
         exit.add(new Point(r,c));
         maze[r][c] = ' ';
         mazeComponent.paintMaze();
         return true;
      } else {
         maze[r][c] = ' ';
         mazeComponent.paintMaze();
         return false;
      }
   }
   private boolean isEdge (int r, int c) {
      return (r == 0 || c == 0 || r == (height-1) || c == (width-1));
   }
   private boolean up (int r, int c) {
      return (maze[r-1][c] == ' ');
   }
   private boolean right (int r, int c) {
      return (maze[r][c+1] == ' ');
   }
   private boolean down (int r, int c) {
      return (maze[r+1][c] == ' ');
   }
   private boolean left (int r, int c) {
      return (maze[r][c-1] == ' ');
   }
   public List<Point> getExit() {
      return exit;
   }
   public void updateExit () {
      for (int i = 0; i < exit.size(); i++) {
         int x = exit.get(exit.size()-i-1).x;
         int y = exit.get(exit.size()-i-1).y;
         maze[x][y] = 'x';
         mazeComponent.paintMaze();
      }
   }
}
