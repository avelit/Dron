package biz.avelit.dron;

import java.util.List;

public class Airplane {
  private String name;
  private AirplaneCharacteristics characteristics;

  public Airplane(String name, AirplaneCharacteristics characteristics) {
    this.name = name;
    this.characteristics = characteristics;
  }

  public List<TemporaryPoint> calculateRoute(TemporaryPoint startPoint, List<WayPoint> wayPoints) {
    return characteristics.calculateRoute(startPoint, wayPoints);
  }
}
