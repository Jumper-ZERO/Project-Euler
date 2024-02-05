import sys

def triple(n):
	for c in range(int(n * 2**0.5 / (2+2**0.5)) - 1, n//2):
	    c2 = c ** 2
	    for a in range(max(1, n - c - (c - 1)), min((n//3) - 1, (n - c) // 2) + 1):
        	b = n - c - a
	        if a ** 2 + b ** 2 == c2:
	            return a * b * c
	return -1

t = int(input().strip())
for a0 in range(t):
	n = int(input().strip())
	print(triple(n))