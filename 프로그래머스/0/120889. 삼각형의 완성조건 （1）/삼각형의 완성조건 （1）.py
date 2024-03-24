def solution(sides):
    answer = 0
    item = max(sides)
    sides.remove(item)
    if sum(sides) > item : 
        return 1
    else: return 2