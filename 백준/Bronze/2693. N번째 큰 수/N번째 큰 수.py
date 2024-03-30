n = int(input())
array = []
for i in range(n):
    array.append(list(map(int,input().split())))
    array[i].sort()
    print(array[i][7])