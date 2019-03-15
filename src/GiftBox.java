import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class GiftBox implements Box, Policity {
    private List<Sweets> sweets = new ArrayList<>();
    Predicate<Sweets> predicate;

    Converter convertFromRubToEuro = (rub) -> Math.round(rub / 75 * 100) / 100d;
    Converter convertFromRubToDollar = (rub) -> Math.round(rub / 65 * 100) / 100d;

    public GiftBox(Predicate<Sweets> predicate) {
        this.predicate = predicate;
    }

    public GiftBox() {
    }

    /**
     * Политика предиката
     *
     * @param predicate условие
     */

    @Override
    public void setPolicity(Predicate<Sweets> predicate) {
        this.predicate = predicate;
    }


    /**
     * Метод выводит текуций состав коробки с подарками
     */
    @Override
    public void print() {
        if (sweets.size() > 0) {
            System.out.println("Состав нашего подарка:");
            sweets.forEach(System.out::println);
            System.out.println("Общий вес подарка: " + weightNow() + " гр., общая цена подарка: " + priceNow() + " руб.");
        } else {
            System.out.println("Коробка пуста");
        }

    }

    /**
     * Метод выводит текуций отсортированный состав коробки с подарками
     */
    public void printSortedByPrice() {
        if (sweets.size() > 0) {
            System.out.println("Состав нашего подарка:");
            sweets.stream().sorted(Comparator.comparingDouble(o -> o.price)).forEach(System.out::println);
            System.out.println("Общий вес подарка: " + weightNow() + " гр., общая цена подарка: " + priceNow() + " руб.");
        } else {
            System.out.println("Коробка пуста");
        }

    }
    /**
     * Метод выводит количество шоколадок в коробке
     */
    public void countChoco() {
        long count = sweets.stream().filter(sweet -> sweet.title == "Шоколад").count();
        System.out.println("Количество шоколадок : " + count);
    }


    /**
     * Метод удаляет сладости конкретного типа
     *
     * @param sweets - тип сладости для удаления
     */

    @Override
    public void deleteByType(Sweets sweet) {
        if (sweets.size() == 0) {
            System.out.println("Коробка пуста");
        } else {
            for (int i = 0; i < sweets.size()-1; i++) {
                if (sweets.get(i).title == sweet.title) {
                    sweets.remove(i);
                    i--;
                }
            }
        }

    }

    /**
     * Метод добавляет сладость в коробку
     *
     * @param sweet - конкретный вид сладости
     */
    @Override
    public void add(Sweets sweet) {
        if (predicate.test(sweet)) {
            sweets.add(sweet);
        } else {
            System.out.println(sweet + " - не удовлетворяет политике коробки!");
        }
    }


    /**
     * Метод удаляет заданный элемент из коробки
     *
     * @param number - номер для удаления
     */
    @Override
    public void delete(int number) {
        if (sweets.size() == 0) System.out.println("Коробка пуста");
        else if (sweets.size() - 1 < number) System.out.println("Нет такой сладости в подарке");
        else sweets.remove(number);
    }

    /**
     * Метод получающий текущую цену слдостей в коробке
     *
     * @return - возвращает текущую цену
     */
    @Override
    public double priceNow() {
        double priceNow = 0;
        if (sweets.size() > 0) {
            for (Sweets sw : sweets) {
                priceNow += sw.price;
            }
            return priceNow;
        } else {
            System.out.println("Коробка пуста");
            return 0;
        }
    }

    /**
     * Метод получающий текущий вес коробки
     *
     * @return - возвращает текущий вес коробки
     */
    @Override
    public double weightNow() {
        double weightNow = 0;
        if (sweets.size() > 0) {
            for (Sweets sw : sweets) {
                weightNow += sw.weight;
            }
            return weightNow;
        } else {
            System.out.println("Коробка пуста");
            return 0;
        }
    }

    /**
     * Метод получающий номер сладости в коробке с наименьшей ценой
     *
     * @return - возвращает номер сладости с наименьшей ценой
     */
    @Override
    public int findLowerPriceSweet() {
        int numberOfLowerPriceSweet = 0;
        if (sweets.size() > 0) {
            for (int i = 0; i < sweets.size() - 1; i++) {
                if (sweets.get(i).price < sweets.get(numberOfLowerPriceSweet).price) {
                    numberOfLowerPriceSweet = i;
                }
            }
        } else {
            System.out.println("Коробка пуста");
        }
        return numberOfLowerPriceSweet;
    }

    /**
     * Метод получающий номер сладости в коробке с наименьшим весом
     *
     * @return - возвращает номер сладости с наименьшим весом
     */
    @Override
    public int findLowerWeightSweet() {
        int numberOfLowerWeightSweetSweet = 0;
        if (sweets.size() > 0) {
            for (int i = 0; i < sweets.size() - 1; i++) {
                if (sweets.get(i).weight < sweets.get(numberOfLowerWeightSweetSweet).weight) {
                    numberOfLowerWeightSweetSweet = i;
                }
            }
        } else {
            System.out.println("Коробка пуста");
        }
        return numberOfLowerWeightSweetSweet;

    }

    /**
     * Метод уменьшающий вес сладостей в коробке до требуемого
     *
     * @param limitWeight требуемый вес
     */
    @Override
    public void reduceWeight(double limitWeight) {
        if (limitWeight < 0) {
            System.out.println("Желаемая вес не корректен");
        } else if (limitWeight < weightNow() && sweets.size() > 0) {
            do {
                delete(findLowerWeightSweet());
            } while (weightNow() > limitWeight);
        }

    }

    /**
     * Метод уменьшающий цену сладостей в коробке до требуемой
     *
     * @param limitPrice требуемая цена
     */
    @Override
    public void fixPrice(double limitPrice) {
        if (limitPrice < 0) {
            System.out.println("Желаемая цена не корректна");
        } else if (limitPrice < priceNow() && sweets.size() > 0) {
            do {
                delete(findLowerPriceSweet());
            } while (priceNow() > limitPrice);
        }
    }

    /**
     * Метод удаляющий последнюю сладость из коробки
     */
    @Override
    public void deleteLast() {
        if (sweets.size() > 0) {
            sweets.remove(sweets.size() - 1);

        } else {
            System.out.println("Коробка пуста");
        }
    }

    public void printEuroPrice() {
        System.out.println("Цена в евро: " + convertFromRubToEuro.convert(priceNow()));
    }

    public void printDollarPrice() {
        System.out.println("Цена в долларах: " + convertFromRubToDollar.convert(priceNow()));
    }
}