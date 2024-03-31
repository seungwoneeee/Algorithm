score = []
for _ in range(8):
    score.append(int(input()))
score_sort = sorted(score, reverse=True)
total = 0
ques = []
for i in range(5):
    total += score_sort[i]
    ques.append(str(score.index(score_sort[i])+1))
num = ' '.join(sorted(ques))
print(total)
print(num)