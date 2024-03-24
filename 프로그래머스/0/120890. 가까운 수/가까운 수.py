def solution(array, n):
    array.sort()
    answer = array[0]
    x = abs(n - array[0])
    for e in array:
        if x > abs(n - e):
            x = abs(n - e)
            answer = e
    return answer