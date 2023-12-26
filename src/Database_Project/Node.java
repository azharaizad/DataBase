/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database_Project;

/**
 *
 * @author User
 * @param <E>
 */
public class Node<E> {
    E element;
    Node<E> next;
    //String dataType;

    public Node(E element) {
        this.element = element;
    }
}
