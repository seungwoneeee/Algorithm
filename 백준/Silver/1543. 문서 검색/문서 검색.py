write = input()
find = input()

count = 0
tmp = 0
a = len(find)

while a <= len(write):
    if find not in write:
        break
    if find == write[tmp:tmp+a]:
        count+=1
        write = write[tmp+a:]
        tmp = 0
    else:
        tmp += 1

print(count)