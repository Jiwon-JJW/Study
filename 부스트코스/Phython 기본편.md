# Python

## 01. 프로그램 세팅

* Python 설치 + visual studio code 설치
* visual syudio code 내에서 Python 한 번 더 설치



* Python에서 코드 입력 후-> 저장 -> 디버그 항목에서 Run을 하는데, 이 때 세팅.
  * Python 클릭
  * Python interpreter 설치 하라는 팝업 발생.(윈도우)
  * 한 번 더 Debug with Python 클릭
  * Python file 클릭.
* new file로 원하는 이름.py를 입력하여 파일 생성.
  * Java에서 처럼 public static void main(String[] args)를 입력하지 않고, 그냥 print 명령어만 써도 된다.





## 02. 숫자 자료형

```python
print(5)
print(-10)
print(3.14)
print(1000)
print(5+3)
print(2*8)
print(3*(3+1))
```

* print(5)
  * 5
* print(-10)
  * -10
* print(3.14)
  * 3.14
* print(1000)
  * 1000
* print(5+3)
  * 8
* print(2*8)
  * 16
* print(3*(3+1))
  * 12

## 03. 문자열 자료형

```python
print('풍선')
print("나비") 
print("ㅋㅋㅋㅋㅋㅋㅋㅋ") 
print("ㅋ"*9)
```

* print('풍선')
  * 풍선 이라고 출력됨
* print("나비") 
  * 풍선과 같이 나비 라고 출력됨
* print("ㅋㅋㅋㅋㅋㅋㅋㅋ") 
  * ㅋㅋㅋㅋㅋㅋㅋㅋㅋ 이 출력됨
* print("ㅋ"*9) 
  * 문자열 계산을 하여 출력 할 수도 있다. 
  * 결과: ㅋㅋㅋㅋㅋㅋㅋㅋㅋ



## 04. boolean 자료형 (참/거짓 을 나타냄)

```python
print(5>10)
print(5<10)
print(True)
print(False)
print(not True)
print(not False)
print(not (5>10))
```

* print(5>10)
  * False
* print(5<10)
  * True
* print(True)
  * True
* print(False)
  * False
* print(not True)
  * False
* print(not False)
  * True
* print(not (5>10))
  * True

not을 붙이면 해당 결과값의 부정이 되어 반대 값이 출력된다.



## 05. 변수

```python
animal = "강아지" # String 변수의 선언
name = "연탄이"
age = 4 # int 변수의 선언
hobby = "산책"
is_adult = age >= 3 #나이가 3보다 크거나 같다면, True 아니라면 False를 반환하는 변수.(boolean 변수 선언)

'''
애완동물을 소개해주세요~
print("우리집 강아지의 이름은 연탄이예요")
print("연탄이는 4살이며, 산책을 아주 좋아해요")
print("연탄이는 어른일까요? True")
'''

print("우리집 "+ animal +"의 이름은 "+ name +"예요")
hobby = "공놀이" 
# 이런 식으로 변수를 문장 중간에 넣어도 된다. 이렇게 될 경우, hobby의 부분이 "산책"이 아닌, "공놀이"로 변화됨.

print(name + "는 "+ str(age) +"살이며, "+ hobby +"을 아주 좋아해요") 
# age의 경우, int형이기 때문에 str로 형변환을 해줘야 한다.

# print(name, "는 ", age, "살이며, ", hobby, "을 아주 좋아해요")
# 와 같은 식으로 +대신 ,를 쓸 수 있는데, 이 때의 경우, 형변환을 따로 해주지 않아도 된다.

print(name +"는 어른일까요? "+str(is_adult)) 
# is_adult부분도 boolean형이기 때문에, str로 형변환.

'''
연탄이의 이름이 변경 되어, 연탄이 라는 부분을 다 변경해야한다.
예제에서는 세 문장이라 수기로 수정해도되지만, 더 많은 문장이 있거나, 실수를 방지하고 번거로움을 줄이려 한다.
따라서 실행하는게 변수.
'''
```



## 06. 주석

* 주석을 사용하는 방법: 

  * 문장 앞에 #을 붙인다.
    여러문장 선택 후, Ctrl+/ 혹은 CMD+/를 하면 앞 부분에 한꺼번에 #이 붙음.

    해제도 동일하게 진행하면 된다.

  * 문장의 시작과 끝에 '''를 붙인다면, 여러 문장을 주석처리 할 수 있다.



## 07. Quiz #1

```python
'''
(Quiz) 변수를 이용하여 다음 문장을 출력하시오

변수명
: station
  
변수값
: "사당","신도림", "인천공항" 순서대로 입력

출력문장
: XX행 열차가 들어오고 있습니다.
'''

# 내가 푼 결과:
station1 ="사당"
station2 ="신도림"
station3 ="인천공항"

print((station1),"행 열차가 들어오고 있습니다.")
print((station2),"행 열차가 들어오고 있습니다.")
print((station3),"행 열차가 들어오고 있습니다.")

# 강의 내 결과:
station = "사당"
print(station + "행 열차가 들어오고 있습니다.")
station = "신도림"
print(station + "행 열차가 들어오고 있습니다.")
station = "인천공항"
print(station + "행 열차가 들어오고 있습니다.")
```

