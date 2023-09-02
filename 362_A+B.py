import sys

n = int(input())
data = [list(map(int, input().split())) for _ in range(n)]

for i in range(len(data)):
    print("Case #" + str(i+1) + ": "+ str(data[i][0] + data[i][1]))

