class test():
    def __init__(self):
        self.b = 2
    a = 1
        
a = test()
print(a.a)
print(a.b)

my_dict = {'name': 'Andy', 'age': 18, 'country': 'China'}

class Person(object):
    def __init__(self, dic):
        self.__dict__.update(dic)
man = Person(my_dict)
print(man.__dict__)
print(man.age)

print(Person.__dict__)