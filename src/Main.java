/**
 * Класс Main, производим действия с коробкой для подарков
 *
 * @autor Сергей Бударагин
 */
public class Main {

    public static void main(String[] args) {

        // 1 способ
        FactoryOfSweets milkChocolateFactory = new FactoryOfSweets() {
            @Override
            public Sweets create() {
                return new Chocolate(true);
            }
        };
        Sweets sweetsFromMilkChocolateFactory = milkChocolateFactory.create();
        System.out.println(sweetsFromMilkChocolateFactory);

        FactoryOfSweets MarshmallowFactory = new FactoryOfSweets() {
            @Override
            public Sweets create() {
                return new Marshmallow(true);
            }
        };
        Sweets sweetsFromMarshmallowFactory = MarshmallowFactory.create();
        System.out.println(sweetsFromMarshmallowFactory);

        // 2 способ
        Factory cookiesFactory = new Factory();
        Sweets sweetsFromCookiesFactory = cookiesFactory.create();
        System.out.println(sweetsFromCookiesFactory);

        Factory2 lollypopsFactory = new Factory2();
        Sweets sweetsFromLollypopsFactory = lollypopsFactory.create();
        System.out.println(sweetsFromLollypopsFactory);

        // 3 способ
        FactoryOfSweets sweetsMarshmallow = () -> new Marshmallow(false);
        System.out.println(sweetsMarshmallow.create());

        FactoryOfSweets sweetsLollypops = () -> new Lollypops(true);
        System.out.println(sweetsLollypops.create());
        System.out.println();
        System.out.println("Коробка 1-----------------------------------------------------------------------------------------");

        // Коробка 1
        Box box = new GiftBox();
        ((GiftBox) box).setPolicity(sweet -> sweet.price > 15);
        box.fixPrice(40);
        box.reduceWeight(500);
        box.print();
        box.delete(1);
        box.deleteLast();
        System.out.println("-----------------------------------------------------------------------------------------");
        box.add(new Chocolate(false));
        box.add(new Lollypops(false));
        box.add(new Marshmallow(false));
        box.add(new Cookies(true));
        box.add(new Chocolate(true));
        box.add(new Lollypops(true));
        box.add(new Cookies(false));
        box.add(new Lollypops(true));
        box.add(new Cookies(false));
        box.add(new Lollypops(false));
        box.add(new Cookies(true));
        box.add(new Marshmallow(true));
        box.add(new Marshmallow(false));
        box.add(new Lollypops(true));
        box.add(new Chocolate(true));
        box.add(new Lollypops(true));
        box.add(new Cookies(false));
        box.add(new Marshmallow(true));
        box.add(new Cookies(true));
        box.add(new Chocolate(true));
        System.out.println("-----------------------------------------------------------------------------------------");

        box.delete(2);
        box.deleteLast();
        box.print();
        System.out.println();
        ((GiftBox) box).printSortedByPrice();
        ((GiftBox) box).countChoco();


        ((GiftBox) box).printDollarPrice();
        ((GiftBox) box).printEuroPrice();
        System.out.println("\nУменьшаем цену сладостей в коробке--------------------------------------------------------------------------------");

        box.fixPrice(800);
        box.print();
        ((GiftBox) box).printDollarPrice();
        ((GiftBox) box).printEuroPrice();

        System.out.println("\nУменьшаем вес сладостей в коробке---------------------------------------------------------------------------------");

        box.reduceWeight(250);
        box.print();
        ((GiftBox) box).printDollarPrice();
        ((GiftBox) box).printEuroPrice();
        System.out.println();
        box.deleteByType(new Chocolate(false));
        box.print();
        System.out.println("Коробка 2-----------------------------------------------------------------------------------------");


        // Коробка 2
        Box box2 = new GiftBox();
        ((GiftBox) box2).setPolicity(sweet -> sweet.title == "Шоколад");
        box2.add(sweetsFromMilkChocolateFactory);
        box2.add(sweetsFromMarshmallowFactory);
        ((GiftBox) box2).setPolicity(sweet -> sweet.weight <= 50);
        box2.add(sweetsFromMarshmallowFactory);
        box2.print();
        ((GiftBox) box2).printDollarPrice();
        ((GiftBox) box2).printEuroPrice();


    }
}
