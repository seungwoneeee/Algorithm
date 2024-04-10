def solution(array):
    answer = 0
    for i in ''.join(str(i) for i in array):
        if i=='7':
            answer +=1
    return answer