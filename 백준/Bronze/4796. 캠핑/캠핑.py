case = 0
while(1):
    answer = 0
    L, P, V = map(int, input().split())
    if L == 0 and P ==0 and V == 0:
        break
    else:
        case+=1
        answer += (V//P)*L + min(V%P,L)
        print(f"Case {case}: {answer}")