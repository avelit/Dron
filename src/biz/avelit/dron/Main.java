package biz.avelit.dron;

import java.util.*;

public class Main {

  public static void main(String[] args) {

    AirplaneCharacteristics characteristics = new AirplaneCharacteristics(500.0,10.0,10.0,10.0);//TODO builder
    Airplane airplane = new Airplane("Dron",characteristics);

    List<WayPoint> wayPoints = new ArrayList<WayPoint>(){
      {
        add(new WayPoint(10.0,10.0,100.0,200.0));
        add(new WayPoint(20.0,20.0,200.0,300.0));
        add(new WayPoint(10.0,20.0,150.0,150.0));
      }
    };

    TemporaryPoint startPoint = new TemporaryPoint(0.0,0.0,0.0,0.0,0.0);
    List<TemporaryPoint> points = airplane.calculateRoute(startPoint, wayPoints);
    for (TemporaryPoint point: points) {
      System.out.println(point);
    }
  }

}
