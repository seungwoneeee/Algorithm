from collections import defaultdict

n = int(input())
cnt = defaultdict(int)

for i in range(n):
    name, information = input().split(".")
    cnt[information]+=1

for i in sorted(cnt):
    print(i, cnt[i])