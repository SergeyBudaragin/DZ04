/**
 * Класс, сладости зефирки
 *
 * @autor Сергей Бударагин
 */
public class Marshmallow extends Sweets {
    /** Поле формы зефирки */
    boolean forma;

    @Override
    public String toString() {
        return super.toString() + title+", вес: " + weight + " цена: " + price + ((forma) ? ", круглые" : ", спиральки");
    }

    public Marshmallow(boolean forma) {
        super(50, 150);
        this.forma = forma;
        title="Зефирки";
    }
}

