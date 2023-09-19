import stdio
import stdrandom
import sys

# accept sides as a command line argument
sides = int(sys.argv[1])

# First roll
rollOne = stdrandom.uniformInt(1, sides+1)

# Second roll
rollTwo = stdrandom.uniformInt(1, sides+1)

# Sum of both rolls
rollSum = rollOne + rollTwo

# write rollSum
stdio.writeln(rollSum)
