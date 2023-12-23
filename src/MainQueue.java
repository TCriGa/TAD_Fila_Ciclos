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

    }
}