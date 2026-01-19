import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

N, M = map(int, input().split())

visited = [False]*(N+1)
graph = [[] for _ in range(N+1)]
count = 0

for _ in range(M):
    s, e = map(int, input().split())
    graph[s].append(e)
    graph[e].append(s)

def dfs(v):
    visited[v]=True
    for i in graph[v]:
        if visited[i]==False:
            dfs(i)

for i in range(1, N+1):
    if visited[i]==False:
        count+=1
        dfs(i)

print(count)