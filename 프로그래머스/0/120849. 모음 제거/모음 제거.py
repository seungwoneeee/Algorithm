def solution(my_string):
    for j in "aeiou":
        my_string=my_string.replace(j,'')
    return my_string