import sys

def triple(n):
    result = -1
    for a in range(1, n // 3):
        b = (n**2 - 2*a*n) // (2*n - 2*a)
        c = n - a - b
        if a**2 + b**2 == c**2 and a * b * c > result:
            result = a * b * c
    return result

t = int(input().strip())
for a0 in range(t):
    n = int(input().strip())
    print(triple(n))
