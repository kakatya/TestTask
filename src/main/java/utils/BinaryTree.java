package utils;

import java.util.Stack;

public class BinaryTree<T extends Comparable<T>> {
    private Branch root;

    public BinaryTree() {
        this.root = null;
    }

    public void addBranch(T t) {
        Branch newBranch = new Branch();
        newBranch.setValue(t);
        if (root == null) {
            root = newBranch;
        } else {
            Branch currentBranch = root;
            Branch parentBranch;
            while (true) {
                parentBranch = currentBranch;
                if (t.compareTo(currentBranch.getValue()) == 1) {
                    currentBranch = currentBranch.getRight();
                    if (currentBranch == null) {
                        parentBranch.setRight(newBranch);
                        return;
                    }


                } else if (t.compareTo(currentBranch.getValue()) == 0) {
                    currentBranch = currentBranch.getRight();
                    if (currentBranch == null) {
                        parentBranch.setRight(newBranch);
                        return;
                    }

                } else {
                    currentBranch = currentBranch.getLeft();
                    if (currentBranch == null) {
                        parentBranch.setLeft(newBranch);
                        return;
                    }

                }


            }
        }


    }

    public void printTree() {
        Stack globalStack = new Stack<>();
        globalStack.push(root);
        int gaps = 32;
        boolean isRowEmpty = false;
        String separator = "-----------------------------------------------------------------";
        System.out.println(separator);
        while (isRowEmpty == false) {
            Stack localStack = new Stack();
            isRowEmpty = true;

            for (int j = 0; j < gaps; j++)
                System.out.print(' ');
            while (globalStack.isEmpty() == false) {
                Branch temp = (Branch) globalStack.pop();
                if (temp != null) {
                    System.out.print(temp.getValue());
                    localStack.push(temp.getLeft());
                    localStack.push(temp.getRight());
                    if (temp.getLeft() != null ||
                            temp.getRight() != null)
                        isRowEmpty = false;
                } else {
                    System.out.print("__");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < gaps * 2 - 2; j++)
                    System.out.print(' ');
            }
            System.out.println();
            gaps /= 2;
            while (localStack.isEmpty() == false)
                globalStack.push(localStack.pop());
        }
        System.out.println(separator);
    }

    public void find() {

    }


    private class Branch {
        T value;
        Branch left;
        Branch right;


        public Branch() {
        }

        public Branch(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public void setRight(Branch right) {
            this.right = right;
        }

        public void setLeft(Branch left) {
            this.left = left;
        }

        public Branch getLeft() {
            return left;
        }

        public Branch getRight() {
            return right;
        }

        @Override
        public String toString() {
            return "Branch{" +
                    "value=" + value +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
