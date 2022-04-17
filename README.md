
## Kotlin JPA, Querydsl 세팅하기
Kotlin Spring에서 JPA와 Querydsl를 세팅해봅시다.

## Build.gradle 세팅
```groovy
plugins {
    id("org.springframework.boot") version "2.6.6"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.6.10"
    kotlin("plugin.spring") version "1.6.10"
    kotlin("plugin.jpa") version "1.6.10"
    kotlin("kapt") version "1.6.20"
}

dependencies {
    val querydslVersion = "5.0.0"
    // jpa
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    // querydsl
    implementation("com.querydsl:querydsl-jpa:${querydslVersion}")
    kapt("com.querydsl:querydsl-apt:${querydslVersion}:jpa")
    kapt("org.springframework.boot:spring-boot-configuration-processor")
}

allOpen {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.MappedSuperclass")
    annotation("javax.persistence.Embeddable")
}

// 기본 생성자를 만들고 싶은 것 세팅
noArg {
  ...
}
```
위의 내용은 부가적인 내용은 전부 잘라내고 필요한 부분만 명시했습니다.  
전체 코드는 해당 프로젝트의 build.gradle.kts를 확인해주세요.  
필요할 플러그인을 하나씩 알아보겠습니다.
+ kotlin("plugin.spring")
    - kotlin-allopen과 동일한 프로젝트입니다.
    - 코틀린은 기본적으로 클래스가 final로써 open 키워드를 명시적으로 사용하지 않으면 상속이 불가능합니다.
    - spring의 AOP는 cglib을 사용하는데 상속으로 proxy 패턴을 사용하기 때문에 이를 위해 특정 클래스를 open으로 상속이 가능하도록 열어줘야 합니다.(지연로딩과 관련된 내용)
    - 해당 플러그인은 아래 애노테이션이 붙은 클래스에 대해 open 클래스로 열어줍니다.
        - @Component, @Async, @Transactional, @Cacheable, @SpringBootTest, @Configuration, @Controller, @RestController, @Service, @Repository
    - JPA를 사용하기 위해서는 @Entity와 비롯하여 같이 사용하는 클래스들에 대해 Open을 해줄 필요가 있습니다.
        - allOpen을 사용해서 해당 애노테이션이 붙은 것들에 대해 open으로 열어주도록 세팅해줍니다.
+ kotlin("plugin.jpa")
    - @Entity, @Embeddable, @MappedSuperclass 애노테이션이 사용된 곳에 no-arg생성자(기본 생성자)가 자동으로 생성됩니다.
    - 이 플러그인이 필요한 이유는 Hibernate는 Reflection으로 객체를 생성하기 때문에 protected 이상의 기본 생성자가 필요하기 때문입니다.
+ kotlin("kapt")
    - 코틀린은 kotlinc로 컴파일되기 때문에 기존에 Java로 작성된 Annotation Process로는 Kotlin의 애노테이션이 제대로 처리되지 않습니다.
    - 이를 해결하는 것이 kapt 플러그인 입니다.
    - 기존 자바의 dependencies에서 annotationProcessor로 세팅하던 내용을 kapt로 변경해주어야 하고 사용 시에는 해당 라이브러리가 kapt를 지원하는지 확인해야 합니다.
+ implementation("org.jetbrains.kotlin:kotlin-reflect")
    - 코틀린은 런타임 라이브러리 용량을 줄이기 위해 기본적으로 reflect를 제공해주지 않습니다.
    - 의존성을 추가하면 reflect를 사용할 수 있습니다.
+ implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    - 코틀린의 필수적인 기능들을 제공해줍니다.
    - let, apply, use, synchronized 등의 함수
    - collection 이용에 도움이 되는 확장 함수
    - 문자열 유틸,
    - IO, threading 관련 함수
