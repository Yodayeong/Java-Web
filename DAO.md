**DAO, DTO, VO의 개념**

1.  DAO(Data Access Object)
   * DB의 데이터에 접근하기 위한 객체
   * 직접 DB에 접근하여 data를 삽입, 삭제, 조회 등의 기능을 수행
2.  DTO(Data Transfer Object)
   * 계층 간 데이터 교환을 위한 Java Bean
   * 로직을 가지지 않고 getter, setter 메서드만을 가지는 클래스
3.  VO(Value Object)
   * Read-Only 속성을 가진 값 오브젝트
   * 불변 클래스이므로, getter 기능만 존재