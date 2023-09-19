import math
import stdio
import sys

# set float(theta1), float(n1), and float(n2) as command line arguments
theta1 = float(sys.argv[1])
n1 = float(sys.argv[2])
n2 = float(sys.argv[3])

# theta1 is in degrees -> convert to radians
theta1rad = math.radians(theta1)

# apply the sin function to theta 1
sineOne = math.sin(theta1rad)

# find sin theta2 by isolating the variable
sineTwo = (sineOne * n1) / n2

# Find the inverse of sin using arc sin to get theta2
theta2rad = math.asin(sineTwo)

# output should be in degrees, hence convert from radians to degrees
theta2deg = math.degrees(theta2rad)

# write the result as a string
stdio.write(str(theta2deg))
