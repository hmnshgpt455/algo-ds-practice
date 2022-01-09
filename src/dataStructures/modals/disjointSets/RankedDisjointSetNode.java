package dataStructures.modals.disjointSets;

public class RankedDisjointSetNode<T> {

    private T value;
    private RankedDisjointSetNode<T> parent;
    private Integer rank;

    public RankedDisjointSetNode(T value, Integer rank) {
        this.value = value;
        this.rank = rank;
        this.parent = this;
    }

    public RankedDisjointSetNode(T value, RankedDisjointSetNode<T> parent, Integer rank) {
        this.value = value;
        this.parent = parent;
        this.rank = rank;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public RankedDisjointSetNode<T> getParent() {
        return parent;
    }

    public void setParent(RankedDisjointSetNode<T> parent) {
        this.parent = parent;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }
}
