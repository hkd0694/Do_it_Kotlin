# Do_it 도전! 안드로이드 Kotlin 미션 (9/30)

## 고객 정보 입력 화면의 구성

고객 정보 입력 화면을 프래그먼트로 만들어 보시오. 이 화면은 고객의 이름, 나이, 생년월일을 입력받기 위한 것이다.

난이도 : 초


1. 프래그먼트로 고객 정보 입력 화면을 만들어 액티비티에 넣어준다.
2. 프래그먼트의 레이아웃에는 리니어 레이아웃이나 상대 레이아웃을 사용하고 그 안에 이름과 나이를 입력받는 입력상자, 생년월일을 표시하는 버튼 그리고 [저장]버튼을 배치한다.
3. 생년월일을 표시하는 버튼에는 오늘 날짜를 자동으로 표시하며, 버튼을 누르면[날짜 선택] 대화상자를 띄우고 날짜를 입력받아 표시한다. 이름을 넣을 수 있는 입력상자에는 문자열을, 나이를 입력받기 위한 입력상자에는 숫자를 입력할 수 있도록 설정하여 적당한 키패드를 띄우도록 하고 나이는 세 자리까지만 입력할 수 있게 만든다.
4. [저장] 버튼을 누으면 토스트로 입력한 정보를 표시한다.

※ 참고할 점 ※

* 이름과 나이를 입력받는 입력상자에 키 입력 유형을 설정한다.
* 그리고 적당한 키패드를 띄우려면 inputType 속성을 이용한다.
* 날짜를 설정하려면 DatePickerDialog와 SimpleDateFormat을 사용할 수 있다.


```kotlin

class CustomFragment : Fragment() {

    val date = Date()
    val simple = SimpleDateFormat("yyyy.MM.dd")
    private lateinit var today:String
    private lateinit var birth:Button


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        val rootView =  inflater.inflate(R.layout.fragment_custom, container, false)

        var name = rootView.findViewById(R.id.name) as EditText
        var age = rootView.findViewById(R.id.age) as EditText
        birth = rootView.findViewById(R.id.birthday) as Button
        var save = rootView.findViewById(R.id.save) as Button
        today = simple.format(date)

        birth.text = today

        birth.setOnClickListener {
            val arr = today.split(".")
            val date = DatePickerDialog(activity!!,DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
                birth.text = "${year}.${month +1}.${dayOfMonth}"
                today = "${year}.${month+1}.${dayOfMonth}"
            },Integer.parseInt(arr[0]),Integer.parseInt(arr[1])-1,Integer.parseInt(arr[2]))
            date.show()
        }
        save.setOnClickListener {
            Toast.makeText(activity!!.applicationContext,"${name.text} ${age.text} ${today}",Toast.LENGTH_LONG).show()
        }

        return rootView
    }

}


```