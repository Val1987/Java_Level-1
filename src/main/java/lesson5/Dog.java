package lesson5;

public class Dog extends Animals {

    Dog(double rr, double jr, double sr, String name) {
        super(rr, jr, sr);
        this.name = name;
    }

    void run(double distance) {
        if (distance > runRestriction)
            System.out.println(name + " can't run the distance " + distance);
        else
            System.out.println(name + " ran " + distance);
    }

    void jump(double height) {
        if (height > jumpRestriction)
            System.out.println(name + " can't jump the distance " + height);
        else
            System.out.println(name + " jumped " + height);
    }

    void swim(double distance) {
        if (distance > swimRestriction)
            System.out.println(name + " can't swim the distance " + distance);
        else
            System.out.println(name + " swam the distance " + distance);

    }

}
