package dataStructures.trees.modals;


public abstract class AbstractTree<T, G extends AbstractTree<T, G, V>, V> {

    abstract G insertKey(V key);

    protected T root;

    public T getRoot() {
        return root;
    }

    public void setRoot(T root) {
        this.root = root;
    }
}
