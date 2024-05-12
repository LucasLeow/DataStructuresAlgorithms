from collections import deque
import time
import threading 

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

class OrderingSystem:
    def __init__(self):
        self.placement = Queue()

    def placeOrder(self, orders):
        for order in orders:
            print(f"Placing order for {order}")
            self.placement.enqueue(order)
            time.sleep(0.5)
    
    def serveOrder(self):
        print("Serving orders")
        while(not self.placement.is_empty()):
            order = self.placement.dequeue()
            print(f"Serving {order}")
            time.sleep(2)

orders = ['pizza', 'samosa', 'pasta', 'briyani', 'burger']
before = time.time()
o = OrderingSystem()

t1 = threading.Thread(target=o.placeOrder, args=(orders,))
t2 = threading.Thread(target=o.serveOrder)

# Starting threads
t1.start()
time.sleep(1)
t2.start()

# Wait for threads to finish
t1.join()
t2.join()

print("Order completed in: ", time.time() - before)