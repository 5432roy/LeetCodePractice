"""
150. Evaluate Reverse Polish Notation

You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.

Evaluate the expression. Return an integer that represents the value of the expression.

Note that:

The valid operators are '+', '-', '*', and '/'.
Each operand may be an integer or another expression.
The division between two integers always truncates toward zero.
There will not be any division by zero.
The input represents a valid arithmetic expression in a reverse polish notation.
The answer and all the intermediate calculations can be represented in a 32-bit integer.

https://leetcode.com/problems/evaluate-reverse-polish-notation/description/
"""
class Solution:
    """
    The weird part is that the result for a negative division would be 1 less then the expected value.
    eg. 6 // -130 = -1, where it should be 0
    """
    def evalRPN(self, tokens) -> int:
        number = []

        for i in range(len(tokens)):
            if tokens[i].isdigit() :
                number.append(int(tokens[i]))
            elif tokens[i][0] == "-" and tokens[i][1::].isdigit():
                number.append(-1 * int(tokens[i][1::]))
            else :
                a = number.pop()
                b = number.pop()
                res = 0
                if tokens[i] == "+" :
                    res = a + b
                if tokens[i] == "-" :
                    res = b - a
                if tokens[i] == "*" :
                    res = b * a
                if tokens[i] == "/" :
                    res = abs(b) // abs(a) if a * b > 0 else -(abs(b) // abs(a))
                number.append(res)

        return number[0]
