**메뉴 DB화**

* 보안과 유지보수에 굉장히 좋다.
* 보통 ajax 또는 jstl로 구현하는데, 속도 면에서는 jstl이 빠르다. 프로젝트에서 left메뉴가 타일즈로 구성되었다면 ajax가 편하다.

<br>

**DB에 테이블 생성 - 칼럼**

* MENU_ID
* MENU_NM (메뉴 이름)
* MENU_URL (메뉴 클릭 시 이동할 경로)
* MENU_CLASS (메뉴 앞에 올 아이콘 ..)
* USE_YN (다음 메뉴의 사용 여부)
* SORT_NO (메뉴의 순서)
* COLLAPSE_YN (하위 메뉴의 존재 여부)
* DEPTH (메뉴의 깊이)
  * 상위 메뉴는 1
  * 하위 메뉴는 2
  * ..
* PARENT_ID (부모 메뉴)
  * 상위 메뉴의 SORT_NO
  * 상위 메뉴가 없으면, NULL