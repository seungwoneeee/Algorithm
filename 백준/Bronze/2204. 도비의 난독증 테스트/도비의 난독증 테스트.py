while True:
    a = int(input())
    if a != 0:
        A = []
        for i in range(a):
            A.append(input()) # 입력되는 문자열을 모두 소문자로 변환
        A = sorted(A, key=str.lower) # 대소문자 구분 없이 sort 할 때는 key = str.lower을 넣어서 할 것
        print(A[0])
    else:
        break