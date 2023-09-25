import dsa.WeightedQuickUnionUF;
import stdlib.In;
import stdlib.StdOut;

// An implementation of the Percolation API using the UF data structure.
public class UFPercolation implements Percolation {
    // U-find representation of the percolation system
    WeightedQuickUnionUF uf;
    // representation used to solve the backwash problem
    WeightedQuickUnionUF bwSolver;
    // Percolation system size
    private final int n;
    // Percolation system
    private final boolean[][] open;
    // Number of open sites
    private int openSites;
    // Virtual source instance variable stored as s1
    private final int s1;
    // virtual instance variable labeled as ex1
    private final int ex1;


    // Constructs an n x n percolation system, with all sites blocked.
    public UFPercolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Illegal n");
        }
        s1 = 0;
        ex1 = (n * n) + 1;
        openSites = 0;
        open = new boolean[n][n];
        this.n = n;
        uf = new WeightedQuickUnionUF((n * n) + 2);
        bwSolver = new WeightedQuickUnionUF((n * n) + 1);
        for (int i = s1; i < n; i++) {
            uf.union(encode(0, i), s1);
            bwSolver.union(encode(0, i), s1);
            uf.union(encode((n-1), i), ex1);
            for (int j = 0; j < n; j++) {
                open[i][j] = false;
            }
        }
    }

    // Opens site (i, j) if it is not already open.
    public void open(int i, int j) {
        if (i < 0 || j < 0 || i > n - 1 || j > n - 1) {
            throw new IndexOutOfBoundsException("Illegal i or j");
        }
        if (!open[i][j]) {
            open[i][j] = true;
            openSites++;
            if ((i - 1) >= 0 && open[i - 1][j]) {
                uf.union(encode(i, j), encode(i - 1, j));
                bwSolver.union(encode(i, j), encode(i - 1, j));
            }
            if ((j + 1) < n && open[i][j + 1]) {
                uf.union(encode(i, j), encode(i, j + 1));
                bwSolver.union(encode(i, j), encode(i, j + 1));
            }
            if ((j - 1) >= 0 && open[i][j - 1]) {
                uf.union(encode(i, j), encode(i, j - 1));
                bwSolver.union(encode(i, j), encode(i, j - 1));
            }
            if ((i + 1) < n && open[i + 1][j]) {
                uf.union(encode(i, j), encode(i + 1, j));
                bwSolver.union(encode(i, j), encode(i + 1, j));
            }
        }
    }

    // Returns true if site (i, j) is open, and false otherwise.
    public boolean isOpen(int i, int j) {
        if (i < 0 || j < 0 || i > n - 1 || j > n - 1) {
            throw new IndexOutOfBoundsException("Illegal i or j");
        }
        return open[i][j];
    }

    // Returns true if site (i, j) is full, and false otherwise.
    public boolean isFull(int i, int j) {
        if (i < 0 || j < 0 || i > n - 1 || j > n - 1) {
            throw new IndexOutOfBoundsException("Illegal i or j");
        }
        return isOpen(i, j) && uf.connected(encode(i, j), s1) &&
                bwSolver.connected(encode(i, j), s1);
    }

    // Returns the number of open sites.
    public int numberOfOpenSites() {
        return openSites;
    }

    // Returns true if this system percolates, and false otherwise.
    public boolean percolates() {
        if (n <= 1) {
            return false;
        }
        return uf.connected(ex1, s1);
    }

    // Returns an integer ID (1...n) for site (i, j).
    private int encode(int i, int j) {
        return n*i+j+1;
    }

    // Unit tests the data type. [DO NOT EDIT]
    public static void main(String[] args) {
        String filename = args[0];
        In in = new In(filename);
        int n = in.readInt();
        UFPercolation perc = new UFPercolation(n);
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