n = int(input())
A = []
max_num = 0
max_str = ''
for i in range(n):
    A.append(input())
for i in A:
    tmp = A.count(i)
    if tmp > max_num:
        max_num = tmp
        max_str = i
    elif tmp == max_num:
        if max_str > i:
            max_str = i
print(max_str)