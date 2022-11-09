class StockSpanner:

    def __init__(self):
        self.stack = []
        self.n = 0

    def next(self, price: int) -> int:
        self.n += 1
        while len(self.stack) > 0 and price >= self.stack[-1][0]:
            self.stack.pop()
        
        res = self.n if len(self.stack) == 0 else self.n - self.stack[-1][1]
        self.stack.append((price, self.n))
        
        return res