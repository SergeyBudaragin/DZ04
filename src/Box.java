public interface Box {
    public void add(Sweets sweet);
    public void delete(int number);
    public void deleteLast();
    public void print();
    public void fixPrice(double limitPrice);
    public double priceNow();
    public double weightNow();
    public int findLowerPriceSweet();
    public int findLowerWeightSweet();
    public void reduceWeight(double limitWeight);
//    public void deleteByType(Sweets sweets);

}
