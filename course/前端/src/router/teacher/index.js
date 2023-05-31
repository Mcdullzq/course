import LoginViewVue from "@/views/teacher/LoginView.vue";
import TeacherMainVue from "@/views/teacher/TeacherMain.vue";
import rooms from './classroom'
import courses from "@/router/teacher/course";
import teachers from "@/router/teacher/tea";
import tcs from  "@/router/teacher/tc";
import stus from "@/router/teacher/stu";
import infos from "@/router/teacher/info";
import sks from "@/router/teacher/sk";
let teas=[
     {
         path:'/teacher',
         redirect:'/login'
     },
     {
         path:'/login',
         component:LoginViewVue
     },
    {
         path:'/teaMain',
        component: TeacherMainVue,
        children:[
            ...rooms ,
            ...courses,
            ...teachers,
            ...tcs,
            ...stus,
            ...infos,
            ...sks
        ]
    }
 ]

export default teas