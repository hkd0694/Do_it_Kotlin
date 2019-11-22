# Do_it 도전! 안드로이드 Kotlin 미션 (6/30)

## 시크바와 프로그레스바 보여주기

시크바와 프로그레스바를 표시하고 시크바의 값을 바꾸었을 때 프로그레스바의 값도 바뀌도록 만들어 보시오.

난이도 : 중


1. 화면에 시크바와 프로그레스바, 그리고 입력상자를 배치한다.
2. 시크바의 값을 바꾸면 프로그레스바의 값도 바뀌도록 한다.
3. 시크바의 값을 바꾸었을 때 그 값이 입력상자에 표시되도록 한다.
4. 프로그레스바는 막대형을 사용한다.

※ 참고할 점 ※

* 시크바의 값이 바뀔 때 그 값을 알려주는 콜백 메서드를 사용한다.
* 시크바의 값이 바뀔 때 그 값을 프로그레스바와 입력상자에 설정한다.

### Java에서의 Seekbar Listener

```java

seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressBar.setProgress(progress);
                textView.setText("현재 값(0~200) : " + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

```

### Kotlin에서의 Seekbar Listener

```kotlin


seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                progressBar.progress = progress
                textView.text = "현재 값(0~200) : $progress"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

```