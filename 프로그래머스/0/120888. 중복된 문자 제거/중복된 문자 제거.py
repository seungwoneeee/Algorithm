def solution(my_string):
    answer = ''
    return ''.join(dict.fromkeys(my_string))