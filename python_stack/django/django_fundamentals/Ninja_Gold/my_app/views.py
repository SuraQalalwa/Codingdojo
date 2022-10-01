from django.shortcuts import render, redirect
import random

def index(request):
    request.session['sum']=0
    context={
        'sum' : 0
    }
    return render(request,'index.html',context)

def play(request):
    #FARM
    if request.POST['form_name'] == 'farm':
        if 'sum' in request.session:
            randomnum=random.randint(10, 20)
            request.session['sum']+=randomnum
        else:
            request.session['sum']=0
            randomnum=random.randint(10, 20)
            request.session['sum']+=randomnum
        context={
            'sum' : request.session['sum'],
            'money_info' : f"You entered a farm and earned {randomnum} gold."
        }
        return render(request,'index.html',context)
    #CAVE
    elif request.POST['form_name'] == 'cave':
        if 'sum' in request.session:
            randomnum=random.randint(5, 10)
            request.session['sum']+=randomnum
        else:
            request.session['sum']=0
            randomnum=random.randint(5, 10)
            request.session['sum']+=randomnum
        context={
            'sum' : request.session['sum'],
            'money_info' : "You entered a Cave and earned {} gold.".format(randomnum)
            }
        return render(request,'index.html',context)
    #HOUSE
    elif request.POST['form_name'] == 'house':
        if 'sum' in request.session:
            randomnum=random.randint(2, 5)
            request.session['sum']+=randomnum
        else:
            request.session['sum']=0
            randomnum=random.randint(2, 5)
            request.session['sum']+=randomnum
        context={
            'sum' : request.session['sum'],
            'money_info' : "You entered a House and earned {} gold.".format(randomnum)
            }
        return render(request,'index.html',context)
    #QUEST
    else:
        if 'sum' in request.session:
            randomnum=random.randint(-50, 50)
            request.session['sum']+=randomnum
        else:
            request.session['sum']=0
            randomnum=random.randint(-50, 50)
            request.session['sum']+=randomnum
        if randomnum>0:
            context={
                'sum' : request.session['sum'],
                'money_info' :"You entered a Quest and earned {} gold.".format(randomnum)
                }
        elif randomnum<0:
            x=abs(randomnum)
            context={
                'sum' : request.session['sum'],
                'money_info' : "You entered a Quest and earned {} gold.".format(x)
                }
        else:
            context={
                'sum' : request.session['sum'],
                'money_info' : "You failed a Quest and lost 50 gold. Ouch."
                }
        return render(request,'index.html',context)

def restart(request):
    return redirect('/')