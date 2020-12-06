package Project1;

public class Point{
    int x,y;
    Point next;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    static double distance(Point a, Point b){
        double r = Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2);
        return Math.sqrt(r);
    }

    public String toString(){
        return "(" + x + ", " + y + ")";
    }
}
