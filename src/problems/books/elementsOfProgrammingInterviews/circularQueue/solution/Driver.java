package problems.books.elementsOfProgrammingInterviews.circularQueue.solution;

public class Driver {
    public static void main(String[] args) {
        CircularQueue cq = new CircularQueue(10);
        cq.enqueue(10)
                .enqueue(20)
                .enqueue(30);
        System.out.println(cq.dequeue());
        System.out.println(cq.dequeue());

        cq.enqueue(40)
                .enqueue(50)
                .enqueue(60)
                .enqueue(70)
                .enqueue(80)
                .enqueue(90)
                .enqueue(100)
                .enqueue(110)
                .enqueue(120);
        cq.dequeue();
        cq.dequeue();
        cq.dequeue();
        cq.dequeue();
        cq.dequeue();
        cq.dequeue();
        cq.dequeue();
        cq.dequeue();
        cq.dequeue();
        cq.dequeue();
        System.out.println("End");
    }
}
