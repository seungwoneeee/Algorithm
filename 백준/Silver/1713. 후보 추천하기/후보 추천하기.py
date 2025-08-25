n = int(input())
recom = int(input())
recom_list = list(map(int,input().split()))

frames = []

for i,s in enumerate(recom_list): #i=들어온 순서,s=추천하는 사람
    found = False
    for j in range(len(frames)):
        if frames[j][0]==s: #이미 존재하면
            frames[j][1]+=1
            found=True
            break
    if found:
        continue

    if len(frames) < n: #없지만, 자리가 남아있는 경우
        frames.append([s,1,i])
        continue

    #자리가 없으면 지울 대상을 찾기
    del_id = 0
    del_cnt = frames[0][1]
    del_time = frames[0][2]

    for j in range(1, len(frames)):
        now_cnt = frames[j][1]
        now_time = frames[j][2]

        if now_cnt < del_cnt: #추천받은 횟수가 더 작은 경우
            del_id = j
            del_cnt = now_cnt
            del_time = now_time
        elif now_cnt == del_cnt and now_time<del_time: #추천수가 같으면 더 오래된 후보를 지울 대상으로 선택
            del_id = j
            del_cnt = now_cnt
            del_time = now_time
    
    del frames[del_id] #찾은 후보 제거
    frames.append([s, 1, i]) #새 후보 넣기

ans = [item[0] for item in frames]
ans.sort()
print(*ans) #print(ans):[2,6,7]->*ans: 2 6 7