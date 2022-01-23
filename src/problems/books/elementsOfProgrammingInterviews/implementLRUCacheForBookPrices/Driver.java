package problems.books.elementsOfProgrammingInterviews.implementLRUCacheForBookPrices;

public class Driver {
    public static void main(String[] args) {
        LRUCacheForBookPrices lruCacheForBookPrices = new LRUCacheForBookPrices(10);
        lruCacheForBookPrices.insertKey("isbn1", 23.0);
        lruCacheForBookPrices.insertKey("isbn2", 23.0);
        lruCacheForBookPrices.insertKey("isbn3", 23.0);
        lruCacheForBookPrices.insertKey("isbn4", 23.0);
        lruCacheForBookPrices.insertKey("isbn5", 23.0);
        lruCacheForBookPrices.lookUpKey("isbn2");
        lruCacheForBookPrices.insertKey("isbn5", 23.0);
    }
}
