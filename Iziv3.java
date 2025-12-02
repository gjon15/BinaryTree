import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

public class Iziv3 {

    public static class TreeNode {
        int value;
        TreeNode left, right;
        double x, y;
        int drawNum = 0;

        public TreeNode(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static class BinaryTree {
        TreeNode root_num;
        int n;
        int drawC = 0;

        public BinaryTree(int n) {
            this.n = n;
            root_num = buildFullTree(1, n);
            setNPosition(root_num, 0, n-1, 0.95);
        }

        private TreeNode buildFullTree(int l, int r) {
            if (l > r) return null;
            int k = (l + r) / 2;
            TreeNode node = new TreeNode(k);
            node.left = buildFullTree(l, k-1);
            node.right = buildFullTree(k+1, r);
            return node;
        }


        private void setNPosition(TreeNode node, int leftIndex, int rightIndex, double y) {
            if (node == null) return;
            int kIndex = (leftIndex + rightIndex) / 2;
            double margin = 0.05;
            node.x = margin + (1 - 2*margin) * kIndex / (n-1);
            node.y = y;
            double yDelay = 0.5 / Math.log(n);
            setNPosition(node.left, leftIndex, kIndex -1, y - yDelay);
            setNPosition(node.right, kIndex +1, rightIndex, y - yDelay);
        }

        private void drawEdge(TreeNode node) {
            if (node == null) return;
            if (node.left != null) {
                StdDraw.line(node.x, node.y, node.left.x, node.left.y);
                drawEdge(node.left);
            }
            if (node.right != null) {
                StdDraw.line(node.x, node.y, node.right.x, node.right.y);
                drawEdge(node.right);
            }
        }

        private void drawCircle(TreeNode node) {
            if (node == null) return;
            int fontSize = (int)Math.max(10, 80 / Math.log(Math.max(n,3)));
            StdDraw.setFont(new java.awt.Font("Arial", Font.PLAIN, fontSize));
            StdDraw.setPenColor(StdDraw.BLACK);
            double nodeRadius = 0.1 / Math.log(Math.max(n,3));
            StdDraw.filledCircle(node.x, node.y, nodeRadius);
        }

        private void drawLabel(TreeNode node) {
            if (node == null) return;
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.text(node.x, node.y, String.valueOf(node.drawNum));
        }

//-------------------------------------------------------------------------------------------------------

        private void drawInO(TreeNode node) {
            if (node == null) return;
            drawInO(node.left);
            drawC++;
            node.drawNum = drawC;
            drawCircle(node);
            drawLabel(node);
            drawInO(node.right);
        }
        public void drawTreeInO() {
            StdDraw.clear();
            drawEdge(root_num);
            drawC = 0;
            drawInO(root_num);
            StdDraw.show();
        }


        private void drawPreO(TreeNode node) {
            if (node == null) return;
            drawC++;
            node.drawNum = drawC;
            drawCircle(node);
            drawLabel(node);
            drawPreO(node.left);
            drawPreO(node.right);
        }
        public void drawTreePreO() {
            StdDraw.clear();
            drawEdge(root_num);
            drawC = 0;
            drawPreO(root_num);
            StdDraw.show();
        }


        private void drawPostOrder(TreeNode node) {
            if (node == null) return;
            drawPostOrder(node.left);
            drawPostOrder(node.right);
            drawC++;
            node.drawNum = drawC;
            drawCircle(node);
            drawLabel(node);
        }
        public void drawTreePostO() {
            StdDraw.clear();
            drawEdge(root_num);
            drawC = 0;
            drawPostOrder(root_num);
            StdDraw.show();
        }


        private void drawLevelO(TreeNode root) {
            if (root == null) return;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                drawC++;
                node.drawNum = drawC;
                drawCircle(node);
                drawLabel(node);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        public void drawTreeLevelO() {
            StdDraw.clear();
            drawEdge(root_num);
            drawC = 0;
            drawLevelO(root_num);
            StdDraw.show();
        }
    }


    public static void main(String[] args) {
        int n;
        if (args.length > 0) {
            try {
                n = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.err.println("n=13.");
                n = 13;
            }
        } else {
            n = 13;
        }

        BinaryTree tree = new BinaryTree(n);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();

        StdDraw.setCanvasSize(width, height);
        StdDraw.setXscale(0, 1);
        StdDraw.setYscale(0, 1);

//        System.out.println("In-Order:");
//        tree.drawTreeInO();
//        StdDraw.pause(0); // 2s
//

//        System.out.println("Pre-Order:");
//        tree.drawTreePreO();
//        StdDraw.pause(0);
//
//
//        System.out.println("Post-Order:");
//        tree.drawTreePostO();
//        StdDraw.pause(0);

//
        System.out.println("Level-Order:");
        tree.drawTreeLevelO();
        StdDraw.pause(0);
//

    }
}
