n = int(input())
back_money = 1000-n
total = 0
total += back_money//500
back_money = back_money%500
total +=back_money//100
back_money = back_money%100
total +=back_money//50
back_money = back_money%50
total +=back_money//10
back_money = back_money%10
total +=back_money//5
back_money = back_money%5
total += back_money

print(total)