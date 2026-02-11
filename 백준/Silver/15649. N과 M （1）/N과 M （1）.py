N, M = map(int, input().split())

a = [[] for _ in range(N+1)]

for i in range(1,N+1):
    for j in range(1,N+1):
        if i!=j:
            a[i].append(j)
tmp = []
answer = []

def dfs(n,dep):
    if dep == M:
        global tmp
        global answer
        answer.append(tmp[:]) #그 시점의 tmp의 "스냅샵"을 저장
        return
    for i in a[n]:
        if visited[i]==False and (i not in tmp):
            visited[i]=True
            tmp.append(i)
            dfs(i,dep+1)
            tmp.pop()
            visited[i]=False

for i in range(1,N+1):
    visited = [False]*(N+1)
    tmp = [i]
    dfs(i,1)
    visited[i]=False

answer = sorted(answer)
for i in answer:
    print(*i)