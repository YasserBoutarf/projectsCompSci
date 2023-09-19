import stdio
import sys

# Accept float(t) and float(v) as command line arguments
t = float(sys.argv[1])
v = float(sys.argv[2])

# find wind chill using the math equation
w = 35.74 + .6215 * t + (.4275 * t - 35.75) * v ** .16

# write windchill
stdio.writeln(w)
