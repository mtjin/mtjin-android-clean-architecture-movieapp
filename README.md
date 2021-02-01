# # 안드로이드 클린아키텍처 공부 및 네이버 영화검색 앱 구현 (Main 브랜치 : Clean MVVM + RxJava2 + Koin + Multi Module)

---

### 설명

---

[이전 프로젝트](https://github.com/mtjin/android-architecture-study-movieapp)

이전에 안드로이드 아키텍처 스터디로 사용했던 프로젝트를 리펙토링하여 사용합니다.

클린아키텍처 관련 영상과 자료를 참고하여 공부하고 프로젝트에 적용해보며 학습합니다. 처음이라 미숙한 점이 많습니다. 😂


### 블로그 정리

---
[블로그 정리](https://youngest-programming.tistory.com/484)


### 아키텍처

---

<img src="https://user-images.githubusercontent.com/37071007/106156645-23159280-61c5-11eb-8add-14383e827487.png">


[출처](https://proandroiddev.com/clean-architecture-data-flow-dependency-rule-615ffdd79e29) 

위 사진의 아키텍처를 따르며 DataSource 로는 **로컬 DB, 캐시, 서버 DB** 로 구성 및 구현했다가 이 프로젝트에서는 캐시 데이터소스로 얻는 단점과 필요성이 적어 제거하게 되었습니다.

화면별 패키지는 splash, login, search가 있으며 **영화검색(search패키지) 위주로 구현**합니다.



### 해야할 리스트

---

1차 : Clean MVVM + RxJava2 + Koin   [clean-mvvm-rxjava-koin 브랜치](https://github.com/mtjin/mtjin-android-clean-architecture-movieapp/tree/clean-mvvm-rxjava-koin)

2차 : 1차에서 모듈나누기 [Main]  [clean-mvvm-multi-module 브랜치](https://github.com/mtjin/mtjin-android-clean-architecture-movieapp/tree/clean-mvvm-multi-module)

3차 : Koin → Dagger2 로 변경   [clean-mvvm-rxjava-dagger 브랜치](https://github.com/mtjin/mtjin-android-clean-architecture-movieapp/tree/clean-mvvm-rxjava-dagger)

추가사항 : 리펙토링 + 예외처리 + Unit Test ==> 현재 듣고 있는 Udemy 강의수강과 더 공부 한 후 할 보강하거나 새 프로젝트에 적용할 예정, 실력이 부족하여 공부가 많이 필요하다... ㅠ



### 사용 및 공부한 것

---

Android, Kotlin, MVVM, 클린아키텍처, RxJava2, RxAndroid, AAC ViewModel, LiveData, Koin, ListAdapter, Databinding, Retrofit2, Room, Dagger2
