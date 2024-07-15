n=str(input())

total_1 = list(n.split('0'))
total_0 = list(n.split('1'))

total_1 = [element for element in total_1 if element !=''] #list에서 ''값을 가지는 거 제거
total_0 = [element for element in total_0 if element !=''] #list에서 ''값을 가지는 거 제거


print(len(total_1) if len(total_1)<len(total_0) else len(total_0))