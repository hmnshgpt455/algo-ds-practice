package problems.books.elementsOfProgrammingInterviews.circularQueue.solution;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

class CircularQueue {
    private Integer[] list;
    private int headIndex = 0, tailIndex = 0, capacity = 0;
    private boolean hasTailCircledToFront = false;

    public CircularQueue(int capacity) {
        if (capacity > 0) {
            this.capacity = capacity;
            this.list = new Integer[capacity];
        } else {
            throw new UnsupportedOperationException("Capacity should be greater than 0");
        }
    }

    public CircularQueue enqueue(Integer element) {
        boolean isQueueFull = checkIfQueueIsFull();
        if (isQueueFull) {
            //Re-initialize the list and refill elements
            reinitializeAndRefillElementsList();
        }
        list[tailIndex++] =  element;
        circleTailIndexIfNeeded();
        return this;
    }

    public Integer dequeue() {
        if (checkIfQueueIsEmpty()) {
            reInitializeIndices();
            throw new UnsupportedOperationException("Cannot dequeue. Queue is empty");
        } else {
            int element = list[headIndex++];
            circleHeadIndexIfNeeded();
            return element;
        }
    }

    private boolean checkIfQueueIsFull() {
        if (tailIndex > headIndex) {
            return (tailIndex > list.length-1 && headIndex == 0);
        } else {
            return (tailIndex == headIndex && hasTailCircledToFront);
        }
    }

    private void reinitializeAndRefillElementsList() {
        Integer[] newList = new Integer[2 * capacity];
        AtomicInteger idx = new AtomicInteger(0);
        if (hasTailCircledToFront) {
            IntStream.range(headIndex, list.length).forEach(i -> newList[idx.getAndIncrement()] = list[i]);
            IntStream.range(0, tailIndex).forEach(i -> newList[idx.getAndIncrement()] = list[i]);
        } else {
            IntStream.range(headIndex, tailIndex + 1).forEach(i -> newList[idx.getAndIncrement()] = list[i]);
        }

        tailIndex = list.length;
        headIndex = 0;
        list = newList;
        hasTailCircledToFront = false;
    }

    private void circleTailIndexIfNeeded() {
        if (!hasTailCircledToFront && (tailIndex > (list.length-1)) && headIndex > 0) {
            tailIndex = 0;
            hasTailCircledToFront = true;
        }
    }

    private boolean checkIfQueueIsEmpty() {
        return (headIndex == tailIndex && !hasTailCircledToFront);
    }

    private void circleHeadIndexIfNeeded() {
        if (headIndex > list.length - 1) {
            if (tailIndex > list.length - 1) {
                reInitializeIndices();
            } else  {
                headIndex = 0;
            }
        }
    }

    private void reInitializeIndices() {
        tailIndex = 0;
        headIndex = 0;
        hasTailCircledToFront = false;
    }
}

