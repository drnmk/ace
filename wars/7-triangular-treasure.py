# 1
def triangular(n):
    if n <= 0: 
        return 0 
    if n % 2 == 0:
        return (n + 1) * int(n / 2)
    if n % 2 != 0:
        return (n + 1) * int(n / 2) + int(n / 2 + 1)
