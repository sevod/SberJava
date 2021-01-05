var = 1
while var <= 13:
    print(var)
    var += 1

for i in [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13]:
    print(i)

for i in range(1, 14):
    print(i)

for var in 'Python':
    if var == 'h':
        continue
    print(var)

for var in 'Python':
    if var == 'h':
        break
    print(var)

print('--else--')

for var in 'Python':
    if var == 'a':
        print('Сработал break!')
        break
else:
    print('Символа a нет в слове Python, break не использовался')

print('--else 2--')

for var in 'Python':
    if var == 't':
        print('Сработал break!')
        break
else:
    print('Символа a нет в слове Python, break не использовался')

