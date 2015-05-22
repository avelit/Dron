package biz.avelit.dron;

import java.util.ArrayList;
import java.util.List;

public class AirplaneCharacteristics {
  private Double maxSpeed;
  private Double maxAcceleration;
  private Double maxSpeedLevelChange;
  private Double maxSpeedDirectionChange;

  public AirplaneCharacteristics(Double maxSpeed, Double maxAcceleration, Double maxSpeedLevelChange, Double maxSpeedDirectionChange) {
    this.maxSpeed = maxSpeed;
    this.maxAcceleration = maxAcceleration;
    this.maxSpeedLevelChange = maxSpeedLevelChange;
    this.maxSpeedDirectionChange = maxSpeedDirectionChange;
  }

  public List<TemporaryPoint> calculateRoute(TemporaryPoint startPoint, List<WayPoint> wayPoints) {
    List<TemporaryPoint> temporaryPoints = new ArrayList<TemporaryPoint>();
    TemporaryPoint currentPoint = startPoint;
    for (WayPoint wayPoint:wayPoints) {
      while (!wayPoint.equals(currentPoint.getWaypoint())) {
        temporaryPoints.add(currentPoint);
        currentPoint = calculateNewPosition(currentPoint,wayPoint);
      }
    }
    return temporaryPoints;
  }

  private TemporaryPoint calculateNewPosition(TemporaryPoint currentPoint, WayPoint wayPoint) {
    Double latitude = 0.0;
    Double longtitude = 0.0;
    Double level = (currentPoint.level > wayPoint.level)?
            Math.max(currentPoint.level - maxSpeedLevelChange,wayPoint.level):
            Math.min(currentPoint.level + maxSpeedLevelChange,wayPoint.level);
    Double speed = (currentPoint.speed > wayPoint.speed)?
            Math.max(currentPoint.speed - maxAcceleration,wayPoint.speed):
            Math.min(Math.min(currentPoint.speed + maxAcceleration, wayPoint.speed), maxSpeed);
    Double direction = 0.0;
    return new TemporaryPoint(latitude,longtitude,level,speed,direction);
  }
}
