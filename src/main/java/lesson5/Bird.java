package lesson5;

public class Bird extends Animals {

    Bird(double rr, double jr, String name) {
        super(rr, jr, 0.0);
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
        System.out.println(name + " can't swim!");
    }

}
