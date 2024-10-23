size = int(input())
listMe = [int(x) for x in input().split()]
listMax = []
max = 0;

for x in listMe:
    max = x
    cout = 0
    for x in listMe:
        if max <= x:
            print(x,end=' ')
            max = x
            cout += 1
    print()
    listMax.append(cout)

print(listMax)