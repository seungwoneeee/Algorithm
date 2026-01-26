import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

N = int(input())
arr = list(map(int, input().split()))

a = [[] for i in range(N)]
visited = [False]*N

for i in range(N):
    if arr[i] == -1:
        continue
    else:
        a[arr[i]].append(i)


def dfs(d):
    if visited[d] != True and len(a[d]) !=0:
        visited[d] = True
        for i in a[d]:
            dfs(i)
    elif visited[d] != True and len(a[d])==0:
        visited[d]=True

d = int(input())
dfs(d)

count=0

for j in range(N):
    if visited[j]==False:
        child = 0
        for c in a[j]:
            if not visited[c]:
                child += 1

        if child == 0:
            count += 1

print(count)