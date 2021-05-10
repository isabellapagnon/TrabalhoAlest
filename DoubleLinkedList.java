public class DoubleLinkedList {

    // Referencia para o sentinela de inicio da lista encadeada.
    private Node header;
    // Referencia para o sentinela de fim da lista encadeada.
    private Node trailer;
    // Contador do numero de elementos da lista.
    private int count;

    private class Node {
        public Integer element;
        public Node next;
        public Node prev;

        public Node(Integer e) {
            element = e;
            next = null;
            prev = null;
        }
    }

    public DoubleLinkedList() {
        header = new Node(null);
        trailer = new Node(null);
        header.next = trailer;
        trailer.prev = header;
        count = 0;
    }

    public void add(Integer element) {
        // Primeiro: cria o nodo
        Node n = new Node(element);
        // Depois "gruda" o nodo criado na lista
        n.next = trailer;
        n.prev = trailer.prev;
        // Ajustar os encadeamentos para o novo nodo
        trailer.prev.next = n;
        trailer.prev = n;
        // Por fim, atualiza o contador
        count++;
    }

    public void add(int index, Integer element) throws IndexOutOfBoundsException {
        if (index < 0 || index > count) // indice invalido
            throw new IndexOutOfBoundsException();
        if (index == count) {
            add(element);
        } else {
            Node aux = getNodeRef(index);
            Node n = new Node(element);
            n.next = aux;
            n.prev = aux.prev;
            aux.prev.next = n;
            aux.prev = n;
            count++;
        }
    }

    private Node getNodeRef(int index) {
        Node aux = null;
        if (index < count / 2) {
            aux = header.next;
            for (int i = 0; i < index; i++)
                aux = aux.next;
        } else {
            aux = trailer.prev;
            for (int i = count - 1; i > index; i--)
                aux = aux.prev;
        }
        return aux;
    }

    public Integer get(int index) {
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException();
        }
        Node aux = getNodeRef(index);
        return aux.element;
    }

    public int size() {
        return count;
    }

    /**
     * Retorna true se a lista não contem elementos
     * 
     * @return true se a lista não contem elementos
     */
    public boolean isEmpty() {
        return (count == 0);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        Node aux = header.next;
        for (int i = 0; i < count; i++) {
            s.append(aux.element.toString());
            s.append("\n");
            aux = aux.next;
        }
        return s.toString();
    }

    public int sum(int index) {
        Node aux = getNodeRef(index);
        if (aux.next.element == null) {
            aux.next.element = 0;
        }
        if (aux.prev.element == null) {
            aux.prev.element = 0;
        }
        return (aux.next.element + aux.prev.element);
    }

    public int indexToAdd(int size, int sum, int previousIndex) {
        int x = size - previousIndex;
        int result = sum - x;
        while(result > size){
            result = result - size;
        }
        return result;
    }

    public boolean IsNodeRefTrailer(int index) {
        Node aux = getNodeRef(index);
        return aux.next == trailer;
    }

    public boolean isNodeRefHeader(int index) {
        Node aux = getNodeRef(index);
        return aux.prev == header;
    }

    public int getIndex(int element) {
        Node aux = header.next;
        for (int i = 0; i < count; i++) {
            if (aux.element.equals(element)) {
                return i;
            }
            aux = aux.next;
        }
        return -1;
    }

    public void printTheFirst20ActiveElement(int element) {
        Node aux = header.next;
        for (int i = 0; i < count; i++) {
            if (aux.element.equals(element)) {
                System.out.print("[" + element + "]");
            } else {
                System.out.print(" " + aux.element + " ");
            }
            aux = aux.next;
        }
            System.out.println("\n" + "------------");
    }

    public void findWhoIsSittingNextToTheKing(int element) {
        Node aux = header.next;
        if(aux.prev.element == 0){
            System.out.println("Sentado ao lado do Rei está: " + aux.next.element);
        }
        else if (aux.next.element == 0){
            System.out.println("Sentado ao lado do Rei está: " + aux.prev.element);
        }
        else{
        System.out.println("Sentados ao lado do Rei: " + aux.prev.element + " e " + aux.next.element);
        }
    }

    public void EraseDataFromList(){
        header = new Node(null);
        trailer = new Node(null);
        header.next = trailer;
        trailer.prev = header;
        count = 0;
    }
}
