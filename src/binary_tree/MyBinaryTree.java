package binary_tree;

import doubly_linked_list.MyDLL;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Nikki
 * @implNote Binary Search Tree (Not balanced).
 */
public class MyBinaryTree<E extends Comparable<? super E>> {
  private TreeNode<E> root;
  private int size;

  /**
   * BST Constructor creates empty BST.
   */
  public MyBinaryTree() {
    this.root = null;
    this.size = 0;
  }

  /**
   * BST Constructor creates BST and adds array of elements in the order they are
   * in the array
   * 
   * @param array of nodes to be added into BST.
   */
  public MyBinaryTree(E array[]) {
    this();
    for (int i = 0; i < array.length; i++) {
      this.insert(array[i]);
    }
  }

  /**
   * In Order BST Traversal
   * 
   * @return MyDLL of node values.
   */
  public MyDLL<E> inOrder() {
    if (this.root == null)
      return null;
    MyDLL<E> traverseList = new MyDLL<>();
    this.inOrder(this.root, traverseList);
    return traverseList;
  }

  /**
   * Internal recursive BST InOrder Traversal
   * 
   * @param node from which Traversal starts
   * @param list to add visited nodes.
   */
  private void inOrder(TreeNode<E> node, MyDLL<E> list) {
    if (node == null) {
      return;
    }
    this.inOrder(node.getLeftChild(), list);
    list.add(node.visit());
    this.inOrder(node.getRightChild(), list);
  }

  /**
   * Pre Order BST Traversal
   * 
   * @return MyDLL of node values.
   */
  public MyDLL<E> preOrder() {
    if (this.root == null)
      return null;
    MyDLL<E> traverseList = new MyDLL<>();
    this.preOrder(this.root, traverseList);
    return traverseList;
  }

  /**
   * Internal recursive BST Pre Order Traversal
   * 
   * @param node from which Traversal starts
   * @param list to add visited nodes.
   */
  private void preOrder(TreeNode<E> node, MyDLL<E> list) {
    if (node == null) {
      return;
    }
    list.add(node.visit());
    this.preOrder(node.getLeftChild(), list);
    this.preOrder(node.getRightChild(), list);
  }

  /**
   * Post Order BST Traversal
   * 
   * @return MyDLL of node values.
   */
  public MyDLL<E> postOrder() {
    if (this.root == null)
      return null;
    MyDLL<E> traverseList = new MyDLL<>();
    this.postOrder(this.root, traverseList);
    return traverseList;
  }

  /**
   * Internal recursive BST Post Order Traversal
   * 
   * @param node from which Traversal starts
   * @param list to add visited nodes.
   */
  private void postOrder(TreeNode<E> node, MyDLL<E> list) {
    if (node == null) {
      return;
    }
    this.postOrder(node.getLeftChild(), list);
    this.postOrder(node.getRightChild(), list);
    list.add(node.visit());
  }

  /**
   * Level Order BST Traversal
   * 
   * @return MyDLL of node values.
   */
  public MyDLL<E> levelOrder() {
    if (this.root == null)
      return null;

    Queue<TreeNode<E>> queue = new LinkedList<>();
    queue.add(this.root);
    MyDLL<E> traverseList = new MyDLL<>();

    while (!queue.isEmpty()) {
      TreeNode<E> curr = queue.remove();
      TreeNode<E> left = curr.getLeftChild();
      TreeNode<E> right = curr.getRightChild();

      traverseList.add(curr.visit());
      if (left != null)
        queue.add(left);
      if (right != null)
        queue.add(right);
    }
    return traverseList;
  }

  /**
   * Helper method for finding first Level Order Child of BST's Node which has TWO
   * CHILDREN!
   * 
   * @param node from which searching starts
   * @return First node's Level Order Child
   * @throws NullPointerException if given node isn't parent of two children.
   */
  private TreeNode<E> getInOrderFirstChild(TreeNode<E> node) {
    // TODO: Change NullPointerException on Meaningfull exception for this case
    // because it is logical mistake, not an error.
    if (node.getLeftChild() == null || node.getRightChild() == null)
      throw new NullPointerException();
    TreeNode<E> curr = node.getRightChild();
    TreeNode<E> prev = null;
    while (curr != null) {
      prev = curr;
      curr = curr.getLeftChild();
    }
    return prev;
  }

  /**
   * 
   * @param value Value to find in BST
   * @return true if node is in the BST or false if there is no one.
   * @throws NullPointerException if argument's value is null.
   */
  public boolean find(E value) {
    if (this.binarySearch(value, this.root) != null)
      return true;
    else
      return false;
  }

  /**
   * 
   * @param value     Value to find in BST
   * @param startNode Node from which binary search is going to start
   * @return pointer to found node or null if there is no one
   * @throws NullPointerException if argument's value is null.
   */
  private TreeNode<E> binarySearch(E value, TreeNode<E> startNode) {
    if (value == null)
      throw new NullPointerException();

    TreeNode<E> curr = startNode;
    while (curr != null) {
      int comparedValue = value.compareTo(curr.visit());
      if (comparedValue < 0)
        curr = curr.getLeftChild();
      else if (comparedValue > 0)
        curr = curr.getRightChild();
      else
        return curr;
    }
    return null;
  }

  /**
   * 
   * @param value Value to be inserted into BST
   * @return true if value was inserted or false if it already exists in the BST
   * @throws NullPointerException if argument's value is null.
   */
  public boolean insert(E value) {
    if (value == null)
      throw new NullPointerException();
    if (this.root == null) {
      this.root = new TreeNode<E>(value, null);
      this.size++;
      return true;
    }

    TreeNode<E> curr = this.root;
    TreeNode<E> prev = null;
    int comparedValue = 0;

    while (curr != null) {
      prev = curr;
      comparedValue = value.compareTo(curr.visit());
      if (comparedValue < 0)
        curr = curr.getLeftChild();
      else if (comparedValue > 0)
        curr = curr.getRightChild();
      else
        return false;
    }

    if (comparedValue < 0)
      prev.addLeftChild(value);
    else
      prev.addRightChild(value);

    this.size++;
    return true;
  }

  /**
   * 
   * @param value to be removed from the BST
   * @return true if value successfully removed or false if there is no such value
   * @throws NullPointerException if argument's value is null.
   */
  public boolean remove(E value) {
    if (this.remove(value, this.root)) {
      this.size--;
      return true;
    }
    return false;
  }

  /**
   * Remove which takes in value and node from which removal proccess will begin
   * 
   * @param value     of element which has to be removed
   * @param startNode node from which proccess will start.
   * @return true if element was removed or false if it is not in the BST.
   */
  private boolean remove(E value, TreeNode<E> startNode) {
    TreeNode<E> nodeToRemove = this.binarySearch(value, startNode);
    if (nodeToRemove == null)
      return false;

    TreeNode<E> leftChild = nodeToRemove.getLeftChild();
    TreeNode<E> rightChild = nodeToRemove.getRightChild();

    if (leftChild == null && rightChild == null) {
      delLeafNode(nodeToRemove);
    } else if (leftChild == null || rightChild == null) {
      delNodeWithOneChild(nodeToRemove);
    } else {
      delNodeWithTwoChildren(nodeToRemove);
    }
    return true;
  }

  /**
   * Helper method for deleting Leaf Node from the BST
   * 
   * @param node to be removed
   * @return true when node has been removed.
   */
  private boolean delLeafNode(TreeNode<E> node) {
    if (node == this.root) {
      this.root = null;
    } else {
      TreeNode<E> parent = node.getParent();
      if (parent.getLeftChild() == node)
        parent.removeLeftLeaf();
      else
        parent.removeRightLeaf();
    }
    return true;
  }

  /**
   * Helper method for deleting Node which has one Child
   * 
   * @param node to be removed
   * @return true when node has been removed.
   */
  private boolean delNodeWithOneChild(TreeNode<E> node) {
    if (node == this.root) {
      if (this.root.getLeftChild() != null)
        this.root = this.root.getLeftChild();
      else
        this.root = this.root.getRightChild();
    } else {
      changeParentLink(node);
    }
    return true;
  }

  /**
   * Helper method for deleting node which has two Children
   * 
   * @param node to be removed
   * @return true when node has been removed.
   */
  private boolean delNodeWithTwoChildren(TreeNode<E> node) {
    TreeNode<E> levelOrderFirstChild = this.getInOrderFirstChild(node);
    E value = levelOrderFirstChild.visit();
    node.setValue(value);
    return this.remove(value, node.getRightChild());
  }

  /**
   * Helper method for deleting Node which has one Child
   * 
   * @param node to be removed.
   */
  private void changeParentLink(TreeNode<E> node) {
    TreeNode<E> parent = node.getParent();
    TreeNode<E> child = node.getLeftChild();
    if (child == null)
      child = node.getRightChild();
    if (parent.getLeftChild() == node)
      parent.changeLeftLink(child);
    else
      parent.changeRightLink(child);
  }

  public int size() {
    return this.size;
  }
}
