class HashTable:
    def __init__(self):
        self.MAX = 10
        self.arr = [[] for i in range(self.MAX)] # [key, value] (separate chaining technique for collision handling)
        
    def get_hash(self, key):
        h = 0
        for char in key:
            h += ord(char)
        return h % self.MAX

    # Add key-value pair to hashtable using built-in __setitem__ & __getitem__
    def __setitem__(self, key, val):
        h = self.get_hash(key)
        found = False
        
        for idx, element in enumerate(self.arr[h]): # check if key exist in hashmap chain
            if len(element) == 2 and element[0]==key:
                self.arr[h][idx] = (key, val) #if found, replace with new tuple
                found = True
                break
        
        if not found:
            self.arr[h].append((key, val)) # if no key exist, append tuple to hashtable
                
    def __getitem__(self, key):
        h = self.get_hash(key)
        
        for element in self.arr[h]:
            if element[0] == key:
                return element[1]

    def __delitem__(self, key):
        h = self.get_hash(key)
        found = False
        
        for idx, element in enumerate(self.arr[h]):
            if (element[0] == key):
                del self.arr[h][idx]
                found = True
                break
        if not found:
            return "Item not exist"
    
t = HashTable()
t['march 6'] = 130
t['march 17'] = 140
print(t.arr)
print(t['march 6'])
print(t['march 17'])
del t['march 17']
print(t['march 17'])


