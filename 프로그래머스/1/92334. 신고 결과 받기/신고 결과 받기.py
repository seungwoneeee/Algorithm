def solution(id_list, report, k):
    report_count = [0]*len(id_list) #각 아이디당 신고당한 횟수
    report_id = [[] for _ in range(len(id_list))] #각 아이디가 신고한 유저
    get_mail = [0]*len(id_list) #각 아이디당 받을 이메일 횟수
    
    for i in range(len(report)):
        user, report_user = report[i].split()
        idx = id_list.index(user) #신고한 유저의 Id index
        if (report_user not in report_id[idx]):
            report_id[idx].append(report_user) #신고한 유저 입력하기
            report_idx = id_list.index(report_user) #신고당한 회원의 index
            report_count[report_idx] += 1
    for i in range(len(report_count)):
        if report_count[i]>=k:
            name = id_list[i]
            for j in range(len(report_id)):
                if (name in report_id[j]):
                    get_mail[j]+=1
    return get_mail