import AddBatchStusView from "@/views/teacher/stu/AddBatchStusView";
import AddStuView from "@/views/teacher/stu/AddStuView";
import SearchStuView from "@/views/teacher/stu/SearchStuView";

let stus =[
    {
    path:'/addBatchStusView',
    component:AddBatchStusView
    },
    {
        path:'/addStuView',
        component:AddStuView
    },
    {
        path:'/searchStuView',
        component:SearchStuView
    }
]
export default stus