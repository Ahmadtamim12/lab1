package se.hig.aod.lab1;

public class BinarySearchTree<T extends Comparable<T>> implements SearchableDataStructure<T> {
    private TreeNode<T> root;
    private int count = 0;

    private static class TreeNode<T> {
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    @Override
    public void addElement(T element) {
        root = addRecursive(root, element);
        count++;
    }

    private TreeNode<T> addRecursive(TreeNode<T> current, T element) {
        if (current == null) {
            return new TreeNode<>(element);
        }

        int compare = element.compareTo(current.data);
        if (compare < 0) {
            current.left = addRecursive(current.left, element);
        } else if (compare > 0) {
            current.right = addRecursive(current.right, element);
        }
        return current;
    }

    @Override
    public boolean containsElement(T element) {
        return containsRecursive(root, element);
    }

    private boolean containsRecursive(TreeNode<T> current, T element) {
        if (current == null) {
            return false;
        }

        int compare = element.compareTo(current.data);
        if (compare == 0) {
            return true;
        } else if (compare < 0) {
            return containsRecursive(current.left, element);
        } else {
            return containsRecursive(current.right, element);
        }
    }

    @Override
    public void removeElement(T element) {
        root = removeRecursive(root, element);
    }

    private TreeNode<T> removeRecursive(TreeNode<T> current, T element) {
        if (current == null) {
            return null;
        }

        int compare = element.compareTo(current.data);
        if (compare == 0) {
            // Element found
            if (current.left == null && current.right == null) {
                count--;
                return null;
            } else if (current.left == null) {
                count--;
                return current.right;
            } else if (current.right == null) {
                count--;
                return current.left;
            }

            T smallestValue = findSmallestValue(current.right);
            current.data = smallestValue;
            current.right = removeRecursive(current.right, smallestValue);
            return current;
        } else if (compare < 0) {
            current.left = removeRecursive(current.left, element);
        } else {
            current.right = removeRecursive(current.right, element);
        }
        return current;
    }

    private T findSmallestValue(TreeNode<T> root) {
        return root.left == null ? root.data : findSmallestValue(root.left);
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }
}
