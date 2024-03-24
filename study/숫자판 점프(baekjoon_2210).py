def dfs(x,y,number):
    if len(number)==6: #만약 현재 숫자의 길이가 6이라면, 이를 결과에 추가하고 함수를 종료함.
        result.append(number)
        return
    
    #숫자의 길이가 6이 아니라면, 현재 위치에서 상하좌우로 이동하면서 다음숫자를 만들어감
    dx = [1,-1,0,0] #DFS를 재귀적으로 호출
    dy = [0,0,1,-1] #상하좌우 이동을 위해 dx, dy 리스트
    for i in range(4): #4번 반복을 통해 상하좌우를 모두 시행
        nx = x + dx[i] #현재의 x점 위치
        ny = y + dy[i] #현재의 y점 위치
        if nx < 0 or nx>=5 or ny<0 or ny>=5:#이동후에는 그래프를 벗어나는지 체크함.
            continue
        else: #벗어나지 않는다면 숫자를 다시 이어붙여서 다시 DFS를 호출(재귀적)
            dfs(nx,ny,number+graph[nx][ny])
            #number+graph[nx][ny]는 원소 덧셈이 아니라 문자열 연결이다.
            #현재까지의 숫자 number과 새로운 그래프에서의 위치에 있는 숫자를 이어붙여서 새로운 숫자를 만든다.
            #graph안의 원소들은 문자열 형태의 숫자가 들어가있기 때문

graph = []
result = []

for i in range(5):
    graph.append(list(map(str,input().split())))

for i in range(5):
    for j in range(5):
        dfs(i,j,graph[i][j])
print(len(set(result))) #중복을 제거하기 위해 결과를 집합으로 변환하고 그 집합의 길이를 출력함