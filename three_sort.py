import stdio
import sys

# accept x y and z as integers and command line arguments
x = int(sys.argv[1])
y = int(sys.argv[2])
z = int(sys.argv[3])

# find the minimum and maximum of x, y , and z
a = min(x, y, z)
w = max(x, y, z)

# Find the middle value by subtracting the minimum and maximum
middle_value = (x + y + z) - (a + w)

# Write x, y, and z in order
stdio.writeln(str(a) + " " + str(middle_value) + " " + str(w))
