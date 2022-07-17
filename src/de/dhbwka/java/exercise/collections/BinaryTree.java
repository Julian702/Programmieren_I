package de.dhbwka.java.exercise.collections;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree<T extends Comparable<T>> {
    
    private T value;
    private BinaryTree<T> left;
    private BinaryTree<T> right;

    public static void main(String[] args) {
        BinaryTree<Integer> bintree = new BinaryTree<>();
        for (int i = 0; i < 10; i++) {
            int n = (int) (Math.random() * (100 - 1) + 1);
            bintree.add(n);
        }
        System.out.println(bintree.traverse());
    }

    public BinaryTree(){}

    public BinaryTree(T value){
        this.value = value;
    }

    public T getValue(){
        return value;
    }

    private BinaryTree<T> getLeft() {
        if(this.left == null){
            this.left = new BinaryTree<>();
        }
        return this.left;
    }

    private BinaryTree<T> getRight() {
        if(this.right == null){
            this.right = new BinaryTree<>();
        }
        return this.right;
    }
    public boolean add(T newValue){
        if(this.getValue() == null){
            this.value = newValue;
        }else if(this.getValue().compareTo(newValue) == 0){
            return false;
        }else if(this.value.compareTo(newValue) > 0) {
            return this.getLeft().add(newValue);
        }else if(this.value.compareTo(newValue) < 0) {
            return this.getRight().add(newValue);
        }
        return true;
    }

    public List<T> traverse(){
        return traverse(new ArrayList<>());
    }

    private List<T> traverse(List<T> inorder){
        if(left != null) left.traverse(inorder);
        if(value != null) inorder.add(this.getValue());
        if(right != null) right.traverse(inorder);
        return inorder;
    }
}
