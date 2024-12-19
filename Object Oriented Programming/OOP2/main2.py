import Rectangle

def number():
    print("사각형의 넓이와 둘레를 계산합니다.")
    width = int(input("사각형의 가로 입력: "))
    height = int(input("사각형의 세로 입력: "))
    return width, height

def main():
    width, height = number()
    my_class = Rectangle.rectangle(width,height)
    print("-"*30)
    print("사각형의 넓이:", my_class.area_calc())
    print("사각형의 둘레:", my_class.circum_clac())
    print("-"*30)

main()
