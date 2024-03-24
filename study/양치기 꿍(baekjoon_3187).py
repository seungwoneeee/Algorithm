from collections import deque

n,m = map(int,input().split()) #입력을 변수에 담음
graph = [list(input()) for _ in range(n)] #배열을 변수에 담는다.

visited = [[0]*m for _ in range(n)] #방문했음을 파악하기 위해서 전체를 방문하지 않았음으로 초기화
dx,dy = [1,-1,0,0],[0,0,1,-1] #상하좌우 움직임을 위해서 dx, dy 사용
def in_range(x,y): #주어진 좌표가 그래프 범위 내에 있고 벽이 아닌지를 확인함.
    return 0<=x<n and 0<=y<m and graph[x][y]!='#'

total_v = 0 #살아남는 늑대의 합
total_k = 0 #살아남는 양의 합
def bfs(x,y): #BFS 알고리즘을 구현한 함수
    global total_v, total_k
    v,k=0,0
    q = deque() #양방향큐 선언, q에 방문할 좌표가 저장됨
    visited[x][y] = True #시작점을 방문했음으로 바꿔줌
    q.append((x,y)) #시작점을 큐에 추가
    while q: #큐가 빌때까지 반복
        #큐가 빌 때까지 반복하므로써 모든 연결된 정점을 방문한다.
        a,b = q.popleft() #큐의 맨 앞에서 좌표를 하나 꺼냄
        #bfs의 특성상, 먼저 들어온 좌표부터 탐색을 진행해야하므로 popleft() 진행
        for i in range(4): #현재 위치에서 상하좌우로 이동할 수 있는지 확인
            nx = dx[i]+a #상하좌우로 이동한 좌표를 계산
            ny = dy[i]+b
            if in_range(nx, ny) and visited[nx][ny] == 0: #만약 새로운 좌표가 그래프 범위 내에 있고, 아직 방문하지 않은 곳이면,
                q.append((nx,ny)) #새로운 좌표를 큐에 추가한다.
                visited[nx][ny]=True #새로운 좌표를 방문했음을 표시
                if graph[nx][ny]=='v': #새로운 좌표가 늑대인경우 v를 1 증가 시킴
                    v+=1
                elif graph[nx][ny]=='k': #새로운 좌표가 양인 경우 k를 1 증가시킴
                    k+=1
    if v>=k: #늑대 수가 더 많으면
        total_v += v #늑대 수를 최종 늑대 수에 추가시켜준다
    else: #양의 수가 더 많으면
        total_k += k #양의 수를 최종 양의 수에 추가시켜준다.
for i in range(n):
    for j in range(m): #모든 점에 대해서 bfs 진행
        bfs(i,j)
print(total_k,total_v)