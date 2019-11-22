# Do_it 도전! 안드로이드 Kotlin 미션 (5/30)

## 두 종류의 버튼 모양 만들기

두 개의 버튼을 화면에 추가하고, 버튼 모양을 각각 다르게 보이도록 만들어 보시오.

난이도 : 초


1. 화면에 두 개의 버튼을 배치한다.
2. 첫 번째 버튼의 모양은 가장자리에 경계선만 보이도록 하고 경계선과 글자색이 동일하도록 만든다.
3. 두 번째 버튼의 모양은 배경색이 있고 모서리는 약간 둥글며 글자가 하얀색이 되도록 만든다.

※ 참고할 점 ※

* 드로어블 객체를 만들어 버튼의 배경으로 설정하면 버튼의 모양을 만들 수 있다.
* 드로어블을 XML로 정의할 때 버튼의 모양이 결정된다.


### Button 경계선만 바이도록 하기

```java

<shape xmlns:android="http://schemas.android.com/apk/res/android"
       android:padding="10dp"
       android:shape="rectangle" >

    <solid android:color="#FFFFFFFF" />

    <stroke
            android:width="2px"
            android:color="#FF5722" />

</shape>

```

### Button의 모서리를 둥글게 하며 배경색을 가지도록 하기

```java

<shape xmlns:android="http://schemas.android.com/apk/res/android"
       android:padding="10dp"
       android:shape="rectangle" >
    <solid android:color="#2171b5" />
    <corners
            android:bottomLeftRadius="12dp"
            android:bottomRightRadius="12dp"
            android:topLeftRadius="12dp"
            android:topRightRadius="12dp" />
    <stroke
            android:width="1dp"
            android:color="#064274" />
</shape>

```