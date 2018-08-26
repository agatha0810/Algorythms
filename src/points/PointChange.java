package points;
/*
import points.PointPosition;
*/
public class PointChange {

    public void addX(PointPosition p){
        p.setX(p.getX()+1);
    }
    public void addY(PointPosition p){
        p.setY(p.getY()+1);
    }
    public void minusX(PointPosition p){
        p.setX(p.getX()-1);
    }
    public void minusY(PointPosition p){
        p.setY(p.getY()-1);
    }

}