/**
 * Класс, сладости шоколадка
 *
 * @autor Сергей Бударагин
 */
public class Chocolate extends Sweets {
    /** Поле молочной шоколадки или нет */
    boolean milk;

    public Chocolate( boolean molochnyi) {
        super(100, 90);
        milk=molochnyi;
        title="Шоколад";
    }

    @Override
    public String toString() {
        return super.toString() +title+", вес: "+ weight+" цена: "+price + ((milk)?", молочный": ", обычный");
    }
}
