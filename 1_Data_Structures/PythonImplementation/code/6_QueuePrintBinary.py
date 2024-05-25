from collections import deque

class Queue:
    def __init__(self):
        self.buffer = deque()

    def enqueue(self, val):
        self.buffer.appendleft(val)

    def dequeue(self):
        return self.buffer.pop()

    def is_empty(self):
        return len(self.buffer) == 0

    def size(self):
        return len(self.buffer)
    
class Solution:
    def __init__(self):
        self.q = Queue()
    
    def generateBinaries(self, num):
        self.q.enqueue(1) # first number
        for i in range(num):
            front = str(self.q.dequeue()) # extract first number
            self.q.enqueue(front+'0')
            self.q.enqueue(front+'1')    
            print(front, end="\n")

s = Solution()
s.generateBinaries(10)


    
    
