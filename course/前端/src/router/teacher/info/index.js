import ShowInfoView from "@/views/teacher/info/ShowInfoView";
import UpdateInfoView from "@/views/teacher/info/UpdateInfoView";
import UpdatePwdView from "@/views/teacher/info/UpdatePwdView";

let infos =[
    {
        path:'/showInfoView',
        component:ShowInfoView
    },
    {
        path:'/updateInfoView',
        component: UpdateInfoView
    },
    {
        path:'/updatePwdView',
        component: UpdatePwdView
    }
]
export default infos