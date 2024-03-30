def solution(my_string, num1, num2):
    answer = ''
    my_array = list(my_string)
    temp = my_array[num1]
    my_array[num1]=my_array[num2]
    my_array[num2]=temp
    return "".join(my_array)