N, M = map(int, input().split())
config = []
testData = []
result = 0

for _ in range(N):
    config.append(input().split())

for _ in range(M):
    testData.append(input().split())

def getSectionSpeed(data, location):
    sum = 0
    for i in range(len(data)):
        sum += int(data[i][0])
        if (sum >= location):
            return int(data[i][1])


for i in range(1, 101):
    configSpeed = int(getSectionSpeed(config, i))
    testSpeed = int(getSectionSpeed(testData, i))
    diff = testSpeed - configSpeed
    if (result < diff):
        result = diff
    
print(result)