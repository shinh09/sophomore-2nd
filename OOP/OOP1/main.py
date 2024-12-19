import myClass

def number():
    num1 = int(input("Num 1: "))
    num2 = int(input("Num 2: "))
    return num1, num2

def main():
    num1, num2 = number()
    my_class = myClass.MyClass(num1, num2)

    print("덧셈:", my_class.add())
    print("뺄셈:", my_class.minus())
    print("곱셈:", my_class.multiply())
    print("나눗셈:", my_class.divide())

main()
