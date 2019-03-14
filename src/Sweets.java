/**
 * Абстрактный класс сладостей
 *
 * @autor Сергей Бударагин
 */
public abstract class Sweets {
    /**
     * Поле веса и цены
     */
    double weight, price;
    /**
     * Поле названия сладости
     */
    String title;

    public Sweets(double w, double p) {
        weight = w;
        price = p;
    }

    @Override
    public String toString() {
        return "Сладость: ";
    }

}
