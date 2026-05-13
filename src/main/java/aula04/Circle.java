package aula04;

public final class Circle extends Figure {
    private double radius;
    public Circle(double x, double y, double radius) {
        super(x, y);
        this.radius = radius;
    }

    @Override
    public String toString()
    {
        return String.format("Circle of radius %.2f in %s with area of %.2f", radius, super.toString(),area());
    }

    public double area() {
        return 0;
    }
}
