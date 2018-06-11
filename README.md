# lab_MVCStructure

---- ========1.binding=============================

//1.1 เรียกใช้ binding

-" dataBinding{enabled true} " --> app/gradle

========2.mvc=================================

//2.1 สร้าง package รูปแบบ MVC

-activity -manager -util -view -fragment

//2.2 สร้าง MainApplication

-create MainApplication.class

-add android:name=".MainApplication" --> androidmanifest

========3.liberry=============================

//3.1 เรียกใช้ liberry

-" ,':TheCheeseLibrary' " -> add library

//3.2 ใช้ Contextor ที่ MainApplication

MainApp,onCreate --> { Contextor.getInstance().init(getApplicationContext()); }
========4.copy template=======================

//4.1 ก๊อปปี้ template จาก libarry

-singleton -fragment -customview -customviewgroup

========5.create fragment_main===============

//5.1 สร้าง fragment เพื่อใช้ แทน activity_main

create fragment_main.xml --> layout xml

//5.2 ก๊อปปี้ template fragmentTemplat เปลี่ยนชื่อเป็น MainFragment

create MainFragment.class --> fragment java

========6.add mainfragment to mainactivity ====

// add fragment เข้าไปที่ activity

-MainActivity

if (savedInstanceState == null){ getSupportFragmentManager().beginTransaction() .add(R.id.contentContainer, MainFragment.newInstance()) .commit(); }

-activity_main.xml

#####################################################

        <FrameLayout
        android:id="@+id/contentContainer"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>
        
 ######################################################

        
