package binary_tree;

/**
 * @author Nikki
 * @implNote Node of my Binary Search Tree
 */
class TreeNode<E> {
  private E value;
  private TreeNode<E> parent;
  private TreeNode<E> left;
  private TreeNode<E> right;

  /**
   * Constructor for my TreeNode
   * 
   * @param value  value of generic type
   * @param parent parent of the created Node, null if root.
   */
  TreeNode(E value, TreeNode<E> parent) {
    this.value = value;
    this.parent = parent;
    this.left = null;
    this.right = null;
  }

  /**
   * 
   * @param value value of the left child to be set
   * @return pointer to the created node.
   */
  TreeNode<E> addLeftChild(E value) {
    this.left = new TreeNode<E>(value, this);
    return this.left;
  }

  /**
   * 
   * @param value value of the right child to be set
   * @return pointer to the created node.
   */
  TreeNode<E> addRightChild(E value) {
    this.right = new TreeNode<E>(value, this);
    return this.right;
  }

  TreeNode<E> getLeftChild() {
    return this.left;
  }

  TreeNode<E> getRightChild() {
    return this.right;
  }

  void removeLeftLeaf() {
    this.left = null;
  }

  void removeRightLeaf() {
    this.right = null;
  }

  TreeNode<E> getParent() {
    return this.parent;
  }

  TreeNode<E> changeLeftLink(TreeNode<E> pointed) {
    return this.left = pointed;
  }

  TreeNode<E> changeRightLink(TreeNode<E> pointed) {
    return this.right = pointed;
  }

  E setValue(E value) {
    this.value = value;
    return this.value;
  }

  E visit() {
    return this.value;
  }
}
