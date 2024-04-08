def solution(quiz):
    answer=[]
    temp=[]
    for i in quiz:
        temp = i.split("=")
        if int(eval(temp[0]))==int(temp[1]):
            answer.append("O")
        else: answer.append("X")
    return answer