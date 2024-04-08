def solution(num, k):
    num_str = str(num)
    for idx, digit in enumerate(num_str, 1):
        if int(digit) == k:
            return idx
    return -1