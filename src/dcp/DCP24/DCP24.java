package dcp.DCP24;

public class DCP24 {

	public static void main(String[] args) {
		DCP24 dcp24=new DCP24();
		LockedBinaryTree lbtRoot=new LockedBinaryTree(14, null);
		LockedBinaryTree lbt1=new LockedBinaryTree(1, lbtRoot);
		LockedBinaryTree lbt2=new LockedBinaryTree(2, lbtRoot);
		lbtRoot.left=lbt1;
		lbtRoot.right=lbt2;
		LockedBinaryTree lbt3=new LockedBinaryTree(3, lbt1);
		LockedBinaryTree lbt4=new LockedBinaryTree(4, lbt1);
		lbt1.left=lbt3;
		lbt1.right=lbt4;
		LockedBinaryTree lbt5=new LockedBinaryTree(5, lbt2);
		LockedBinaryTree lbt6=new LockedBinaryTree(6, lbt2);
		lbt2.left=lbt5;
		lbt2.right=lbt6;
		System.out.println(lbtRoot.isLocked());
		System.out.println(lbt1.lock());
		System.out.println(lbtRoot.lock());
		System.out.println(lbtRoot.lock());
	}

}
 class LockedBinaryTree {
    private Integer data;
    public LockedBinaryTree parent, left, right;
    private boolean locked;
    private int numLockedDescendant = 0;

    public LockedBinaryTree(Integer data, LockedBinaryTree parent) {
        this.data = data;
        this.parent = parent;
    }

    public boolean isLocked() {
        return locked;
    }
    public boolean lock() {
        if (numLockedDescendant > 0 || locked == true)
            return false;
        for (LockedBinaryTree curr = parent; curr != null; curr = curr.parent) {
            if (curr.isLocked())
                return false;
        }
        locked = true;
        for (LockedBinaryTree curr = parent; curr != null; curr = curr.parent) {
            curr.numLockedDescendant++;
        }
        return true;
    }

    public void unlock(LockedBinaryTree tree) {
        if (locked) {
            locked = false;
            for (LockedBinaryTree curr = parent; curr != null; curr = curr.parent) {
                curr.numLockedDescendant--;
            }
        }
    }

    @Override
    public String toString() {
        return "LockedBinaryTree{" +
                "data=" + data +
                '}';
    }
}