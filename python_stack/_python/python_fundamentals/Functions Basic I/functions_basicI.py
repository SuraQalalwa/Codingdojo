#1
def a():
    return 5
print(a())  #it will print 5

#2
def a():
    return 5
print(a()+a()) #it will print 10

#3
def a():
    return 5
    return 10
print(a())  #it will print 5

#4
def a():
    return 5
    print(10)
print(a())  #it will print 5

#5
def a():
    print(5)  #it will print 5
x = a()
print(x)      #it will print 5

#6
def a(b,c):
    print(b+c)     
print(a(1,2) + a(2,3))   #it will print 3 , 5 respectively


#7
def a(b,c):
    return str(b)+str(c)
print(a(2,5))    #it will print 25

#8
def a():
    b = 100   
    print(b)   
    if b < 10:
        return 5
    else:
        return 10
    return 7
print(a())   #it will print 100 , 10 respectively

#9
def a(b,c):
    if b<c:
        return 7
    else:
        return 14
    return 3
print(a(2,3))  
print(a(5,3))  
print(a(2,3) + a(5,3))   #it will print 7, 14, 21 respectively

#10
def a(b,c):
    return b+c
    return 10
print(a(3,5))  #it will print 8

#11
b = 500
print(b)
def a():
    b = 300
    print(b)
print(b)
a()
print(b)  #it will print 500, 500, 300, 500 respectively

#12
b = 500
print(b)
def a():
    b = 300
    print(b)
    return b
print(b)
a()
print(b)  #it will print 500,500,300,500  respectively

#13
b = 500
print(b)
def a():
    b = 300
    print(b)
    return b
print(b)
b=a()
print(b)  #it will print 500, 500, 300, 300 respectively

#14
def a():
    print(1)
    b()
    print(2)
def b():
    print(3)
a()   #it will print 1, 3, 2 respectively

#15
def a():
    print(1)
    x = b()
    print(x)
    return 10
def b():
    print(3)
    return 5
y = a()
print(y)   #it will print 1,3,5,10  respectively