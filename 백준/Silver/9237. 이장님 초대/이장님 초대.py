n = int(input()) #나무의 개수 입력

data = list(map(int, input().split())) #나무가 자라는 일수 배열 입력
data.sort(reverse=True) #가장 오래 걸리는 나무부터 내림차수 정렬

result = [] #결과값을 넣는 배열
for i in range(n): #나무의 개수만큼 반복
    result.append(data[i]+ 1 + i) #각 나무마다 최종적으로 자라나는데 걸리는 일 수 = 나무가 자라는데 걸리는 일수 + 나무를 심는데에 걸리는 일수 + 몇번째로 심는 나무인지

print(max(result) + 1) #언제 초대할 수 있는지를 출력 = 나무가 자라고 + 1(그 다음 날) 