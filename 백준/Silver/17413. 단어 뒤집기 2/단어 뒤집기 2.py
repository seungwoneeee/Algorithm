str = input()
tmp = ''
A = []
for index,i in enumerate(str):
    if i ==" " and not tmp.startswith('<'):
        A.append(tmp)
        tmp = ''
    elif i == '>':
        tmp += i
        A.append(tmp)
        tmp = ''
    elif index == len(str) -1:
        tmp += i
        A.append(tmp)
    elif i=='<' and len(tmp)!=0:
        A.append(tmp)
        tmp = ''
        tmp+=i
    else: 
        tmp+=i

answer = ''
for j in A:
    if j.startswith('<'):
        answer += j
    else:
        if not answer.endswith('>') and answer != '':
            answer += ' '
        answer += ''.join(reversed(j))
print(answer)