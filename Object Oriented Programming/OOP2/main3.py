import Person

def personn():
    name = str(input("이름 입력: "))
    age = int(input("나이 입력: "))
    gender = str(input("성별(male,female) 입력:"))
    
    return name, age, gender

def main():
    name,gender,age = personn()
    my_class = Person.person(name,age,gender)
    my_class.display()


