package OOPS.Door;

abstract public class Door implements Idoor {
    private double length;
    private double breadth;
    private double width;
    private String material;

    public Door(double length, double breadth, double width, String material) {
        this.length = length;
        this.breadth = breadth;
        this.width = width;
        material = material;
    }

    public double getLength() {
        return length;
    }

    public double getBreadth() {
        return breadth;
    }

    public double getWidth() {
        return width;
    }

    public String getMaterial() {
        return material;
    }

    @Override
    public void open() {
        System.out.println("open");
    }

    @Override
    public void close() {
        System.out.println("close");
    }
}
