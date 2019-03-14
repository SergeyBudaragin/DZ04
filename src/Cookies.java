/**
 * Класс, сладости печенька
 *
 * @autor Сергей Бударагин
 */
public class Cookies extends Sweets {
    /** Поле начинки печенья*/
    boolean snachinoi;

    @Override
    public String toString() {
        return super.toString() +title+", вес: "+ weight+" цена: "+price + ((snachinoi)?", с начинкой": ", без начинки");
    }

    public Cookies(boolean nachinka) {
        super(30, 15);
        snachinoi=nachinka;
        title="Печенька";

    }
}
