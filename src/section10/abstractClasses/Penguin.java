package section10.abstractClasses;

public class Penguin extends Bird {


    public Penguin(String name) {
        super(name);
    }

    @Override
    public void fly() {
        super.fly();
        System.out.println("I can't fly very well...im good in swimming");
    }


}
