from collections import deque

def solution(queue1, queue2):
    answer = -1;
    queue1_len = len(queue1)
    queue2_len = len(queue2)
    queue1_sum = sum(queue1)
    queue2_sum = sum(queue2)
    q1 = deque(queue1)
    q2 = deque(queue2)
    
    total = queue1_sum+queue2_sum
    goal = (total)//2
    
    if total%2 == 1:
        return answer
    
    for i in range(3*queue2_len):
        if (queue1_sum>queue2_sum):
            tmp = q1.popleft()
            q2.append(tmp)
            queue1_sum -= tmp
            queue2_sum += tmp
            answer +=1 
        elif (queue1_sum<queue2_sum):
            tmp = q2.popleft()
            q1.append(tmp)
            queue1_sum += tmp
            queue2_sum -= tmp
            answer +=1 
        elif (queue1_sum==queue2_sum and queue1_sum==goal):
            break
    if (queue1_sum!=queue2_sum or queue1_sum!=goal or queue2_sum!=goal):
        answer = -2
    return answer+1


