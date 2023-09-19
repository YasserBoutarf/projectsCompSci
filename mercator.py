import math
import stdio
import sys

# accept float (a) and float (b) as command line arguments
a = float(sys.argv[1])
b = float(sys.argv[2])

# Set the x coordinate equal to b
x = b

# Convert degrees into radians
a = math.radians(a)

# Use arithmetic to find y value
y = math.log((1 + math.sin(a)) / (1 - math.sin(a))) / 2

stdio.write(str(x) + " " + str(y))
