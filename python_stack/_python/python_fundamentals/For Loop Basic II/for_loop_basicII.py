# 1. Given a list, write a function that changes all positive numbers in the list to "big".
def do(arr):
    for i in range(0,len(arr),1):
        if (arr[i]>0):
            arr[i]="big"
    return arr
print(do([-1, 3, 5, -5]))
    

# 2. Given a list of numbers, create a function to replace the last value with the number of positive values. 
#(Note that zero is not considered to be a positive number).
def replace(arr):
    count = 0
    for i in range(0,len(arr),1):
        if arr[i]>0:
            count += 1
    arr[len(arr)-1]=count
    return arr
print(replace([1,6,-4,-2,-7,-2])) 


# 3. Create a function that takes a list and returns the sum of all the values in the list.
def sumAll(arr):
    sum = 0
    for i in range(0,len(arr),1):
        sum +=arr[i]
    return sum    
print(sumAll()) 

# # 4. Create a function that takes a list and returns the average of all the values.x
avgTotal = 0
def avg(arr):
    sum = 0
    for i in range(0,len(arr),1):
        sum +=arr[i]
    avgTotal= sum/len(arr)
    return avgTotal    
print(avg())

# 5. Create a function that takes a list and returns the length of the list.
def take(arr):
    return len(arr)
print(take(arr))    

# 6.Create a function that takes a list of numbers and returns the minimum value in the list. If the list is empty,
# have the function return False.
def min(arr):
    if (len(arr) < 1):
            return False
    else:
        for i in range(1, len(arr),1):
            mini =arr[0]
            print(len(arr))
            if arr[i]<mini:
                mini = arr[i]
        return mini 
print(min(arr))


# 7.Create a function that takes a list and returns the maximum value in the list. If the list is empty, have the function return False.
def max(arr):
    if (len(arr) < 1):
            return False
    else:
        for i in range(1, len(arr),1):
            mixi =arr[0]
            print(len(arr))
            if arr[i]>mixi:
                mixi = arr[i]
        return mixi
print(max(arr))

# 8. Create a function that takes a list and returns a dictionary that has the sumTotal, average, minimum, maximum and length of the list.
def list(arr):
    sum = 0
    avg = 0
    min = arr[0]
    max = arr[1]
    for i in range(0,len(arr),1):
        sum +=arr[i]
        avg= sum/len(arr)
        if arr[i]<min: 
            min = arr[i]
        if arr[i]>max: 
            max = arr[i]
    dictionary = {'sumTotal':sum, 'average':avg, 'minimum':min,'maximum': max,'length': len(arr)}       
    return dictionary                   
print(list(arr))


# 9. Create a function that takes a list and return that list with values reversed. Do this without creating a second list. 
# (This challenge is known to appear during basic technical interviews.)
def reverse(list):
    temp=0
    round=len(list)//2
    for x in range(0,round,1):
        temp= list[x]
        list[x]=list[len(list)-1-x]
        list[len(list)-1-x]=temp
    return list

print(reverse([37,2,1,-9]))
