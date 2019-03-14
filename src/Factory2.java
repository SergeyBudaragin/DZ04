import java.util.Random;

public class Factory2 implements FactoryOfSweets {
    @Override
    public Sweets create() {
        Sweets Sweet;
        Random random= new Random();
        int r=random.nextInt(2);
        Sweet=(r==1)?  new Lollypops(true):new Lollypops(false);
        return Sweet;
    }
}
