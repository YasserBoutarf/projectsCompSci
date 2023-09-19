import stdio
import sys

# accept int(month), int(day), and int(year) as command line arguments
m = int(sys.argv[1])
d = int(sys.argv[2])
y = int(sys.argv[3])

# Calculate the year
year = y-(14-m) // 12

# Calculate the day
day = year + year // 4 - year//100 + year//400

# Calculate the month
month = m + 12 * ((14-m)//12) - 2

# Compute and write the value of dow
dow = (d + day + 31 * month//12) % 7

# convert dow into a string
stringDOW = str(int(dow))

# write dow
stdio.writeln(dow)
