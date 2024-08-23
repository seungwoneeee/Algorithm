n = int(input())
score = []
for i in range(n):
    score.append(list(map(int,input().split())))

#score의 첫번째 행만 복사해옴
max_dp = score[0][:]  # 첫 번째 줄은 초기값으로 설정
min_dp = score[0][:]  # 최소 점수를 위한 DP 배열


#위에서 아래를 고려하는게 아니라 아래에서 위를 고려하는 방식

for i in range(1, n):
    # 현재 값을 저장하기 위해 새로운 배열을 사용
    max_temp = [0] * 3
    min_temp = [0] * 3
    
    # 최대값 계산
    max_temp[0] = score[i][0] + max(max_dp[0], max_dp[1]) #현재 행에서 첫번째 열로 올 수 있는 최댓값 계산
    max_temp[1] = score[i][1] + max(max_dp[0], max_dp[1], max_dp[2]) #바로 위의 행에서 두번째 열로 올 수 있는 최댓값 계산
    max_temp[2] = score[i][2] + max(max_dp[1], max_dp[2]) #바로 위의 행에서 세번째 열로 올 수 있는 최댓값 계산
    
    # 최소값 계산
    min_temp[0] = score[i][0] + min(min_dp[0], min_dp[1])
    min_temp[1] = score[i][1] + min(min_dp[0], min_dp[1], min_dp[2])
    min_temp[2] = score[i][2] + min(min_dp[1], min_dp[2])
    
    # 계산된 값들을 dp 배열에 갱신
    max_dp = max_temp
    min_dp = min_temp

# 마지막 줄에서의 최대값과 최소값 출력
print(max(max_dp), min(min_dp))

