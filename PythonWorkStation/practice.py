# 숫자 자료형
print(5)
print(-10)
print(3.14)
print(1000)
print(5+3)
print(2*8)
print(3*(3+1))

# 문자 자료형
print('풍선') # 풍선 이라고 출력됨
print("나비") # 풍선과 같이 나비 라고 출력됨
print("ㅋㅋㅋㅋㅋㅋㅋㅋ") # ㅋㅋㅋㅋㅋㅋㅋㅋㅋ 이 출력됨
print("ㅋ"*9) # 문자열과 계산을 해서 반복하여 출력 할 수도 있다. 결과: ㅋㅋㅋㅋㅋㅋㅋㅋㅋ

# boolean 참 / 거짓
print(5>10)
print(5<10)
print(True)
print(False)
print(not True)
print(not False)
print(not (5>10))

# 변수
animal = "강아지" # String 변수의 선언
name = "연탄이"
age = 4 # int 변수의 선언
hobby = "산책"
is_adult = age >= 3 #나이가 3보다 크거나 같다면, True 아니라면 False를 반환하는 변수.(boolean 변수 선언)

# 애완동물을 소개해주세요~
#print("우리집 강아지의 이름은 연탄이예요")
#print("연탄이는 4살이며, 산책을 아주 좋아해요")
#print("연탄이는 어른일까요? True")
print("우리집 "+ animal +"의 이름은 "+ name +"예요")
hobby = "공놀이" # 이런 식으로 변수를 문장 중간에 넣어도 된다. 이렇게 될 경우, hobby의 부분이 "산책"이 아닌, "공놀이"로 변화됨.
print(name + "는 "+ str(age) +"살이며, "+ hobby +"을 아주 좋아해요") # age의 경우, int형이기 때문에 str로 형변환을 해줘야 한다.
print(name +"는 어른일까요? "+str(is_adult)) # is_adult부분도 boolean형이기 때문에, str로 형변환.

# 연탄이의 이름이 변경 되어, 연탄이 라는 부분을 다 변경해야한다.
# 예제에서는 세 문장이라 수기로 수정해도되지만, 더 많은 문장이 있거나, 실수를 방지하고 번거로움을 줄이려 한다.

'''
(Quiz) 변수를 이용하여 다음 문장을 출력하시오

변수명
: station
  
변수값
: "사당","신도림", "인천공항" 순서대로 입력

출력문장
: XX행 열차가 들어오고 있습니다.
'''

station1 ="사당"
station2 ="신도림"
station3 ="인천공항"

print((station1),"행 열차가 들어오고 있습니다.")
print((station2),"행 열차가 들어오고 있습니다.")
print((station3),"행 열차가 들어오고 있습니다.")