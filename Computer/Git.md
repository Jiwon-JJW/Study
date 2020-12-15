# GIt

Git은 협업 시, 버전 관리를 위한 시스템.

* 한 프로젝트를 여러명이서 작업 할때, 레포지토리에서 Banch를 추출함.

  Master의 경우 기본 branch 이지만, 실제로는 개발용(develop) branch를 따서 작업 하고,
  Mater는 버전 관리용



#### Git 명령어

* **git init** : 원하는 디렉토리에서 저장소를 지정하는 것. 처음에 cd로 디렉토리 이동이 필요하다.
* **git clone {url}** : 원격 저장소로 부터 디렉토리에 복제하는 것
* **git branch {브랜치 이름}** : 새로운 브랜치 생성
  * **git checkout {브랜치 이름}** : 해당 브랜치 사용
  * **git branch -b {브랜치 이름}** : 브랜치 생성과 체크아웃을 동시에

* **git add:** 변경된 사항을 커밋에 올리기
  * **git add .:**변경된 모든 사항을 커밋에 올리기 
* **git Commit:** 커밋 진행하기
  I: insert 진입
  ESC: Insert모드에서 빠져나가기
  :wq: 저장하고 나가기 (W: 저장 Q: 나가기)
* **git status:** 깃의 진행사항 확인하기
* **git push:**커밋된 파일 올리기

---

* **git pull origin *master* :** 레포지토리에 변경사항이 있을 때 동기화 하는 방식.
  * *master* 의 경우  변동 될 수 있음. (Branch 이기 때문에)
  * origin 의 경우: 레포지토리의 별명

