import stdio
import sys

# Enter float(m1, m2, and r) as command line arguments
m1 = float(sys.argv[1])
m2 = float(sys.argv[2])
r = float(sys.argv[3])

# Use mathematical expression to find G
G = 6.674 * 10**-11

# find gravitational force by using g previously to plug in and entering parameters
gravitational_force = G * (m1 * m2 / r ** 2)

# write gravitational force
stdio.write(gravitational_force)
