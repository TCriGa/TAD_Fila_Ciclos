import java.util.Scanner;

public class MainQueue {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨");
        System.out.println("-Programa de simulação de fila de jobs a serem executados-");
        System.out.println("___________________________________________________________");
        System.out.println();

        System.out.println("------------Informe o tamanho máximo da fila -> ");
        int sizeQueue = scanner.nextInt();
        QueueOperations queueOperations = new QueueOperations(sizeQueue);
        System.out.println();
        Queue queue = new Queue(sizeQueue);

        System.out.println("------------Informe o número de ciclos -> ");
        int numberCyclo = scanner.nextInt();
        System.out.println();
        System.out.println("------------Informe o máximo de jobs gerados por ciclos -> ");
        int maxJobs = scanner.nextInt();
        System.out.println();
        System.out.println("-----------Informe a quantidade de processadores paralelos");
        int qtdProcessors = scanner.nextInt();

        int timesExceeded = 0;  // quantidade de vezes que a fila excedeu o tamanho maximo possivel
        int jobsGenerated = 0;
        int jobsLost = 0;

        for (int i = 1; i <= numberCyclo ; i++) {

            int jobs = QueueOperations.geraRand (maxJobs);
            jobsGenerated += jobs;
            int variacao = jobs - qtdProcessors;

            if (variacao > 0) {
                for (int j = 0; j < variacao; j++) {
                    if (queueOperations.isFull()) {
                        timesExceeded++;
                        jobsLost += variacao - j;
                        break;
                    }
                    timesExceeded++;
                    jobsLost += variacao - j;
                        break;
                    }
                queueOperations.enqueue(QueueOperations.geraRand (1000));
                }
            if (variacao < 0) {
                variacao *= -1;
                for (int j = 0; j < variacao; j++) {
                    if (queueOperations.isEmpty()) {
                        break;
                    }
                    queueOperations.dequeue();
                }
            }

        }
        System.out.println("--------------------------------------------------");
        System.out.println("Rodou " + numberCyclo + " ciclos.");
        System.out.println("Jobs gerados -> " + jobsGenerated);
        System.out.println("Excedeu " + timesExceeded + " vezes (" + 100 * timesExceeded / numberCyclo + "%)");
        System.out.println("Jobs perdidos -> " + jobsLost + "(" + 100 * (double) jobsLost / jobsGenerated + " %)");

    }

}