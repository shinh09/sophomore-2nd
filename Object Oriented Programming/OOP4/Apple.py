class Apple:
    def __init__(self,model,price,username,battery):
        self.model = model
        self.price = price
        self.username = username
        self.battery = battery
        self.network = "seoultech.dream"
        self.bluetooth = True
        

    def connect_network(self):
        return f"{self.model}가 {self.network} 네트워크에 연결되었습니다."
    
    def fix(self):
        return f"해당 {self.model} 기기는 애플 서비스 센터를 이용해주시길 바랍니다."
    
    def change_battery(self):
        if self.battery < 85:
            return "배터리 교체가 필요합니다."
        else:
            return "배터리 성능이 '좋음'입니다."
        
# 연락추가, 연락찾기, 수신 중

class Iphone(Apple):
    def __init__(self,model,price,username,battery):
        super().__init__(model,price,username,battery)
        self.contact = {}

    def add_contact(self,name,phonenumber):
        self.contact[name] = phonenumber
        return f"{phonenumber}가 {name}으로 연락처에 저장되었습니다."
    
    def search_contact(self,searchname):
        if searchname in self.contact:
            return f"{searchname}:{self.contact[searchname]}"
        else:
            return f"해당 번호의 연락처가 없습니다."
            
    def calling(self,phonenumber):
        for name,number in self.contact.items():
            if phonenumber==number:
                return f"{self.username}->{name} 수신 중....."
            else:
                return f"{self.username}->{phonenumber} 수신 중...."
        

        
class Mac(Apple):
    def __init__(self,model,price,username,battery):
        super().__init__(model,price,username,battery)
    def price_by_size(self,inch):
        if inch > 14 :
            self.price += 300000
        return f"해당 맥북{self.model}의 가격은 {self.price}원 입니다."


class Airpods(Apple):
    def __init__(self,model,price,username,battery):
        super().__init__(model,price,username,battery)

    def pairing(self,connect_device):
        if self.bluetooth:
            return f"{self.username}의 {self.model}가 {connect_device}에 연결되었습니다."



# class Airpods(Apple):


        
macbook= Mac("MacBook Air M3", 1800000, "박신형",100)
print(macbook.connect_network())
print(macbook.fix())
print(macbook.change_battery())
print()
print(macbook.price_by_size(13))
print(macbook.price_by_size(15))


iphone = Iphone("Iphone 15",523434,"황유영",80)
print(iphone.connect_network())
print(iphone.fix())
print(iphone.change_battery())
print()
print(iphone.add_contact("김민서","010-1234-5678"))
print(iphone.calling("010-3151-2419"))
print(iphone.calling("010-1234-5678"))
print(iphone.search_contact("김민서"))
print(iphone.search_contact("심수용"))

airpods = Airpods("Airpods Pro 2",200000,"이민혁",80)
print(macbook.fix())
print()
print(airpods.pairing("Iphone 16"))





# 부모: 모델명, 가격, 배터리, 사용자이름, 네트워크연결
# 배터리를 교체하세요
# 네트워크에 연결되었습니다
# 사용자이르

# 자식:
# 맥북-> 몇인치, M1M2M3칩이 탑재되어있는지 
# 인치가 15일 경우, 가격이 original +20만원
# 

# 에어팟-> 
# def1. 모델과 에어팟 페이링이 되었습니다.

# 아이패드-> 애플펜슬 종류, 애플펜슬 배터리
# def1. 애플펜슬 종과 모델 매치,네트워크연결 -->  
# def2. 애플펜슬 충전 알림

# 아이폰-> number, 친구 이름
# def1. 연락처 저장 이름으로
# def2. 연락하기-> 연락처 여부-> 있으면 calling, 없으면 없는 연락처