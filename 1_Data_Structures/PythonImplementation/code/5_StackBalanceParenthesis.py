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

def is_balanced(string):
    s = Stack()
    for char in string:
        if char in "({[":
            s.push(char)
        elif char in ")}]" and s.is_empty():
            return False
        if char == ")" and not s.is_empty():
            latest = s.peek()
            if latest == "(":
                s.pop()
        if char == "]" and not s.is_empty():
            latest = s.peek()
            if latest == "[":
                s.pop()
        if char == "}" and not s.is_empty():
            latest = s.peek()
            if latest == "{":
                s.pop()
    if (s.is_empty()):
        return "Balanced"
    else:
        return "Unbalanced"
    
myString = "[ ( ] )"
print(is_balanced(myString))