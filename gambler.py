import stdio
import sys

# Accept n1, n2, and p as floats and command line arguments
n1 = float(sys.argv[1])
n2 = float(sys.argv[2])
p = float(sys.argv[3])

# probability of the second player
q = 1 - p

# probability of the unfair coin p1
p1 = (1 - ((p/q) ** n2)) / (1 - ((p/q) ** (n1 + n2)))

# probability of the unfair coin p2
p2 = (1 - ((q/p) ** n1)) / (1 - ((q/p) ** (n1 + n2)))

# write both probabilities with a space inbetween
stdio.writeln(str(p1) + " " + str(p2))
