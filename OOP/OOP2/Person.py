class person:
    def __init__(self, name, gender, age):
        self.name = name
        self.gender = gender
        self.age = age

    def display(self):
        if self.gender == "female":
            self.gender = "여자"
        else:
            self.gender = "남자"
            
        