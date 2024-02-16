package entities;

import java.util.Date;
import java.util.Objects;

public class LogEntry {
  private String userName;
  private Date date;

  public LogEntry(){}

  public LogEntry(String userName, Date date) {
    this.userName = userName;
    this.date = date;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  @Override
  public boolean equals(Object o) {
    if(this == o) return true;
    if(! (o instanceof LogEntry logEntry)) return false;
    return Objects.equals(userName, logEntry.userName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userName);
  }

  @Override
  public String toString() {
    return userName +" "+ date;
  }
}
