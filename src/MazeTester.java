import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.filechooser.*;

public class MazeTester
{
   public static void main(String[] args)
   {
      JFileChooser jfc = new JFileChooser();
      jfc.setFileFilter(new FileNameExtensionFilter("text files", "txt"));
      jfc.showOpenDialog(null);
      File file = jfc.getSelectedFile();
      //File file = new File("/Users/Stewart/Downloads/mazefile.txt");
      Scanner scanner = null;
      try {
         scanner = new Scanner(file);
      } catch (FileNotFoundException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
      List<String> al = new ArrayList<String>();
      while (scanner.hasNextLine()) {
             al.add(scanner.nextLine());
      }
      
      char[][] mazeArray = new char[al.size()][al.get(0).length()];
      System.out.println(al.size());
      System.out.println(al.get(0).length());
      int i = 0;
      for (String s : al) {
         mazeArray[i] = s.toCharArray();
         i++;
      }

      JFrame frame = new JFrame();
      
      frame.setSize((mazeArray[0].length + 2) * MazeComponent.SCALE, (mazeArray.length + 3) * MazeComponent.SCALE);
      frame.setTitle("Maze");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      MazeComponent component = new MazeComponent(mazeArray);
      frame.add(component);

      frame.setVisible(true);
      
      Maze maze = new Maze(mazeArray, component);
      
      if (maze.escape(1, 1)) {
         maze.updateExit();
      }
      
      
      
   }
}
