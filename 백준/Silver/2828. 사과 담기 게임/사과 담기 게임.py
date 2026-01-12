N, M = map(int, input().split())
J = int(input())

start = 1
end = M
distance = 0

for i in range(J):
    drop = int(input())
    if (end<drop):
            distance += drop-M+1-start
            start = drop-M+1
            end = drop
    elif (start>drop):
            distance += start-drop
            start = drop
            end = drop+M-1
    else:
        continue


print(distance)
    