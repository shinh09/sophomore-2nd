class Person:
    def __init__(self, name, age):
        self.name = name
        self.age = age

        
people = []

def profile(name, age):
    person = Person(name, age) 
    people.append(person)


def find_name(name):
    for person in people:
        if person.name == name:
            return person.age
    return "해당 이름의 사람이 없습니다."

def find_age(age):
    for person in people:
        if person.age == age:
            return person.name
    return "해당 나이의 사람이 없습니다."

def main():
    profile("두루미", 21)
    profile("황유영", 29)
    profile("황유영", 25)
    profile("김민서", 12)
    profile("이민혁", 14)
    profile("심수용", 23)
    profile("냐냔냔", 23)   #이름중복, 나이 출력,,

    while (True):
        searchNumber = input("이름[1] 나이[2] 종료하려면[q] :  ")
        
        if searchNumber == "1":
            name = input("이름을 입력하세요: ")
            print(f"{name}님의 나이: {find_name(name)}")
        
        elif searchNumber == "2":
            age = int(input("나이를 입력하세요: "))        
            print(f"이름: {find_age(age)}")
        
        elif searchNumber == "q":
            print("종료")
            break
        
        else:
            print("1 또는 2를 입력하세요.")

main()