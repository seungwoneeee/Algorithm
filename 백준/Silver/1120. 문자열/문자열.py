A, B = input().split()
N = len(A)
M = len(B)
best = float('inf') #파이썬에서 무한대 표현 방식

for i in range(0,M-N+1):
    diff = 0
    for j in range(0, N):
        if A[j]!=B[i+j]:
            diff+=1
    best = min(diff,best)

print(best)
