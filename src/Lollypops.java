/**
 * Класс, сладости леденцы
 *
 * @autor Сергей Бударагин
 */
public class Lollypops extends Sweets {
    /** Поле вкуса леденца*/
    boolean myata;

    @Override
    public String toString() {
        return super.toString() +title+", вес: "+ weight+" цена: "+price + ((myata)?", мятный": ", обычный");
    }

    public Lollypops(boolean myatnie) {
        super(10, 50);
        myata = myatnie;
        title="Леденец";

    }
}
