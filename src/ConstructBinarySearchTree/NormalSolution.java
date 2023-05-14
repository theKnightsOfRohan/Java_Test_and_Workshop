package ConstructBinarySearchTree;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NormalSolution {
    public static void main(String[] args) {
        int[] nums = constructRandomSortedArray(20, 40);
        TreeNode root = constructBST(nums);
        root.printAsString();

        int[] newNumArr = constructRandomSortedArray(10, 80);
        int[] optimizedArr = root.insertNums(newNumArr);
        TreeNode optimizedRoot = constructBST(optimizedArr);
        optimizedRoot.printAsString();

        TreeNode invertedRoot = invert(optimizedRoot);
        invertedRoot.printAsString();
    }

    public static TreeNode constructBST(int[] nums) {
        Arrays.sort(nums);

        int rootIndex = (int) nums.length/2;
        int rootval = nums[rootIndex];
        
        int[] leftArr = Arrays.copyOfRange(nums, 0, rootIndex);
        int[] rightArr = Arrays.copyOfRange(nums, rootIndex + 1, nums.length);

        if (leftArr.length == 0 && rightArr.length == 0) {
            return new TreeNode(rootval);
        } else if (leftArr.length == 0) {
            return new TreeNode(rootval, null, constructBST(rightArr));
        } else if (rightArr.length == 0) {
            return new TreeNode(rootval, constructBST(leftArr), null);
        } else {
            return new TreeNode(rootval, constructBST(leftArr), constructBST(rightArr));
        }
    }

    public static int[] constructRandomSortedArray(int maxSize, int maxValue) {
        int[] nums = new int[(int)(Math.random() * maxSize) + 1];
        HashSet<Integer> numSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int)(Math.random() * maxValue) + 1;
            if (numSet.contains(nums[i])) {
                i--;
            } else {
                numSet.add(nums[i]);
            }
        }
        Arrays.sort(nums);
        return nums;
    }

    public static TreeNode invert(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = invert(root.left);
        TreeNode right = invert(root.right);

        root.left = right;
        root.right = left;

        return root;
    }
}

class TreeNode {
    int val;
    TreeNode parent;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    TreeNode(TreeNode parent, int val, TreeNode left, TreeNode right) {
        this.parent = parent;
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public void printAsString() {
        StringBuilder sb = new StringBuilder();
        print(sb, "", "");
        System.out.println(sb.toString());
    }

    private void print(StringBuilder sb, String prefix, String childrenPrefix) {
        // https://stackoverflow.com/questions/4965335/how-to-print-binary-tree-diagram
        sb.append(prefix);
        sb.append(val);
        sb.append('\n');
        if (left != null && right != null) {
            left.print(sb, childrenPrefix + "├── ", childrenPrefix + "│   ");
            right.print(sb, childrenPrefix + "└── ", childrenPrefix + "    ");
        } else if (left != null) {
            left.print(sb, childrenPrefix + "└── ", childrenPrefix + "    ");
        } else if (right != null) {
            right.print(sb, childrenPrefix + "└── ", childrenPrefix + "    ");
        }
    }

    public int[] insertNums(int[] nums) {
        for (int num : nums) {
            insert(num);
        }
        this.printAsString();

        Set<Integer> set = new HashSet<>();
        this.optimize(this, set);

        return set.stream().mapToInt(i -> i).toArray();
    }

    public void insert(int num) {
        if (num < this.val) {
            if (this.left == null) {
                this.left = new TreeNode(this, num, null, null);
            } else {
                this.left.insert(num);
            }
        } else if (num > this.val) {
            if (this.right == null) {
                this.right = new TreeNode(this, num, null, null);
            } else {
                this.right.insert(num);
            }
        } else {
            System.out.println("Number " + num + " already exists in tree.");
        }
    }

    public void optimize(TreeNode root, Set<Integer> set) {
        if (root.left != null) {
            optimize(root.left, set);
        }
        if (root.right != null) {
            optimize(root.right, set);
        }

        set.add(root.val);
        root = null;
    }
}