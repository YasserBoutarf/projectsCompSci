import math
import stdio
import sys

# Accept float(a) and float(t) as command line arguments
a = float(sys.argv[1])
t = float(sys.argv[2])

# find value of p using the mathematical expression
value_of_p = math.exp(-a*t)

# write value of p
stdio.writeln(value_of_p)
