n = int(input())
name = []

for i in range(n):
    name.append(input())

if sorted(name)==name:
    print("INCREASING")
elif sorted(name, reverse=True)==name:
    print("DECREASING")
else:
    print("NEITHER")
