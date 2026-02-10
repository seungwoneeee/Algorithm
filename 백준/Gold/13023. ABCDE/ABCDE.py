N, M = map(int, input().split())

a = [[] for _ in range(N)]
visited = [False]*N

for i in range(M):
    s,e = map(int, input().split())
    a[s].append(e)
    a[e].append(s)

arrive = False
dep = 0

def dfs(num, dep):
    if dep == 4:
        global arrive
        arrive = True
        return
    visited[num]=True
    for i in a[num]:
        if visited[i]==False:
            dfs(i, dep+1)
    visited[num] = False

for i in range(N):
    visited = [False] * N
    dfs(i, 0)
    if arrive == True:
        break


if arrive == True:
    print(1)
else:
    print(0)