import AddClassroomViewVue from "@/views/teacher/classroom/AddClassroomView.vue";
import SearchClassroomView from "@/views/teacher/classroom/SearchClassroomView";

let rooms=[
    {
    path:'/addClassroom',
    component:AddClassroomViewVue
    },
    {
    path:'/searchClassroom',
    component:SearchClassroomView
    }
]
export default rooms;