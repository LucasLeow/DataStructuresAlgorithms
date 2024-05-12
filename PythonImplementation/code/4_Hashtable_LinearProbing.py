class HashTable:
    def __init__(self):
        self.MAX = 10
        self.arr = [None for i in range(self.MAX)]

    def get_hash(self, key):
        h = 0
        for char in key:
            h += ord(char)
        return h % self.MAX
    
    def __setitem__(self, key, val):
        h = self.get_hash(key)

        if self.arr[h] is None:
            self.arr[h] = (key, val)
        else:
            new_h = self.find_slot(key, h) # pass h to find index range, key to find keys saved in new_hs
            self.arr[new_h] = (key, val)
    
    def __getitem__(self, key):
        h = self.get_hash(key)
        print(h)
        if (self.arr[h] is None):
            return
        
        if (self.arr[h][0] == key):
            return self.arr[h][1]
        else:
            new_h = self.find_slot(key, h)
            return self.arr[new_h][1]
    
    def __delitem__(self, key):
        h = self.get_hash(key)
        if (self.arr[h][0] == key):
            self.arr[h] = None
        else:
            new_h = self.find_slot(key, h)
            self.arr[new_h] = None
    
    def find_slot(self, key, h):
        idx_range = self.get_index_range(h)
        for idx in idx_range:
            if self.arr[idx] is None: # For allocating new key, value
                return idx
            if self.arr[idx][0] == key: # For retrieving displaced key, value
                return idx
        raise Exception("Hashmap is full")
        
    def get_index_range(self, h):
        return [*range(h, self.MAX)] + [*range(0, h)]
        
t = HashTable()
t['march 6'] = 130
t['march 17'] = 140
print(t.arr)
del t['march 6']
print(t.arr)
print(t['march 6'])
print(t.arr)