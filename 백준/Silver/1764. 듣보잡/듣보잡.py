N, M = map(int,input().split())
ans = []
count = 0
heard = {input().strip() for _ in range(N)} #strip()을 써서 문자열 뒤에 있는 /n 같은 걸 제거
for j in range(M):
    tmp = input().strip()
    if tmp in heard:
        count += 1
        ans.append(tmp)

ans.sort()

print(count)
for k in ans:
    print(k)