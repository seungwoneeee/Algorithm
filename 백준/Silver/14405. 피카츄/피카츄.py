a = input()
while a:
    if a.startswith("pi"):
        a=a[2:]
    elif a.startswith("ka"):
        a=a[2:]
    elif a.startswith("chu"):
        a=a[3:]
    else:
        print("NO")
        break
else:
    print("YES")