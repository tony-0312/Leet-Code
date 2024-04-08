string=list(input())
lpar,rpar,star=0,0,0
for i in range(len(string)):
    if(string[i]=='('):
        lpar=lpar+1
    elif(string[i]==')'):
        rpar=rpar+1
    if(string[i]=='*'):
        star=star+1
for i in range(0,star):
    if(lpar!=rpar):
        if(lpar>rpar):
            rpar=rpar+1
            star=star-1
        else:
            lpar=lpar+1
            star=star-1
if(lpar==rpar):
    print("True")
else:
    print("False")
