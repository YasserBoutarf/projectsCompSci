import stdio
import sys

# Accept name1 (str), name2 (str), and name3 (str) as command-line arguments.
name1 = str(sys.argv[1])
name2 = str(sys.argv[2])
name3 = str(sys.argv[3])

# Set x to greet the three names
x = "Hi " + name3 + ", " + name2 + ", " + "and " + name1 + "."

# Write "Hi name3, name2, and name1." to standard output.
stdio.write(x)
