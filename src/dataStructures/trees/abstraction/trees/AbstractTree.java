package dataStructures.trees.abstraction.trees;


public abstract class AbstractTree<T, V>  implements Tree<V> {

    protected T root;

    public T getRoot() {
        return root;
    }

    public void setRoot(T root) {
        this.root = root;
    }
}
