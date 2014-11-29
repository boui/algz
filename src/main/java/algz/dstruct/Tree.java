package algz.dstruct;


public class Tree {

    class Node{
        public Node(int value){
            this.value = value;
        }

        private int value;
        private boolean black = true;
        private Node parent;
        private Node left=null, right = null;

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", black=" + black +
                    '}';
        }
    }

    private Node root;
    public Tree(int[] values){
        for( int v:values){
            if(root==null){
                root = new Node(v);
            } else{
                insert(this.root, new Node(v));
            }
        }
    }

    private Node max(Node root){
        if(root == null) return null;

        if(root.right == null){
            return root;
        }

        return max(root.right);
    }


    private Node min(Node root){
        if(root == null) return null;
        if(root.left == null){
            return root;
        }

        return min(root.left);
    }

    public Node min(){
        return min(root);
    }

    public Node max(){
        return max(root);
    }


    public Node pred(Node root){
        if(root == null) return null;

        if(root.left == null){
            Node parent = root.parent;
            int value = root.value;
            while(parent!=null){
                if(parent.right!= null && parent.right.value == value) break;
                value = parent.value;
                parent = parent.parent;
            }

            return parent;
        }

        root = root.left;

        while(root.right != null){
            root = root.right;
        }

        return root;
    }

    public Node succ(Node root){
        if(root == null) return null;

        if(root.right == null){
            Node parent = root.parent;
            int value = root.value;
            while(parent!=null){
                if(parent.left!= null && parent.left.value == value) break;
                value = parent.value;
                parent = parent.parent;
            }

            return parent;
        }

        root = root.right;

        while(root.left != null){
            root = root.left;
        }

        return root;
    }

    public Node succ(int value){
        Node valueNode = search(root, value);
        return succ(valueNode);
    }


    public Node pred(int value){
        Node valueNode = search(root, value);
        return pred(valueNode);
    }

    public void traverseTree(){
        traverseTree(root);
    }

    private void traverseTree(Node root){
        if(root!=null){
            traverseTree(root.left);
            System.out.print(root.value + ",");
            traverseTree(root.right);
        }
    }

    public void delete(int value){
        Node node = search(root, value);
        deleteNode(node, value);
    }

    public void deleteNode(Node root, int value){

        if(root.left == null && root.right == null){
            Node parent = root.parent;
            if(parent.left.value == value){
                parent.left = null;
            } else {
                parent.right = null;
            }
            return;
        }

        if(root.left !=null && root.right == null){
            Node parent = root.parent;
            if(parent.left.value == value){
                parent.left = root.left;
            } else {
                parent.right = root.left;
            }
            return;
        }

        if(root.left == null){
            Node parent = root.parent;
            if(parent.left.value == value){
                parent.left = root.right;
            } else {
                parent.right = root.right;
            }
            return;
        }

        Node minRight = min(root.right);
        root.value = minRight.value;
        deleteNode(root.right, minRight.value);
    }

    public Node search(Node root, int value){
        if(root!= null){
            if(root.value == value) return root;
            if(root.value < value) return search(root.right, value);
            if(root.value > value) return search(root.left, value);
        }
        return null;
    }

    private void insert(Node root, Node value){
        if(root == null || value == null){
            return;
        }

        if(value.value < root.value){
            if(root.left == null){
                value.parent = root;
                root.left = value;
            } else {
                insert(root.left, value);
            }
        }

        if(value.value>=root.value){
            if(root.right == null){
                value.parent = root;
                root.right = value;
            } else {
                insert(root.right, value);
            }
        }
    }

    public boolean isValid(){
        return isValid(root);
    }
    public boolean isValid(Node root){
        if(root!=null){
            boolean f = true;

            if(root.left!=null){
                if(root.left.value <= root.value){
                    f = isValid(root.left);
                } else return false;
            }

            if(root.right!=null){
                if(root.right.value > root.value){
                    f = f&&isValid(root.right);
                } else return false;
            }

            return f;
        }

        return true;
    }

    public static void main(String[] array){
        Tree tree = new Tree(new int[]{15, 9, 18, 20, 5, 14, 12, 16, 2, 6 , 21});
//              15
//          9       18
//      5     14  16  20
//   2   6  12          21

//

//        tree.traverseTree();
//        System.out.println(tree.max());
//        System.out.println(tree.min());
//
//
//        System.out.println(tree.pred(9));
//        System.out.println(tree.pred(6));
//        System.out.println(tree.pred(16));

//        System.out.println(tree.succ(9));
//        System.out.println(tree.succ(6));
//        System.out.println(tree.succ(16));

//        tree.traverseTree();
//        tree.delete(12);
//        tree.delete(9);
//        System.out.println();
//        tree.traverseTree();

        System.out.println(tree.isValid());
    }
}
