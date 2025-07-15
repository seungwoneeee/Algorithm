n, m = map(int, input().split())
A = []
word = []
for i in range(n):
    A.append(list(input().strip()))
for i in range(n):
    tmp=''
    for j in range(m):
        if A[i][j]=='#':
            if len(tmp) > 1:
                word.append(tmp)
            tmp=''
            continue
        else:
            tmp=tmp+A[i][j]
            if j == m-1 and len(tmp) >1:
                word.append(tmp)
for i in range(m):
    tmp=''
    for j in range(n):
        if A[j][i]=='#':
            if len(tmp) >1:
                word.append(tmp)
            tmp=''
            continue
        else:
            tmp=tmp+A[j][i]
            if j == n-1 and len(tmp) >1:
                word.append(tmp)
word.sort()
#print(word)
print(word[0])