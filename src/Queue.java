public class Queue {

    int size;
    int[] queue;
    int init;
    int fin;
    int capacity;

    public Queue(int size){
        this.size = size;
        this.queue = new int[size];
        this.init = 0;
        this.fin = 0;
        this.capacity = 0;

    }
}
