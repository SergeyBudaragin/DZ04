import java.util.Random;

public class Factory implements FactoryOfSweets {
    @Override
    public Sweets create() {
        Sweets Sweet;
        Random random= new Random();
        int r=random.nextInt(2);
        Sweet=(r==1)?  new Cookies(true):new Cookies(false);
        return Sweet;

    }
}
