def solution(my_string):
    answer = ''
    for i in my_string:
        if ord(i)>=97:
            answer+=chr(ord(i)-32)
        elif ord(i)<=90:
            answer+=chr(ord(i)+32)
    return answer