package Project1;

import java.util.Stack;
import static Project1.Point.distance;

/*
a.	Your program must be able to create polygons
i.	with a given stack of Points
ii.	with a given queue of Points
*/

public class Polygon{
    Point first;
    Point last;
    Stack<Point> pointStack;
    int size;
    boolean isOpen;

    Polygon(Point p1){
        this.first = p1;
        this.last = null;
        this.size = 1;
        this.isOpen = true;
        pointStack = new Stack<>();
        pointStack.push(p1);
    }

    boolean isEmpty(){
        return size == 0;
    }

    public void close(){
        last.next = first;
        last = null;
        first = null;
        isOpen = false;
    }

    void addPoint(Point p1){
        if (isEmpty()){
            first = p1;
            last = p1;
        }else if (!isOpen){
            System.out.println("Polygon is closed!");
        }else{
            if (first == p1){
                if (size < 3){
                    System.out.println("Size need to be bigger than 2 to close!");
                }else{
                    close();
                    isOpen = false;
                    System.out.println("Now your polygon has been closed.");
                }
            }else{
                last.next = p1;
                last = p1;
                size++;
                pointStack.push(p1);
            }
        }
    }

    Point removeLastPoint(){
        if (isEmpty()){
            return null;
        }else if (!isOpen){
            System.out.println("You cant remove a point from closed Polygon!");
            return null;
        }else{
            Point secondLast = first;
            while (secondLast.next.next != null){
                secondLast.next= secondLast.next.next;
            }
            secondLast.next = null;
            last = secondLast;
            size--;
            return null;
        }
    }

    void insertAtBottom(Point point1) {
    if(pointStack.isEmpty()){
        pointStack.push(point1);
    } else{
        Point a = pointStack.peek();
        pointStack.pop();
        insertAtBottom(point1);
        pointStack.push(a);
    }
    }

    void reverse() {
        if(pointStack.size() > 0) {
            Point point2 = pointStack.peek();
            pointStack.pop();
            reverse();
            insertAtBottom(point2);
        }
    }


public double calculateTotalLength(){
        double sum = 0;
        Point curr = first;
        for (int i = 0; i < size - 1; i++){
            sum += distance(curr, curr.next);
            curr = curr.next;
        }if (!isOpen){
            sum += distance(last, first);
        }
        return sum;
    }

    double area() throws Exception{
        if (isOpen){
            throw new Exception("You can't calculate an open polygon's area.");
        }
        double sum = 0;
        Point curr = first;
        for (int i = 0; i < size; i++){
            if (i != size - 1){/*last hariç*/
                sum += (curr.x * curr.next.y) - (curr.y * curr.next.x);
                curr = curr.next;
            }else{
                sum += (curr.x * first.y) - (curr.y * first.x);
            }
        }
        return Math.abs(sum/2);
    }

    public void concatenate(Polygon p1) throws Exception{
        if (!isOpen || !p1.isOpen){
            throw new Exception("You can't concatenate a closed polygon.");
        }
        last.next = p1.first;
        last = p1.last;
    }

    @Override
    public String toString(){
        String x;
        if (isOpen){
            x = "Closed";
        }else{
            x = "Open";
        }
        String string = "Polygon type: " + x + "\n Corner Number: " + size + "\n Points: " + pointStack.toString();
        return string;
    }

}