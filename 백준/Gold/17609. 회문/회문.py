def palindrome(s: str, l: int, r: int) -> bool:
    while l < r:
        if s[l] != s[r]:
            return False
        l += 1
        r -= 1
    return True

def check(s: str) -> int:
    l, r = 0, len(s) - 1

    while l < r:
        if s[l] == s[r]:
            l += 1
            r -= 1
        else:
            if palindrome(s, l + 1, r) or palindrome(s, l, r - 1):
                return 1
            return 2

    return 0


t = int(input().strip())
for _ in range(t):
    s = input().strip()
    print(check(s))
