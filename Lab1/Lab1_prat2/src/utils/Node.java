package utils;

public class Node<T> {
    T Data;
    Node<T> Next;

    public Node(){}
    public Node(T value, Node<T> next)
    {
        this.Data = value;
        this.Next = next;
    }
}
