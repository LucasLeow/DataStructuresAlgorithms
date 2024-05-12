class Node:
    def __init__(self, data=None, next=None, prev=None):
        self.data = data  # to store node value
        self.next = next  # pointer to next element
        self.prev = prev


class LinkedList:
    def __init__(self):
        self.head = None  # Points to head of LinkedList, initially None
        # null in Python is None
        # Head is the only attribute inside LinkedList

    def insert_at_beginning(self, data):
        node = Node(data, self.head) # initially, self.head is none
        self.head = node # self.head now points to created node
    
    def insert_at_end(self, data):
        if self.head is None: # if LinkedList empty
            self.head = Node(data, None) # Point head to newly created node, next is None
            return

        # If not empty, want to iterate till end of LinkedList to insert value (O(n))
        itr = self.head
        
        while(itr.next): # At last element, itr.next = None (Break out of loop)
            itr = itr.next
        
        itr.next = Node(data, None, itr) # Point last element to newly created node
    
    # Create new LinkedList with provided list
    def insert_values(self, data_list):
        self.head = None
        for data in data_list:
            self.insert_at_end(data)
    
    # Insert element at given index
    def insert_at(self, idx, value):
        # sanity check
        if (idx < 0) or (idx >= self.get_length()):
            raise Exception("Invalid Index")
    
        # Insert at head
        if (idx == 0):
            self.insert_at_beginning(value)
        
        count = 0
        itr = self.head
        while (itr):
            if (count == idx - 1): # At element before idx to be inserted
                node = Node(value, itr.next, itr)
                itr.next = node
                break
                
            itr = itr.next
            count += 1
        
    
    # Remove element at given index
    def remove_at(self, idx):
        # sanity check
        if (idx < 0) or (idx >= self.get_length()):
            raise Exception("Invalid Index")

        # Remove head element
        if (idx == 0):
            self.head = self.head.next # Point current head to next element, current element will be lost
            self.head.prev = None # Remove reference to previous removed head element
            return #python performs garbage collection and will remove memory used
        
        count = 0
        itr = self.head # itr is used to prevent loss of self.head pointer (somthing like temp)
        while (itr):
            if (count == idx - 1): # At the previous element (before the element to be removed)
                itr.next = itr.next.next
                itr.next.prev = itr
                break
            
            itr = itr.next
            count += 1

                
    def get_length(self):
        count = 0
        itr = self.head
        while (itr):
            count += 1
            itr = itr.next
        return count
        
    def print_forward(self):
        if (self.head is None) :
            print("LinkedList is empty!")
            return

        itr = self.head
        llstr = ''
        while (itr):
            llstr += str(itr.data) + ' --> '
            itr = itr.next

        print(llstr)
        
    def print_backward(self):
        if (self.head is None) :
            print("LinkedList is empty!")
            return

        itr = self.head
        llstr = ''
        while (itr.next):
            itr = itr.next

        while (itr):
            llstr += str(itr.data) + ' --> '
            itr = itr.prev
        print(llstr)
        
if __name__ == '__main__':
    ll = LinkedList()

    myFruits = ['apple', 'orange', 'banana', 'pineapple']
    ll.insert_values(myFruits)
    print("Newly created fruit list")
    
    print("Forward Printing:")
    ll.print_forward()
    print()
    
    print("Backward Printing:")
    ll.print_backward()
    print()


    
    
    

    