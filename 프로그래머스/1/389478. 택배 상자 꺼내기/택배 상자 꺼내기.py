def solution(n, w, num):
    final_box = n%w 
    if(final_box==0):
        total_line = (n // w)
        final_box = w
    else:
        total_line = (n // w)+1 #총 쌓인 줄의 갯수
        #가장 마지막의 박스 위치
        #짝수번째 줄이면 오른쪽에서부터, 홀수번째 줄이면 왼쪽부터

    #꺼내야하는 박스의 위치
    num_box = num%w
    if(num_box==0):
        #꺼내야하는 박스의 줄 위치
        num_line = (num//w)
        num_box=w
    else:
        num_line = (num//w)+1
   
    answer = 0
    if (total_line%2==0 and num_line%2==0) or (total_line%2==1 and num_line%2==1): 
        #둘 다 짝수번째 줄에 위치하거나 둘 다 홀수번째 줄에 위치할 때
        if (final_box>=num_box):
            answer = total_line-num_line+1
        else: answer = total_line-num_line
    elif (total_line%2==1 and num_line%2==0) or (total_line%2==0 and num_line%2==1): 
        #한쪽이 홀수고 한쪽이 짝수일때
        if (final_box+num_box<=w):
            answer = total_line-num_line
        else: answer = total_line-num_line+1
    
    return answer