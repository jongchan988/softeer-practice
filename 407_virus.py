# 입력값 받기
K, P, N = map(int, input().split())

# 초기 바이러스 개수
total_virus = K

# N초 동안 바이러스 개수 계산
for i in range(N):
    total_virus = (total_virus * P)

# 최종 바이러스 개수 출력
print(total_virus % 1000000007)