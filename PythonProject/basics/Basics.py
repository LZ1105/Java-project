'''
Created on Nov. 26, 2023

@author: User
'''

def solution(a, b, c):
    d = b ** 2 - 4 * a * c
    if d < 0:
        return None
    # d = math.sqrt(d)
    d = d ** 0.5
    x1 = (-b + d) / 2 * a
    x2 = (-b - d) / 2 * a
    
    x1 = (-b + (b ** 2 - 4 * a * c) ** 0.5) / 2 * a
    
    return (x1, x2)

def basic_operation():
    a = 10
    b = 20
    c = 3
    
    answer = solution(a, b, c)
    if answer == None:
        print("No solution")
    else:
        x1, x2 = answer
        print(f'x1={x1}, x2={x2}')
        
def print_last_item_twice(lst):
    print(f"the last item is: {lst[len(lst) - 1]}")
    print(f"the last item is: {lst[-1]}")
    
        
def list_operations():
    list1 = [0] * 10
    print(f"list1={list1}")
    for i in range(10):
        list1[i] = i + 1
    print(f"list1={list1}")
    
    print(f"the last item is: {list1[9]}")
    print_last_item_twice(list1)
    
    list1b = list1[3:6] # sublist from 4th to 6th
    print(f"list1b = {list1b}")
    list1b = list1[3:-2] # sublist from 4th to the one before the 2nd last
    print(f"list1b = {list1b}")
    list1b = list1[3:] # sublist from 4th to the end
    print(f"list1b = {list1b}")
    list1b = list1[:6] # sublist from the beginning to 6th 
    print(f"list1b = {list1b}")
    
    list2 = []
    for i in range(10):
        # list2[i] = i + 1
        list2.append(i + 1)
        print(f"list2={list2}    len={len(list2)}")
    print(f"list2={list2}")
    list2.extend(list1) # list2 = list2 + list1
    print(f"list2={list2}")
    
    # remove all elements
    toBeRemoved = 1
    removedTimes = 0
    while len(list2) > 0:
        if removedTimes < 2:
            list2.remove(toBeRemoved)
            removedTimes += 1 # removedTimes = removedTimes + 1, however, you can't do this: removeTimes++
            print(f"After remove {toBeRemoved}, list2 contains {list2}")
        else:
            toBeRemoved += 1
            removedTimes = 0
    
    # the following has two problems: (1) logical error (doesn't remove in order); (2) when i > the actual length of list2, out-of-range error occurs
    # list2 = list1 * 2
    # print(f"list2={list2}")
    # for i in range(len(list2)):
    #     list2.pop(i)
    #     print(f"After pop({i}), list2={list2}")
    
    # There are two approaches to remove all elements from a list, one by one.
    # Approach #1
    list2 = list1 * 2
    print(f"list2={list2}")
    for i in reversed(range(len(list2))):
        list2.pop(i)
        print(f"[1] After pop({i}), list2={list2}")
        
    list2 = list1 * 2
    print(f"list2={list2}")
    while len(list2) > 0:
        list2.pop(0) # list2.pop() or list2.pop(-1) also works
        print(f"[2] After pop(), list2={list2}")
        
def print_operations():
    
    print("hello world!")
    a = 10
    b = 20
    
    print(str(a) + " + " + str(b) + " = " + str(a + b) )
    print("a + b = %d" % (a + b))
    print("%d + %d = %d" % (a, b, a + b))
    print(f"{a} + {b} = {a + b}")
    
    c = 20 / 3
    print("c = %.20f" % c)
    
    interestRate = 0.00525
    principal = 1000
    interest = principal * (interestRate * (10 ** 10)) / (10 ** 10)
    print("interest = %.10f" % interest)
    
    for num in range(33):
        print("%d = %X" % (num, num))
        
def replace_name(s, name1, name2):
    pos = s.find(name1)
    while pos >= 0:
        s = s[0:pos] + name2 + s[pos + len(name1):]
        pos = s.find(name1, pos + 1)
    return s

def string_operations():
    s = "Hello lucks, how are you doing? Can I meet you tomorrow, lucks?"
    name1 = "lucks"
    name2 = "john"
    s = replace_name(s, name1, name2)
    print(f"s = {s}")



if __name__ == '__main__':
    # a = int(input('Enter 1st number: '))
    # b = int(input('Enter 2nd number: '))
    # basic_operation()
    # list_operations()
    # print_operations()
    string_operations()
    a = 10
    b = 20
    print(f"a = {a}, b = {b}")
    a, b = b, a
    print(f"a = {a}, b = {b}")
    
