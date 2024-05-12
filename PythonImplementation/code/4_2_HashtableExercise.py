words = {}

with open("poem.txt", 'r') as f:
    for line in f:
        for word in line.split():
            if word in words:
                words[word] += 1
            else:
                words[word] = 1

    f.close()
print(words)
