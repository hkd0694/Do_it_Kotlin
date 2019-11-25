# Do_it 도전! 안드로이드 Kotlin 미션 (8/30)

## 세 개 이상의 화면 만들어 전환하기

앱에서 사용될 수 있는 여러 화면을 구성하고 각 화면을 전환하면서 토스트로 메시지를 띄워주도록 만들어 보시오.

난이도 : 중


1. 로그인 화면과 메뉴 화면 그리고 세 개의 서브 화면(고객 관리 화면, 매출 관리 화면, 상품 관리 화면)을 각각 액티비티로 만든다.
2. 로그인 화면에는 두 개의 입력상자와 하나의 버튼이 들어가도록 한다.
3. 메뉴 화면에서는 세 개의 버튼이 들어가도록 하고 각각 '고객 관리', '매출 관리', '상품 관리'라는 이름으로 표시한다.
4. 로그인 화면의 [로그인]버튼을 누르면 메뉴 화면으로 이동한다. 만약 사용자 이름이나 비밀번호가 입력되어 있지 않은 상태에서 [로그인]버튼을 누르면 토스트로 입력하라는 메시지를 보여주고 대기한다.
5. 메뉴 화면의 버튼 중에서 하나를 누르면 해당 서브 화면으로 이동한다. 메뉴 화면에 있는 [로그인]버튼을 누르면 로그인 화면으로 이동하고 각 서브 화면에 있는 [메뉴] 버튼을 누르면 메뉴 화면으로 이동한다.

※ 참고할 점 ※

* 각 화면은 액티비티로 만들고 startActivityForResult() 메서드로 새로 띄우거나 finish() 메서드를 사용해서 원래의 화면으로 돌아올 수 있게 한다.
* 어떤 화면으로부터 보내온 응답인지 모두 확인하여 토스트 메시지로 보여준다.
