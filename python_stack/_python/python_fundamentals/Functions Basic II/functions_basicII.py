# # 1.Create a function that accepts a number as an input. 
# # Return a new list that counts down by one, 
my_list=[]
def countdown(x):
    for i in range (x,-1,-1):
        print(i)
        my_list.append(i)
countdown(5)
print(my_list)    

# # 2.Create a function that will receive a list with two numbers. 
# # Print the first value and return the second.
# # Example: print_and_return([1,2]) should print 1 and return 2
arr=[1,2]
def print_and_return(arr):
    print(arr[0])
    return(arr[1])
print(print_and_return(arr))  

# 3.Create a function that accepts a list and returns the sum of the first value in the list plus the list's length.
# Example: first_plus_length([1,2,3,4,5]) should return 6 (first value: 1 + length: 5)
arr =[]
sum = 0
def plus(arr): 
    sum = arr[0]+len(arr)
    print(sum)
plus([1,2,3,4,5])

# 4. Write a function that accepts a list and creates a new list containing only the values from the original list that are greater than its 2nd value. 
# Print how many values this is and then return the new list. 
# If the list has less than 2 elements, have the function return False
arr=[5,2,3,2,1,4]
newArr=[]
def compare(arr):
    for i in range(0,len(arr),1):
        count = 0
        if (len(arr) < 2):
            return("False")
        elif arr[i] > arr[1]:
            count +=1
            newArr.append(arr[i])
    return (newArr)
print(compare(arr))
print(compare([3]))


# #5. Write a function that accepts two integers as parameters: size and value. 
# #The function should create and return a list whose length is equal to the given size, and whose values are all the given value.
newArr=[]
def new(size,value):
    for i in range (0,size,1):
        newArr.append(value)
new(4,7) 
print(newArr)       

