# Do_it 도전! 안드로이드 Kotlin 미션 (10/30)

## 기본 앱 화면 구성

바로가기 메뉴와 하단 탭 그리고 뷰페이저가 들어간 기본 앱 화면을 만들어 보시오.

난이도 : 중


1. 앱의 화면에 바로가기 메뉴와 하단 탭 그리고 뷰페이저가 들어가도록 만들어야 한다.
2. 하단 탭에서는 세 개의 탭 메뉴가 보이도록 한다.
3. 하단 탭에서 첫 번째 탭 메뉴를 눌렀을 때 보이는 첫 번째 프래그먼트 화면 안에 뷰페이저가 표시되도록 한다. 그리고 뷰페이저 안에는 이미지나 기타 화면이 2~3개 들어가 있도록 한다.
4. 바로가기 메뉴를 넣어준다.

※ 참고할 점 ※

* 바로가기 메뉴, 하단 탭, 뷰페이저 등이 포함된 구조를 가지는 앱이 많으므로 이 위젯들을 모두 포함하는 앱 구조를 만들어 보는 것이 좋다.


```kotlin
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        viewpager.offscreenPageLimit = 3

        val myPagerAdapter = MyPagerAdapter(supportFragmentManager,3)
        viewpager.adapter = myPagerAdapter


        viewpager.addOnPageChangeListener(object: ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {

            }
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                bottomNavigationView.menu.getItem(position).isChecked = true
            }
        })

        bottomNavigationView.setOnNavigationItemSelectedListener(object : BottomNavigationView.OnNavigationItemSelectedListener{
            override fun onNavigationItemSelected(menu: MenuItem): Boolean {

                when(menu.itemId){
                    R.id.tab1 -> {
                        viewpager.currentItem = 0
                        return true
                    }
                    R.id.tab2 -> {
                        viewpager.currentItem = 1
                        return true
                    }
                    R.id.tab3 -> {
                        viewpager.currentItem = 2
                        return true
                    }
                }
              return false
            }
        })


        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }


```