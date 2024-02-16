package application;

import entities.LogEntry;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import static java.lang.String.format;

public class Main {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    System.out.println("Write the name and path this file");
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
      System.out.println("Set size: "+ set.size());
    }
    catch(IOException e){
      e.printStackTrace();
    }
    finally {
      sc.close();
    }
  }
}