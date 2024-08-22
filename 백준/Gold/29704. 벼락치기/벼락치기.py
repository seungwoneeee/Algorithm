n,t = map(int,input().split())
prob = []
for _ in range(n):
    prob.append(list(map(int,input().split())))

total = 0
for days,money in prob:
    total+=money

dp = [0]*(t+1)

for days,money in prob:
    for i in range(t,days-1,-1):
        dp[i]=max(dp[i], dp[i-days]+money)

print(total-dp[t])
#print(dp)