package biz.avelit.dron;

public class TemporaryPoint extends WayPoint{
  public Double direction;

  public TemporaryPoint(Double latitude, Double longtitude, Double level, Double speed , Double direction) {
    super(latitude, longtitude, level, speed);
    this.direction = direction;
  }

  @Override
  public String toString() {
    return super.toString() + "TemporaryPoint{" +
            "direction=" + direction +
            '}';
  }

  public WayPoint getWaypoint() {
    return new WayPoint(latitude,longtitude,level,speed);
  }
}
