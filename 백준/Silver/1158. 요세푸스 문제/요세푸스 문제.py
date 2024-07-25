n,k = map(int,input().split())

array = []
answer =[]
start = 0

for i in range(n):
    array.append(i+1)

while len(array) != 0:
    start = (start+k-1)%len(array)
    answer.append(array.pop(start))
    
formatted_string = "<" + ", ".join(map(str, answer)) + ">"

print(formatted_string)