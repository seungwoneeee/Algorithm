def solution(order):
    answer = 0
    for i in str(order):
        for j in ['3','6','9']:
            if i==j:
                answer+=1
    return answer