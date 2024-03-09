def solution(n):
    answer = 1
    number = 0
    for i in range(11):
        answer*=(number+1)
        if answer > n:
            break
        else: number+=1
    return number