package problems.books.elementsOfProgrammingInterviews.implementLRUCacheForBookPrices;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Himanshu Gupta
 * Problem : 13.3 : Implement LRU cache for ISBN of books to their prices
 * Page : 214 (Kindle : 228)
 * Time complexity : O(1) for each operation
 * Space complexity : O(n) - size of the cache
 */

public class LRUCacheForBookPrices {
    LinkedHashMap<String, Double> isbnToPricesMap;

    LRUCacheForBookPrices(final int capacity) {
        this.isbnToPricesMap = new LinkedHashMap<>(capacity, 1.0f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, Double> eldest) {
                return this.size() > capacity;
            }
        };
    }

    public double lookUpKey(String isbn) {
        return isbnToPricesMap.get(isbn);
    }

    public void updateKey(String isbn, Double price) {
        isbnToPricesMap.put(isbn, price);
    }

    public void insertKey(String isbn, Double price) {
        if (!isbnToPricesMap.containsKey(isbn)) {
            isbnToPricesMap.put(isbn, price);
        }
        isbnToPricesMap.get(isbn);
    }

    public void removeKey(String isbn) {
        isbnToPricesMap.remove(isbn);
    }

}
