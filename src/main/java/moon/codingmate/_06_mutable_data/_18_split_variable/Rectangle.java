package moon.codingmate._06_mutable_data._18_split_variable;

public class Rectangle {

    private double perimeter;
    private double area;

    public void updateGeometry(double height, double width) {
        // temp 역할 1 : perimeter
        // double temp = 2 * (height + width);
        final double perimeter = 2 * (height + width);
        System.out.println("Perimeter: " + perimeter);
        //둘레
        this.perimeter = perimeter;

        // temp 역할 2 : area
        // double temp = height * width;
        final double area = height * width;
        System.out.println("Area: " + area);
        //넓이
        this.area = area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public double getArea() {
        return area;
    }
}
