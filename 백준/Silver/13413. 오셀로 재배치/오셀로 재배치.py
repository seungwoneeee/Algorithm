n = int(input())
for i in range(n):
    m = int(input())
    str = list(input().strip())
    answer = list(input().strip())
    #여기에서 strip이 아닌 split을 쓰면 공백이 없기 때문에 문자열이 그대로 list가 되어버림. 그 이후에 list를 또 하면 그냥 List 복사본을 만드는 형태
    #strip은 공백을 제거하고 문자열로 반환함. 이후 list를 사용함으로써 한글자씩 잘라서 List 형태가 됨


    wb = 0 #w->b
    bw = 0 #b->w

    for s,g in zip(str, answer):
        if s == 'W' and g == 'B':
            wb +=1
        elif s== 'B' and g == 'W':
            bw += 1
    count = min(wb, bw)+abs(wb-bw) 
    print(count)