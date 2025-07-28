write = input().strip()
answer = input().strip()
tmp = ''

#작성한 것 중에 알파벳만 남기기
for i in write:
    if i.isalpha(): #알파벳이면
        tmp += i #문자열에 추가

if answer in tmp:
    print("1")
else:
    print("0")