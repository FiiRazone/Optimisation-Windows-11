import java.awt.Dimension;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Main
{
  public static JFrame fenetre;
  public static javax.swing.JButton bouton;
  public static javax.swing.JPanel container;
  public static String userHome = System.getProperty("user.home");
  
  public Main() {}
  
  public static void main(String[] args)
  {
	try {
		downloadFileFromUrl();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    lookAndFeel();
    fenetre();
    javax.swing.SwingUtilities.updateComponentTreeUI(fenetre);
  }
  
  public static void fenetre() {
    Container();
    boutonsAndBoutonsActions();
    fenetre = new JFrame("Optimisation windows 11");
    fenetre.setDefaultCloseOperation(3);
    fenetre.setUndecorated(false);
    fenetre.setSize(400, 300);
    fenetre.setLocationRelativeTo(null);
    fenetre.setContentPane(container);
    fenetre.setIconImage(new ImageIcon(userHome + "\\Documents\\Optimisation\\icon.png").getImage());
    fenetre.setVisible(true);
  }
  
  public static void lookAndFeel() {
    String lookAndFeel = javax.swing.UIManager.getSystemLookAndFeelClassName();
    try {
      javax.swing.UIManager.setLookAndFeel(lookAndFeel);
    }
    catch (ClassNotFoundException|InstantiationException|IllegalAccessException|javax.swing.UnsupportedLookAndFeelException e)
    {
      e.printStackTrace();
    }
  }
  
  public static void Container() {
    container = new javax.swing.JPanel();
    container.setBackground(java.awt.Color.white);
    container.setLayout(new java.awt.FlowLayout(1));
    container.setBackground(java.awt.Color.DARK_GRAY);
  }
  
  public static void boutonsAndBoutonsActions() {
    bouton = new javax.swing.JButton("Clean");
    bouton.setForeground(java.awt.Color.BLACK);
    bouton.setBorderPainted(false);
    bouton.setFocusPainted(false);
    bouton.setPreferredSize(new Dimension(1920, 30));
    bouton.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent e)
      {
    	String userHome = System.getProperty("user.home");
        long startMs = System.currentTimeMillis();
        File temp = new File("C:\\Windows\\Temp");
        File[] listOfFiles = temp.listFiles();
        File temp2 = new File(userHome + "\\AppData\\Local\\Temp");
        File[] listOfFiles2 = temp2.listFiles();
        File cacheChrome = new File(userHome + "\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\Cache\\Cache_Data");
        File[] listofFilesChrome = cacheChrome.listFiles();
        File[] array;
        int length = (array = listOfFiles).length; for (int i = 0; i < length; i++) {
          File value = array[i];
          value.delete();
        }
        File[] array2;
        int length2 = (array2 = listOfFiles2).length; for (int j = 0; j < length2; j++) {
          File value = array2[j];
          value.delete();
        }
        File[] array3;
        int length3 = (array3 = listofFilesChrome).length; for (int k = 0; k < length3; k++) {
          File value = array3[k];
          value.delete();
        }
        long endMs = System.currentTimeMillis();
        javax.swing.JOptionPane.showMessageDialog(Main.fenetre, "Optiomisation : Suppresion des fichiers temporaires." + (endMs - startMs) + "ms");
      }
    });
    container.add(bouton);
  }
  
  public static void downloadFileFromUrl() throws IOException {
	  Files.createDirectories(Paths.get(userHome + "\\Documents\\Optimisation"));
	  try (BufferedInputStream inputStream = new BufferedInputStream(new URL("https://icon-icons.com/downloadimage.php?id=30027&root=272/PNG/512/&file=Settings_30027.png").openStream());
			  FileOutputStream fileOS = new FileOutputStream(userHome + "\\Documents\\Optimisation\\icon.png")) {
			    byte data[] = new byte[1024];
			    int byteContent;
			    while ((byteContent = inputStream.read(data, 0, 1024)) != -1) {
			        fileOS.write(data, 0, byteContent);
			    }
			} catch (IOException e) {
			    // handles IO exceptions
			}
  }
}