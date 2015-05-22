package biz.avelit.dron;

public class WayPoint {
  public Double latitude;
  public Double longtitude;
  public Double level;
  public Double speed;

  public WayPoint(Double latitude, Double longtitude, Double level, Double speed) {
    this.latitude = latitude;
    this.longtitude = longtitude;
    this.level = level;
    this.speed = speed;
  }

  @Override
  public String toString() {
    return "WayPoint{" +
            "latitude=" + latitude +
            ", longtitude=" + longtitude +
            ", level=" + level +
            ", speed=" + speed +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    WayPoint point = (WayPoint) o;

    //if (Math.abs(latitude - point.latitude) > 0.1) return false;
    //if (Math.abs(longtitude - point.longtitude) > 0.1) return false;
    if (Math.abs(level - point.level) > 0.1) return false;
    return (Math.abs(speed - point.speed) < 0.1);

  }

  @Override
  public int hashCode() {
    return 0;
  }
}
