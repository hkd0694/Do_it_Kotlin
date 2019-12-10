# Do_it 도전! 안드로이드 Kotlin 미션 (11/30)

## 서비스 실행하고 화면에 보여주기

버튼을 눌렀을 때 서비스를 실행하고 서비스에서 보내오는 글자를 화면에 보여주게 만들어 보시오.

난이도 : 하


1. 화면에 버튼 하나를 입력상자 그리고 텍스트뷰를 배치한다.
2. 버튼을 누르면 입력상자의 글자를 가져와 서비스를 실행하면서 보내준다.
3. 서비스에서는 다시 MainActivity 화면으로 받은 글자를 보내준다.
4. MainActivity 화면에서는 서비스로부터 받은 텍스트를 화면의 텍스트 뷰에 표시한다.

※ 참고할 점 ※

* 입력상자의 글자를 바로 텍스트뷰에 보여주는 것이 아니라 서비스로 보냈다가 다시 받아서 보여주도록 한다.


```kotlin
    class TextService : Service() {

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if(intent == null) {
            return START_STICKY
        } else {
            process1(intent)
        }
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(intent: Intent?): IBinder? {
        throw UnsupportedOperationException("Not yet implemented")
    }

    private fun process1(intent : Intent){
        val name = intent.getStringExtra(MainActivity.name)
        val message = intent.getStringExtra(MainActivity.message)

        Log.e("Start", "$name + 호출 : $message")

        val backIntent = Intent(applicationContext,MainActivity::class.java)
        backIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
        backIntent.putExtra(MainActivity.name,name)
        backIntent.putExtra(MainActivity.message,message)
        startActivity(backIntent)
    }
}


```