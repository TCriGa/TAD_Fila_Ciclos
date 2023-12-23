import java.util.Random;

public class QueueOperations extends Queue {
    int operation = 0;

    public QueueOperations(int size) {
        super(size);
    }

    public Boolean isEmpty() {
        return init == fin && operation <= 0;
    }

    public Boolean isFull() {
        return init == fin && operation == 1;
    }

    public String enqueue(int value) {
        if (isFull()) {
            return "Fila está cheia";
        } else {
            queue[fin] = value;
            fin = (fin + 1) % capacity;
            operation = 1;
            return "Valor adicionado";
        }
    }

    public Integer dequeue() {
        if (isEmpty()) {
            return null;
        } else {
            int value = queue[init];
            init = (init + 1) % capacity;
            operation = -1;
            return value;
        }
    }

    public int size() {
        if (init < fin) {
            return fin - init;
        } else if (init == fin) {
            if (isEmpty()) {
                return 0;
            } else {
                return capacity;
            }
        } else {
            return capacity - (init + fin);
        }
    }

    public String print() {
        StringBuilder print = new StringBuilder();
        if (isEmpty()) {
            return "Fila vazia";
        } else if (init < fin) {
            for (int i = init; i < fin; i++) {
                print.append(queue[i]).append(" ");
            }
        } else if (isFull() || init == fin) {
            for (int i = 0; i < capacity; i++) {
                print.append(queue[i]).append(" ");
            }
        }
        if (init > 0) {
            for (int i = 0; i < init; i++) {
                print.append(queue[i]).append(" ");;
            }
        }
        return print.toString();
    }
    static int geraRand(int max){
    Random random = new Random();
    return random.nextInt(max + 1);
    }

}

