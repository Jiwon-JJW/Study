# GIt

Git은 협업 시, 버전 관리를 위한 시스템.

* 한 프로젝트를 여러명이서 작업 할때, 레포지토리에서 Banch를 추출함.

  Master의 경우 기본 branch 이지만, 실제로는 개발용(develop) branch를 따서 작업 하고,
  Mater는 버전 관리용



#### Git 명령어

* **Git add:** 변경된 사항을 커밋에 올리기
  * **Git add .:**변경된 모든 사항을 커밋에 올리기 
* **Git Commit:** 커밋 진행하기
  I: insert 진입
  ESC: Insert모드에서 빠져나가기
  :wq: 저장하고 나가기 (W: 저장 Q: 나가기)
* **Git status:** 깃의 진행사항 확인하기
* **Git push:**커밋된 파일 올리기

---

* **Git pull origin *master* :** 레포지토리에 변경사항이 있을 때 동기화 하는 방식.
  * *master* 의 경우  변동 될 수 있음. (Branch 이기 때문에)
  * origin 의 경우: 레포지토리의 별명

