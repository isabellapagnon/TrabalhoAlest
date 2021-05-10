import java.util.*;

public class App {
    public static void main(String[] args) {

        Scanner populacao = new Scanner(System.in);
        DoubleLinkedList dll = new DoubleLinkedList();

        // Caso o input da populacao seja um numero muito elevado, o algorítmo deve
        // levar bastante tempo para responder, visto que não está muito otimizado.
        System.out.println("Digite o numero da populacao de Marmia ");
        int numPopulacao = populacao.nextInt();

        while (numPopulacao < 0) {
            System.out.println("Numero invalido, tente novamente:");
            numPopulacao = populacao.nextInt();
        }

        // O programa só irá rodar caso o input seja positivo, caso seja negativo entrará em loop até que um input positivo seja digitado
        // Para terminar o programa apenas digite qualquer caracter que não seja um número.
        while (numPopulacao > 0) {
            dll.add(0);
            System.out.println(" " + "[" + dll.get(0) + "]");
            System.out.println("------------");

            for (int i = 1; i < numPopulacao; i++) {

                if (dll.sum(dll.getIndex(i - 1)) == 0) {
                    dll.add(i);
                }

                else {
                    if (dll.IsNodeRefTrailer(dll.getIndex(i - 1))) {
                        dll.add(dll.sum(dll.getIndex(i - 1)), i);
                    } else if ((dll.sum(dll.getIndex(i - 1)) + dll.getIndex(i - 1)) < dll.size()) {
                        dll.add((dll.sum(dll.getIndex(i - 1)) + dll.getIndex(i - 1)) + 1, i);
                    } else {
                        dll.add(dll.indexToAdd(dll.size(), (dll.sum(dll.getIndex(i - 1))) + 1, dll.getIndex(i - 1)), i);
                    }

                }

                dll.printTheFirst20ActiveElement(i);

            }

            dll.findWhoIsSittingNextToTheKing(0);

            // Iniciando um novo processo: Apagando os dados da fila e pedindo um novo input
            dll.EraseDataFromList();
            numPopulacao = 0;
            System.out.println("Digite o numero da populacao de Marmia ");
            numPopulacao = populacao.nextInt();

            while (numPopulacao < 0) {
                System.out.println("Numero invalido, tente novamente:");
                numPopulacao = populacao.nextInt();
            }
        }

    }

}