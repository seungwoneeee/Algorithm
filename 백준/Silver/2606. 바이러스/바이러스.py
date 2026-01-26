N = int(input())
e = int(input())

visited = [False]*(N+1)
a = [[]for _ in range(N+1)]

for _ in range(e):
    S, E = map(int, input().split())
    a[E].append(S)
    a[S].append(E)

count = 0

def dfs(n):
    global count
    if visited[n] != True:
        visited[n] = True
        count += 1
        for i in a[n]:
            dfs(i)


dfs(1)

print(count-1)