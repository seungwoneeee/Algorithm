n = int(input())
for i in range(n):
    dic = {}
    tmp = input()
    tmp = tmp.replace(" ","")
    tmp = tmp.upper()
    for chr in tmp:
        if 'A'<=chr<='Z': #알파벳만 세기
            if chr in dic:
                dic[chr]+=1
            else:
                dic[chr]=1
    if len(dic) == 26:
        if min(dic.values())==3:
            print("Case "+str(i+1)+": Triple pangram!!!")
        elif min(dic.values())==2:
            print("Case "+str(i+1)+": Double pangram!!")
        else:
            print("Case "+str(i+1)+": Pangram!")
    else:
        print("Case "+str(i+1)+": Not a pangram")