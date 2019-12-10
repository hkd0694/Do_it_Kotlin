# Do_it 도전! 안드로이드 Kotlin 미션 (12/30)

## 서비스에서 수신자로 메시지 보내기

서비스에서 보낸 메시지를 액티비티 안에서 등록한 브로드캐스트 수신자를 이용해 받도록 연결해 보시오.

난이도 : 중급


1. 화면에 버튼 하나와 입력상자 그리고 텍스트뷰를 배치한다.
2. 버튼을 누르면 입력상자의 글자를 가져와 서비스를 실행하면서 보내준다.
3. 서비스에서는 다시 브로드캐스팅을 이용해 글자를 보내준다.
4. MainActivity 화면에서는 브로드 캐스트 수신자를 통해 글자를 전달받는다.
5. 수신자를 통해 전달받은 글자를 화면에 있는 텍스트뷰에 표시한다.

※ 참고할 점 ※

* 액티비티 안에서 브로드캐스트 수신자를 등록할 수 있다.
* 액티비티 안의 수신자에서 메시지를 수신하면 그 메시지를 액티비티 안의 텍스트뷰에 표시할 수 있다.

```kotlin
    
    class TextService : Service() {

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        val message = intent.getStringExtra(MainActivity.message)
        val intentReceiver = Intent()
        intentReceiver.action = "BroadCast"
        intentReceiver.putExtra(MainActivity.message, message)
        sendBroadcast(intentReceiver)
        return super.onStartCommand(intent, flags, startId)
    }

}


```

``` kotlin

class TextReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {

        val textMessage = intent.getStringExtra(MainActivity.message)
        val mainIntent = Intent(context,MainActivity::class.java)
        mainIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_SINGLE_TOP or Intent.FLAG_ACTIVITY_CLEAR_TOP
        mainIntent.putExtra(MainActivity.message,textMessage)
        context.startActivity(mainIntent)
        val spService = Intent(context,TextService::class.java)
        context.stopService(spService)
    }
}


```