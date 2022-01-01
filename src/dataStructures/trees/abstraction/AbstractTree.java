package dataStructures.trees.abstraction;


public abstract class AbstractTree<T, G extends AbstractTree<T, G, V>, V>  implements Tree<G, V> {

    protected T root;

    public T getRoot() {
        return root;
    }

    public void setRoot(T root) {
        this.root = root;
    }
}
