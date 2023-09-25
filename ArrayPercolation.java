import stdlib.In;
import stdlib.StdOut;

// An implementation of the Percolation API using a 2D array.
public class ArrayPercolation implements Percolation {
    // initialize n
    private int n;

    // initialize 2d open
    private boolean[][] open;

    // initialize number of open sites
    private int openSites;

    // Constructs an n x n percolation system, with all sites blocked.
    public ArrayPercolation(int n) {
        // check if n < 0 which throws an error if it is
        if (n <= 0) {
            throw new IllegalArgumentException("Illegal n");
        }
        // initialize the instance variables needed in this object
        this.n = n;
        this.open = new boolean[n][n];
    }

    // Opens site (i, j) if it is not already open.
    public void open(int i, int j) {
        // check if i or j is outside the interval;
        if (i < 0 || i > n - 1 || j < 0 || j > n - 1) {
            throw new IndexOutOfBoundsException("Illegal i or j");
        }
        // if site is not open then open it then increment 1 to the total open sites
        if (!this.isOpen(i, j)) {
            open[i][j] = true;
            openSites += 1;
        }
    }

    // Returns true if site (i, j) is open, and false otherwise.
    public boolean isOpen(int i, int j) {
        // checks if i or j is outside the interval
        if (i < 0 || i > n - 1 || j < 0 || j > n - 1) {
            throw new IndexOutOfBoundsException("Illegal i or j");
        }
        // returns true if site is open otherwise false
        return open[i][j];
    }


    // Returns the number of open sites.
    public int numberOfOpenSites() {
        return openSites;
    }

    // Returns true if this system percolates, and false otherwise.
    public boolean percolates() {
        // check if the last row of the system contains at least one full site
        for (int j = 0; j < open.length; j++) {
            if (this.isFull(n - 1, j)) {
                return true;
            }
        }
        return false;
    }

    // Recursively flood fills full[][] using depth-first exploration, starting at (i, j).
    private void floodFill(boolean[][] full, int i, int j) {
        // check if conditions are met
        if (i < 0 || i > full.length - 1 || j < 0 || j > full.length - 1
                || !this.isOpen(i, j) || full[i][j]) {
            return;
        }
        // otherwiser fill the site
        full[i][j] = true;

        // call recusively on the sites to n, e, w, and s
        this.floodFill(full, i, j - 1); // north
        this.floodFill(full, i + 1, j); // east
        this.floodFill(full, i - 1, j); // west
        this.floodFill(full, i, j + 1); // south
    }

    // Returns true if site (i, j) is full, and false otherwise.
    public boolean isFull(int i, int j) {
        // check if i or j is outside of the interval
        if (i < 0 || i > n - 1 || j < 0 || j > n - 1) {
            throw new IndexOutOfBoundsException("Illegal i or j");
        }
        // create a n x n of array booleans
        boolean[][] full = new boolean[n][n];

        // call floodfill on every site in the first row of the percolation system
        for (int col = 0; col < open.length; col++) {
            if (this.isOpen(0, col)) {
                floodFill(full, 0, col);
            }
        }
        // return if true or not
        return full[i][j];

    }

    // Unit tests the data type. [DO NOT EDIT]
    public static void main(String[] args) {
        String filename = args[0];
        In in = new In(filename);
        int n = in.readInt();
        ArrayPercolation perc = new ArrayPercolation(n);
        while (!in.isEmpty()) {
            int i = in.readInt();
            int j = in.readInt();
            perc.open(i, j);
        }
        StdOut.printf("%d x %d system:\n", n, n);
        StdOut.printf("  Open sites = %d\n", perc.numberOfOpenSites());
        StdOut.printf("  Percolates = %b\n", perc.percolates());
        if (args.length == 3) {
            int i = Integer.parseInt(args[1]);
            int j = Integer.parseInt(args[2]);
            StdOut.printf("  isFull(%d, %d) = %b\n", i, j, perc.isFull(i, j));
        }
    }
}
