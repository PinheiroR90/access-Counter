package application;

import entities.LogEntry;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    System.out.print("Write the name and path this file: ");
    String path = sc.nextLine();

    try (BufferedReader br = new BufferedReader(new FileReader(path))){
      Set<LogEntry> set = new HashSet<>();

      String line = br.readLine();
      while(line != null){
        String[] fields = line.split(" ");
        String user = fields[0];
        Date date = Date.from(Instant.parse(fields[1]));
        set.add(new LogEntry(user,date));
        line = br.readLine();
      }
      System.out.println("Size Access for users: "+ set.size());
    }
    catch(IOException e){
      e.printStackTrace();
    }
    finally {
      sc.close();
    }
  }
}