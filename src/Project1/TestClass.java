package Project1;

import java.util.Scanner;
import java.util.Stack;

public class TestClass {
    public static void main(String[] args) throws Exception {
        Stack<Polygon> polArray = new Stack<>();
        int x, y;
        int opt = 1;
        int opt2;
        String ans;
        Point p1, p2;
        Polygon pol1;
        Scanner input = new Scanner(System.in);
        System.out.println("---Welcome to the Lines & Polygons representing program.---\n" +
                "Lines & Polygons are formed with linked Points.\n" +
                "To continue, first you need to create a point...\n" +
                "Enter value of x => (x, y)");
        x = input.nextInt();
        System.out.println("Enter value of y => (" + x + ", y)");
        y = input.nextInt();
        p1 = new Point(x, y);
        System.out.println("Point created => (" + x + ", " + y + ") ");
        while (opt > 0 && opt < 13) {
            System.out.println("\n*****|| MENU  ||*****\n" +
                    "1) Add point with 2D coordinates\n" +
                    "2) Calculate selected point distance to other points\n" +
                    "3) Create a polygon\n" +//i.	with the user given Point positions (x and y) ii.	with a given stack of Points iii.	with a given queue of Points
                    "4) Add point to polygon\n" +
                    "5) Remove point from polygon\n" +
                    "6) Learn number of points\n" +
                    "7) Learn the points of a selected polygon\n" +
                    "8) Close a polygon\n" +
                    "9) Calculate the total length of the selected polygon\n" +
                    "10) Calculate the area of the selected polygon\n" +
                    "11) Concatenate a polygon with another polygon\n" +
                    "12) Reverse the points of selected polygon in the order\n" +
                    "13) Exit");

            opt = input.nextInt();

            if (opt == 1) {//1) Add point with 2D coordinates       gerekli mi & nerede kullanılacak
                System.out.println("Enter value of x => (x, y)");
                x = input.nextInt();
                System.out.println("Enter value of y => (" + x + ", y)");
                y = input.nextInt();
                p1 = new Point(x, y);
                System.out.println("Point created => " + p1.toString());
            }

            if (opt == 2) {//2) Calculate selected point distance to other points
                System.out.println("You have the point => (" + p1.x + ", " + p1.y + ") \n" +
                        "Do you want to use it? (yes & no)");
                ans = input.next();/////
                if (!ans.equalsIgnoreCase("yes") && !ans.equalsIgnoreCase("no")){
                    System.out.println("Invalid input!");
                    break;
                }else if (ans.equalsIgnoreCase("no")) {
                    System.out.println("Enter value of x => (x, y)");
                    x = input.nextInt();
                    System.out.println("Enter value of y => (" + x + ", y)");
                    y = input.nextInt();
                    p1 = new Point(x, y);
                    System.out.println("Point created => " + p1.toString());
                }
                System.out.println("Enter the other point: ");
                System.out.println("Enter value of x => (x, y)");
                x = input.nextInt();
                System.out.println("Enter value of y => (" + x + ", y)");
                y = input.nextInt();
                p2 = new Point(x, y);
                System.out.println("Point created => " + p2.toString());
                System.out.println("Distance between " + p1.toString() + " and " + p2.toString() + " is: " + Point.distance(p1, p2));
            }

            if (opt == 3) {//3) Create a polygon
                System.out.println("With which way do you want to create polygon?\n" +
                        "1) Selected point\n" +
                        "2) New Point\n" +
                        "3) With the given stack of points\n" +
                        "4) With the given queue of points");
                opt2 = input.nextInt();
                if (opt2 == 1){
                    pol1 = new Polygon(p1);
                    polArray.push(pol1);
                }else if (opt2 == 2){
                    System.out.println("Enter value of x => (x, y)");
                    x = input.nextInt();
                    System.out.println("Enter value of y => (" + x + ", y)");
                    y = input.nextInt();
                    p1 = new Point(x, y);
                    System.out.println("Point created => " + p1.toString());
                    pol1 = new Polygon(p1);
                    polArray.push(pol1);
                }else if (opt2 == 3){
                    System.out.println();
                }else if (opt2 == 4){
                    System.out.println();
                }else{
                    System.out.println("Invalid input!");
                }
            }

            if (opt == 4) {//4) Add point to polygon
                System.out.println("Enter value of x => (x, y)");
                x = input.nextInt();
                System.out.println("Enter value of y => (" + x + ", y)");
                y = input.nextInt();
                p1 = new Point(x, y);
                System.out.println("Point created => " + p1.toString());
                System.out.println("Which polygon do you want to add point to?");
                opt2 = input.nextInt();
                if (polArray.elementAt(opt2 - 1) == null){
                    System.out.println("Null place!");
                    break;
                }
                polArray.elementAt(opt2 - 1).addPoint(p1);
                polArray.elementAt(opt2 - 1).pointStack.push(p1);
            }

            if (opt == 5) {//5) Remove point from polygon
                System.out.println("Which polygon's last point do you want to remove to?");
                opt2 = input.nextInt();
                if (polArray.elementAt(opt2 - 1) == null){
                    System.out.println("Null place!");
                    break;
                }
                polArray.elementAt(opt2 - 1).removeLastPoint();
            }

            if (opt == 6) {//6) Learn number of points
                System.out.println("Which polygon's number of points do you want to learn to?");
                opt2 = input.nextInt();
                if (polArray.elementAt(opt2 - 1) == null){
                    System.out.println("Null place!");
                    break;
                }
                System.out.println("Number of Points: " + polArray.elementAt(opt2 - 1).size);

            }

            if (opt == 7) {//7) Learn the points of a selected polygon
                System.out.println("Which polygon's points do you want to learn to?");
                opt2 = input.nextInt();
                if (polArray.elementAt(opt2 - 1) == null){
                    System.out.println("Null place!");
                    break;
                }
                System.out.println(polArray.elementAt(opt2 - 1).pointStack.toString());
            }

            if (opt == 8) {//8) Close a polygon
                System.out.println("Which polygon do you want to close to?");
                opt2 = input.nextInt();
                if (polArray.elementAt(opt2 - 1) == null){
                    System.out.println("Null place!");
                    break;
                }
                polArray.elementAt(opt2 - 1).close();//ya kapalıysa?? metotta eksik var
            }

            if (opt == 9) {//9) Calculate the total length of the selected polygon
                System.out.println("Which polygon's total length do you want to learn to?");
                opt2 = input.nextInt();
                if (polArray.elementAt(opt2 - 1) == null){
                    System.out.println("Null place!");
                    break;
                }
                System.out.println("Total length: " + polArray.elementAt(opt2 - 1).calculateTotalLength());
            }

            if (opt == 10) {//10) Calculate the area of the selected polygon
                System.out.println("Which polygon's area do you want to calculate to?");
                opt2 = input.nextInt();
                if (polArray.elementAt(opt2 - 1) == null){
                    System.out.println("Null place!");
                    break;
                }
                System.out.println("Area: " + polArray.elementAt(opt2 - 1).area());
            }

            if (opt == 11) {//11) Concatenate a polygon with another polygon
                System.out.println("Which polygon do you want to concatenate?");
                opt2 = input.nextInt();
                if (polArray.elementAt(opt2 - 1) == null){
                    System.out.println("Null place!");
                    break;
                }
                System.out.println("And for the another polygon? ");
                int opt3 = input.nextInt();
                if (polArray.elementAt(opt2 - 1) == null){
                    System.out.println("Null place!");
                    break;
                }else if (opt2 == opt3){
                    System.out.println("You need to select different!");
                }
                polArray.elementAt(opt2 - 1).concatenate(polArray.elementAt(opt3 - 1));
            }
            if(opt == 12) {
                System.out.println("Which polygon do you want to reverse?");
                opt2 = input.nextInt();
                if (polArray.elementAt(opt2 - 1) == null){
                    System.out.println("Null place!");
                    break;
                }
                polArray.elementAt(opt2 - 1).reverse();
            }
            for (int i = 0; i < polArray.size(); i++){
                System.out.println(polArray.toString());
            }

        }
        if (opt == 13){
            System.out.println("Exiting... :)");
        }
    }
}
