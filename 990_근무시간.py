days = 5
workingData = [list(map(str, input().split())) for _ in range(days)]
sum = 0

for i in range(len(workingData)):
    startTimes, startminutes = map(int, workingData[i][0].split(":"))
    endTimes, endtminutes = map(int, workingData[i][1].split(":"))
    sum += (endTimes * 60 + endtminutes) - (startTimes * 60 + startminutes)
print(sum)

