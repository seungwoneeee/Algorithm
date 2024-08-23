from itertools import permutations
#itertools.permutations(arr) = 주어진 리스트 arr의 모든 가능한 순열을 생성하는 함수
#순열이란? 주어진 원소들을 모든 가능한 순서로 패치한것
#ex. [1, 2, 3] => [1, 2, 3]
# [1, 3, 2]
# [2, 1, 3]
# [2, 3, 1]
# [3, 1, 2]
# [3, 2, 1]
#=> itertools.permutations(arr)는 주어진 배열 arr의 원소들로 만들 수 있는 모든 순열을 튜플 형태로 생성 후 이를 반복 가능한 객체 형태로 반환

#아래는 더 자세한 함수의 예시
#import itertools

# arr = [1, 2, 3]
# permutations = itertools.permutations(arr)

# for p in permutations:
#     print(p)


# 입력 받기
n = int(input())  # N 입력
arr = list(map(int, input().split()))  # 배열 A 입력

# 최댓값을 저장할 변수
max_value = 0

# 배열의 모든 순열을 구함
for perm in permutations(arr):
    # 순열 perm에 대해 주어진 식을 계산
    current_value = 0
    for i in range(n - 1):
        current_value += abs(perm[i] - perm[i + 1])
    
    # 최댓값 갱신
    max_value = max(max_value, current_value)

# 결과 출력
print(max_value)
