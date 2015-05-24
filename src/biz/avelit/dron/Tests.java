package biz.avelit.dron;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Tests {
  @Test
  public void closeToPoint() {
    WayPoint point = new WayPoint(10.0,10.0,99.91,200.05);

    TemporaryPoint temporaryPoint = new TemporaryPoint(10.0,10.0,100.0,200.0,100.0);
    WayPoint result = temporaryPoint.getWaypoint();

    Assert.assertEquals(result,point);
  }

}
