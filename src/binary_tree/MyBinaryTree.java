package binary_tree;

import doubly_linked_list.MyDLL;

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
      return new MyDLL<>();
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
      return new MyDLL<>();
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
      return new MyDLL<>();
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
      return new MyDLL<>();

    MyDLL<TreeNode<E>> queue = new MyDLL<>();
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
   * Helper method for finding first InOrder Successor of a given Node,
   * WHICH HAS GOT TWO CHILDREN!
   * 
   * @param node from which searching starts
   * @return Given node's first InOrder successor
   * @throws IllegalArgumentException if given node isn't parent of two children.
   */
  private TreeNode<E> getInOrderFirstChild(TreeNode<E> node) {
    if (node.getLeftChild() == null | node.getRightChild() == null)
      throw new IllegalArgumentException("Given Node Must Have Two Children!");
    TreeNode<E> curr = node.getRightChild();
    TreeNode<E> prev = null; // Curr is never null in the first itteration, so prev can be init as null
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
    return null; // It is internal method, caller will check if return is null
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

    TreeNode<E> curr = this.root; // at this point root is never null
    TreeNode<E> prev = null; // at least one iteration occurs, so prev won't be null
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
   * @return True if element was removed or False if it is not in the BST.
   */
  private boolean remove(E value, TreeNode<E> startNode) {
    TreeNode<E> nodeToRemove = this.binarySearch(value, startNode);
    if (nodeToRemove == null)
      return false;

    TreeNode<E> leftChild = nodeToRemove.getLeftChild();
    TreeNode<E> rightChild = nodeToRemove.getRightChild();

    if (leftChild == null && rightChild == null) {
      delLeafNode(nodeToRemove);
    } else if (leftChild == null | rightChild == null) {
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
      this.root = null; // erasing leaf node (root in this case)
    } else {
      TreeNode<E> parent = node.getParent();
      if (parent.getLeftChild() == node)
        parent.removeLeftLeaf();
      else
        parent.removeRightLeaf();
      node.setParent(null);
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
      TreeNode<E> onlyChild = this.root.getLeftChild();
      if (onlyChild != null) {
        this.root = onlyChild;
        onlyChild.setParent(null);
      } else {
        onlyChild = this.root.getRightChild();
        this.root = onlyChild;
        onlyChild.setParent(null);
      }
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
    TreeNode<E> InOrderFirstChild = this.getInOrderFirstChild(node);
    E value = InOrderFirstChild.visit();
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
    TreeNode<E> onlyChild = node.getLeftChild();
    if (onlyChild == null)
      onlyChild = node.getRightChild();
    if (parent.getLeftChild() == node)
      parent.changeLeftLink(onlyChild);
    else
      parent.changeRightLink(onlyChild);
    onlyChild.setParent(parent);
  }

  /**
   * 
   * @return Number of nodes in the Tree.
   */
  public int size() {
    return this.size;
  }

  /**
   * Draws Tree in the console.
   */
  public void drawMe() {
    if (this.root == null) {
      System.out.println("Empty Tree");
      return;
    }

    int height = this.height();
    int depth = height + 1;
    int spaces = height * 4;
    int maxNodesInTree = (int) ((Math.pow(2, depth)) - 1);

    MyDLL<TreeNode<E>> queue = new MyDLL<>();
    MyDLL<String> toDrawList = new MyDLL<>();
    queue.add(this.root);

    for (int i = 0; i < maxNodesInTree; i++) {
      TreeNode<E> curr = queue.remove();
      TreeNode<E> left = (curr != null) ? curr.getLeftChild() : null;
      TreeNode<E> right = (curr != null) ? curr.getRightChild() : null;

      toDrawList.add((curr != null) ? curr.visit().toString() : "null");

      if (left != null)
        queue.add(left);
      else
        queue.add(null);
      if (right != null)
        queue.add(right);
      else
        queue.add(null);
    }

    int nodesOnThisLevel = 1;
    for (int i = 1; i <= depth; i++) {

      int branchesSpace = nodesOnThisLevel / 2;

      for (int s = 0; s < spaces; s++)
        System.out.print("\s");
      spaces -= 2;

      for (int j = 1; j <= nodesOnThisLevel; j++) {
        String node = toDrawList.remove();
        System.out.print(node + " ");

        if (j == branchesSpace)
          for (int s = 0; s < ((depth * 2) - i); s++)
            System.out.print(" ");
      }
      System.out.print("\n");

      for (int s = 0; s < spaces; s++)
        System.out.print("\s");
      spaces -= 2;
      System.out.print("\n");

      nodesOnThisLevel *= 2;
    }
  }

  public int height() {
    if (this.root == null)
      return -1;
    return this.height(this.root);
  }

  private int height(TreeNode<E> startNode) {
    if (startNode == null)
      return -1;

    int leftHeight = this.height(startNode.getLeftChild());
    int rightHeight = this.height(startNode.getRightChild());

    return Math.max(leftHeight, rightHeight) + 1;
  }
}
