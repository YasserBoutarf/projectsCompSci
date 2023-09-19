import stdio
import sys

# Accept name (str) and age (str) as command-line arguments.
name = str(sys.argv[1])
age = str(int(sys.argv[2]))

# Set x equal to name and age incorporated into the words " is " and " years old."
x = name + " is " + age + " years old."

# Write the message "name is age years old." to standard output.
stdio.write(x)
