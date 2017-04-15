"""
a script that allows you to add strings and
find a number of strings that start with input string, using dictionarys

for example:
======
4
add kim
add kiml
find kim -> return 2
2
find kiml -> return 1
1
======
5
add kim
add kimleng
add kimlong
find kim -> return 3
3
find kiml ->return 2
2
======
"""
from collections import defaultdict

class DB:
    __slots__ = ['cont', 'contN']
    def __init__(self,cont=None,contN=None):
        self.cont=cont
        self.contN=contN
def dictInDict(db:DB,x:str):
    if x=='':
        return
    if db.cont.get(x[0]) ==None:
        tmp=""
        tmp2=None
        found = False
        for i,j in db.cont.items():
            if i[0]==x[0]:
                tmp = i
                tmp2 = j
                found = True
                break
        if found:   
            del db.cont[tmp]
            del db.contN[tmp]
            db.cont[tmp[0]] = DB(dict(),defaultdict(int))
            db.contN[tmp[0]]+=2
            dictInDict(db.cont[tmp[0]],tmp[1:])
            dictInDict(db.cont[tmp[0]],x[1:])
            
        else:
            db.cont[x]=DB(dict(),defaultdict(int))
            db.contN[x]+=1
            
    else:
        db.contN[x[0]]+=1
        dictInDict(db.cont[x[0]],x[1:])

def findBeg(db:DB,x:str):
    if x=='':
        return
    if db.contN.get(x[0])==None:
        for i,j in db.contN.items():
            if i[0]==x[0]:
                for k in range(len(x)):
                    if i[k]!=x[k]:
                        return 0
                return j
        return 0
    else:
        if len(x)==1:
            if db.contN.get(x)!=None:
                return db.contN.get(x)
            return 0
        else:
            return findBeg(db.cont[x[0]],x[1:])
    return 0
def printDict(db:DB,ext):
    for i, j in db.cont.items():
        print(ext,i,'==',db.contN[i])
       
        printDict(j,ext+'=')
myObj= DB(dict(),defaultdict(int))
n = int(input().strip())
for a0 in range(n):
    op, contact = input().strip().split(' ')
    if op=='add':
        dictInDict(myObj,contact)
        printDict(myObj,"=")
    else:
        print( findBeg(myObj,contact))
input()
