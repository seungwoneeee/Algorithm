def solution(clothes):
    answer = 1
    cloth_list = {}
    for i in clothes:
        cloth, cloth_type = i
        if cloth_type not in cloth_list:
            cloth_list[cloth_type]=[]
        cloth_list[cloth_type].append(cloth)
    for i in cloth_list:
        answer = answer * (len(cloth_list[i])+1)
    return answer-1