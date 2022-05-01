package ntnu.mikkel.wargames.logic;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import ntnu.mikkel.wargames.data.CavalryUnit;
import ntnu.mikkel.wargames.data.CommanderUnit;
import ntnu.mikkel.wargames.data.InfantryUnit;
import ntnu.mikkel.wargames.data.RangedUnit;
import ntnu.mikkel.wargames.data.Unit;

/**
 * Class represents a handler for army. Here we can read and upload files to represent an army. User can upload
 * a CSV.sheet of armies to determine the fight. We create the instances of Units and Armies here to
 * preserve high cohesion and loose coupling.
 */
public class ArmyHandler {

  private Army army;

  public ArmyHandler(){
  }

  public static void writeToFile() {
    try {
      FileWriter fileWriter =
          new FileWriter("C://Program Files//Hobbyprogrammering/Sometextttt.txt");
      BufferedWriter printWriter = new BufferedWriter(fileWriter);

      for (int i = 0; i < 10; i++) {
        printWriter.write("Line:" + i + "\n");
      }
      printWriter.close();
    } catch (IOException e) {
      System.out.println("File could not be saved.");
    }
  }

  /**
   * Open file
   *
   * Get scanner on file
   *
   * Read name of Unit
   *
   *
   *
   *
   *
   * @param filename
   * @return
   * @throws FileNotFoundException
   */
  public ArrayList<Unit> readArmyFromFile(String filename) throws FileNotFoundException {
    int count = 0;
    String line = null;
    ArrayList<Unit> fileUnits = army.getArrayList();
                                                                                                            //"C://Programfiler//Hobbyprogrammering/Armies/army1.txt"
    File file = new File(filename);
    Scanner scanner = new Scanner(file);

    while(scanner.hasNextLine()){



    }











    //line.split(","); //Splitter mellom komma

    while (scanner.hasNextLine()) {

      if(scanner.hasNextLine()){ //hvis første linje starter med CavalryUnit

        //scanner.s

          //https://www.youtube.com/watch?v=-iVTEzwgJ2s&ab_channel=MITEECSman



        units.add(new CavalryUnit("Gromp", 100));
      }
      if(scanner.hasNextLine()){
        units.add(new InfantryUnit("Dog", 100));
      }
    }
    return units;
  }


  public static void readFromFile() throws IOException {
    try {
      File file = new File("C://Program Files//Hobbyprogrammering/text.txt");
      Scanner scanner = new Scanner(file);

      while (scanner.hasNextLine()) {
        System.out.println(scanner.nextLine());
      }
    } catch (IOException e) {
      System.out.println("Something wrong happend.");
    }
  }

  public static void writeArmyFile(ArrayList<Unit> arr) throws IOException {
    FileWriter fileWriter =
        new FileWriter("C://Program Files//Hobbyprogrammering/testArmyPrint.txt");
    int size = arr.size();

    for (int i = 0; i < size; i++) {
      String str = arr.get(i).toString();
      fileWriter.write(str + "\n");
    }
    fileWriter.close();
  }













