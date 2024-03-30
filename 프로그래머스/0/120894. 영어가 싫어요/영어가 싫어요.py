def solution(numbers):
    answer = ''
    temp=''
    dic = {'zero':0,'one':1,'two':2,'three':3,'four':4,'five':5,'six':6,'seven':7,'eight':8,'nine':9}
    for i in numbers:
        temp = temp + i
        if temp in dic:
            answer=answer + str(dic[temp])
            temp=''
    return int(answer)