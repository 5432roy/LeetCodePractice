def gcdOfStrings(self, str1: str, str2: str) -> str:
    if len(str2) > len(str1):
        str1, str2 = str2, str1
    l1, l2 = len(str1), len(str2)

    res = ""

    for i in range(l2, 0, -1):
        if l2 % i == 0 and str2 == str2[:i] * (l2 // i):
            if l1 % i == 0 and str1 == str2[:i] * (l1 // i):
                return str2[:i]

    return res