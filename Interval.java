import java.lang.Comparable;

public class Interval implements Comparable<Object> {
  int startTime;
  int finishTime;
  boolean conflict;

  public Interval(int startTime, int finishTime) {
    this.startTime = startTime;
    this.finishTime = finishTime;
    this.conflict = false;
  }

  /**
   * Compare finish time of intervals
   * @return -1 if o is after this, 1 if o  is before this, 0 if at same time
   */
  public int compareTo(Object o) {
    Interval other = (Interval) o;
    if (this.finishTime < other.finishTime)
      return -1;
    else if (other.finishTime < this.finishTime)
      return 1;
    else
      return 0;
  }

  public boolean conflictsWith(Interval other) {
    if (other.finishTime <= this.startTime)
      return false;

    if (other.startTime >= this.finishTime)
      return false;

    return true;
  }

  public String toString() {
    String s = "(" + this.startTime + ", " + this.finishTime + ")";
    return s;
  }
}
