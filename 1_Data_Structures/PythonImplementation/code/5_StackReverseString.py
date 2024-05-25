from collections import deque
class Stack:
    def __init__(self):
        self.container = deque()

    def push(self, val):
        self.container.append(val)
    
    def pop(self):
        return self.container.pop()
    
    def peek(self):
        return self.container[-1]
    
    def is_empty(self):
        return len(self.container) == 0
    
    def size(self):
        return len(self.container)

def reverse_string(string):
    s = Stack()
    for char in string:
        s.push(char)
    reverse_string = ''
    while (not s.is_empty()):
        reverse_string += s.pop()
    return reverse_string

myString = "We will conquer Covid-19"
print(reverse_string(myString))