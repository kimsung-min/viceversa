1. 요구사항 분석
   - 공공데이터 포탈 등의 공개된 json 데이터를 50개 이상 수집하여 로컬 db 에 저장
   - 전반적인 REST API 동작을 체크할 수 있는 테스트 소스 구현
   - JPA Specification을 이용한 동적 검색 기능 구현
  
2.  REST API 구현은 HTTP요청을 사용하여 테스트 코드를 구현하였습니다 (http파일 안에 있습니다)
   - 공공데이터 데이터 목록 조회
   - 데이터 수집 및 저장
   - 단일 데이터 저장
   - 저장된 데이터를 제목 및 작가 이름 검색

3. 코드진행
    - 코드를 실행하면 DataCollector 클래스에서 API를 호출하여 데이터를 가져옵니다.
    - 수집된 데이터를 PublicDataService를 통해 데이터베이스에 저장합니다.
    - 저장된 데이터를 PublicDataController에서 제공하는 검색 API를 통해 검색할 수 있습니다.

4. 구동방법
    - Clone the repository
  
5. 데이터베이스 설정
   - spring.datasource.url=jdbc:mysql://localhost:3306/ksm
   - spring.datasource.username=ksm
   - spring.datasource.password=1q2w3e4R!
   - spring.jpa.hibernate.ddl-auto=update
   - spring.jpa.show-sql=true
  
6. 빌드
   
   dependencies {
	implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
	implementation 'org.springframework.boot:spring-boot-starter-web'
	compileOnly 'org.projectlombok:lombok'
	developmentOnly 'org.springframework.boot:spring-boot-devtools'
	runtimeOnly 'com.mysql:mysql-connector-j'
	annotationProcessor 'org.projectlombok:lombok'
	testImplementation 'org.springframework.boot:spring-boot-starter-test'
	testRuntimeOnly 'org.junit.platform:junit-platform-launcher'
	implementation 'com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.13.3'
}

7. 환경
    - tool : intellij
    - Gradle
    - java version 17
    - spring boot version 3.3.2



