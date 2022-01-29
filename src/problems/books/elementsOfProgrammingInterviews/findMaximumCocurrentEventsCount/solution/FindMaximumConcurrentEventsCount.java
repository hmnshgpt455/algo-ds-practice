package problems.books.elementsOfProgrammingInterviews.findMaximumCocurrentEventsCount.solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Himanshu Gupta
 * Problem : 14.4 : Find the maximum concurrent event count
 * Page : 240
 * Time complexity : O(nlogn)
 * Space complexity : O(n)
 */

public class FindMaximumConcurrentEventsCount {
    public static void main(String[] args) {
        List<Event> events = new ArrayList<>();
        events.add(new Event(1, 5));
        events.add(new Event(6, 10));
        events.add(new Event(11, 13));
        events.add(new Event(14, 15));
        events.add(new Event(2, 7));
        events.add(new Event(8, 9));
        events.add(new Event(12, 15));
        events.add(new Event(4, 5));
        events.add(new Event(9, 7));

        System.out.println(findMaximumConcurrentEventCount(events));
    }

    static class EventTime implements Comparable<EventTime> {
        int time;
        boolean isStartTime;

        public EventTime(int time, boolean isStartTime) {
            this.time = time;
            this.isStartTime = isStartTime;
        }

        public EventTime() {}

        @Override
        public int compareTo(EventTime event) {
            if (event.time != this.time) {
                return Integer.compare(time, event.time);
            }

            if (this.isStartTime) {
                return -1;
            }

            return 1;
        }
    }

    static class Event {
        int startTime;
        int endTime;

        public Event(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

    static public int findMaximumConcurrentEventCount(List<Event> eventsList) {
        List<EventTime> eventTimesList = new ArrayList<>();

        eventsList.forEach(event -> {
            eventTimesList.add(new EventTime(event.startTime, true));
            eventTimesList.add(new EventTime(event.endTime, false));
        });

        Collections.sort(eventTimesList);

        AtomicInteger maxCount = new AtomicInteger(0), currentCount = new AtomicInteger(0);

        eventTimesList.forEach(eventTime -> {
            if (eventTime.isStartTime) {
                currentCount.incrementAndGet();
            } else {
                currentCount.decrementAndGet();
            }
            maxCount.set(Math.max(maxCount.get(), currentCount.get()));
        });

        return maxCount.get();
    }



}
