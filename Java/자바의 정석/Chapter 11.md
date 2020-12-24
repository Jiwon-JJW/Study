# CHAPTER 11

## 01. 컬렉션 프레임 웍

#### 컬렉션 프레임웍이란?

* 데이터 군(Group)을 저장하는 클래스들을 표준화 한 설계

* 컬렉션(collection): 다수의 데이터, 즉 데이터 그룹을 의미.
  프레임웍: 표준화된 프로그래밍 방식을 의미.
  
* Vector, Hashtable, Properties와 같은 컬렉션 클래스를 다룰 수 있으며, 다양한 컬렉션 클래스가 추가되어 있다.
  
  > 컬렉션 클래스: Vector와 같이 다수의 데이터를 저장할 수 있는 클래스.
  
* 모든 컬렉션 클래스를 표준화된 방식으로 다룰 수 있도록 체계화 되어있음.



* 컬렉션 프레임웍은 컬렉션,다수의 데이터 등을 다루는 데 필요한 다양하고 풍부한 클래스들을 제공하고 있음.
  또한 인터페이스와 다형성을 이용한 객체지향적 설계를 통해 표준화 되어있기 때문에 사용법 숙지가 편리하고, 재사용성이 높은 코드를 작성할 수 있음.



#### 라이브러리와 프레임웍

* 라이브러리(그래픽 라이브러리, 통계 라이브러리): 공통으로 사용될만한 유용한 기능을 모듈화하여 제공.
* 프레임웍: 기능뿐만 아니라 프로그래밍 방식을 정형화 하여 프로그램의 개발 생산성을 높이고 유지보수를 용이하게 함.



## 02. 컬렉션 프레임웍의 핵심 인터페이스

* 컬렉션 프레임웍에서는 컬렉션데이터 그룹을 크게 3가지 타입이 존재한다고 인식 해, 각 컬렉션을 다루는 데 필요한 기능을 가진 3개의 인터페이스를 정의함.

* 인스턴스 List와 Set의 공통된 부분을 다시 뽑아, 새로운 인터페이스인 Collection을 추가로 정의 함.
  ![스크린샷 2020-10-04 오후 1 14 23](https://user-images.githubusercontent.com/69128652/95006844-922e1080-0643-11eb-80f8-903a965ea592.png)

  🔼 컬렉션 프레임웍의 핵심 인터페이스간의 상속 계층도

  * 인터페이스 List와 Set을 구현한 컬렉션 클래스들은 서로 많은 공통부분이 있어서, 공통된 부분을 다시 뽑아 Collection인터페이스를 정의할 수 있었지만, Map인터페이스는 이들과 전혀 다른 형태이기 때문에, 상속계층도에 포함되지 않음.



* 인터페이스의 특징과 차이:

  | 인터페이스 | 특징                                                         |
  | ---------- | ------------------------------------------------------------ |
  | List       | 순서가 있는 데이터의 집합. 데이터의 중복을 허용한다.<br />ex) 대기자 명단<br />**구현 클래스: ArrayList, LinkedList, Stack, Vector 등** |
  | Set        | 순서를 유지하지않는 데이터의 집합. 데이터의 중복을 허용하지 않는다.<br />ex) 양의 정수집합, 소수의 집합<br />**구현 클래스: HashSet, TreeSet 등** |
  | Map        | 키(key)와 값(value)의 쌍(pair)으로 이루어진 데이터의 집합<br />순서는 유지되지 않으며, 키는 중복을 허용하지 않고, 값은 중복을 허용한다.<br />ex) 우편번호, 지역번호(전화번호)<br />**구현 클래스: HashMap, TreeMap, Hashtable, Properties 등** |

  * 컬렉션 프레임웍의 모든 컬렉션 클래스들은 List, Set, Map 중의 하나를 구현하고 있으며, 
    구현한 인터페이스의 이름이 클래스의 이름에 포함되어있어서 이름만으로 클래스의 특징을 쉽게 알 수 있도록 되어있음.



## 03. Collection인터페이스

* Collection인터페이스의 메서드:

  | 메서드                                                       | 설명                                                         |
  | ------------------------------------------------------------ | ------------------------------------------------------------ |
  | boolean add(Object o)<br />boolean addAll(Collection c)      | 지정된 객체(o) 또는 Collection(c) 의 객체들을 Collection에 추가한다. |
  | void clear()                                                 | Collection의 모든 객체를 삭제한다.                           |
  | boolean contains(Object o)<br />boolean containsAll(Collection c) | 지정된 객체(o) 또는 Collection의 객체들이 Collection에 포함되어 있는지 확인한다. |
  | boolean equals(Object o)                                     | 동일한 Collection인지 비교한다.                              |
  | int hashCode()                                               | Collection의 hash code를 반환한다.                           |
  | boolean isEmpty()                                            | Collection이 비어있는지 확인한다.                            |
  | Iterator iterator()                                          | Collection의 Iterator를 얻어서 반환한다.<br />** Iterator인터페이스는 컬렉션에 포함된 객체들에 접근할 수 있는 방법을 제공.* |
  | boolean remove(Object o)                                     | 지정된 객체를 삭제한다.                                      |
  | boolean removeAll(Collection c)                              | 지정된 Collection에 포함된 객체들을 삭제한다.                |
  | boolean retainAll(Collection c)                              | 지정된 Collection에 포함된 객체만을 남기고 다른 객체들은 Collection 에서 삭제한다. <br />이 작업으로 인해 Collection에 변화가 있으면 true를, 그렇지 않으면 falese를 반환한다. |
  | int size()                                                   | Collection에 저장된 객체의 개수를 반환한다.                  |
  | Object[] toArray()                                           | Collection에 저장된 객체를 객체배열(Object[])로 반환한다.    |
  | Object[] toArray(Object[] a)                                 | 지정된 배열에 Collection의 객체를 저장해서 반환한다.         |

  

* Collection인터페이스는 컬렉션 클래스에 저장된 데이터를 읽고, 추가하고 삭제하는 등 컬렉션을 다루는데 가장 기본적인 메서드들을 정의하고 있다.
* 위의 표에서 반환타입이 boolean인 메서드들은 작업을 성공하거나 사실이면 true를, 실패하거나 사실이 아닐 경우 false를 반환.



## 04. List 인터페이스

* 중복을 허용하면서 저장순서가 유지되는 컬렉션을 구현하는데 사용됨.

  ![img](https://user-images.githubusercontent.com/69128652/95007101-c22ae300-0646-11eb-92de-00bb4dc2057f.png)

  🔼 List의 상속계층도
  
* List인터페이스에 정의된 메서드: Collection인터페이스로부터 상속받은 것들은 제외 됨.

  | 메서드                                                       | 설명                                                         |
  | ------------------------------------------------------------ | ------------------------------------------------------------ |
  | void add(int index, Object element)<br />boolean addAll(int index, Collection c) | 지정된 위치(index)에 객체(element) 또는 컬렉션에 포함된 객체들을 추가한다. |
  | Object get(int index)                                        | 지정된 위치(index)에 있는 객체를 반환한다.                   |
  | int indexOf(Object o)                                        | 지정된 객체의 위치(index)를 반환한다.<br />(List의 첫 번째 요소부터 순방향으로 찾는다.) |
  | int lastIndexOf(Object o)                                    | 지정된 객체의 위치(index)를 반환한다.<br />(List의 마지막 요소부터 역방향으로 찾는다.) |
  | ListIterator listIterator()<br />ListIterator listIterator(int index) | List의 객체에 접근할 수 있는 ListIterator를 반환한다.        |
  | Object remove(int index)                                     | 지정된 위치(index)에 있는 객체를 삭제하고 삭제된 객체를 반환한다. |
  | Object set(int index, Object element)                        | 지정된 위치(index)에 있는 객체(element)를 저장한다.          |
  | void sort(Comparator c)                                      | 지정된 비교자(comparator)로 List를 정렬한다.                 |
  | List subList(int fromIndex, int toIndex)                     | 지정된 범위(fromIndex부터 toIndex)에 있는 객체를 반환한다.   |

  

## 05. Set인터페이스

* 중복을 허용하지 않고 저장순서가 유지되지 않는 컬렉션 클래스를 구현하는 데 사용됨.

  ![스크린샷 2020-10-04 오후 1 49 59](https://user-images.githubusercontent.com/69128652/95007247-7f6a0a80-0648-11eb-93f2-fdfbc586913d.png)

  🔼 Set의 상속계층도



* Set의 인터페이스에 정의 된 메서드: 모두 Collection인터페이스로부터 상속받은 것들.

  | 메서드                                                       | 설명                                                         |
  | ------------------------------------------------------------ | ------------------------------------------------------------ |
  | boolean add(Object o)<br />boolean addAll(Collection c)      | 지정된 객체(o) 또는 Collection(c) 의 객체들을 Collection에 추가한다. |
  | void clear()                                                 | Collection의 모든 객체를 삭제한다.                           |
  | boolean contains(Object o)<br />boolean containsAll(Collection c) | 지정된 객체(o) 또는 Collection의 객체들이 Collection에 포함되어 있는지 확인한다. |
  | boolean equals(Object o)                                     | 동일한 Collection인지 비교한다.                              |
  | int hashCode()                                               | Collection의 hash code를 반환한다.                           |
  | boolean isEmpty()                                            | Collection이 비어있는지 확인한다.                            |
  | Iterator iterator()                                          | Collection의 Iterator를 얻어서 반환한다.<br />** Iterator인터페이스는 컬렉션에 포함된 객체들에 접근할 수 있는 방법을 제공.* |
  | boolean remove(Object o)                                     | 지정된 객체를 삭제한다.                                      |
  | boolean removeAll(Collection c)                              | 지정된 Collection에 포함된 객체들을 삭제한다.                |
  | boolean retainAll(Collection c)                              | 지정된 Collection에 포함된 객체만을 남기고 다른 객체들은 Collection 에서 삭제한다. <br />이 작업으로 인해 Collection에 변화가 있으면 true를, 그렇지 않으면 falese를 반환한다. |
  | int size()                                                   | Collection에 저장된 객체의 개수를 반환한다.                  |
  | Object[] toArray()                                           | Collection에 저장된 객체를 객체배열(Object[])로 반환한다.    |
  | Object[] toArray(Object[] a)                                 | 지정된 배열에 Collection의 객체를 저장해서 반환한다.         |



## 06. Map인터페이스

* 키(key)와 값(value)을 하나의 쌍으로 묶어서 저장하는 컬렉션 클래스를 구현하는 데 사용됨.

* 키는 중복될 수 없지만 값은 중복을 허용하고 있음.

  기존에 저장된 데이터와 중복된 키와 값을 저장하면, 기존의 값은 없어지고 마지막에 저장된 값이 남게 됨.
  ![스크린샷 2020-10-04 오후 2 09 49](https://user-images.githubusercontent.com/69128652/95007459-45e6ce80-064b-11eb-883f-4f33a8f3fdf4.png)

  🔼 Map의 상속계층도

* Map인터페이스에 정의된 메서드:

  | 메서드                               | 설명                                                         |
  | ------------------------------------ | ------------------------------------------------------------ |
  | void clear()                         | Map의 모든 객체를 삭제한다.                                  |
  | boolean containsKey(Object key)      | 지정된 key객체와 일치하는 Map의 key객체가 있는지 확인한다.   |
  | boolean containsValue(Object value)  | 지정된 value객체와 일치하는 Map의 value객체가 있는지 확인한다. |
  | Set entrySet()                       | Map에 저장되어 있는 key-value쌍을 Map.Entry타입의 객체로 저장한 Set으로 반환한다. |
  | boolean equals(Object o)             | 동일한 Map인지 비교한다.                                     |
  | Object get(Object key)               | 지정한 key객체에 대응하는 value객체를 찾아서 반환한다.       |
  | int hashCode()                       | 해시코드를 반환한다.                                         |
  | boolean isEmpty()                    | Map이 비어있는지 확인한다.                                   |
  | Set keySet()                         | Map에 저장된 모든 key객체를 반환한다.                        |
  | Object put(Object key, Object value) | Map에 value객체를 key객체에 연결(mapping)하여 저장한다.      |
  | void putAll(Map t)                   | 지정된 Map의 모든 key-value쌍을 추가한다.                    |
  | Object remove(Object key)            | 지정한 key객체와 일치하는 key-value객체를 삭제한다.          |
  | int size()                           | Map에 저장된 key-value쌍의 개수를 반환한다.                  |
  | Collection values()                  | Map에 저장된 모든 value객체를 반환한다.                      |

  * values() 에서는 반환타입이 Collection(value는 중복을 허용하기 때문에 Collection타입)이고,
    keySet() 에서는 반환타입이 Set(key는 중복을 허용하지 않기 때문에 Set타입)이다.



## 07. ArrayList

* 컬렉션 프레임웍에서 가장 많이 사용되는 컬렉션 클래스.
* List인터페이스를 구현하기 때문에, 데이터의 저장순서가 유지되고 중복을 허용한다는 특징을 가짐.
* 기존의 Vector를 개선한 것으로, Vector와 구현원리와 기능적인 측면에서 동일하다고 할 수 있음.
  Vector는 기존에 작성된 소스와의 호환성을 위해 남겨두고있는 것이므로, Vector보다 ArrayList를 사용하는 것이 좋음.



* ArrayList는 Object배열을 이용해서 데이터를 순차적으로 저장한다.
  배열에 더 이상 저장할 공간이 없으면, 보다 큰 새로운 배열을 생성해, 기존의 배열에 저장된 내용을 새로운 배열로 복사한 뒤 저장됨.

  ```java
  public class ArrayList extends AbstractList
    implements List, RandomAccess, Cloneable, java.io.Serializable {
    ...
      transient Object[] elementData; // Object 배열
    ...
  }
  ```

  * ArrayList소스코드 일부.
    ArrayList는 elementData라는 이름의 Object배열을 멤버변수로 선언한 것을 알 수 있음.
    선언된 배열의 타입이 모든 객체의 최고조상인 Object이기 때문에 모든 종류의 객체를 담을 수 있다.



* **ArrayList의 메서드**

  | 메서드                                   | 설명                                                         |
  | ---------------------------------------- | ------------------------------------------------------------ |
  | ArrayList()                              | 크기가 0인 ArrayList를 생성                                  |
  | ArrayList(Collection c)                  | 주어진 컬렉션이 저장된 ArrayList를 생성                      |
  | ArrayList(int initialCapacity)           | 지정된 초기용량을 갖는 ArrayList를 생성                      |
  | boolean add(Object o)                    | ArrayList의 마지막에 객체를 추가. 성공하면 true              |
  | void add(int index, Object element)      | 지정된 위치(index)에 객체를 저장                             |
  | boolean addAll(Collection c)             | 주어진 컬렉션의 모든 객체를 저장한다.                        |
  | boolean addAll(int index, Collection c)  | 지정된 위치부터 주어진 컬렉션의 모든 객체를 저장한다.        |
  | void clear()                             | ArrayList를 완전히 비운다.                                   |
  | Objcet clone()                           | ArrayList를 복제한다.                                        |
  | boolean contains(Object o)               | 지정된 객체(o)가 ArrayList에 포함되어 있는지 확인            |
  | void ensureCapacity(int minCaspacity)    | ArrayList의 용량이 최소한 minCaspacity가 되도록 한다.        |
  | Object get(int index)                    | 지정된 위치(index)에 저장된 객체를 반환한다.                 |
  | int indexOf(Object o)                    | 지정된 객체가 저장된 위치를 찾아 반환한다.                   |
  | boolean isEmpty()                        | ArrayList가 비어있는지 확인한다.                             |
  | Iterator iterator()                      | ArrayList의 Iterator객체를 반환                              |
  | int lastIndexOf(Object o)                | 객체(o)가 저장된 위치를 끝부터 역방향으로 검색해서 반환      |
  | ListIterator listIterator()              | ArrayList의 ListIterator를 반환                              |
  | ListIterator listIterator(int index)     | ArrayList의 지정된 위치부터 시작하는 ListIterator를 반환     |
  | Objcet remove(int index)                 | 지정된 위치 (index)에 있는 객체를 제거한다.                  |
  | boolean remove(Object o)                 | 지정한 객체를 제거한다.(성공하면 true, 실패하면 false)       |
  | boolean removeAll(Collcetion c)          | 지정한 컬렉션에 저장된 것과 동일한 객체들을 ArrayList에서 제거한다. |
  | boolean retainAll(Collcetion c)          | ArrayList에 저장된 객체 중에서 주어진 컬렉션과 공통된 것들만을 남기고 나머지는 삭제한다. |
  | Object set(int index, Object element)    | 주어진 객체(element)를 지정된 위치(index)에 저장한다.        |
  | int size()                               | ArrayList에 저장된 객체의 개수를 반환한다.                   |
  | void sort(Comparator c)                  | 지정된 정렬기준(c)으로 ArrayList를 정렬                      |
  | List subList(int fromIndex, int toIndex) | fromIndex부터 toIndex사이에 저장된 객체를 반환한다.          |
  | Object[] toArray()                       | ArrayList에 저장된 모든 객체들을 객체배열로 반환한다.        |
  | Object[] toArray(Object[] a)             | ArrayList에 저장된 모든 객체들을 객체배열 a에 담아 반환한다. |
  | void trimToSize()                        | 용량을 크기에 맞게 줄인다.(빈 공간을 없앤다.)                |



* 예제: ArrayList의 기본적인 메서드를 이용해서 객체를 다루는 방법.

  ```java
  import java.util.*;
  
  public class Ex11_1 {
  	public static void main(String[] args) {
  		ArrayList list1 = new ArrayList(10);
  		list1.add(new Integer(5));
  		list1.add(new Integer(4));
  		list1.add(new Integer(2));
  		list1.add(new Integer(0));
  		list1.add(new Integer(1));
  		list1.add(new Integer(3));
  		
  		ArrayList list2 = new ArrayList(list1.subList(1, 4));
  		print(list1, list2);
  		
  		Collections.sort(list1); // list1과 list2를 정렬한다.
  		Collections.sort(list2); // Collections.sort(List 1)
  		print(list1, list2);
  		
  		System.out.println("list1.containsAll(list2):" + list1.containsAll(list2));
  		
  		list2.add("B");
  		list2.add("C");
  		list2.add(3, "A"); //인덱스가 3인 곳에 "A"를 추가
  		print(list1,list2);
  		
  		list2.set(3, "AA"); //인덱스가 3인 곳을 "AA"로 변경
  		print(list1,list2);
  		
  		// list1에서 list2와 겹치는 부분만 남기고 나머지는 삭제한다.
  		System.out.println("list1.retainAll(list2):"+ list1.retainAll(list2));
  		
  		print(list1, list2);
  		
  		// list2에서 list1에 포함된 객체들을 삭제한다.
  		for(int i = list2.size()-1; i>=0; i--) {
  			if(list1.contains(list2.get(i)))
  				list2.remove(i); // 인덱스가 i인 곳에 저장된 요소를 삭제 
  		}
  		print(list1,list2);
  	} //main의 끝
  	
  	static void print(ArrayList list1, ArrayList list2) {
  		System.out.println("list1:" + list1);
  		System.out.println("list2:" + list2);
  		System.out.println();
  	}
  }
  
  ```

  > 위 코드의 결과: 
  >
  > list1:[5, 4, 2, 0, 1, 3]
  >
  > list2:[4, 2, 0]
  >
  > 
  >
  > list1:[0, 1, 2, 3, 4, 5] < Collections.sort(List 1)를 이용하여 정렬.
  >
  > list2:[0, 2, 4]
  >
  > 
  >
  > list1.containsAll(list2):true < list1이 list2의 모든 요소를 포함하고 있을 때만 true
  >
  > list1:[0, 1, 2, 3, 4, 5]
  >
  > list2:[0, 2, 4, A, B, C] < add(Object obj)를 이용해서 새로운 객체를 저장하였다.
  >
  > 
  >
  > list1:[0, 1, 2, 3, 4, 5]
  >
  > list2:[0, 2, 4, AA, B, C] < set(int index, Object obj)를 이용해서 다른 객체로 변경.
  >
  > 
  >
  > list1.retainAll(list2):true < retainAll에 의해 list1에 변화가 있었으므로 true를 반환
  >
  > list1:[0, 2, 4] < list2와의 공통요소 이외에는 모두 삭제되었다.(변화가 있었다.)
  >
  > list2:[0, 2, 4, AA, B, C]
  >
  > 
  >
  > list1:[0, 2, 4]
  >
  > list2:[AA, B, C]

  * ArrayList는 List의 인터페이스를 구현했기 때문에 저장된 순서를 유지한다.
  * Collection은 인터페이스고, Collections는 클래스임에 주의.
    Collecrtion의 sort메서드로 ArrayList의 객체들을 정리할 수 있음을 알아둘 것.



* **ArrayList의 추가와 삭제**
  - ArrayList의 요소를 삭제하는 경우, 삭제할 객체의 바로 아래에있는 데이터를 한 칸씩 위로 복사해서 삭제할 객체를 덮어쓰는 방식으로 처리.
  - 만일 삭제할 객체가 마지막 데이터라면, null로 변경해주기만 하면 됨.
    ![스크린샷 2020-10-04 오후 4 07 33](https://user-images.githubusercontent.com/69128652/95009283-b8f84100-065b-11eb-95c7-be3c3082c432.png)
    1. 삭제할 데이터의 아래에 있는 데이터를 한 칸씩 위로 복사해서 삭제할 데이터를 덮어쓴다.
    2. 데이터가 모두 한 칸씩 위로 이동하였으므로 마지막 데이터는 null로 변경해야한다.
    3. 데이터가 삭제되어 데이터의 개수(size)가 줄었으므로 size의 값을 1감소시킨다.
  - 배열에 객체를 순차적으로 저장했을 때, **객체를 마지막에 저장한 것 부터 삭제하면 과정이 줄어 작업시간이 짧지만**,
    **배열의 중간에 위치한 객체를 추가하거나 삭제하는 경우**, 다른 데이터의 위치를 옮겨야하는 과정이 있어 **데이터의 개수가 많을 수록 작업시간이 증가**한다.
  - ArrayList에 새로운 요소를 추가할 때도 먼저 추가할 위치 이후의 요소들을 모두 한칸씩 이동 시킨 후 저장해야함.



## 08. LinkedList

> 배열의 장점:
>
> 1. 기본적인 형태의 자료구조로, 구조가 간단함.
> 2. 사용하기 쉬움.
> 3. 데이터를 읽어오는데 걸리는 시간(접근시간,access time)이 가장 빠름.

> 배열의 단점:
>
> 1. 크기를 변경할 수 없다.
>    - 크기를 변경할 수 없으므로 새로운 배열을 생성해서 데이터를 복사해야한다.
>    - 실행속도를 향상시키기 위해서는 충분히 큰 크기의 배열을 생성해야 하므로 메모리가 낭비.
> 2. 비순차적인 데이터의 추가 또는 삭제에 시간이 많이 걸림.
>    * 차례대로 데이터를 추가하고 마지막에서부터 데이터를 삭제하는 것은 빠름.
>    * 하지만 배열의 중간에 데이터를 추가하려면 빈자리를 만들기 위해 다른 데이터를 복사해서 이동해야함.



이러한 배열의 단점 때문에 보완하기 위해 **링크드 리스트(linked list) 라는 자료구조가 고안**되었다.



* 링크드 리스트는 불연속적으로 존재하는 데이터를 서로 연결(link)한 형태로 구성.
  ![스크린샷 2020-10-04 오후 4 25 05](https://user-images.githubusercontent.com/69128652/95009590-2c02b700-065e-11eb-830b-919a8fbe982b.png)

  * 링크드 리스트의 각 요소(node)들은 자신과 연결된 다음요소에 대한 참조(주소값)와 데이터로 구성.

  ```java
  class Node {
    Node next;	// 다음 요소의 주소를 저장
    Object obj; // 데이터를 저장
  }
  ```

  

#### Linked List의 추가와 삭제

* 링크드 리스트를 삭제하려면, 삭제하고자 하는 요소의 이전요소가 삭제하고자 하는 요소의 다음요소를 참조하도록 변경하면 됨.
  단 하나의 참조만 변경하면 되므로, 처리속도가 매우 빠르다.
  ![스크린샷 2020-10-04 오후 4 30 55](https://user-images.githubusercontent.com/69128652/95009687-fc07e380-065e-11eb-9919-5b8387f10966.png)

* 새로운 데이터를 추가하려면, 아래의 과정을 따라하면 된다.

  1. 새로운 요소를 생성 
  2. 추가하고자 하는 위치의 이전 요소의 참조를 새로운 요소에 대한 참조로 변경
  3. 새로운 요소가 그 다음의 요소를 참조하도록 변경

  ![스크린샷 2020-10-04 오후 4 35 42](https://user-images.githubusercontent.com/69128652/95009795-a6800680-065f-11eb-98fd-931e9b40538d.png)



#### ArrayList와 LinkedList의 비교

* 배열의 경우, 만일 인덱스가 n인 원소의 값을 얻어오고자 한다면 단순히 아래와 같은 수식을 계산함으로서 해결.

  > 인덱스가 n인 데이터의 주소 = 배열의 주소 + n * 데이터 타입의 크기

* 배열은 각 요소들이 연속적으로 메모리상에 존재하기 때문에 이처럼 간단한 계산만으로 원하는 요소의 주소를 얻어서 저장 된 데이터를 곧바로 읽어올 수 있음.
  LinkedList는 불연속적으로 위치한 각 요소들이 서로 연결된 것이라 처음부터 n번째 데이터 까지 차례대로 따라가야만 원하는 값을 얻을 수 있음.

* 비교 표:

  | 컬렉션     | 읽기(접근시간) | 추가 / 삭제 | 비고                                                     |
  | ---------- | -------------- | ----------- | -------------------------------------------------------- |
  | ArrayList  | 빠르다         | 느리다      | 순차적인 추가삭제는 더 빠름.<br />비효율적인 메모리 사용 |
  | LinkedList | 느리다         | 빠르다      | 데이터가 많을수록 접근성이 떨어짐.                       |



## 09. Stack과 Queue

* 스택(Stack): 

  * 마지막에 저장한 데이터를 가장 먼저 꺼내게 되는 LIFO(Last In First Out) 구조.

  * 동전통과 같은 구조로, 양 옆과 바닥이 막혀있어 한 방향으로만 뺄 수 있는 구조.

  * ArrayList와 같은 배열기반의 컬렉션 클래스가 적합.

    ![스크린샷 2020-10-04 오후 6 21 03](https://user-images.githubusercontent.com/69128652/95011808-5eb4ab80-066e-11eb-840f-98928d52ed4b.png)

  * 스택의 메서드:

    | 메서드                   | 설명                                                         |
    | ------------------------ | ------------------------------------------------------------ |
    | boolean empty()          | Stack이 비어있는지 알려준다.                                 |
    | Object peek()            | Stack의 맨 위에 저장된 객체를 반환. pop()과 달리 Stack에서 객체를 꺼내지는 않음.<br />(비었을 때는 EmptyStackException 발생) |
    | Object pop()             | Stack의 맨 위에 저장된 객체를 꺼낸다. (비었을 때는 EmptyStackException 발생) |
    | Object push(Object item) | Stack에 객체(item)를 저장한다.                               |
    | int search(Object o)     | Stack에 주어진 객체(o)를 찾아서 그 위치를 반환. 못찾으면 -1을 반환.<br />(배열과 달리 위치는 0이 아닌 1부터 시작.) |

    

* 큐(Queue):

  * 처음에 저장한 데이터를 가장 먼저 꺼내게 되는 FIFO(Final In First Out)구조.
  * 양 옆만 막혀있고 위 아래로 뚫려있어, 한 방향으로는 넣고 한 방향으로는 빼는 파이프와 같은 구조.
  * 데이터를 꺼낼 때, 항상 첫번째 저장된 데이터를 삭제하므로, LinkedList로 구현하는 것이 적합.

  ![스크린샷 2020-10-04 오후 6 21 36](https://user-images.githubusercontent.com/69128652/95011818-71c77b80-066e-11eb-8896-d6610647ab51.png)

  * 스택의 메서드:

    | 메서드                  | 설명                                                         |
    | ----------------------- | ------------------------------------------------------------ |
    | boolean add (Object o)  | 지정된 객체를 Queue에 추가한다. 성공하면 true를 반환. <br />저장공간이 부족하면 IllegalStateException 발생. |
    | Object remove()         | Queue에서 객체를 꺼내 반환. 비어있으면 NoSuchElementException발생 |
    | Object element()        | 삭제없이 요소를 읽어온다. peek와 달리 Queue가 비었을 때 NoSucjElementException 발생 |
    | boolean offer(Object o) | Queue에 객체를 저장. 성공하면 true, 실패하면 false를 반환    |
    | Object poll()           | Queue에서 객체를 꺼내서 반환.비어있으면 null을 반환.         |
    | Object peek()           | 삭제없이 요소를 읽어 온다. Queue가 비어있으면 null을 반환.   |

    

* 예제:

  ```java
  import java.util.*;
  
  public class Ex11_2 {
  	public static void main(String[] args) {
  		Stack st = new Stack();
  		Queue q = new LinkedList(); // Queue인터페이스의 구현체인 LinkedList를 사용
  		
  		st.push("0");
  		st.push("1");
  		st.push("2");
  		
  		q.offer("0");
  		q.offer("1");
  		q.offer("2");
  		
  		System.out.println("= Stack =");
  		while(!st.empty()) {
  			System.out.println(st.pop()); // 스택에서 요소 하나를 꺼내서 출력.
  		}
  		
  		System.out.println("= Queue =");
  		while(!q.isEmpty()) {
  			System.out.println(q.poll()); // 큐에서 요소 하나를 꺼내서 출력.
  		}
  	}
  }
  ```

  > 위 코드의 결과:
  >
  > = Stack =
  >
  > 2
  >
  > 1
  >
  > 0
  >
  > = Queue =
  >
  > 0
  >
  > 1
  >
  > 2



* 자바에서 스택을 Stack클래스로 구현하여 제공하고 있지만,
  큐는 Queue인터페이스로만 정의해 놓았을 뿐 별도의 클래스를 제공하고 있지 않음.
  대신 Queue인터페이스를 구현한 클래스들이 있어서 이 들 중의 하나를 선택해서 사용 하면 됨.
  ![스크린샷 2020-10-04 오후 6 41 23](https://user-images.githubusercontent.com/69128652/95012177-367a7c00-0671-11eb-9359-277308aee580.png)
  
  * 이 중, 'All Known Implementing Classes' 에 적혀있는 클래스 중 적당한 것을 골라,
    'Queue q = new LinkedList();'와 같은 식으로 객체를 생성해 사용하면 됨.
    
    >  'All Known Implementing Classes' :
    >
    > Queue인터페이스를 구현한 클래스들



### Stack과 Queue의 활용

* 스택과 큐의 활용 예:
  * 스택 - 수식 계산, 수식괄호검사, 워드프로세서의 undo/ redo, 웹브라우저의 뒤로/앞으로 가기 버튼
  * 큐    - 최근 사용문서, 인쇄작업 대기목록, 버퍼(buffer)



* 예제1: 입력한 수식의 괄호가 올바른지를 체크하는 예제.
  

  ```java
  import java.util.*;
  
  public class Ex11_3 {
  	public static void main(String[] args) {
  		if (args.length != 1) {
  			System.out.println("Usage:java Ex11_3 \"EXPRESSION\"");
  			System.out.println("Example:java Ex11_3 \"((2+3)*1)+3\"");
  			System.exit(0);
  		}
  		
  		Stack st = new Stack();
  		String expression = args[0];
  		
  		System.out.println("expression:" + expression);
  		
  		try {
  			for (int i = 0; i < expression.length(); i++) {
  				char ch = expression.charAt(i);
  				
  				if(ch=='(') {
  					st.push(ch + "");
  				} else if (ch ==')') {
  					st.pop();
  				}
  			}
  			
  			if (st.isEmpty()) {
  				System.out.println("괄호가 일치합니다.");
  			} else {
  				System.out.println("괄호가 일치하지 않습니다.");
  			}
  		} catch (EmptyStackException e) {
  			System.out.println("괄호가 일치하지 않습니다.");
  		} //try
  	}
  }
  ```

  > 위 코드의 결과:
  >
  > Usage:java Ex11_3 "EXPRESSION"
  >
  > Example:java Ex11_3 "((2+3)*1)+3"

  * '('를 만나면 스택에 넣고, ')'를 만나면 스택에서 '('를 꺼낸다.
    ')'를 만나서 '('를 꺼내려 할 때 스택이 비어있거나 수식을 검사한 뒤에도 스택이 비워져있지 않으면 괄호가 잘못 된 것.



* 예제2: 유닉스의 history명령어를 Queue를 이용해서 구현.

  ```java
  import java.util.*;
  
  public class Ex11_4 {
  	static Queue q = new LinkedList();
  	static final int MAX_SIZE = 5; // Queue에 최대 5개까지만 저장되도록 한다.
  	
  	public static void main(String[] args) {
  		System.out.println("help를 입력하면 도움말을 볼 수 있습니다.");
  		
  		while(true) {
  			System.out.println(">>");
  			try {
  				//화면으로부터 라인단위로 입력받는다.
  				Scanner s = new Scanner(System.in);
  				String input = s.nextLine().trim();
  				
  				if("".equals(input)) continue;
  				
  				if(input.equalsIgnoreCase("q")) {
  					System.exit(0);
  				} else if(input.equalsIgnoreCase("help")) {
  					System.out.println(" help - 도움말을 보여줍니다.");
  					System.out.println(" q또는 Q - 프로그램을 종료합니다.");
  					System.out.println(" history - 최근에 입력한 명령어를" + MAX_SIZE + "개 보여줍니다.");
  				} else if(input.equalsIgnoreCase("history")) {
  					int i = 0;
  					// 입력받은 명령어를 저장하고,
  					save(input);
  					
  					// LinkedList의 내용을 보여준다.
  					LinkedList tmp = (LinkedList)q;
  					ListIterator it = tmp.listIterator();
  					
  					while(it.hasNext())
  						System.out.println(++i+"."+it.next());
  				} else {
  					save(input);
  					System.out.println(input);
  				} // if(input.equalsIgnoreCase("q") {
  			} catch (Exception e) {
  				System.out.println("입력 오류입니다.");
  			}
  		} // while (true)
  	} // main()
  	
  	public static void save(String input) {
  		//queue에 저장한다.
  		if(!"".equals(input))
  			q.offer(input);
  		
  		//queue의 최대크기를 넘으면 제일 처음 입력된 것을 삭제한다.
  		if(q.size() > MAX_SIZE) // size()는 Collection인터페이스에 정의
  			q.remove();
  	}
  } // end of class
  ```

  > 위 코드의 결과:help를 입력하면 도움말을 볼 수 있습니다.
  >
  > \>>
  >
  >  dir
  >
  > dir
  >
  > \>>
  >
  > cd
  >
  > cd
  >
  > \>>
  >
  > gd
  >
  > gd
  >
  > \>>
  >
  > gg
  >
  > gg
  >
  > \>>
  >
  > history
  >
  > 1.dir
  >
  > 2.cd
  >
  > 3.gd
  >
  > 4.gg
  >
  > 5.history
  >
  > \>>
  >
  > q

  * MAX_SIZE의 값을 변경함으로써 더 많은 명령어 입력 기록을 남길 수 있다.

## 10. Iterator, ListIterator, Enumeration

| 종류             | 설명                                                         |
| ---------------- | ------------------------------------------------------------ |
| **Iterator**     | 컬렉션에 저장된 요소를 접근하는 데 사용되는 인터페이스.      |
| **ListIterator** | Iterator에 양방향 조회기능 추가(List를 구현한 경우만 사용 가능) |
| **Enumeration**  | Iterator의 구버전                                            |

* 컬렉션 프레임 웍에서 컬렉션에 저장된 요소들을 읽어오는 방법을 표준화 한것.

  * 컬렉션에 저장된 요소에 접근하는 기능을 가진 Iterator 인터페이스를 정의

    ```java
    public interface Iterator {
      boolean hasNext();
      Object next();
      void remove();
    }
    ```

  * Colletion 인터페이스에 **Iterator를 구현한 클래스의 인터페이스** 를 반환하는 **iterator()**를 정의함.

    ```java
    public interface Collection {
     	 	...
      puvlic Iterator iterator();
      	...
    }
    ```

    * iterator()는 Collection인터페이스에 정의된 메서드이므로, Collection 인터페이스의 자손인 List와 Set에도 포함되어있다.

    * 이 때, List나 Set 인터페이스를 구현하는 컬렉션은 각 컬렉션의 특징에 맞게 iterator()가 작성되어있음.

    * 아래의 예제와 같이 요소를 읽어올 때 주로 사용.(while문을 주로 사용한다.)

      ```java
      List list = new ArrayList(); // 다른 컬렉션으로 변경할 땐, 이 부분만 고치면 됨.
      Iterator it = list.iterator();
      
      while(it.hasNext()) { // boolean hasNext() 읽어올 요소가 있는지 확인
        System.out.println(it.next()); // Object next() 다음 요소를 읽어옴
      }
      ```

* 위의 예제들 처럼 컬렉션의 요소를 읽어오는 방식을 표준화 했기 때문에, 코드의 재사용성을 높일 수 있게 되었다.

* 이처럼 공통 인터페이스를 정의해서 표준을 정의하고, 이를 구현하여 표준을 따르도록 함으로써 일관성을 유지하여 재사용성을 극대화 하는 것이 객체지향 프로그래밍의 중요한 목적 중의 하나이다.



* 예제:

  ```java
  import java.util.*;
  
  public class Ex11_5 {
      public static void main(String[] args) {
          ArrayList list = new ArrayList();
          list.add("1");
          list.add("2");
          list.add("3");
          list.add("4");
          list.add("5");
  
          Iterator it = list.iterator();
  
          while (it.hasNext()) {
              Object obj = it.next();
              System.out.println(obj);
          }
      } // main
  }
  ```

  * List 클래스들은 **저장순서를 유지**하기 때문에, Iterator를 이용해서 읽어 온 결과도 **저장 된 순서와 동일**하지만,
    Set 클래스들은 각 요소간의 **순서가 유지되지 않기** 때문에 Iterator를 이용해서 저장된 요소들을 읽어와도 처음에 **저장된 순서와 같지 않다.**

  * List 클래스들은 Iterator 대신 for문과 get()으로도 모든 요소를 출력할 수 있다.

    ```java
    Iterator it = list.iterator();
    
    while(it.hasNext()){
      Object obj = it.next();
      System.out.println(obj);
    }
    ```

    ↕

    ```java
    for(int i = 0; i < list.size(); i++){
      Object obj = list.get(i);
      System.out.println(obj);
    }
    ```



## 11. Map과 Iterator

* Map인터페이스를 구현한 컬렉션 클래스는 키(key)와 값(value)을 쌍(pair)으로 저장하고 있기 때문에 iterator()를 직접 호출 할 수 없다.

* 때문에, keySet() 이나 entrySet()과 같은 메서드를 통해, 키와 값을 따로 Set의 형태로 얻어 온 후, 다시 iterator()를 호출해야 Iterator를 얻을 수 있다.

  ```java
  Map map = new HashMap();
  		...
  Iterator it = map.entrySet().iterator();
  ```

  * `Iterator it = map.entrySet().iterator();` 란?

    아래의 두 문장을 합친 것.

    ```java
    Set eSet = map.entrySet();
    Iterator it = eSet.iterator();
    ```

  * `Iterator it = map.entrySet().iterator();` 의 실행순서

    1. `map.entrySet()`

       * `map.entrySet()`의 실행 결과가 Set이므로
         `Iterator it = map.entrySet().iterator();` 

         ▶️ `Iterator it = Set인스턴스.iterator();` 

    2. `map.entrySet().iterator();`

    3. `map.entrySet().iterator();` 

       * `map.entrySet()`를 통해 얻은 Set인스턴스의 iterator()를 호출해서 Iterator 인스턴스를 얻는다.
         `Iterator it = Set인스턴스.iterator();`
         ▶️`Iterator it = Iterator인스턴스;`

    4. 마지막으로 Iterator 인스턴스의 참조가 it에 저장된다.



## 12. Arrays의 메서드

### 1. Arrays의 메서드(1) - 복사

* **배열의 복사 - `copyOf()`, `copyOfRange()`**

  * `copyOf()`
    * 배열 전체를 복사.
  * `copyOfRange()`
    * 배열의 일부를 복사해서 새로운 배열을 만들어 반환.
    * 단, 지정된 범위의 끝은 포함되지않는다.

  ```java
  int[] arr = {0,1,2,3,4};
  int[] arr2 = Arrays.copyOf(arr, arr.length); // arr2 = [0,1,2,3,4]
  int[] arr3 = Arrays.copyOf(arr, 3);					 // arr3 = [0,1,2]
  int[] arr4 = Arrays.copyOf(arr, 7);					 // arr4 = [0,1,2,3,4,0,0]
  int[] arr5 = Arrays.copyOfRange(arr, 2, 4);	 // arr5 = [2,3] < 4는 불포함
  int[] arr6 = Arrays.copyOfRange(arr, 0, 7);	 // arr6 = [0,1,2,3,4,0,0]
  ```



### 2. Arrays의 메서드(2) - 채우기, 정렬, 검색

* **배열 채우기 - `fill()`, `setAll()`**

  *  `fill()`
    * 배열의 모든 요소를 지정된 값으로 채운다.
  * `setAll()`
    * 배열을 채우는데 사용할 함수형 인터페이스를 매개변수로 받는다.
    * 이 메서드를 호출할 때, 함수형 인터페이스를 구현한 개체를 매개변수로 지정하거나,
      람다식을 지정해야한다.

  ```java
  int[] arr = new int[5];
  Arrays.fill(arr, 9);																 // arr = [9,9,9,9,9]
  Arrays.setAll(arr, (i) -> (int)(Math.random()*5)+1); // arr = [1,5,2,1,1]
  ```

  > 람다식(lambda expression)?
  > 현재로서는 `(i) -> (int)(Math.random()*5)+1)` .  와 같은 형식이 **'람다식'**이라고 이해하면된다.
  > `(Math.random()*5)+1)`는 1~5의 범위에 속한 임의의 정수를 반환하는 일을 하며,
  > `setAll()`메서드는 이 람다식이 반환식의 정수로 배열을 채운다.

* **배열의 정렬과 검색 - `sort()`, `binarySearch()`**

  * `sort()`
    * 배열을 정렬 할 때 사용
  * `binarySearch()`
    * 배열에 저장된 요소를 검색할 때 사용
    * 배열에서 지정된 값이 저장된 위치(index)를 찾아서 반환하는데,
      반드시 배열이 정렬된 상태이어야 올바른 결과를 얻는다.
    * 만일 검색한 값과 일치하는 요소들이 여러 개 있다면, 어떤 것의 위치가 반환될 지 알 수 없다.

  ```java
  int[] arr = {3,2,0,1,4};
  int idx = Arrays.binarySearch(arr, 2); 		// idx = -5 <- 잘못된 결과
  
  Arrays.sort(arr);
  System.out.println(Arrays.toString(arr)); // [0,1,2,3,4]
  int idx = Arrays.binarySearch(arr, 2);		// idx = 2  <- 올바른 결과
  ```

  * 배열을 첫 번째 요소부터 순서대로 하나씩 검색하는 것을 `'순차검색(liner search)'` 이라고 한다.
    * 배열이 정렬 되어 있을 필요는 없지만 **배열의 요소를 하나씩 비교**하기 때문에 시간이 많이 소요됨.
  * 이에 반해, `'이진 검색(binary search)'`은?
    * **배열의 검색할 범위를 반복적으로 절반씩 줄여**나가며 검색하기 때문에, 검색속도가 상당히 빠르다.
    * 배열의 길이가 10배 늘어나도, 검색 횟수가 3~4회 정도밖에 늘어나지않으므로, **큰 배열의 검색에 유리**.
    * 단, 배열이 정렬이 되어있는 경우에만 사용가능.



### 3. Arrays의 메서드(3) - 비교와 출력

* **문자열의 비교와 출력 - `equals()`, `toString()`**

  * `toString()`

    * 배열의 모든 요소를 문자열로 편하게 출력할 수 있다.

    * `toString()`은 일차원 배열에만 사용할 수 있으므로, 다차원 배열에는 `deepToString()`을 사용해야한다.

      > `deepToString()`
      >
      > * 배열의 모든 요소를 재귀적으로 접근해서 문자열을 구성.
      > * 2차원 뿐만 아니라 3차원 이상의 배열에도 동작.

    ```java
    int[] arr = {0,1,2,3,4};
    int[][] arr2D = {{11,12},{21,22}};
    
    System.out.println(Arrays.toString(arr));			  // [0,1,2,3,4]
    System.ouy.println(Arrays.deepToString(arr2D)); // [[11,12],[21,22]]
    ```

  * `equals()`

    * 두 배열에 저장된 모든 요소를 비교하여, 같으면 true, 다르면 false를 반환.
    * `equals()` 역시 일차원 배열에만 사용 가능하므로, 다차원 배열에는 `deepEquals()`를 사용해야한다.

    ```java
    String[][] str2D = new String[][]{{"aaa","bbb"},{"AAA","BBB"}};
    String[][] str2D2 = new String[][]{{"aaa","bbb"},{"AAA","BBB"}};
    
    System.out.println(Arrays.equals(str2D. str2D2)); 		// false
    System.out.println(Arrays.deepEquals(str2D. str2D2)); // true
    ```

    * 1차원 String배열을 `equals()`로 비교하면 배열에 저장된 내용이 같아도 false를 반환하는데,
      다차원 배열은 '배열의 배열'의 형태로 구성하기 때문에 equals()로 비교하면, 문자열로 비교하는 것이 아닌,
      '배열에 저장된 배열의 주소'를 비교하게 된다. 서로 다른 배열은 주소가 다르기 때문에 false가 반환되는 것.

### 4. Arrays의 메서드(4) - 변환

* **배열을 List로 변환 - `asList(Object... a)`**

  * `asList(Object... a)`

    * 배열을 List에 담아서 반환.
    * 매개변수의 타입이 가변인수라서, 배열 생성없이 저장할 요소들만 나열하는 것도 가능.

    ```java
    List list = Arrays.asList(new Integer[]{1,2,3,4,5}); // list = [1,2,3,4,5]
    List list = Arrays.asList(1,2,3,4,5);								 // list = [1,2,3,4,5]
    list.add(6); // UnsupportedOperationExcption 예외 발생
    ```

    * 주의할 점은, asList()가 반환한 List의 크기를 변경할 수 없다는 것.
      즉, 추가 또는 삭제가 불가능 하다.

    * 크기를 변경할 수 있는 List가 필요한 경우, 아래와 같이 하면된다.

      ```java
      List list - new ArrayList(Arrays.asList(1,2,3,4,5));
      ```

* **`parallelXXX()`, `spliterator()`, `stram()`**

  * 이외에도 `'parallel'`로 시작하는 이름의 메서드들이 있는데, 
    이 메서드들은 보다 빠른 결과를 얻기 위해 여러 쓰레드가 작업을 나누어 처리하도록한다.
  * `spliterator()`
    * 여러 쓰레드가 처리할 수 있게 하나의 작업을 여러 작업으로 나누는 Spliterator를 반환.
  * `stram()`
    * 컬렉션을 스트림으로 변환한다.
  * **이 메서드들은 앞으로 배울 '14장 람다와 스트림'과 관련된 내용.**



### 5. 예제

```java
import java.util.*;

public class Ex11_6 {
    public static void main(String[] args) {
        int[] arr = {0,1,2,3,4};
        int[][] arr2D = {{11,12,13},{21,22,23}};

        System.out.println("arr="+Arrays.toString(arr));
        System.out.println("arr2D="+Arrays.deepToString(arr2D));

        int[] arr2 = Arrays.copyOf(arr,arr.length);
        int[] arr3 = Arrays.copyOf(arr,3);
        int[] arr4 = Arrays.copyOf(arr,7);
        int[] arr5 = Arrays.copyOfRange(arr,2,4);
        int[] arr6 = Arrays.copyOfRange(arr,0,7);

        System.out.println("arr2="+Arrays.toString(arr2));
        System.out.println("arr3="+Arrays.toString(arr3));
        System.out.println("arr4="+Arrays.toString(arr4));
        System.out.println("arr5="+Arrays.toString(arr5));
        System.out.println("arr6="+Arrays.toString(arr6));

        int[] arr7 = new int[5];
        Arrays.fill(arr7, 9); // arr = [9,9,9,9,9]
        System.out.println("arr7="+Arrays.toString(arr7));

        Arrays.setAll(arr7, i -> (int)(Math.random()*6)+1);
        System.out.println("arr7="+Arrays.toString(arr7));

        for(int i : arr7){
            char[] graph = new char[i];
            Arrays.fill(graph, '*');
            System.out.println(new String(graph)+i);
        }

        String[][] str2D = new String[][]{{"aaa","bbb"},{"AAA","BBB"}};
        String[][] str2D2 = new String[][]{{"aaa","bbb"},{"AAA","BBB"}};

        System.out.println(Arrays.equals(str2D,str2D2));
        System.out.println(Arrays.deepEquals(str2D, str2D2));

        char[] chArr = {'A','D','C','B','E'};

        System.out.println("chArr="+Arrays.toString(chArr));
        System.out.println("index of B ="+Arrays.binarySearch(chArr, 'B'));
        System.out.println("= After sorting =");
        Arrays.sort(chArr);
        System.out.println("chArr="+Arrays.toString(chArr));
        System.out.println("index of B ="+Arrays.binarySearch(chArr, 'B'));
    }
}

```

> 위 코드의 결과:
>
> ```java
> arr=[0, 1, 2, 3, 4]
> arr2D=[[11, 12, 13], [21, 22, 23]]
> arr2=[0, 1, 2, 3, 4]
> arr3=[0, 1, 2]
> arr4=[0, 1, 2, 3, 4, 0, 0]
> arr5=[2, 3]
> arr6=[0, 1, 2, 3, 4, 0, 0]
> arr7=[9, 9, 9, 9, 9]
> arr7=[6, 5, 3, 1, 6]
> ******6
> *****5
> ***3
> *1
> ******6
> false
> true
> chArr=[A, D, C, B, E]
> index of B =-2
> = After sorting =
> chArr=[A, B, C, D, E]
> index of B =1
> ```



## 13. Comparator와 Comparable

* Comparator와 Comparable

  * 인터페이스로 컬렉션을 정렬하는데 필요한 메서드를 정의.

  * `Comparable`을 구현하고 있는 클래스들은 같은 타입의 인스턴스끼리 서로 비교할 수 있는클래스들.

    * 주로 Integer와 같은 wrapper클래스

    * String, Date, File과 같은 클래스.

    * 기본적으로 오름차순(작은 값 > 큰값 순으로 정렬)으로 정렬되도록 구현되어있다.
      따라서 `Comparable`를 구현한 클래스는 정렬이 가능하다는 것을 의미.|

      > Java API 문서에서 `Comparable`을 찾아보면, 이를 구현한 클래스 목록을 볼 수있다.
      > `Comparable` : java.lang 패키지
      >
      > `Comparator` : java.util 패키지

  * 실제 소스:

    ```java
    public interface Comparator{
      int compare(Object o1, Object o2); // o1과 o2를 비교
      boolean equals(Object obj);
    }
    
    public interface Comparable{
      int comapareTo(Object o); // 객체 자신(this)과 o를 비교
    }
    ```

* `compare()` 와 `comapareTo()`는 선언 형태와 이름이 다를 뿐, 두 객체를 비교한다는 같은 기능을 목적으로 고안됨.

  *  `comapareTo()`,`compare()`: 
    객체를 비교하여 객체가 같으면 0, 비교하는 값보다 작으면 음수, 비교하는 값보다 크면 양수를 반환.

  | 종류       | 설명                                                    |
  | ---------- | ------------------------------------------------------- |
  | Comparator | 기본 정렬 기준 외에 다른 기준으로 정렬하고자 할 때 사용 |
  | Comparable | 기본 정렬 기준을 구현하는 데 사용                       |

> **Comparator를 구현하는 클래스는 오버라이딩이 필요할 수 있기 때문에 정의한 것이므로,**
> **compare(Object o1, Object o2)만 구현하면 됨.**



* 예제:

  ```java
  import java.util.*;
  
  public class Ex11_7 {
      public static void main(String[] args) {
          String[] strArr = {"cat", "Dog", "lion", "tiger"};
  
          Arrays.sort(strArr); // String의 Comparable구현에 의한 정렬
          System.out.println("strArr= " + Arrays.toString(strArr));
  
          Arrays.sort(strArr, String.CASE_INSENSITIVE_ORDER); // 대소문자 구분 안함
          System.out.println("strArr= " + Arrays.toString(strArr));
  
          Arrays.sort(strArr, new Descending()); // 역순 정렬
          System.out.println("strArr= " + Arrays.toString(strArr));
      }
  }
  
  class Descending implements Comparator {
      public int compare(Object o1,Object o2){
          if(o1 instanceof Comparable && o2 instanceof Comparable){
              Comparable c1 = (Comparable)o1;
              Comparable c2 = (Comparable)o2;
              return c1.compareTo(c2) * -1; // -1을 곱해서 기본 정렬방식의 역으로 변경한다.
                                            // 또는 c2.compareTo(c1)와 같이 순서를 바꿔도 된다.
          }
          return -1;
      }
  }
  ```

  > 위 식의 결과:
  > strArr= [Dog, cat, lion, tiger]
  > strArr= [cat, Dog, lion, tiger]
  > strArr= [tiger, lion, cat, Dog]

  * `Arrays.sort()`는 배열을 정렬할 때, Comparator를 지정해주지 않으면 
    저장하는 객체(Comparable을 구현한 클래스의 객체)에 구현된 내용에 따라 정렬된다.

    ```java
    static void sort(Object[] a) //객체 배열에 저장된 객체가 구현한 Comparable에 의한 정렬
    static void sort(Object[] a, Comparator c) //지정한 Comparator에 의한 정렬
    ```

  * String의 Comparable 구현:

    * 문자열이 사전 순으로 정렬되도록 작성되어있음.

    * 문자열의 오름차순: 공백, 숫자, 대문자, 소문자 순으로 정렬되는 것.

    * 더 자세히 설명하자면, 문자의 유니코드 순서가 작은값에서부터 큰 값으로 정렬되는 것.

    * 아래와 같이 대소문자를 구분하지 않고 비교하는 Comparator를 상수의 형태로 제공한다.

      ```java
      public static final Comparator CASE_INSENSITIVE_ORDER
      ```

      이 Comparator를 이용하면, 문자열을 대소문자 구분없이 정렬할 수 있다.

      ```java
      Arrays.sort(strArr, String.CASE_INSENSTIVE_ORDER);
      ```

      

## 14. Integer와 Comparable

* 아래의 코드는 Integer클래스의 일부인데, Comparable의 compareTo(Object o)를 구현해 놓은 것을 볼 수 있다.

  ```java
  public final class Integer extends Number implements Comparable {
    ...
    public int compareTo(Object o){
      return compareTo((Integer)o);
    }
    public int compareTo(Integer anotherInteger){
      int thisVal = this.value;
      int anotherVal = anotherInteger.value;
      
      // 비교하는 값이 크면 -1, 같으면 0, 작으면 1을 반환한다.
      return (thisVal<anotherVal ? -1 : (thisVal == anotherVal ? 0 : 1));
    }
  }
  ```

  * Integer클래스의 compareTo() :
    * 두 Integer 객체에 저장된 int값(value)을 비교해서 같으면 0, 크면 -1, 작으면 1을 반환.
    * TreeSetdp Integer인스턴스를 저장했을 때 정렬되는 기준이 바로 위의 compareTo()에 의한 것.

* **Comparable**을 구현한 클래스들이 기본적으로 오름차순으로 정렬 되지만, 내림차순이나 다른 방식으로 정렬 하고 싶을 때 
  **Comparator**를 구현해서 정렬기준을 제공할 수 있다.

* 위의 예제는 성능을 위한 삼항연산자 사용을 했지만, 대부분 아래와 같이 간단히 구현할 수 있다.

  ```java
  public int compareTo(Integer anotherInteger){
    int thisVal = this.value;
    int anotherVal = anotherInteger.value;
    
    //왼쪽 값이 크면 음수를, 두 값이 같으면 0, 왼쪽 값이 크면 양수를 반환.
    return thisVal - anotherVal; //내림차순의 경우 반대로 뺄셈.
  }
  ```

* 이미 `Array.sort()`와 같은 메서드의 정렬 알고리즘은 이미 잘 작성되어있으므로,
   `compareTo()`를 구현해, 어떤 비교기준으로 정렬할지만 알려주면 된다.





* 예제:
  1~50사이의 숫자 중에서 25개를 골라, '5 x 5'크기의 빙고판을 만드는 예제.

  ```java
  import java.util.*;
  
  public class Ex11_8 {
      public static void main(String[] args) {
          Set set = new HashSet();
  //        Set set = new LinkedHashSet();
          int[][] board = new int[5][5];
  
          for(int i =0; set.size() < 25; i++){
              set.add((int)(Math.random()*50)+1+"");
          }
  
          Iterator it = set.iterator();
  
          for(int i = 0; i < board.length; i++){
              for(int j = 0; j<board[i].length; j++){
                  board[i][j]= Integer.parseInt((String)it.next());
                  System.out.print((board[i][j] < 10 ? "  " : " ") + board[i][j]);
              }
              System.out.println();
          }
      } // main
  }
  ```

  > 위 코드의 결과:
  >   44 22 45 47 26
  >  27 29 10 32 11
  >  34 12 35 13 14
  >  37 16 38 17 39
  >   1  3 20 42 21

  * `next()`는 반환값이 Object타입이므로, 형변환 해서 원래의 타입으로 되돌려놔야 한다.
  * 몇 번 더 실행 해 보면, 같은 숫자가 비슷한 위치에서 나오는 것을 볼 수 있는데,
    이는 HashSet이 저장된 순서를 보장하지 않고, 자체적인 저장방식에 따라 순서가 결정되기 때문.
  * 이 경우, HashSet보다 LinkedHashSet이 더 낫다.



## 15. HashSet

* Set인터페이스를 구현한 가장 대표적인 컬렉션
  * Set인터페이스의 특징대로 중복된 요소를 저장하지 않는다.
* HashSet에 새로운 요소를 추가할 때는 add메서드나 addAll 메서드를 사용하는데,
  중복된 요소를 추가하고자 한다면, false를 반환함으로써 이미 중복된 요소이기 때문에 추가에 실패했다는 것을 알린다.
* 위의 특징으로 중복 요소들을 쉽게 제거할 수 있다.
* 다만 저장ㄷ순서를 유지하지 않으므로, 저장 순서를 유지하고자 한다면 LinkedHashSet을 사용해야한다.

| 생성자 또는 메서드                             | 설명                                                         |
| ---------------------------------------------- | ------------------------------------------------------------ |
| HashSet()                                      | HashSet객체를 생성한다.                                      |
| HashSet(Collection c)                          | 주어진 컬렉션을 포함하는 HashSet객체를 생성한다.             |
| HashSet(int initialCapacity)                   | 주어진 값을 초기용량으로하는 HashSet객체를 생성한다.         |
| HashSet(int initialCapacity, float loadFactor) | 초기용량과 load factor를 지정하는 생성자. <br />저장공간이 가득차기 전 용량확보를 위한 것. (기본적인 용량: 0.75(75%)) |
| boolean add(Object o)                          | 새로운 객체를 저장한다.(성공하면 ture, 실패하면 false)       |
| boolean addAll(Collection c)                   | 주어진 컬렉션에 저장된 모든 객체들을 추가한다.(합집합)       |
| void clear()                                   | 저장된 모든 객체를 삭제한다.                                 |
| Object clone()                                 | HashSet을 복제해서 반환한다.(얕은 복사)                      |
| boolean contains(Object o)                     | 지정된 객체를 포함하고 있는지 알려준다.                      |
| boolean containsAll(Collection c)              | 주어진 컬렉션에 저장된 모든 객체들을 포함하고 있는지 알려준다. |
| boolean isEmpty()                              | HashSet이 비어있는지 알려준다.                               |
| Iterator iterator()                            | Iterator를 반환한다.                                         |
| boolean remove(Object o)                       | 지정된 객체를 HashSet에서 삭제한다.(성공하면 ture, 실패하면 false) |
| boolean removeAll(Collection c)                | 주어진 컬렉션에 저장된 모든 객체와 동일한 것들을 HashSet에서 모두 삭제한다.(차집합) |
| boolean retainAll(Collection c)                | 주어진 컬렉션에 저장된 객체와 동일한 것만 남기고 삭제한다.(교집합) |
| int size()                                     | 저장된 객체의 개수를 반환한다.                               |
| Object[] toArray()                             | 저장된 객체들을 객체배열의 형태로 반환한다.                  |
| Object[] toArray(Object[] a)                   | 저장된 객체들을 주어진 객체배열(a)에 담는다.                 |



* 예제 1:
  중복값을 허용하지 않는 것에 대한 예제

  ```java
  import java.util.*;
  
  public class Ex11_9 {
      public static void main(String[] args) {
          Object[] objArr = {"1",new Integer(1),"2","2","3","3","4","4","4"};
          Set set = new HashSet();
  
          for(int i = 0; i < objArr.length; i++){
              set.add(objArr[i]);  //HashSet에 objArr의 요소들을 저장한다.
          }
          //HashSet에 저장된 요소들을 출력한다.
          System.out.println(set);
  
          //HashSet에 저장된 요소들을 출력한다.(Iterator이용)
          Iterator it = set.iterator();
  
          while (it.hasNext()) {
              System.out.println(it.next());
          }
      }
  }
  ```

  > 위 식의 결과:
  > [1, 1, 2, 3, 4]
  > 1
  > 1
  > 2
  > 3
  > 4

  * "1"이 두번 출력 된 이유는, 하나는 String인스턴스이고, 하나는 Integer인스턴스로, 서로 다른 객체이기 때문에 중복으로 간주하지 않은 것이다.
  * Set을 구현한 컬렉션 클래스는 List를 구현한 컬렉션 클래스와 달리 순서를 유지하지 않아, 저장한 순서와 다를 수 있다.
  * 중복 제거와 저장 순서를 유지하고 싶다면, LinkedHashSet을 사용하면 된다.



* 예제2:
  중복값을 허용하지 않는 성질을 이용해, 로또 번호를 만드는 예제.

  ```java
  import java.util.*;
  
  public class Ex11_10 {
      public static void main(String[] args) {
          Set set = new HashSet();
  
          for(int i = 0; set.size() < 6 ; i++){
              int num = (int)(Math.random()*45)+1;
              set.add(new Integer(num));
          }
  
          List list = new LinkedList(set); // LinkedList(Collection c)
          Collections.sort(list);          // Collections.sort(List list)
          System.out.println(list);
      }
  }
  ```

  > 위 식의 결과:
  > [5, 8, 18, 31, 34, 39]

  * 번호를 크기순으로 정렬하기 위해 Collections클래스의 sort(List list)를 사용했다.

    * 인자로 List인터페이스 타입을 필요로 하기 때문에, LinkedList에 HashSet의 객체들을 담아 처리함.

    > Collection은 인터페이스, Collections는 클래스임을 주의하자.

  * 실행 결과의 정렬기준은, 객체가 Integer이기 때문에 Integer클래스에 정의된 기본 정렬이 사용 됨.



* 예제3:

  ```java
  import java.util.*;
  
  public class Ex11_11 {
      public static void main(String[] args) {
          HashSet set = new HashSet();
          set.add("abc");
          set.add("abc");
          set.add(new Person("David",10));
          set.add(new Person("David",10));
  
          System.out.println(set);
      }
  }
  
  class Person {
      String name;
      int age;
  
      Person(String name, int age){
          this.name = name;
          this.age = age;
      }
  
      public String toString() {return name + ":"+ age;}
  ```

  > 위 식의 결과:
  > [abc, David:10, David:10]

  * Person클래스는 name과 age를 멤버변수로 갖는데, 이름과 나이가 같으면 같은 사람으로 인식하도록 하려는 의도로 작성 된 것이다.
    하지만 의도와 맞지않게 다른 것으로 인식하였는데, 이를 같은 것으로 인식하려면 어떻게 해야할까?

    > Person클래스에 아래의 두 메서드를 추가(오버라이딩)한다.
    >
    > ```java
    > public boolean equals(Object obj){
    >   if(!(obj instanceof Person)) return false;
    >   Person p = (Person)obj;
    >   return name.equals(p.name) && age == p.age;
    > }
    > 
    > public int hashCode(){
    >   return Objects.hash(name, age); // int hash(Object ... values)
    > }
    > ```
    >
    > * HashSet의 add메서드는 새로운 요소를 추가하기 전에 기존에 저장된 요소와 같은것인지 판별하기 위해,
    >   추가하려는 요소의 `equals()`와 `hashCode()`를 호출하기 때문에, 
    >   이처럼 `equals()`뿐만 아니라, `hashCode()`도 목적에 맞게 오버라이딩 해야한다.



* 예제 3:

  ```java
  import java.util.*;
  
  public class Ex11_12 {
      public static void main(String[] args){
          HashSet setA = new HashSet();
          HashSet setB = new HashSet();
          HashSet setHab = new HashSet();
          HashSet setKyo = new HashSet();
          HashSet setCha = new HashSet();
  
          setA.add("1");
          setA.add("2");
          setA.add("3");
          setA.add("4");
          setA.add("5");
          System.out.println("A = "+setA);
  
          setB.add("4");
          setB.add("5");
          setB.add("6");
          setB.add("7");
          setB.add("8");
          System.out.println("B ="+setB);
  
          Iterator it = setB.iterator();
          while (it.hasNext()){
              Object tmp = it.next();
              if(!setA.contains(tmp))
                  setKyo.add(tmp);
          }
  
          it = setA.iterator();
          while (it.hasNext()){
              Object tmp = it.next();
              if(!setB.contains(tmp))
                  setCha.add(tmp);
          }
  
          it = setA.iterator();
          while (it.hasNext())
              setHab.add(it.next());
  
          it = setB.iterator();
          while (it.hasNext())
              setHab.add(it.next());
  
          System.out.println("A ∩ B ="+setKyo);
          System.out.println("A ∪ B ="+setHab);
          System.out.println("A - B ="+setCha);
      }
  }
  ```

  > 위 식의 결과
  > A = [1, 2, 3, 4, 5]
  > B =[4, 5, 6, 7, 8]
  > A ∩ B =[6, 7, 8]
  > A ∪ B =[1, 2, 3, 4, 5, 6, 7, 8]
  > A - B =[1, 2, 3]



## 16. TreeSet

