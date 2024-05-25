weather = {}
temps = []

with open("nyc_weather.csv", 'r') as f:
    next(f) # skip header
    for line in f:
        data = line.split(',')
        weather[data[0]] = int(data[1])
        temps.append(int(data[1]))
    f.close()
print(weather)
print(f"Average Temperature: {sum(temps) / len(temps)}")
print(f"Maximum Temperature: {max(temps)}")
print(f"Temperature on Jan 9: {weather['Jan 9']}")
print(f"Temperature on Jan 4: {weather['Jan 4']}")