import java.awt.*;
import javax.swing.JComponent;

public class MazeComponent extends JComponent{
   /**
    * 
    */
   private static final long serialVersionUID = 1L;
   private char[][] maze;
   private int width;
   private int height;
   public static final int SCALE = 20; // Scale factor for maze
   public static final int DELAY = 40;
   
   public MazeComponent(char[][] aMaze)
   {
      super();
      maze = aMaze;
      width = maze[0].length;
      height = maze.length;
   }
   public void paintComponent(Graphics g)
   {
      Graphics2D g2 = (Graphics2D) g;
      for (int r = 0; r < height; r++) {
         for (int c = 0; c < width; c++) {
            if (maze[r][c] == "*".charAt(0)) {
               g2.setColor(Color.BLACK);
            } else if (maze[r][c] == " ".charAt(0)) {
               g2.setColor(Color.WHITE);
            } else if (maze[r][c] == "?".charAt(0)) {
               g2.setColor(Color.RED);
            } else {
               g2.setColor(Color.GREEN);
            }
            Rectangle box = new Rectangle((c+1)*SCALE,(r+1)*SCALE,SCALE,SCALE);
            g2.fill(box);
         }
      }
   }
   public void paintMaze()
      {
      this.repaint();
      try {
         Thread.sleep(DELAY);
      } catch (InterruptedException e) {
         System.out.println("Timer error");
      }
   }
}
