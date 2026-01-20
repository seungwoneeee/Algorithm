import sys
sys.setrecursionlimit(10**6)

N = int(input())

arr = [2,3,5,7]
answer = []

def check(n):
    if n<2:
        return False
    if n==2:
        return True
    if n%2==0:
        return 0
    j = 3
    while j*j <=n:
        if n%j==0:
            return False
        j+=2
    return True

def dfs(n):
    if check(n) and len(str(n))<N:
        for i in range(1,10,2):
            tmp = n*10+i
            dfs(tmp)
    elif check(n) and len(str(n))==N:
        answer.append(n)

for i in arr:
    dfs(i)

print(*answer, sep="\n")