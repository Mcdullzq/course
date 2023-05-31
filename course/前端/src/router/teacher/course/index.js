import AddCourseView from "@/views/teacher/course/AddCourseView";
import SearchCourseView from "@/views/teacher/course/SearchCourseView";
import resetDeleteCourseView from "@/views/teacher/course/resetDeleteCourseView";


let course=[
    {
    path:'/addCourse',
    component:AddCourseView
    },
    {
        path: '/searchCourse',
        component: SearchCourseView
    },
    {
         path:"/resetDeleteCourse",
         component: resetDeleteCourseView
    }

]

export default course;