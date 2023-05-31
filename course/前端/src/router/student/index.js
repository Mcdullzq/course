import LoginView from "@/views/student/LoginView";
import StudentMain from "@/views/student/StudentMain";
import ShowInfoView from "@/views/student/info/ShowInfoView";
import UpdatePwdView from "@/views/student/info/UpdatePwdView";
import UpdateInfoView from "@/views/student/info/UpdateInfoView";
import UnSelectedCourseView from "@/views/student/course/UnSelectedCourseView";
import SelectedCourseView from "@/views/student/course/SelectedCourseView";

let stus = [
    {
        path:'/student',
        redirect:'/stuLogin'
    },
    {
      path:'/stuLogin',
      component:LoginView
    },
    {
        path:'/stuMain',
        component: StudentMain,
        children:[
            {
               path:'/stuInfo',
                component:ShowInfoView
            },
            {
                path:'/updateStuPwdView',
                component: UpdatePwdView
            },
            {
                path:'/updateStuInfoView',
                component: UpdateInfoView
            },
            {
                path:'/unSelectedCourse',
                component: UnSelectedCourseView
            },
            {
                path:'/selectedCourse',
                component: SelectedCourseView
            }
        ]
    }
]
export default stus